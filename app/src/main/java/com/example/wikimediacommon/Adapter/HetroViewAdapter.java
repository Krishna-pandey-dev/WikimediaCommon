package com.example.wikimediacommon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wikimediacommon.ArticleModel.ItemArticleDataPOJO;
import com.example.wikimediacommon.Models.Item;
import com.example.wikimediacommon.Models.ItemPOJO;
import com.example.wikimediacommon.R;

import java.util.List;

public class HetroViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(viewType == 0)
       {
           return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type1,parent,false));

       }
       else
       {
           return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type2,parent,false));

       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position)==0)
        {
        ItemPOJO pojo = (ItemPOJO) items.get(position).getObject();
            ((ImageViewHolder) holder).setImageData(pojo);
        }
        else
        {
            ItemArticleDataPOJO dataPOJO = (ItemArticleDataPOJO) items.get(position).getObject();
            ((ArticleViewHolder) holder).setArticleData(dataPOJO);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,desciption,hide;
        ImageView image;
        WebView webView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.question);
            image = itemView.findViewById(R.id.imagetype1);
            webView = itemView.findViewById(R.id.webview);
        }
        void setImageData(ItemPOJO imageData)
        {
            title.setText(imageData.getTitle());
            Context context = null;
            image.setImageResource(Integer.parseInt(imageData.getImageurl()));
//            Glide
//                    .with(context)
//                    .load(imageData.getImageurl())
//                    .centerCrop()
//                    .into(image);
        }
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,description;
        ImageView images;
        WebView webarticle;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            webarticle = itemView.findViewById(R.id.web);
        }
        void setArticleData(ItemArticleDataPOJO articleData)
        {
            webarticle.loadData(articleData.getData(),"text/x-wiki","wikitext");
        }
    }


}
