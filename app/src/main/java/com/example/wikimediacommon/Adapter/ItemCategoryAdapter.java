package com.example.wikimediacommon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikimediacommon.CategoryModel.Allcategory;
import com.example.wikimediacommon.CategoryModel.CategoryPOJO;
import com.example.wikimediacommon.R;

import java.util.List;

public class ItemCategoryAdapter extends RecyclerView.Adapter<ItemCategoryAdapter.CategorytypeViewHolder>
{
    private Context context;
    private List<CategoryPOJO> list;

    public ItemCategoryAdapter(Context context, List<CategoryPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CategorytypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_type3,parent,false);
        return new CategorytypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorytypeViewHolder holder, int position) {
        CategoryPOJO allcategory = list.get(position);
        holder.category.setText(allcategory.getCategorydata());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CategorytypeViewHolder extends RecyclerView.ViewHolder {

        TextView category;
        public CategorytypeViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.categorylistdata);
        }
    }
}
