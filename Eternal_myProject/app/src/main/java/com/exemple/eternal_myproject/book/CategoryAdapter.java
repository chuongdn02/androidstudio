//package com.exemple.eternal_myproject.book;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.exemple.eternal_myproject.R;
//
//import java.util.List;
//
//public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
//
//    private Context mContext;
//    private List<Category> mListCategory;
//
//    public CategoryAdapter(Context mContext) {
//        this.mContext = mContext;
//    }
//    public void setData(List<Category> list){
//        this.mListCategory = list;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent,false);
//        return new CategoryViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
//        Category category = mListCategory.get(position);
//        if (category == null) {
//            return;
//        }
//
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
//        holder.rcvBook.setLayoutManager(linearLayoutManager);
//        RecycleAdapter recycleAdapter = new RecycleAdapter();
//        recycleAdapter.setData(category.getRecycle());
//        holder.rcvBook.setAdapter(recycleAdapter);
//        holder.textView.setText(category.getTextView());
//    }
//
//    @Override
//    public int getItemCount() {
//        if(mListCategory != null){
//            return mListCategory.size();
//        }
//        return 0;
//    }
//
//    public class CategoryViewHolder extends RecyclerView.ViewHolder{
//
//
//        private RecyclerView rcvBook;
//        private TextView textView;
//
//        public CategoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//           textView = itemView.findViewById(R.id.txt);
//            rcvBook = itemView.findViewById(R.id.laprcv);
//        }
//    }
//}
