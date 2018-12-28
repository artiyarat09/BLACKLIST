package com.example.artt.blacklist;

import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class regis1 extends Activity {

    private TextInputEditText mUsername,mPassword,mConfirmpassword,mEmail;
    private Button mCancelBtn,mSignupBtn;
    private FirebaseAuth mAuth;
    private DatabaseReference mUserdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis1);

        mAuth = FirebaseAuth.getInstance();
        mUsername = (TextInputEditText) findViewById(R.id.signup_fname);
        mEmail = (TextInputEditText) findViewById(R.id.signup_email);
        mPassword = (TextInputEditText ) findViewById(R.id.signup_password);
        mConfirmpassword = (TextInputEditText) findViewById(R.id.signup_password2);


        mSignupBtn = (Button) findViewById(R.id.signup_signup);

        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsername.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String password2 = mConfirmpassword.getText().toString();

                if(password.equals(password2)){
                    signupUser(username,email,password,password2);
                }else{
                    Toast.makeText(regis1.this,"รหัสผ่านไม่ตรงกัน",Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    private void signupUser(final String username, final String email, String password, String confirmpassword){

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = current_user.getUid();

                mUserdatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
                mUserdatabase.child("Username").setValue(username);
                mUserdatabase.child("Email").setValue(email);
                Toast.makeText(regis1.this,"บันทึกข้อมูล",Toast.LENGTH_LONG).show();

            }
        });
    }
}
