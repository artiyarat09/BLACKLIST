package com.example.artt.blacklist;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;

public class Pop4 extends Activity {

    @Override
    protected void  onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.popwindow4);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int) (height*.7));

        Log.d(TAG, "onCreate: started.");
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);

        int imageResource = getResources().getIdentifier("@drawable/law1",null,this.getPackageName());
        imageView4.setImageResource(imageResource);
    }
}

