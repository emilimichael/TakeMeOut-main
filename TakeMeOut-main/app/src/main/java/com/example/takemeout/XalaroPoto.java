package com.example.takemeout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.takemeout.stores.drinks.LenasBistro;
import com.example.takemeout.stores.drinks.Local;
import com.example.takemeout.stores.drinks.One;
import com.example.takemeout.stores.drinks.RedRoseBar;
import com.example.takemeout.stores.drinks.Senor;
import com.example.takemeout.stores.drinks.StoreParaty;

import java.util.ArrayList;
import java.util.List;

public class XalaroPoto extends AppCompatActivity implements Adapter.OnPlaceListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);



        //setup recyclerview me ton adapter

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist=new ArrayList<>();
        mlist.add(new item(R.drawable.paraty_and_loft,"Paraty and Loft","Πίνδου 8, Λαδάδικα","28","0"));
        mlist.add(new item(R.drawable.lenas,"Lena's Bistro","Κατούνη 7","29","0"));
        mlist.add(new item(R.drawable.senor,"Senor","Προξένου Κορομηλά 1","30","0"));
        mlist.add(new item(R.drawable.one,"ONE","Καρόλου Ντήλ 1","31","0"));
        mlist.add(new item(R.drawable.red_rose_bar,"Red Rose Bar","Στοά Βενιζέλου","32","0"));
        mlist.add(new item(R.drawable.local,"Local","Π. Πατρών Γερμανού 17\n & Παύλου Μελά γωνία","33","0"));


        Adapter adapter=new Adapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public void onPlaceClick(int position) {
        Intent intent;
        if (position == 0) {
            intent = new Intent(this, StoreParaty.class);
        } else if (position == 1) {
            intent = new Intent(this, LenasBistro.class);
        } else if (position == 2) {
            intent = new Intent(this, Senor.class);
        } else if (position==3) {
            intent = new Intent(this, One.class);
        } else if (position==4) {
            intent = new Intent(this, RedRoseBar.class);
        } else {
            intent = new Intent(this, Local.class);
        }

        startActivity(intent);
    }




    }
