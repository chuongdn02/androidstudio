package com.exemple.eternal_myproject.book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.exemple.eternal_myproject.Detail;
import com.exemple.eternal_myproject.R;
import com.exemple.eternal_myproject.model.Lap;
import com.squareup.picasso.Picasso;

import java.util.List;

public class lapAdapter extends RecyclerView.Adapter<lapAdapter.BookViewHolder> {

    List<Lap> list;
    Context context;


    public lapAdapter(List<Lap> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Lap lap = list.get(position);
        if (lap == null) {
            return;
        }


        holder.title_rcv1.setText(list.get(position).getManu());
        holder.title_rcv2.setText(list.get(position).getPrice());
        Picasso.get().load(list.get(position).getPic()).into(holder.img_rcv1);
        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("lap_name", list.get(position).getName());
                intent.putExtra("lap_price", list.get(position).getPrice());
                intent.putExtra("lap_title", list.get(position).getTitle());
                intent.putExtra("lap_manu", list.get(position).getManu());
                intent.putExtra("lap_pic",list.get(position).getPic());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_rcv1;
        private TextView title_rcv1, title_rcv2;
        CardView layout_item;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            img_rcv1 = itemView.findViewById(R.id.img_rcv1);
            title_rcv1 = itemView.findViewById(R.id.title_rcv1);
            title_rcv2 = itemView.findViewById(R.id.title_rcv2);
            layout_item = itemView.findViewById(R.id.layout_item);


        }
    }
}
//}
