package com.exemple.eternal_myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exemple.eternal_myproject.book.lapAdapter;
import com.exemple.eternal_myproject.model.Lap;
import com.exemple.eternal_myproject.photo.Photo;
import com.exemple.eternal_myproject.photo.PhotoAdapter;
import com.exemple.eternal_myproject.rcv.RCV_T;
import com.exemple.eternal_myproject.rcv.RCV_T_Adapter;
import com.exemple.eternal_myproject.remote.APIUtils;
import com.exemple.eternal_myproject.remote.LapService;
import com.exemple.eternal_myproject.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//import com.exemple.eternal_myproject.book.Category;
//import com.exemple.eternal_myproject.book.CategoryAdapter;
//import com.exemple.eternal_myproject.book.Recycle;
import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class FragmentHome extends Fragment {
    private RecyclerView rcvCategory,rcvLap,laprcv;
//    private CategoryAdapter categoryAdapter,categoryAdapter2;
    private ViewPager viewPager;
    private RCV_T_Adapter rcv_t_adapter;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mListPhoto;
    private Timer mTimer;
    List<Lap> list = new ArrayList<Lap>();
    LapService lapService;
    lapAdapter  adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);


        viewPager = view.findViewById(R.id.view_paper);
        circleIndicator = view.findViewById(R.id.indicator);

        mListPhoto = getListPhoto();

        photoAdapter = new PhotoAdapter(getActivity(),mListPhoto);
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlideImages();

        rcvLap =view.findViewById(R.id.rcv_laptop);
        rcv_t_adapter = new RCV_T_Adapter(getActivity());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rcvLap.setLayoutManager(linearLayoutManager1);
        rcv_t_adapter.setData(getListLap());
        rcvLap.setAdapter(rcv_t_adapter);





        rcvCategory = view.findViewById(R.id.rcv_category);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        lapService = APIUtils.getLapService();
        getListLaptop();

//        categoryAdapter = new CategoryAdapter(getActivity());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
//        rcvCategory.setLayoutManager(linearLayoutManager);
//        categoryAdapter.setData(getListCategory());
//        rcvCategory.setAdapter(categoryAdapter);
        return view;
    }
    private List<Photo> getListPhoto(){

        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.banner1));
        list.add(new Photo(R.drawable.banner2));
        list.add(new Photo(R.drawable.banner3));
        list.add(new Photo(R.drawable.banner4));
        list.add(new Photo(R.drawable.banner5));

        return list;
    }
    private void autoSlideImages(){
        if(mListPhoto == null || mListPhoto.isEmpty() || viewPager == null){
            return;
        }
        if (mTimer == null){
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mListPhoto.size() -1;
                        if(currentItem<totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }
                        else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        },1000,4000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mTimer != null) {
            mTimer.cancel();
            mTimer=null;
        }
    }
    private List<RCV_T> getListLap(){
        List<RCV_T> list = new ArrayList<>();
        list.add(new RCV_T(R.drawable.htvp));
        list.add(new RCV_T(R.drawable.dhkt));
        list.add(new RCV_T(R.drawable.lg));
        list.add(new RCV_T(R.drawable.cc));
        list.add(new RCV_T(R.drawable.mn));
        return list;
    }


//    private List<Category> getListCategory(){
//        List<Category> list = new ArrayList<>();
//        List<Lap> listRecycle = new ArrayList<>();
//        listRecycle.add(new Lap("1","","","","",""));
//        listRecycle.add(new Recycle(R.drawable.bds,"Asus","Việc làm"));
//        listRecycle.add(new Recycle(R.drawable.bds,"Macbook","9000000"));
//        listRecycle.add(new Recycle(R.drawable.bds,"hp","400000"));
//
//        list.add(new Category( listRecycle,"SẢN PHẨM HOT"));
//        List<Recycle> listRecycle1 = new ArrayList<>();
//        listRecycle1.add(new Recycle(R.drawable.bds,"Bất động sản â","500000"));
//        list.add(new Category( listRecycle1,"SẢN PHẨM NHẬP KHẨU"));
//
//        return list;
//    }
    public void getListLaptop(){
            Call<List<Lap>> call = lapService.getLaps();
            call.enqueue(new Callback<List<Lap>>() {
                @Override
                public void onResponse(Call<List<Lap>> call, Response<List<Lap>> response) {
                    if(!response.isSuccessful()){
                        return;
                    }
                    list=response.body();
                    adapter=new lapAdapter(list,getActivity());
                    rcvCategory.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<Lap>> call, Throwable t) {
                    Log.e("ERROR: ", t.getMessage());
                }
            });

    }
}