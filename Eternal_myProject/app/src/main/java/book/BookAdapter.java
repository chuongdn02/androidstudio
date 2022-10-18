package book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exemple.eternal_myproject.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    List<Book> mBds;

    public void setData(List<Book> list){
        this.mBds = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book bds = mBds.get(position);
        if(bds == null){
            return;
        }

        holder.img_bds.setImageResource(bds.getResourceId());
        holder.title_bds.setText(bds.getTitle());
    }

    @Override
    public int getItemCount() {
        if (mBds != null){
            return mBds.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_bds;
        private TextView title_bds;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            img_bds = itemView.findViewById(R.id.img_bds);
            title_bds = itemView.findViewById(R.id.title_bds);


        }
    }
}
