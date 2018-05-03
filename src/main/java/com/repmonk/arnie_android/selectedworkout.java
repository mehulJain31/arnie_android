package com.repmonk.arnie_android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mehuljain on 12/28/17.
 */

public class selectedworkout extends AppCompatActivity

{
    public void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.selectedworkout);
        Button start= (Button)findViewById(R.id.start_workout);
        globalset.allworkout.clear();
        super.onCreate(savedInstanceState);

        Intent i=getIntent();

        Intent nextpage=new Intent(this,trackworkout.class);

        ListView lv = (ListView) findViewById(R.id.outputList);
        globalset.allworkout.addAll(globalset.selectedItems_chest);
        globalset.allworkout.addAll(globalset.selectedItems_shoulder);
        globalset.allworkout.addAll(globalset.selectedItems_arms);
        globalset.allworkout.addAll(globalset.selectedItems_legs);
        globalset.allworkout.addAll(globalset.selectedItems_back);
        globalset.allworkout.addAll(globalset.selectedItems_abs);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,globalset.allworkout);

        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                nextpage.putExtra("workout_pos",position);
                startActivity(nextpage);
                //Toast.makeText(getApplication().getBaseContext(),"You clicked,"+ clicked,Toast.LENGTH_SHORT).show();
            }
        });

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(nextpage);

            }
        });



}

}
