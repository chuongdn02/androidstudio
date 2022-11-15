package com.exemple.editlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class nghesyadapter extends RecyclerView.Adapter<nghesyadapter.RCVHolder> {
    private Context mContext;
    private List<nghesy> mListRCV;

    public nghesyadapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<nghesy> list){
        this.mListRCV = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public RCVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new nghesyadapter.RCVHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RCVHolder holder, int position) {
        nghesy nghesy = mListRCV.get(position);
        if (nghesy == null) {
            return;
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
        holder.img.setImageResource(nghesy.getImageId());
        holder.ten.setText(nghesy.getTen());
        holder.nghedanh.setText(nghesy.getNghedanh());
        holder.sosao.setText(nghesy.getSosao());
        holder.quocgia.setText(nghesy.getQuocgia());
    }



    @Override
    public int getItemCount() {
        if(mListRCV != null){
            return mListRCV.size();
        }
        return 0;
    }

    public class RCVHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        TextView ten,nghedanh,sosao,quocgia;
        public RCVHolder(@NonNull View itemView) {
            super(itemView);


            img = itemView.findViewById(R.id.profile_pic);
            ten = itemView.findViewById(R.id.ten);
            nghedanh = itemView.findViewById(R.id.nghedanh);
            sosao = itemView.findViewById(R.id.sosao);
            quocgia = itemView.findViewById(R.id.quocgia);
        }
    }
}
