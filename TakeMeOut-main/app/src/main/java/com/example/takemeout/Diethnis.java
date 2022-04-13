package com.example.takemeout;

import android.content.Intent;
import android.os.Bundle;


import com.example.takemeout.stores.food.ElBurrito;
import com.example.takemeout.stores.food.Erebuni;
import com.example.takemeout.stores.food.Esperanto;
import com.example.takemeout.stores.food.Glikanisos;
import com.example.takemeout.stores.food.KivotosGeusewn;

import com.example.takemeout.stores.food.Momo;
import com.example.takemeout.stores.food.Nargis;
import com.example.takemeout.stores.food.Navona;
import com.example.takemeout.stores.food.NeaFolia;
import com.example.takemeout.stores.food.Negroponte;
import com.example.takemeout.stores.food.OuzeriToNisi;
import com.example.takemeout.stores.food.Palati;
import com.example.takemeout.stores.food.Siviria;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Diethnis extends AppCompatActivity implements Adapter.OnPlaceListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);





        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist=new ArrayList<>();
        mlist.add(new item(R.drawable.navona3,"Navona","Λεωφ. Μεγ. Αλεξάνδρου 2","9","0"));
        mlist.add(new item(R.drawable.momo,"Momo Asian Bar ","Κουντουριώτου 13","10","0"));
        mlist.add(new item(R.drawable.erebuni,"Erebuni","Λεωφ. Μεγάλου Αλεξάνδρου 45","11","0"));
        mlist.add(new item(R.drawable.nargis,"Nargis Indian Bar","Καπ. Πατρίκη 18 ","12","0"));
        mlist.add(new item(R.drawable.elburrito,"El Burrito","Χρυσοστόμου Σμύρνης 5","13","0"));
        mlist.add(new item(R.drawable.esperanto,"Esperanto","Επταλόφου 14, Κάτω Τούμπα","14","0"));
        mlist.add(new item(R.drawable.siviria,"Σιβηρία Πελμένι","Ιουστινιανού 12","15","0"));



        Adapter adapter=new Adapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onPlaceClick(int position) {
        Intent intent;
        if (position == 0) {
            intent = new Intent(this, Navona.class);
        } else if (position == 1) {
            intent = new Intent(this, Momo.class);
        } else if (position == 2) {
            intent = new Intent(this, Erebuni.class);
        } else if (position==3) {
            intent = new Intent(this, Nargis.class);
        } else if (position==4) {
            intent = new Intent(this, ElBurrito.class);
        } else if (position==5) {
            intent = new Intent(this, Esperanto.class);
        }else {
            intent=new Intent(this, Siviria.class);
        }

        startActivity(intent);

    }
}
