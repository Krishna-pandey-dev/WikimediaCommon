package com.example.wikimediacommon.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikimediacommon.Models.Imagedata;
import com.example.wikimediacommon.R;


public class ItemTypeAdapter extends RecyclerView.Adapter<ItemTypeAdapter.ItemtypeViewHolder> {
private Context context;
private Imagedata dataretrivals;

    public ItemTypeAdapter(Context context, Imagedata dataretrivals) {
        this.context = context;
        this.dataretrivals = dataretrivals;
    }

    @NonNull
    @Override
    public ItemtypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_type1,parent,false);
        return new ItemtypeViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ItemtypeViewHolder holder, int position) {
        Imagedata data = dataretrivals;
        try
        {

        }
        catch (NullPointerException ignored)
        {

        }


    }

        public int getItemCount() {
        return 10;
    }

    public class ItemtypeViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,description;
        ImageView image;
        ListView listView;
        CardView cardView;
        public ItemtypeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.question);
            description = itemView.findViewById(R.id.imagediscription);
            image = itemView.findViewById(R.id.imagetype1);
            listView = itemView.findViewById(R.id.Listview);
            cardView = itemView.findViewById(R.id.card);


        }
    }
}
