package com.exemple.eternal_myproject.rcv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exemple.eternal_myproject.R;

import java.util.List;

public class RCV_T_Adapter extends RecyclerView.Adapter<RCV_T_Adapter.RCVHolder> {
    private Context mContext;
    private List<RCV_T> mListRCV;

    public RCV_T_Adapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<RCV_T> list){
        this.mListRCV = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public RCVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top, parent,false);
        return new RCV_T_Adapter.RCVHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RCVHolder holder, int position) {
        RCV_T rcv_t = mListRCV.get(position);
        if (rcv_t == null) {
            return;
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.imageButton.setImageResource(rcv_t.getResourceId());

    }



    @Override
    public int getItemCount() {
        if(mListRCV != null){
            return mListRCV.size();
        }
        return 0;
    }

    public class RCVHolder extends RecyclerView.ViewHolder {
        private ImageButton imageButton;
        public RCVHolder(@NonNull View itemView) {
            super(itemView);

            imageButton = itemView.findViewById(R.id.img_rt);
        }
    }
}
