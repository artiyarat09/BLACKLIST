package com.example.artt.blacklist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page1 extends AppCompatActivity {
    EditText user,pass;
    Button bt1,bt2;
    private FirebaseAuth mAuth;
    private DatabaseReference mUserdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        mAuth = FirebaseAuth.getInstance();
        mUserdatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        user = (EditText) findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = user.getText().toString();
                String password = pass.getText().toString();

                loginUser(username,password);


//                    if (user.getText().toString().equals("iyarat09")&&pass.getText().toString().equals("123456")){
//                        Intent B1=new Intent(Page1.this,Menu1.class);
//                        startActivity(B1);
//                    }else {
//                        Toast.makeText(getApplicationContext(),"รหัสผ่านไม่ถูกต้อง",Toast.LENGTH_LONG).show();
//                    }
                }
            });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regisIntent = new Intent(Page1.this,regis1.class);
                startActivity(regisIntent);
            }
        });

        }


    private void loginUser(String username,String password){
        mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Intent mainIntent = new Intent(Page1.this,page2.class);
                    startActivity(mainIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"รหัสผ่านไม่ถูกต้อง",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}

