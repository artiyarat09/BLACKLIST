package com.example.artt.blacklist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class About_me extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:
                        Intent intent0 = new Intent(About_me.this, page2.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_search:
                        Intent intent = new Intent(About_me.this, SearchActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_prot:
                        Intent intent1 = new Intent(About_me.this, beware.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_Top:
                        Intent intent2 = new Intent(About_me.this, Protect.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_about:

                        break;

                }

                return true;
            }
        });

    }
}
