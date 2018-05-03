package com.repmonk.arnie_android;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mehuljain on 12/20/17.
 */

public class select_user extends AppCompatActivity
{

   private static final String TAG = "select_user";

   DBHandler mdbhelper;


   ListView mlistview;
   String number1;


    protected  void onCreate(Bundle savedInstanceState)
        {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.user_select);

            String[] randomID = new String[20];

            mlistview = (ListView) findViewById(R.id.listview);
            mdbhelper= new DBHandler(this);

            populatelistveiew();


        }

    private void populatelistveiew()
    {
        Cursor data= mdbhelper.getData();
        ArrayList<String> listdata = new ArrayList<>();
        while(data.moveToNext())
        {
            listdata.add(data.getString(0));
        }

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listdata);
        mlistview.setAdapter(adapter);

        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), listdata.get(position), Toast.LENGTH_LONG).show();

                Intent i= new Intent(select_user.this,main_workout.class );

                Intent i1= new Intent(select_user.this,trackworkout.class );


                i.putExtra("username",listdata.get(position));

                i1.putExtra("username1",number1);

                i.putExtra("UniqueID",number1);

                generatePIN(number1);

                startActivity(i);
            }
        });
    }

    private String generatePIN(String number)
    {
        Random random = new Random();
        number = String.format("%04d", random.nextInt(10000));
        Toast.makeText(getApplicationContext(), "The number assigned to this id is"+number, Toast.LENGTH_LONG).show();
        return number;
    }


    public void Action (View v)
    {
        Intent i= new Intent(select_user.this,new_user.class );
        startActivity(i);
    }
}
