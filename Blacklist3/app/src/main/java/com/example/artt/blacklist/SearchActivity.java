package com.example.artt.blacklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SearchActivity extends AppCompatActivity {

    private EditText mSearchField;
    private ImageButton mSearchBtn;

    private RecyclerView mResultList;


    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        mUserDatabase = FirebaseDatabase.getInstance().getReference("blacklist-IDs/datas");

        mSearchField = (EditText) findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);

        mResultList = (RecyclerView) findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));


        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchText = mSearchField.getText().toString();

                firebaseUserSearch(searchText);
            }
        });


    }

    private void firebaseUserSearch(String searchText) {

        Toast.makeText(SearchActivity.this, "Started Search", Toast.LENGTH_LONG).show();


        Query firebaseSearchQuery = mUserDatabase.orderByChild("name").startAt(searchText).endAt(searchText + "\uf8ff");



        FirebaseRecyclerAdapter<User, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<User, UsersViewHolder>(

                User.class,
                R.layout.list_layout,
                UsersViewHolder.class,
                firebaseSearchQuery

        ){

            @Override
            protected void populateViewHolder(UsersViewHolder viewHolder, User model, int position) {

                viewHolder.setDetails(getApplicationContext(), model.getName(), model.getId(), model.getBank(), model.getBaked(), model.getData(), model.getImage());

            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class  UsersViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public UsersViewHolder(View itemView){
            super(itemView);

            mView = itemView;
        }

        public void setDetails(Context ctx, String userName, String userId, String userBank, String userBaked, String userData, String userImage){

            TextView user_name = (TextView) mView.findViewById(R.id.name_text);
            TextView user_id = (TextView) mView.findViewById(R.id.id_text);
            TextView user_bank = (TextView) mView.findViewById(R.id.bank_text);
            TextView user_baked = (TextView) mView.findViewById(R.id.baked_text);
            TextView user_data = (TextView) mView.findViewById(R.id.data_text);
            ImageView user_image = (ImageView) mView.findViewById(R.id.profile_image);

            user_name.setText(userName);
            user_id.setText(userId);
            user_bank.setText(userBank);
            user_baked.setText(userBaked);
            user_data.setText(userData);

            Glide.with(ctx).load(userImage).into(user_image);


        }



    }
}
