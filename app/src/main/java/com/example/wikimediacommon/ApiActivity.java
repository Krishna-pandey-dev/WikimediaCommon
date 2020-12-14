package com.example.wikimediacommon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wikimediacommon.Adapter.ItemTypeAdapter;
import com.example.wikimediacommon.Models.Imagedata;
import com.example.wikimediacommon.Models.ItemPOJO;
import com.example.wikimediacommon.Models.MainData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApiActivity extends AppCompatActivity {
    String url;

    List<ItemPOJO> list;
    String nextPageKey;
   RecyclerView recyclerView;
   Boolean isScrolling=false;
   int currentItems,totalItems,scrollOutItems;
    LinearLayoutManager manager;
    int sum=0;
    ItemTypeAdapter itemTypeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        list=new ArrayList<>();
        manager= new  LinearLayoutManager(this);
        recyclerView = findViewById(R.id.Recyclerview);
        recyclerView.setLayoutManager(manager);
        nextPageKey="file|30312043414c414e434845205049414e412e4a50470a30312043414c414e434845205049414e412e4a5047|28822769";
        fetchData();
    }



    public void fetchData(){
        url = "https://commons.wikimedia.org/w/api.php?action=query&prop=imageinfo&iiprop=timestamp%7Cuser%7Curl&generator=categorymembers&gcmtype=file&gcmtitle=Category:Featured_pictures_on_Wikimedia_Commons&format=json&gcmcontinue=%20"+nextPageKey;
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("yes", response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Imagedata datas = gson.fromJson(response, Imagedata.class);

                nextPageKey=datas.getContinue().getGcmcontinue();


                try {
                    JSONObject json= new JSONObject(response);
                    JSONObject songsObject = json.getJSONObject("query");
                    JSONArray songsArray = songsObject.toJSONArray(songsObject.names());
                    String a=songsArray.get(0).toString();

                    Log.d("Array Values",a);
                    System.out.println("Array Values"+a);
                    JSONObject json1= new JSONObject(songsArray.get(0).toString());

                    String kept = a.substring( 0, a.indexOf(":"));
                    JSONObject songsObject1 = json1.getJSONObject(kept.replaceAll("[^0-9]", ""));
                    JSONArray songsArray1 = songsObject1.toJSONArray(songsObject1.names());

                    System.out.println("Abc "+songsObject1.toString());

                    MainData mainData=gson.fromJson(songsObject1.toString(),MainData.class);
                    System.out.println("Datahai : = "+mainData.getImageinfo().get(0).getUser());

                    list.add(new ItemPOJO(mainData.getImageinfo().get(0).getUrl(),mainData.getImageinfo().get(0).getUser(),mainData.getImageinfo().get(0).getDescriptionshorturl()));
                }catch (Exception e){
                }
                sum=sum+1;
                if (sum<10){
                    fetchData();
                }else {
                    itemTypeAdapter= new ItemTypeAdapter(ApiActivity.this, list);
                    recyclerView.setAdapter(itemTypeAdapter);
                }

                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                            itemTypeAdapter.notifyDataSetChanged();

                        }
                    }
                });
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ApiActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}