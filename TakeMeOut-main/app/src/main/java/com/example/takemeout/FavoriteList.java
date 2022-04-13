package com.example.takemeout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.takemeout.database.FavDB;
import com.example.takemeout.stores.drinks.Casper;
import com.example.takemeout.stores.drinks.Eightball;
import com.example.takemeout.stores.drinks.Epu;
import com.example.takemeout.stores.drinks.Jadore;
import com.example.takemeout.stores.drinks.Trap;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavoriteList extends AppCompatActivity {

     RecyclerView recyclerView;
     FavDB favDB;
     List<FavItem> favItemList = new ArrayList<>();
     FavAdapter adapter;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);



        favDB = new FavDB(this);

        recyclerView = findViewById(R.id.rv_list);




        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();
    }


    private void loadData(){
        if (favItemList !=null) {
            favItemList.clear();
        }
        SQLiteDatabase db = favDB.getReadableDatabase();
        Cursor cursor = favDB.select_all_favorite_list();
        try{
            while (cursor.moveToNext()){
                String title = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_TITLE));
                String id = cursor.getString(cursor.getColumnIndex(FavDB.KEY_ID));
                String odos = cursor.getString(cursor.getColumnIndex(FavDB.ADDRESS));
                int image = Integer.parseInt(cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE)));
                String status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                FavItem favItem = new FavItem(image,title,odos,id,status);
                favItemList.add(favItem);
            }

        }finally {
            if (cursor !=null && cursor.isClosed())
                cursor.close();
            db.close();
        }
        adapter= new FavAdapter(this,favItemList);
        recyclerView.setAdapter(adapter);    }
}
