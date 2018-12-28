package com.example.artt.blacklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        //button1
        Button b = (Button) findViewById(R.id.button_1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopActivity.this,Pop.class));
            }
        });
        //button2
        Button c = (Button) findViewById(R.id.button2);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopActivity.this,Pop2.class));
            }
        });
        //button3
        Button d = (Button) findViewById(R.id.button3);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopActivity.this,Pop3.class));
            }
        });
        //button4
        Button e = (Button) findViewById(R.id.button4);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopActivity.this,Pop4.class));
            }
        });
        //button5
        Button f = (Button) findViewById(R.id.button5);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopActivity.this,Pop5.class));
            }
        });
        //button6
        Button g = (Button) findViewById(R.id.button6);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PopActivity.this,Pop6.class));
            }
        });


    }

}
