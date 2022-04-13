package com.example.takemeout;

import android.content.Intent;
import android.os.Bundle;


import com.example.takemeout.stores.food.Glikanisos;
import com.example.takemeout.stores.food.KivotosGeusewn;

import com.example.takemeout.stores.food.NeaFolia;
import com.example.takemeout.stores.food.Negroponte;
import com.example.takemeout.stores.food.OuzeriToNisi;
import com.example.takemeout.stores.food.Palati;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Taverns extends AppCompatActivity implements Adapter.OnPlaceListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);





        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist=new ArrayList<>();
        mlist.add(new item(R.drawable.fwlia,"Νέα Φωλιά","Αριστομένους 4 ","22","0"));
        mlist.add(new item(R.drawable.ouzeri,"Ουζέρι το Νησί ","Πολυτεχνείου 18","23","0"));
        mlist.add(new item(R.drawable.glikanisos,"Γλυκάνισος","Μεγάλου Αλεξάνδρου 46","24","0"));
        mlist.add(new item(R.drawable.negroponte,"Negroponte","Αιγύπτου 24 Κατούνη 21","25","0"));
        mlist.add(new item(R.drawable.kivotos,"Κιβωτός των Γεύσεων","Πατριάρχου Ιωακείμ 26","26","0"));
        mlist.add(new item(R.drawable.palati,"Palati","Πλατεία Μοριχόβου 6","27","0"));



        Adapter adapter=new Adapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onPlaceClick(int position) {
        Intent intent;
        if (position == 0) {
            intent = new Intent(this, NeaFolia.class);
        } else if (position == 1) {
            intent = new Intent(this, OuzeriToNisi.class);
        } else if (position == 2) {
            intent = new Intent(this, Glikanisos.class);
        } else if (position==3) {
            intent = new Intent(this, Negroponte.class);
        } else if (position==4) {
            intent = new Intent(this, KivotosGeusewn.class);
        }
        else {
            intent=new Intent(this, Palati.class);
        }

        startActivity(intent);

    }
}
