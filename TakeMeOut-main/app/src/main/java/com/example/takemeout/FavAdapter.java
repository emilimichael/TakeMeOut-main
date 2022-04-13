package com.example.takemeout;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import com.example.takemeout.item;
import com.example.takemeout.database.FavDB;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.takemeout.database.FavDB;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.myViewHolder> {
    private Context mContext;
    private List<FavItem> favItemList;
    private FavDB favDB;


    public FavAdapter(Context mContext, List<FavItem> favItemList) {
        this.mContext = mContext;
        this.favItemList = favItemList;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.card_fav_item, parent, false);
        favDB = new FavDB(mContext);


        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        holder.background_img.setImageResource(favItemList.get(position).getBackground());
        holder.titlos_magaziou.setText(favItemList.get(position).getTitlosMagaziou());
        holder.odos_magaziou.setText(favItemList.get(position).getOdosMagaziou());

    }

    @Override
    public int getItemCount() {
        return favItemList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView background_img;
        TextView titlos_magaziou, odos_magaziou;

        Button favBtn;


        public myViewHolder(View itemView) {
            super(itemView);
            background_img = itemView.findViewById(R.id.card_background);
            titlos_magaziou = itemView.findViewById(R.id.card_title);
            odos_magaziou = itemView.findViewById(R.id.card_nb);
            favBtn = itemView.findViewById(R.id.favBtn);




            //remove from Fav
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final FavItem favitem = favItemList.get(position);
                    favDB.remove_fave(favitem.getKey_id());
                    removeItem(position);
                }
            });

        }


        private void removeItem(int position) {
            favItemList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, favItemList.size());
        }
    }

}






