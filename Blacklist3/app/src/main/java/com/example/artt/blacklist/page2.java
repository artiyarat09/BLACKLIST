package com.example.artt.blacklist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class page2 extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);



        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);




                        ImageButton p1;
                        p1=(ImageButton)findViewById(R.id.search);
                        p1.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("WrongViewCast")
                    @Override
                    public void onClick(View v) {
                        Intent p1 = new Intent(page2.this,SearchActivity.class);
                        startActivity(p1);

                    }
                });

                        ImageButton p2;
                        p2=(ImageButton)findViewById(R.id.about1);
                        p2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p2 = new Intent(page2.this,About_me.class);
                                startActivity(p2);

                            }
                        });


                        ImageButton p3;
                        p3=(ImageButton)findViewById(R.id.protect1);
                        p3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent p3 = new Intent(page2.this,Protect.class);
                                startActivity(p3);

                    }
                });

                        ImageButton p4;
                        p4=(ImageButton)findViewById(R.id.imageButton3);
                        p4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        Intent p4 = new Intent(page2.this,PopActivity.class);
                        startActivity(p4);

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:

                        break;

                    case R.id.nav_search:
                    Intent intent = new Intent(page2.this, SearchActivity.class);
                    startActivity(intent);
                    break;

                    case R.id.nav_prot:
                        Intent intent1 = new Intent(page2.this, PopActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_Top:
                        Intent intent2 = new Intent(page2.this, Protect.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_about:
                        Intent intent3 = new Intent(page2.this, About_me.class);
                        startActivity(intent3);
                        break;



                }

                return true;
            }
        });


                }

    }
