package com.exemple.eternal_myproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.exemple.eternal_myproject.databinding.ActivityMainBinding;
import com.exemple.eternal_myproject.model.Lap;
import com.exemple.eternal_myproject.model.User;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class ListLapAdapter extends ArrayAdapter<Lap> implements Filterable {

    private Context context;

    private List<Lap> laps;
    Handler mainHandler = new Handler();
    ImageView lap_pic;
    TextView lap_name,lap_price;
    private List<Lap> mListLap;

    public ListLapAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Lap> objects) {
        super(context, resource, objects);
        this.context = context;
        this.laps = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_itemlap, parent, false);

        lap_name = (TextView) rowView.findViewById(R.id.lap_name);
         lap_price = (TextView) rowView.findViewById(R.id.lap_price);
        lap_pic = (ImageView) rowView.findViewById(R.id.lap_pic) ;



            lap_name.setText(String.format(" %s", laps.get(pos).getName()));
            lap_price.setText(String.format(" %s", laps.get(pos).getPrice()));

//            new FetchImage(laps.get(pos).getPic()).start();
        Picasso.get().load(laps.get(pos).getPic()).into(lap_pic);



        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("lap_name", laps.get(pos).getName());
                intent.putExtra("lap_price", laps.get(pos).getPrice());
                intent.putExtra("lap_title", laps.get(pos).getTitle());
                intent.putExtra("lap_manu", laps.get(pos).getManu());
                  intent.putExtra("lap_pic", laps.get(pos).getPic());

                context.startActivity(intent);
            }
        });

        return rowView;
    }

//    class FetchImage extends Thread{
//
//        String URL = null;
//        Bitmap bitmap;
//        FetchImage(String URL){
//
//            this.URL = URL;
//
//        }
//        @Override
//        public void run() {
//
//            InputStream inputStream = null;
//            try {
//                inputStream = new URL(URL).openStream();
//                bitmap = BitmapFactory.decodeStream(inputStream);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            mainHandler.post(new Runnable() {
//                @Override
//                public void run() {
//
//                    lap_pic.setImageBitmap(bitmap);
//
//                }
//            });
//
//
//
//
//        }
//    }
}