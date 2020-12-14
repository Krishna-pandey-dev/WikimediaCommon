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
import com.example.wikimediacommon.Adapter.ItemArticleAdapter;
import com.example.wikimediacommon.Adapter.ItemTypeAdapter;
import com.example.wikimediacommon.ArticleModel.ArticleData;
import com.example.wikimediacommon.ArticleModel.ItemArticleDataPOJO;
import com.example.wikimediacommon.ArticleModel.MainArticleData;
import com.example.wikimediacommon.Models.ItemPOJO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArticleApiActivity extends AppCompatActivity {
    String url,nextarticlekey;
    List<ItemArticleDataPOJO> list;
    Boolean isScrolling=false;
    RecyclerView articlerecyclerView;
    int currentItems,totalItems,scrollOutItems;
    LinearLayoutManager manager;
    int sum=0;
    ItemArticleAdapter itemArticleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_api);
        list=new ArrayList<>();
        manager= new  LinearLayoutManager(this);
        articlerecyclerView = findViewById(R.id.recyclerviewarticle);
        articlerecyclerView.setLayoutManager(manager);
        //nextarticlekey = "0.440914716262|0.440914716262|0|0";
        fetchData();

    }

    private void fetchData() {
        url = "https://en.wikipedia.org/w/api.php?format=json&action=query&generator=random&grnnamespace=0&prop=revisions%7Cimages&rvprop=content&grnlimit=10";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("randomarticle", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                ArticleData articleData = gson.fromJson(response,ArticleData.class);
                try {
                    JSONObject json= new JSONObject(response);
                    JSONObject articleobject = json.getJSONObject("query");
                    JSONArray articlesarray = articleobject.toJSONArray(articleobject.names());
                    String a=articlesarray.get(0).toString();
                    Log.d("Array Values",a);

                    JSONObject json1= new JSONObject(articlesarray.get(0).toString());
                    String kept = a.substring( 0, a.indexOf(":"));
                    JSONObject articleObject1 = json1.getJSONObject(kept.replaceAll("[^0-9]", ""));
                    JSONArray songsArray1 = articleObject1.toJSONArray(articleObject1.names());

                    System.out.println("Abc "+articleObject1.toString());
                    MainArticleData mainArticleData = gson.fromJson(articleObject1.toString(),MainArticleData.class);
                    System.out.println("Datahai"+mainArticleData.getRevisions().get(0).getContentmodel());
                    System.out.println("Datahai"+mainArticleData.getRevisions().get(0).getContentformat());
                    System.out.println("Datahai"+mainArticleData.getRevisions().get(0).getArticlefile());

                    //list.add(new ItemArticleDataPOJO(mainArticleData.getRevisions().get(0).getContentmodel(),mainArticleData.getRevisions().get(0).getAtticlefile()));
                    list.add(new ItemArticleDataPOJO(mainArticleData.getRevisions().get(0).getContentmodel(),mainArticleData.getRevisions().get(0).getContentformat(),mainArticleData.getRevisions().get(0).getArticlefile()));

                } catch (Exception e) {
                }



                sum=sum+1;
                if (sum<1){
                    fetchData();
                }else {
                    itemArticleAdapter= new ItemArticleAdapter(ArticleApiActivity.this, list);
                    articlerecyclerView.setAdapter(itemArticleAdapter);
                }

                articlerecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                            itemArticleAdapter.notifyDataSetChanged();

                        }
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ArticleApiActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}