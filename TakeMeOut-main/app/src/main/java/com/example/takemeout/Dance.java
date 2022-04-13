package com.example.takemeout;

import android.content.Intent;
import android.os.Bundle;

import com.example.takemeout.stores.drinks.Habanita;
import com.example.takemeout.stores.drinks.LaRosaNegra;
import com.example.takemeout.stores.drinks.TangoBar;
import com.example.takemeout.stores.drinks.Xarhakos;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dance extends AppCompatActivity implements Adapter.OnPlaceListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);


        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist=new ArrayList<>();
        mlist.add(new item(R.drawable.ksar,"Ξαρχάκος coffee & drinks","Πάρκο ΧΑΝΘ","5","0"));
        mlist.add(new item(R.drawable.larosa,"La Rosa Negra Latin Club","Καρατάσου 3","6","0"));
        mlist.add(new item(R.drawable.tango,"Tango Bar","Διαμ. Ολυμπίου 19","7","0"));
        mlist.add(new item(R.drawable.habanita,"Habanita Latin Bar","Περιστερίου 6","8","0"));




        Adapter adapter=new Adapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onPlaceClick(int position) {
        Intent intent;
        if (position == 0) {
            intent = new Intent(this, Xarhakos.class);
        } else if (position == 1) {
            intent = new Intent(this, LaRosaNegra.class);
        } else if (position == 2) {
            intent = new Intent(this, TangoBar.class);
        } else {
            intent = new Intent(this, Habanita.class);
        }

        startActivity(intent);

    }
}
