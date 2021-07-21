package com.harry.listview;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView li;
    final ArrayList<String> aa= new ArrayList<>();

    public void add_item(View view)
    {
        TextView t=findViewById(R.id.text);
//        Toast.makeText(getApplicationContext(),t.getText().toString(),Toast.LENGTH_SHORT).show();
        String val=t.getText().toString();
        aa.add(val);
        ArrayAdapter<String> adp= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, aa);
        // arrayadapters android mi use krte hai so that java k aarays ko istemal kr sake;
        li.setAdapter(adp);// arry apdter set krdo mylistview mi;
        t.setText("");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=findViewById(R.id.list);

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s="Item "+position+" "+((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}