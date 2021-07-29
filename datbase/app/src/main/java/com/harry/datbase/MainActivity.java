package com.harry.datbase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.harry.datbase.adapter.RecyclerViewAdapter;
import com.harry.datbase.data.my_db_handler;
import com.harry.datbase.model.contact;

import java.util.ArrayList;
import java.util.List;


// CRUD application;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private  ArrayList<contact> contactArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Recyclerview initialization
        recyclerView = findViewById(R.id.hero);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        my_db_handler db = new my_db_handler(MainActivity.this);

//         Creating a contact object for the db
//        contact harry = new contact();
//        harry.setPhone_number("9090909090");
//        harry.setName("Harry");
//        db.addcontact(harry);
//        db.addcontact(harry);
//        db.addcontact(harry);
//        db.addcontact(harry);
//        db.addcontact(harry);
//        db.addcontact(harry);


        contactArrayList = new ArrayList<>();

        // Get all contacts
        List<contact> contactList = db.getallcontacts();
        int i=0;
        for(contact contact: contactList){

            Log.d("dbharry", "\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n"+
                    "Phone Number: " + contact.getPhone_number() + "\n" );
            contactArrayList.add(contact);
        }


//       Use your recyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.d("dbharry", "Bro you have "+ db.GetCountTableRows()+ " contacts in your database");


    }
}
