package com.exemple.eternal_myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import book.Book;
import book.Category;
import book.CategoryAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        List<Book> listBook = new ArrayList<>();
        listBook.add(new Book(R.drawable.bds,"Bat Dong San1"));
        listBook.add(new Book(R.drawable.bds,"Bat Dong San2"));
        listBook.add(new Book(R.drawable.bds,"Bat Dong San3"));
        listBook.add(new Book(R.drawable.bds,"Bat Dong San4"));

        listBook.add(new Book(R.drawable.bds,"Bat Dong San5"));
        listBook.add(new Book(R.drawable.bds,"Bat Dong San6"));
        listBook.add(new Book(R.drawable.bds,"Bat Dong San7"));
        listBook.add(new Book(R.drawable.bds,"Bat Dong San8"));

        list.add(new Category("Category1",listBook));
        list.add(new Category("Category2",listBook));
        list.add(new Category("Category3",listBook));
        list.add(new Category("Category4",listBook));


        return list;
    }


}