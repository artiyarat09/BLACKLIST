package com.example.artt.blacklist;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;

public class Pop3 extends Activity {

    @Override
    protected void  onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.popwindow3);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int) (height*.7));

        Log.d(TAG, "onCreate: started.");
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);

        int imageResource = getResources().getIdentifier("@drawable/line",null,this.getPackageName());
        imageView3.setImageResource(imageResource);
    }
}

