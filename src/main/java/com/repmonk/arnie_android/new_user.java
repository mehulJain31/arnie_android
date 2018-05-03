package com.repmonk.arnie_android;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class new_user extends AppCompatActivity

{   String number2;

    DBHandler mydb;
    protected void onCreate(Bundle savedInstanceState)
    {
        TextView name,age,feet,inches,level,gender,email;
       String[] PINstring = new String[20];


        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);

        mydb= new DBHandler(this);

        name= (EditText) findViewById(R.id.name_input);
        String nameS = name.getText().toString();
        email= (EditText) findViewById(R.id.email_input);
        String emails= email.getText().toString();


        feet= (EditText) findViewById(R.id.ft_input);
        inches= (EditText) findViewById(R.id.inch_input);
        //age= (Text View)findViewById(R.id.age_group);
        gender= (RadioButton) findViewById(R.id.gender);
        level= (RadioButton) findViewById(R.id.level);
        Button add_user = (Button) findViewById(R.id.add_user);


        add_user.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getBaseContext(), "User Added" , Toast.LENGTH_SHORT ).show();
                if( email.getText().toString().trim().equals(""))
                {
                    //  Toast.makeText(getBaseContext(), "Email Address is mandatory", Toast.LENGTH_SHORT).show();
                    email.setError("Email is required!");
                }


                if( name.getText().toString().trim().equals(""))
                {
                    // Toast.makeText(getBaseContext(), "Name is mandatory", Toast.LENGTH_SHORT).show();
                    name.setError("Name is required!");
                }
                else
                {
                    generatePIN((EditText) name);
                    Random random1 = new Random();
                    number2 = "1234";

                    //Toast.makeText(getBaseContext(),"The id is"+PINstring,Toast.LENGTH_LONG ).show();
                   boolean isInserted=  mydb.insertData(PINstring,emails,nameS,number2);
                   if(isInserted=true)
                       Toast.makeText(getBaseContext(),"Data inserted into database with unique id"+number2, Toast.LENGTH_LONG).show();
                   else
                       Toast.makeText(getBaseContext(),"Data NOT inserted into database", Toast.LENGTH_LONG).show();
                }
            }


            public void generatePIN(EditText name)
            {
                Random random = new Random();
                String nameID = name.getText().toString();
                String number = String.format("%04d", random.nextInt(10000));
                PINstring[0]=nameID+"_"+number;
                Toast.makeText(getBaseContext(),"The id is "+PINstring[0], Toast.LENGTH_LONG ).show();

            }
        });

    }




}







