package com.example.artt.blacklist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import br.com.bloder.magic.Magic;
import br.com.bloder.magic.view.MagicButton;

public class Menu1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        MagicButton p1;
        p1=(MagicButton) findViewById(R.id.search);
        p1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                Intent p1 = new Intent(Menu1.this,page3.class);
                startActivity(p1);

            }
        });

        MagicButton p2;
        p2=(MagicButton) findViewById(R.id.about1);
        p2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                Intent p2 = new Intent(Menu1.this,About_me.class);
                startActivity(p2);

            }
        });


        MagicButton p3;
        p3=(MagicButton) findViewById(R.id.protect1);
        p3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                Intent p3 = new Intent(Menu1.this,Protect.class);
                startActivity(p3);

            }
        });

        MagicButton p4;
        p4=(MagicButton) findViewById(R.id.beware);
        p4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                Intent p4 = new Intent(Menu1.this,beware.class);
                startActivity(p4);
            }
        });


    }
}


