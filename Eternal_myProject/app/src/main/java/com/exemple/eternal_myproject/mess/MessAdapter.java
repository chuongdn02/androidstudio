package com.exemple.eternal_myproject.mess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exemple.eternal_myproject.R;

import java.util.List;

public class MessAdapter extends RecyclerView.Adapter<MessAdapter.MessageViewHolder> {

    private List<Message> messageList;

    public void setData(List<Message> list){
        this.messageList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent,false);

        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (message == null) {
            return;
        }

        holder.txtmess.setText(message.getMessage());

    }

    @Override
    public int getItemCount() {
        if (messageList != null){
            return messageList.size();
        }
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{

        private TextView txtmess;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtmess = itemView.findViewById(R.id.txtmess);
        }
    }
}
