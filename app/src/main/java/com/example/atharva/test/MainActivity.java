package com.example.atharva.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    GridView gridview;

    GridItem gridItem,gridItem1;

    CustomAdapter customAdapter;

    public static FirebaseDatabase mDatabase;
    public static DatabaseReference mMessagesDatabaseRefrence;


    List<GridItem> list;

    ArrayList<String> xName = new ArrayList<>();

    ArrayList<String> xUrl = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseRefrence = mDatabase.getReference();

        





        list = new ArrayList<>();

      mMessagesDatabaseRefrence.child("Genres").addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              for (DataSnapshot child : dataSnapshot.getChildren()) {
                  list.add(child.getValue(GridItem.class));
              }

              for (GridItem x : list) {
                  xName.add(x.getTexts());
                  xUrl.add(x.getImageUrl());
              }
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });




             /*   if (flag)
                {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                }
                else
                {
            Intent i = getIntent();
            dname.setText(i.getStringExtra("name"));
            did.setText(i.getStringExtra("id"));
            dcentre.setText(i.getStringExtra("centre"));
            daddress.setText(i.getStringExtra("address"));

                    dname.setText(current.name);
                    did.setText(current.id);
                    dcentre.setText(current.testCentre.name);
                    daddress.setText(current.testCentre.address);


                }*/






        gridview = (GridView) findViewById(R.id.customgrid);
        gridview.setAdapter(new CustomAdapter(this, xName, xUrl));
        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/
    }
}
