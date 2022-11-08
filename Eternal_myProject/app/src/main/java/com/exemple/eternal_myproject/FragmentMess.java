package com.exemple.eternal_myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.exemple.eternal_myproject.mess.Message;
import com.exemple.eternal_myproject.mess.MessAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentMess extends Fragment {
    private EditText editText;
    private Button button;
    private RecyclerView rcvMessage;
    private MessAdapter messAdapter;
    private List<Message> messages;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mess, container, false);
        editText = view.findViewById(R.id.edt_mess);
        button = view.findViewById(R.id.btn_send);
        rcvMessage = view.findViewById(R.id.rcv_mess);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvMessage.setLayoutManager(linearLayoutManager);

        messages = new ArrayList<>();
        messAdapter = new MessAdapter();
        messAdapter.setData(messages);

        rcvMessage.setAdapter(messAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });


        return view;
    }


    private void sendMessage(){
        String stringMess = editText.getText().toString().trim();
        if ( TextUtils.isEmpty(stringMess)){
            return;
        }
        messages.add(new Message(stringMess));
        messAdapter.notifyDataSetChanged();
        rcvMessage.scrollToPosition(messages.size()-1);
        editText.setText("");
    }
}