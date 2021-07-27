package com.harry.datbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.harry.datbase.data.my_db_handler;
import com.harry.datbase.model.contact;

import java.util.List;


// CRUD application;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_db_handler  db= new my_db_handler(MainActivity.this);// ye krkke mi apna db object bna lunga;
        // ye krne se create method run ho jaiga, then table ko bna dega;


        // Creating contact for  the db
        contact harry= new contact();
        harry.setPhone_number("9191919191");
        harry.setName("Harry Singh");
        db.addcontact(harry);

        contact harry1= new contact();
        harry1.setPhone_number("9191919391");
        harry1.setName("Harry temo");
        db.addcontact(harry1);

        contact harry2= new contact();
        harry2.setPhone_number("9192919191");
        harry2.setName("Harry babu");
        db.addcontact(harry2);


        // for updation:


        harry2.setId(30);
        harry2.setName("changed harry2");
        harry2.setPhone_number("0000000");
        int affected_rows=db.UpdateContact(harry2);// db.updatecontact returns number of affected rows;
        Log.d("db_harry","No of the affected rows are: "+affected_rows);

        // how to get the query;
        Log.d("db_harry","created the id successfully!");


        // Get all the contacts;
        List<contact> all= db.getallcontacts();
        for(contact con: all){
            Log.d("db_harry","*****************************************\n"+ " id : "+con.getId()+"\n"+
                    "Name: "+con.getName()+"\n"
                    + " Phone Number: "+con.getPhone_number()+"\n"+ "*****************************************\n");


        }


        /*********************************************************************/
        // for updation:





    }
}