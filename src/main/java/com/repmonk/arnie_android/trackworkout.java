package com.repmonk.arnie_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by mehuljain on 1/5/18.
 */

public class trackworkout extends AppCompatActivity
{
    int weight_input=30;
    int rep_input=0;
    int position;

    String user;

    ArrayList<String> workouts = new ArrayList<String>();



    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.trackworkout);

        Intent i = getIntent();


        main_workout m= new main_workout();

        user=m.name;

        //Log.d("username",user);

        Button minusfive= (Button)findViewById(R.id.minus5);

        Button plusfive= (Button)findViewById(R.id.plus5);

        Button minus= (Button)findViewById(R.id.minus);

        Button plus= (Button)findViewById(R.id.plus);

        Button previous= (Button)findViewById(R.id.previous);

        Button next= (Button)findViewById(R.id.next);

        Button start= (Button)findViewById(R.id.start_workout);

        TextView weight= (TextView)findViewById(R.id.weightview);

        TextView reps= (TextView)findViewById(R.id.repview);

        TextView name= (TextView)findViewById(R.id.user_name);

        TextView wname=(TextView)findViewById(R.id.workout_name);

        workouts=globalset.allworkout;

        Log.d("Workouts", String.valueOf(workouts));
        name.setText(user);

        Log.d("username",user);

        weight.setText("   "+weight_input+"lbs");

        reps.setText("  "+rep_input+"Reps");

        position=0;

        if(i.getExtras()!=null)

        {position= (i.getExtras().getInt("workout_pos"));}

        else
        {
            position=0;
        }

        wname.setText(workouts.get(position));


       previous.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               if(position!=0)

               {    position--;
                   wname.setText(workouts.get(position));}
           }
       });


        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {   if(position!=workouts.size()-1)
                {   position++;
                    wname.setText(workouts.get(position));}
            }
        });


        minusfive.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               if (weight_input < 0)
               {
                   Toast.makeText(getApplicationContext(), "WEIGHT cannot be negative", Toast.LENGTH_SHORT).show();
                   weight_input=weight_input+5;
               }
               else
               {
                   weight_input = weight_input - 5;
                   if (weight_input < 0)
                   {weight_input=weight_input+5;
                   weight.setText("  " + weight_input + "lbs");
                   }

                   else{
                       weight.setText("  " + weight_input + "lbs");
                   }
               }
           }
       });


        plusfive.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                weight_input=weight_input+5;
                weight.setText("  "+ (weight_input)+"lbs");
            }
        });


        minus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               if (rep_input < 0)
                {
                    Toast.makeText(getApplicationContext(), "REP cannot be negative", Toast.LENGTH_SHORT).show();
                    rep_input=1;
                }
                else
                {
                    rep_input = rep_input - 1;

                    if (rep_input < 0)
                    {
                        rep_input=1;
                        reps.setText("  " + (rep_input)+ "reps");
                    }
                    else{
                        reps.setText("  " + rep_input + "reps");
                    }
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rep_input=rep_input+1;
                reps.setText("   "+(rep_input+1)+"Reps");
            }

        });
    }
}
