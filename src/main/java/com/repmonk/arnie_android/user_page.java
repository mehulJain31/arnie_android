package com.repmonk.arnie_android;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by mehuljain on 12/20/17.
 */

public class user_page extends AppCompatActivity
{


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected  void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);


        Button chest= (Button)findViewById(R.id.chest);
        Button shoulder= (Button)findViewById(R.id.shoulder);
        Button legs= (Button)findViewById(R.id.legs);
        Button arms= (Button)findViewById(R.id.arms);
        Button back= (Button)findViewById(R.id.back);
        Button abs= (Button)findViewById(R.id.abs);

        Button useworkout= (Button)findViewById(R.id.useworkout);  // Use a workout plan
        Button addworkout= (Button)findViewById(R.id.addworkout);   //Add a workout
        Button selectworkout= (Button)findViewById(R.id.selectworkout); // select a workout

        ListView showtypeworkout= (ListView)findViewById(R.id.workouts); //list of workouts


        EditText newworkout= (EditText) findViewById(R.id.newworkout);


        Bundle extras= getIntent().getExtras();
        String username2;

        if(extras != null)
        {
            username2= (String) extras.get("username");
            TextView nameuser= (TextView) findViewById(R.id.username1);
            nameuser.setText("You are logged in as: "+username2);

        }

    }


}
