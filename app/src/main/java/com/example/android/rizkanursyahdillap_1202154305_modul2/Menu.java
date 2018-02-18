package com.example.android.rizkanursyahdillap_1202154305_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
public class Menu extends AppCompatActivity {

    private final LinkedList<String> foods = new LinkedList<>();
    private final LinkedList<Integer> priceses = new LinkedList<>();
    private final LinkedList<Integer> photos = new LinkedList<>();
    private int mCount = 0;

    private RecyclerView mRecyclerView;
    private MenuAdapter mAdapter;

    @Override //membuat recyclerview dan menghubungkannya dengan adaptor dan data
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        dummiesData();
        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new MenuAdapter(this, foods, priceses, photos);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    //membuat data recycler
    private void dummiesData(){
        for (int i = 0;i < 3; i++){
            foods.add("Nasi Goreng");
            foods.add("Ayam Penyet");
            foods.add("Ayam Bakar");
            foods.add("Ayam Rica rica");
            foods.add("Soto Ayam");
            foods.add("Batagor");
            foods.add("Siomay");

            priceses.add(10000);
            priceses.add(15000);
            priceses.add(17000);
            priceses.add(16000);
            priceses.add(13000);
            priceses.add(5000);
            priceses.add(5000);

            photos.add(R.drawable.nasigoreng);
            photos.add(R.drawable.ayampenyet);
            photos.add(R.drawable.ayambakar);
            photos.add(R.drawable.ayamrica);
            photos.add(R.drawable.sotoayam);
            photos.add(R.drawable.batagor);
            photos.add(R.drawable.siomay);
        }
    }
}
