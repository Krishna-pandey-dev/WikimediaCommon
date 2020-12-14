package com.example.wikimediacommon.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wikimediacommon.ApiActivity;
import com.example.wikimediacommon.Models.Imagedata;
import com.example.wikimediacommon.Models.ItemPOJO;
import com.example.wikimediacommon.R;

import java.util.List;


public class ItemTypeAdapter extends RecyclerView.Adapter<ItemTypeAdapter.ItemtypeViewHolder> {
private Context context;
private List<ItemPOJO> list;

    public ItemTypeAdapter(Context context, List<ItemPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemtypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_type1,parent,false);
        return new ItemtypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemtypeViewHolder holder, int position) {
        ItemPOJO itemPOJO= list.get(position);
        holder.title.setText(itemPOJO.getTitle());
                        Glide
                        .with(context)
                        .load(itemPOJO.getImageurl())
                        .centerCrop()
                        .into(holder.image);
                        holder.webView.setVisibility(View.INVISIBLE);
                         holder.hide.setVisibility(View.INVISIBLE);
                        holder.image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                holder.webView.setVisibility(View.VISIBLE);
                                holder.hide.setVisibility(View.VISIBLE);
                                holder.webView.loadUrl(itemPOJO.getDescription());
                            }
                        });
                        holder.hide.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                holder.webView.setVisibility(View.GONE);
                                holder.hide.setVisibility(View.INVISIBLE);
                            }
                        });

    }

        public int getItemCount() {
        return list.size();
    }

    public static class ItemtypeViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,desciption,hide;
        ImageView image;
        WebView webView;
        public ItemtypeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.question);
            image = itemView.findViewById(R.id.imagetype1);
            webView = itemView.findViewById(R.id.webview);
            hide = itemView.findViewById(R.id.hide);

        }
    }
}
