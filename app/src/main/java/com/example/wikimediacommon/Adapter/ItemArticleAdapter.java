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

import com.example.wikimediacommon.ArticleModel.ItemArticleDataPOJO;
import com.example.wikimediacommon.R;

import java.util.List;

public class ItemArticleAdapter extends RecyclerView.Adapter<ItemArticleAdapter.ItemarticleViewHolder> {
    private Context context;
    private List<ItemArticleDataPOJO> list;

    public ItemArticleAdapter(Context context, List<ItemArticleDataPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemarticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_type2,parent,false);
        return new ItemarticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemarticleViewHolder holder, int position) {
        ItemArticleDataPOJO itemArticleDataPOJO = list.get(position);
        try {
//            holder.title.setText(itemArticleDataPOJO.getModel());
//            holder.description.setText(itemArticleDataPOJO.getData());
//
//            holder.title.setText(itemArticleDataPOJO.);

            //holder.webarticle.loadUrl(itemArticleDataPOJO.getData());
            holder.webarticle.loadData(itemArticleDataPOJO.getData(),"text/x-wiki","wikitext");




        }catch (Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ItemarticleViewHolder extends RecyclerView.ViewHolder {

        TextView title,description;
        ImageView images;
        WebView webarticle;

        public ItemarticleViewHolder(@NonNull View itemView) {
            super(itemView);
            webarticle = itemView.findViewById(R.id.web);
        }
    }

}
