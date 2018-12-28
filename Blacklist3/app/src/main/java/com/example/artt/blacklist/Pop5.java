package com.example.artt.blacklist;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;

public class Pop5 extends Activity {

    @Override
    protected void  onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.popwindow5);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int) (height*.7));

        Log.d(TAG, "onCreate: started.");
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);

        int imageResource = getResources().getIdentifier("@drawable/ninja",null,this.getPackageName());
        imageView5.setImageResource(imageResource);
    }
}

