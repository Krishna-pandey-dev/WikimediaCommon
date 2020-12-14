package com.example.wikimediacommon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wikimediacommon.Adapter.ItemCategoryAdapter;
import com.example.wikimediacommon.CategoryModel.Allcategory;
import com.example.wikimediacommon.CategoryModel.CategoryPOJO;
import com.example.wikimediacommon.CategoryModel.Categoryinfo;
import com.example.wikimediacommon.CategoryModel.Query;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CategoryApiActivity extends AppCompatActivity {

    String url ;
    List<CategoryPOJO> list;
    String nextpagekey;
    RecyclerView Categoryrecyclerview;
    Boolean isScrolling=false;
    int currentItems,totalItems,scrollOutItems;
    LinearLayoutManager manager;
    int sum=0;
    ItemCategoryAdapter itemCategoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_api);
        list=new ArrayList<CategoryPOJO>();
        manager= new  LinearLayoutManager(this);
        Categoryrecyclerview = findViewById(R.id.categoryrecyclerview);
        Categoryrecyclerview.setLayoutManager(manager);
        nextpagekey = "List_of_BioWare_characters";
        fetchData();
    }

    private void fetchData() {
        url = "https://en.wikipedia.org/w/api.php?action=query&list=allcategories&acprefix=List+of&formatversion=2&format=json&accontinue="+nextpagekey;
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("yes", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Categoryinfo datas = gson.fromJson(response, Categoryinfo.class);
                nextpagekey = datas.getContinue().getAccontinue();

                try {
                    JSONObject json = new JSONObject(response);
                    JSONObject songsObject = json.getJSONObject("query");
                    JSONArray songsArray = songsObject.toJSONArray(songsObject.names());
                    Query mainData = gson.fromJson(songsObject.toString(), Query.class);
                    System.out.println("Datahai : = " + mainData.getAllcategories().get(0).getCategory());

                    int i;
                    for (i = 0; i < 10; i++) {
                        list.add(new CategoryPOJO(mainData.getAllcategories().get(i).getCategory()));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                sum=sum+1;
                if (sum<5){
                    fetchData();
                }else {
                    ItemCategoryAdapter itemCategoryAdapter = new ItemCategoryAdapter(CategoryApiActivity.this, list);
                    Categoryrecyclerview.setAdapter(itemCategoryAdapter);
                }
                Categoryrecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if (newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                            isScrolling=true;
                        }
                    }

                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        currentItems=manager.getChildCount();
                        totalItems=manager.getItemCount();
                        scrollOutItems =manager.findFirstVisibleItemPosition();
                        if (isScrolling &&(currentItems + scrollOutItems == totalItems)){
                            isScrolling=false;
                            fetchData();
                            itemCategoryAdapter.notifyDataSetChanged();

                        }
                    }
                });


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CategoryApiActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}