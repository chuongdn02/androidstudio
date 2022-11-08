package com.exemple.eternal_myproject;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.exemple.eternal_myproject.databinding.ActivityMainBinding;
import com.exemple.eternal_myproject.model.Lap;
import com.exemple.eternal_myproject.model.User;
import com.exemple.eternal_myproject.remote.APIUtils;
import com.exemple.eternal_myproject.remote.LapService;
import com.exemple.eternal_myproject.remote.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentSearch extends Fragment  {
    private SearchView searchView;
    private MenuItem menuItem;
    ListView listView;
    LapService lapService;
    List<Lap> list = new ArrayList<Lap>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        listView = (ListView) view.findViewById(R.id.List_Lap);
        lapService = APIUtils.getLapService();
        getLapsList();



        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

        @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
//            searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//            searchView.setIconified(true);

            SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
            searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            searchView.setMaxWidth(Integer.MAX_VALUE);
        super.onCreateOptionsMenu(menu, inflater);

    }
    public void getLapsList(){
        Call<List<Lap>> call = lapService.getLaps();
        call.enqueue(new Callback<List<Lap>>() {
            @Override
            public void onResponse(Call<List<Lap>> call, Response<List<Lap>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(new ListLapAdapter(getActivity(), R.layout.list_itemlap, list));
                }
            }

            @Override
            public void onFailure(Call<List<Lap>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}