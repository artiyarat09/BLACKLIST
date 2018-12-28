package com.example.artt.blacklist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Protect extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private  SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protect);

        mSlideViewPager =(ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:
                        Intent intent0 = new Intent(Protect.this, page2.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_search:
                        Intent intent = new Intent(Protect.this, SearchActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_prot:
                        break;

                    case R.id.nav_Top:
                        Intent intent2 = new Intent(Protect.this, Protect.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_about:
                        Intent intent3 = new Intent(Protect.this, About_me.class);
                        startActivity(intent3);
                        break;

                }

                return true;
            }
        });

    }

    public void addDotsIndicator(){
        mDots = new TextView[5];

        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }
    }
}
