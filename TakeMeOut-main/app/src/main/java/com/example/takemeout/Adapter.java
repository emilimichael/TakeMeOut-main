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

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
    private Context mContext;
    private List<item> mData; //λιστα μαγαζιών
    private FavDB favDB; // βαση δεδομενων
    private OnPlaceListener mOnPlaceListener ;

    //constructor
    public Adapter(Context mContext, List<item> mData,OnPlaceListener mOnPlaceListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.mOnPlaceListener=mOnPlaceListener;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.card_item,parent,false);
        favDB = new FavDB(mContext);
        //create table on first
        SharedPreferences prefs= mContext.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        return new myViewHolder(v,mOnPlaceListener);
    }

    // οριζουμε το item
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        final item item = mData.get(position); //ανάλογα με την θέση του βάζουμε και τις αντίστοιχες πληροφορίες

        readCursorData(item, holder);

        holder.background_img.setImageResource(item.getBackground());
        holder.titlos_magaziou.setText(item.getTitlosMagaziou());
        holder.odos_magaziou.setText(item.getOdosMagaziou());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    } //σύνολο μαγαζιών σε μια λιστα


    // ορισμός λίστας μαγαζιών
    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView background_img;
        TextView titlos_magaziou, odos_magaziou;
        OnPlaceListener onPlaceListener;
        Button favBtn;


        public myViewHolder(View itemView,OnPlaceListener onPlaceListener) {
            super(itemView);
            background_img = itemView.findViewById(R.id.card_background);
            titlos_magaziou = itemView.findViewById(R.id.card_title);
            odos_magaziou = itemView.findViewById(R.id.card_nb);
            favBtn = itemView.findViewById(R.id.favBtn);
            this.onPlaceListener = onPlaceListener;
            itemView.setOnClickListener(this);


            // εισαγωγή ή διαγραφή απο την βάση με τα αγαπημένα μαγαζιά
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    item item = mData.get(position);

                    if (item.getFavStatus().equals("0")) {

                        item.setFavStatus("1");
                        favDB.insertIntoTheDatabase(item.getTitlosMagaziou(), item.getOdosMagaziou(),
                                item.getBackground(), item.getKey_id(), item.getFavStatus());
                        favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24);
                        favBtn.setSelected(true);
                    }
                    else {
                        item.setFavStatus("0");
                        favDB.remove_fave(item.getKey_id());
                        favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                        favBtn.setSelected(false);
                    }
                }
            });

        }

        @Override
        public void onClick(View view) {
            onPlaceListener.onPlaceClick(getAdapterPosition());
        }
    }

        public interface OnPlaceListener{
            void onPlaceClick(int position);
        }




        private void readCursorData(item item, myViewHolder viewHolder){
        Cursor cursor = favDB.read_all_data(item.getKey_id());
            SQLiteDatabase db = favDB.getReadableDatabase();
            try {
                while (cursor.moveToNext()) {
                    String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                    item.setFavStatus(item_fav_status);
                    //check fav status

                    if (item_fav_status != null && item_fav_status.equals("1")) {
                        viewHolder.favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24);
                    } else if (item_fav_status != null && item_fav_status.equals("0")) {
                        viewHolder.favBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);

                    }
                }
            } finally {
                if (cursor != null && cursor.isClosed())
                    cursor.close();
                db.close();
            }

        }


}
