//package com.exemple.eternal_myproject.book;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.exemple.eternal_myproject.R;
//import com.exemple.eternal_myproject.model.Lap;
//
//import java.util.List;
//
//public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.BookViewHolder> {
//
//    List<Lap> mRecycle;
//
//    public void setData(List<Lap> list){
//        this.mRecycle = list;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv,parent,false);
//        return new BookViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
//        Lap lap = mRecycle.get(position);
//        if(lap == null){
//            return;
//        }
//
////        holder.img_rcv1.setImageResource(lap.getResourceId());
//        holder.title_rcv1.setText(lap.getName());
//        holder.title_rcv2.setText(lap.getPrice());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mRecycle != null){
//            return mRecycle.size();
//        }
//        return 0;
//    }
//
//    public class BookViewHolder extends RecyclerView.ViewHolder{
//
//        private ImageView img_rcv1;
//        private TextView title_rcv1,title_rcv2;
//
//        public BookViewHolder(@NonNull View itemView) {
//            super(itemView);
//            img_rcv1 = itemView.findViewById(R.id.img_rcv1);
//            title_rcv1 = itemView.findViewById(R.id.title_rcv1);
//            title_rcv2 = itemView.findViewById(R.id.title_rcv2);
//
//
//        }
//    }
//}
