package com.example.wikimediacommon;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private TextView name, email;
    private RecyclerView recyclerView;
    private String type = "";
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        ImageView aboutimage = (ImageView) findViewById(R.id.aboutimage);
        aboutimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ActivityAbout.class);
                startActivity(intent);
            }
        });


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(HomeActivity.this, "Home Panel", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.explore:
                        Intent apintent = new Intent(HomeActivity.this,ApiActivity.class);
                        startActivity(apintent);
                        Toast.makeText(HomeActivity.this, "Please Wait", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bookmarks:
                        Intent articleintent = new Intent(HomeActivity.this,ArticleApiActivity.class);
                        startActivity(articleintent);
                        Toast.makeText(HomeActivity.this, "Please Wait... Loading", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Review:
                        Intent categoryintent = new Intent(HomeActivity.this,CategoryApiActivity.class);
                        startActivity(categoryintent);
                        Toast.makeText(HomeActivity.this, "Explore", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        if(!type.equals("Admin")) {
                            Intent settingsintent = new Intent(HomeActivity.this,SettingActivity.class);
                            startActivity(settingsintent);
                            Toast.makeText(HomeActivity.this, "settings", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.about:
                        if(!type.equals("Admin"))
                        {
                            Intent aboutintent = new Intent(HomeActivity.this,ActivityAbout.class);
                            startActivity(aboutintent);
                        }
                        break;
                    case R.id.apptour:
                        if(!type.equals("Admin"))
                        {
                            Intent tourintent = new Intent(HomeActivity.this,IntroActivity.class);
                            startActivity(tourintent);
                            Toast.makeText(HomeActivity.this, "App Tour", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.logout:
                        if(!type.equals("Admin")) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                            builder.setTitle("Notice!");
                            builder.setMessage("Are you sure!!");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    System.exit(0);

                                    finish();
                                }
                            });
                            builder.setNegativeButton("Cancel", null);
                            builder.show();
                        }
                        break;
                }
                return true;
            }
        });


        View headerView = navigationView.getHeaderView(0);
        TextView username = headerView.findViewById(R.id.user_profile_name);
        TextView useremail = headerView.findViewById(R.id.user_profile_email);
        CircleImageView profileimageview = headerView.findViewById(R.id.user_profile_image);





    }

    public void setSupportActionBar(Toolbar toolbar) {
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }

}