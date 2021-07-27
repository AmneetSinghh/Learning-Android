package com.harry.datbase.data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.harry.datbase.model.contact;
import com.harry.datbase.params.Params;

import java.util.ArrayList;
import java.util.List;

public class my_db_handler extends SQLiteOpenHelper
{
    public my_db_handler(Context context) {
        super(context, Params.DB_NAME,null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create= "CREATE TABLE " + Params.TABLE_NAME+
                "(" + Params.KEY_ID+" INTEGER PRIMARY KEY,"+Params.KEY_NAME
                +" Text, "+Params.KEY_PHONE+" Text"+")";


//        CharSequence text = create;
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(contexts, text, duration);
//        toast.show();
//        Log.d(",db_harry","Query being run is : "+ create);
        Log.d("db_harry","query crated=? "+create);

        db.execSQL(create);// for execuring query;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_version) {


    }


    public void addcontact(contact con)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        // id will be automatically incremented;
        values.put(Params.KEY_NAME,con.getName());
        values.put(Params.KEY_PHONE,con.getPhone_number());
        db.insert(Params.TABLE_NAME,null,values);
        Log.d("db_harry","Successfully inserted!");
        db.close();
    }

    public List<contact> getallcontacts(){
        List<contact> contactlist= new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        // generate the query to read the database;
        String select="SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor= db.rawQuery(select,null);

        //loop though now;
        if(cursor.moveToFirst())
        {
            do{
                /*
                 table name
               first   second              thrid;
          id      name          phonenumber
 ursor 0   1.
cursor 1   2.
ursor 2    3.

                 */
                contact con= new contact();
                con.setId(Integer.parseInt(cursor.getString(0)));// it will take first
                con.setName(cursor.getString(1));// will take second;
                con.setPhone_number(cursor.getString(2));// will take thid;
                contactlist.add(con);
            } while(cursor.moveToNext());
        }


        return contactlist;

    }

    public int UpdateContact(contact con)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Params.KEY_NAME,con.getName());
        values.put(Params.KEY_PHONE,con.getPhone_number());
        return db.update(Params.TABLE_NAME, values,Params.KEY_ID+ "=?",
                new String[]{String.valueOf(con.getId())});
    }


//    public void 
}
