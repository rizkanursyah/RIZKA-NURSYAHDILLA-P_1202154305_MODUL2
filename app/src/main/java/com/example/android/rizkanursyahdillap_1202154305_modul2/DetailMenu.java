package com.example.android.rizkanursyahdillap_1202154305_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
public class DetailMenu extends AppCompatActivity {

    TextView tv_food, tv_price;//deklarasi objek
    ImageView iv_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //method yang pertama kali dijalankan ketika aplikasi berjalan
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        Intent intent = getIntent();//buat intent
        String food = intent.getStringExtra("food");//mengambil data dari activity sebelumnya
        Integer price = intent.getIntExtra("price",0);
        Integer photo = intent.getIntExtra("photo",0);

        Log.d("getIntExtra", ""+price+photo);//logcat

        tv_food = (TextView)findViewById(R.id.tv_detailFood);//mengambil id dari xml
        tv_price = (TextView)findViewById(R.id.tv_detailPrice);
        iv_photo = (ImageView)findViewById(R.id.iv_detailPhoto);

        tv_food.setText(food);//mengisi komponen data dengan setText
        tv_price.setText("Rp. "+price);
        iv_photo.setImageResource(photo);
    }
}
