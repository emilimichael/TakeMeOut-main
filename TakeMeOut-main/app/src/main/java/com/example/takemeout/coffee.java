package com.example.takemeout;

import android.content.Intent;
import android.os.Bundle;


import com.example.takemeout.stores.coffee.Arxegono;
import com.example.takemeout.stores.coffee.Boulevard;
import com.example.takemeout.stores.coffee.Castra;
import com.example.takemeout.stores.coffee.Diatiriteo;
import com.example.takemeout.stores.coffee.Diorofon;
import com.example.takemeout.stores.coffee.DomatioThea;
import com.example.takemeout.stores.coffee.Efimerida;
import com.example.takemeout.stores.coffee.Enoxes;
import com.example.takemeout.stores.coffee.KitrinoPodilato;
import com.example.takemeout.stores.coffee.LeJardin;
import com.example.takemeout.stores.coffee.Madison;
import com.example.takemeout.stores.coffee.ProtoPatoma;
import com.example.takemeout.stores.coffee.Shark;
import com.example.takemeout.stores.coffee.ToTsai;
import com.example.takemeout.stores.coffee.Urban;
import com.example.takemeout.stores.coffee.Υpsilon;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class coffee extends AppCompatActivity implements Adapter.OnPlaceListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_list);
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist=new ArrayList<>();

        Adapter adapter=new Adapter(this,mlist,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





        mlist.add(new item(R.drawable.domatio_me_thea,"Δωμάτιο με Θέα","Πλ. Αριστοτέλους 10","34","0"));
        mlist.add(new item(R.drawable.tsai,"Το Τσάι","Καρόλου Ντηλ 27","35","0"));
        mlist.add(new item(R.drawable.patwma,"Πρώτο Πάτωμα","Τσιμισκή 97","36","0"));
        mlist.add(new item(R.drawable.podilato,"Κίτρινο Ποδήλατο","Στρ. Ναπολέοντος Ζέρβα 3","37","0"));
        mlist.add(new item(R.drawable.jardin,"Le Jardin Extraordinaire Café","Παλαιών Πατρών Γερμανού 8","38","0"));
        mlist.add(new item(R.drawable.urban,"Urban Cafe","Ζεύξιδος 7","39","0"));
        mlist.add(new item(R.drawable.enoxes,"Ενοχές","Πλατεία Ναυαρίνου 15","40","0"));
        mlist.add(new item(R.drawable.efimerida,"Εφημερίδα","Φιλικής Εταιρείας 11","41","0"));
        mlist.add(new item(R.drawable.ypsilon,"Ypsilon","Εδέσσης 5","42","0"));
        mlist.add(new item(R.drawable.boulevard,"Boulevard 23","Λεωφ. Νίκης 25","43","0"));
        mlist.add(new item(R.drawable.madison,"Madison","Αλ. Σβώλου 44","44","0"));
        mlist.add(new item(R.drawable.diorofon,"Διώροφον","Κερασούντος 81","45","0"));
        mlist.add(new item(R.drawable.diatiriteo,"Το Διατηρητέο","Ικτίνου 12","46","0"));
        mlist.add(new item(R.drawable.castra,"Castra All Day Terrace Bar","Επταπυργίου 122","47","0"));
        mlist.add(new item(R.drawable.shark,"Shark","Αργοναυτών 2, Καλαμαριά","48","0"));
        mlist.add(new item(R.drawable.arxegono,"Αρχέγονο","25ης Μαρτίου 12","49","0"));

    }

    @Override
    public void onPlaceClick(int position) {
        Intent intent;
        if (position == 0) {
            intent = new Intent(this, DomatioThea.class);
        } else if (position == 1) {
            intent = new Intent(this, ToTsai.class);
        } else if (position == 2) {
            intent = new Intent(this, ProtoPatoma.class);
        } else if (position == 3) {
            intent = new Intent(this, KitrinoPodilato.class);
        } else if (position == 4) {
            intent = new Intent(this, LeJardin.class);
        } else if (position == 5){
            intent = new Intent(this, Urban.class);
        } else if (position == 6) {
            intent = new Intent(this, Enoxes.class);
        } else if (position == 7) {
            intent = new Intent(this, Efimerida.class);
        } else if (position == 8) {
            intent = new Intent(this, Υpsilon.class);
        } else if (position == 9) {
            intent = new Intent(this, Boulevard.class);
        } else if (position == 10) {
            intent = new Intent(this, Madison.class);
        } else if (position == 11) {
            intent = new Intent(this, Diorofon.class);
        } else if (position == 12) {
            intent = new Intent(this, Diatiriteo.class);
        } else if (position == 13) {
            intent = new Intent(this, Castra.class);
        } else if (position == 14) {
            intent = new Intent(this, Shark.class);
        } else {
            intent = new Intent(this, Arxegono.class);
        }

        startActivity(intent);

    }
}
