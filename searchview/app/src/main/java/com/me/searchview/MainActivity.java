package com.me.searchview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    SearchView mysearchview;
    ListView mylist;
    // firebase
    FirebaseDatabase database;
    DatabaseReference ref,nameref;

    //arraylist to store items
    ArrayList <String> list;
    ArrayList <String> plist;
    ArrayAdapter <String> adapter;
    Users user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mysearchview =(SearchView)findViewById(R.id.search);
        mylist =(ListView)findViewById(R.id.myList);

        //for firebase
        database = FirebaseDatabase.getInstance();
        ref= database.getReference("users");
        ref.keepSynced(true);

        user = new Users();

        list = new ArrayList<String>();
        plist = new ArrayList<String>();

        //add event listener for firebase
        ref.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {

                    user= ds.getValue(Users.class);
                    list.add(user.getName());
                    plist.add(user.getPrice());

               }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        /*//add items in a list
        list.add("sadik");
        list.add("raj");
        list.add("madhu");
        list.add("meeravali");
        list.add("vamsi");
        list.add("jagga");
        */



        //initilise new adapter class
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),plist.get(i),Toast.LENGTH_LONG).show();


                Intent intent= new Intent(getApplicationContext() , show.class);
                intent.putExtra( "name",list.get(i));
                intent.putExtra( "price",plist.get(i));
                startActivity(intent);
            }
        });

        mysearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

    }
}
