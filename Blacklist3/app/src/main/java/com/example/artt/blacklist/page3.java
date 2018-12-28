package com.example.artt.blacklist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.NameList;

import java.util.ArrayList;

public class page3 extends AppCompatActivity {



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_home:
                        Intent intent0 = new Intent(page3.this, page2.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_search:
                        break;

                    case R.id.nav_prot:
                        Intent intent1 = new Intent(page3.this, beware.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_Top:
                        Intent intent2 = new Intent(page3.this, Protect.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_about:
                        Intent intent3 = new Intent(page3.this, About_me.class);
                        startActivity(intent3);
                        break;

                }

                return true;
            }
        });


    }

}


