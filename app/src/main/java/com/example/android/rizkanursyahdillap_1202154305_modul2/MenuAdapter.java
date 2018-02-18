package com.example.android.rizkanursyahdillap_1202154305_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
/**
 * Created by asus on 2/17/2018.
 */

//membuat class menuadapter
public class MenuAdapter extends
        RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    //menampung data di adaptor
    private final LinkedList<String> mFoodList;
    private final LinkedList<Integer> mPriceList;
    private final LinkedList<Integer> mPhotoList;
    //membuat variabel anggota untuk inflater
    private LayoutInflater mInflater;

    //implementasi contstactor menyetel ke data yang diteruskan
    public MenuAdapter(Context context, LinkedList<String> foodList, LinkedList<Integer> priceList, LinkedList<Integer> photoList) {
        mInflater = LayoutInflater.from(context);
        this.mFoodList = foodList;
        this.mPriceList = priceList;
        this.mPhotoList = photoList;
    }

    @Override //mengembalikan holder tampilan dengan layout adaptor
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_menu, parent, false);
        return new MenuViewHolder(mItemView, this);
    }

    @Override// menghubungkan data kita ke holder tampilan
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        String mCurrentFood = mFoodList.get(position);
        Integer mCurrentPrice = mPriceList.get(position);
        Integer mCurrentPhoto = mPhotoList.get(position);
        holder.foodItemView.setText(mCurrentFood);
        holder.priceItemView.setText("Rp."+mCurrentPrice.toString());
        holder.photoItemView.setImageResource(mCurrentPhoto);
    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    } // mengisi method untuk mengembalikan ukuran

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{//untuk tampilan teks dan adaptor
        public final TextView foodItemView;
        public final TextView priceItemView;
        public final ImageView photoItemView;

        final MenuAdapter mAdapter;
        public MenuViewHolder(final View itemView, MenuAdapter adapter) {
            super(itemView);
            foodItemView = (TextView)itemView.findViewById(R.id.tv_food);
            priceItemView = (TextView)itemView.findViewById(R.id.tv_price);
            photoItemView = (ImageView)itemView.findViewById(R.id.iv_photo);
            photoItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // mendapatkan posisi item dari tampilanPosition
                    int mPosition = getLayoutPosition();
                    // guanakan item untuk list yang diinginkan
                    String food = mFoodList.get(mPosition);
                    Integer price = mPriceList.get(mPosition);
                    Integer photo = mPhotoList.get(mPosition);
                    Intent intent = new Intent(itemView.getContext(),DetailMenu.class);
                    intent.putExtra("food",food);
                    intent.putExtra("price",price);
                    intent.putExtra("photo",photo);
                    itemView.getContext().startActivity(intent);
                }
            });
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
