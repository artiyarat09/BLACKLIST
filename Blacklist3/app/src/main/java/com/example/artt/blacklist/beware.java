package com.example.artt.blacklist;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class beware extends AppCompatActivity {
    private ListView jsonLisview;
    private ArrayList<String> exData;
    private ProgressDialog progressDialog;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beware);

        jsonLisview = (ListView)findViewById(R.id.json_listview);

        exData = new ArrayList<String>();
        exData.add("ธัญวลัย กนต์ธรรตน์");
        exData.add("คมเพชร ทองสุข");
        exData.add("ศุภณัฐ บุญสมพงษ์");
        exData.add("ศิรินภา ประสมพงษ์");
        exData.add("พอนีย์ กลิ่นเจริญ");
        exData.add("นฤมล อินชม");
        exData.add("เจนจิรา นิยม");
        exData.add("ลู่หาญ เห่อนาน");
        exData.add("วรรณา แซ่คู");
        exData.add("อำไพวรรณ อนันต์สุข");

        AsyncTask<Void, Void, Void> execute = new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(beware.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("กำลังค้นหาข้อมูล ...");
                progressDialog.show();
            }


            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    URL url = new URL("https://blacklist3-b96e6.firebaseio.com/");

                    URLConnection urlConnection = url.openConnection();

                    HttpURLConnection httpURLConnection =(HttpURLConnection)urlConnection;
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    InputStream inputStream = null;

                    if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
                        inputStream = httpURLConnection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);

                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;

                    while ((line=reader.readLine()) !=null ){
                        stringBuilder.append(line + "\n");
                    }
                    inputStream.close();
                    Log.d("JSON Result", stringBuilder.toString());

                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    JSONArray exArray = jsonObject.getJSONArray("Users");

                    for(int i=0; i < exArray.length(); i++){
                        JSONObject jsonObj = exArray.getJSONObject(i);
                        exData.add(jsonObj.getString("E-mail"));
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(beware.this, android.R.layout.simple_list_item_1, android.R.id.text1, exData);
                jsonLisview.setAdapter(myAdapter);
                progressDialog.dismiss();
            }
        }.execute();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:
                        Intent intent0 = new Intent(beware.this, page2.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_search:
                        Intent intent = new Intent(beware.this, SearchActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_prot:
                        Intent intent1 = new Intent(beware.this, beware.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_Top:

                        break;

                    case R.id.nav_about:
                        Intent intent3 = new Intent(beware.this, About_me.class);
                        startActivity(intent3);
                        break;

                }

                return true;
            }
        });


    }
}
