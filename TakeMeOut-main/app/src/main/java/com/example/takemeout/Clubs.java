package com.example.takemeout;

import android.content.Intent;
import android.os.Bundle;

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

public class    Clubs extends AppCompatActivity implements Adapter.OnPlaceListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);





        RecyclerView recyclerView = findViewById(R.id.rv_list);
        //ορισμός λίστας
        List<item> mlist=new ArrayList<>();
        mlist.add(new item(R.drawable.epu,"Epu Night Club","Γρ. Λαμπράκη 193","0","0"));
        mlist.add(new item(R.drawable.eight,"8Ball Club","Πίνδου 1","1","0"));
        mlist.add(new item(R.drawable.jadore,"J'adore Supreme Club","Φωκαίας 1 & Αβέρωφ","2","0"));
        mlist.add(new item(R.drawable.casper,"Casper at Verykoko","Παγγαίου 11","3","0"));
        mlist.add(new item(R.drawable.trap,"TRAP BASEMENT","Συγγρού 3","4","0"));



        //δημιουργία adapter
        Adapter adapter=new Adapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // λειτουργία του onPlaceListener
    @Override
    public void onPlaceClick(int position) {
        Intent intent;
        if (position == 0) {
            intent = new Intent(this, Epu.class);
        } else if (position == 1) {
            intent = new Intent(this, Eightball.class);
        } else if (position == 2) {
            intent = new Intent(this, Jadore.class);
        } else if (position==3) {
            intent = new Intent(this, Casper.class);
        } else {
            intent = new Intent(this, Trap.class);
        }

        startActivity(intent);

    }
}
