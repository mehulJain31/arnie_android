package com.repmonk.arnie_android;

/**
 * Created by mehuljain on 12/21/17.
 */

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class back extends Fragment

{
    ArrayList<String> outputStrArr1 = new ArrayList<String>();

    View rootView;

    Button addworkout, selectbutton;

    EditText newworkout;

    ListView show;

    Dbworkouthandler mydb1;

    new_user n1= new new_user();  //taking user id

    String uq=n1.number2;

    String bodytype1="back";

    ArrayList<String> copy = new ArrayList<String>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        rootView = inflater.inflate(R.layout.back, container, false);

        mydb1 = new Dbworkouthandler(getContext());

        newworkout = (EditText) rootView.findViewById(R.id.newworkout); //edittext for typing the nwe workout

        ArrayList<String> copy_global= new ArrayList<String>(globalset.allworkout);

        Log.d(" onecopy,back", String.valueOf(globalset.allworkout));



        show = (ListView) rootView.findViewById(R.id.workoutlist);

        show.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        addworkout= (Button)rootView.findViewById(R.id.addworkout);//adding workout

        selectbutton= (Button)rootView.findViewById(R.id.selectbutton); //selecting for new workout plan

        Intent i=new Intent(getContext(),selectedworkout.class);

        Cursor data= mydb1.getData(bodytype1);

        ArrayList<String> listdata = new ArrayList<>();

        while(data.moveToNext())
        {
            listdata.add(data.getString(0));
        }

        ListAdapter adapter = new ArrayAdapter<>(getActivity() ,android.R.layout.simple_list_item_multiple_choice,listdata);

        show.setAdapter(adapter);


        ArrayList<String> outputStrArr = new ArrayList<String>();

        show.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position1, long id)
            {
                SparseBooleanArray checked=show.getCheckedItemPositions();


                globalset.selectedItems_back.clear();



                Log.d(" twocopy,back", String.valueOf(copy_global));

                Log.d(" twoglobal, back", String.valueOf(globalset.allworkout));

                for (int i = 0; i < checked.size(); i++)
                {
                    // Item position in adapter
                    int position = checked.keyAt(i);

                    // Add sport if it is checked i.e.) == TRUE!
                    if (checked.valueAt(i))

                        globalset.selectedItems_back.add("[back]"+adapter.getItem(position));
                }
                Log.d(" threeglobal,back", String.valueOf(globalset.allworkout));


            }
        });


        addworkout.setOnClickListener(new View.OnClickListener()
        {
            public void  onClick(View v)
            {
                {
                    String type2="back";
                    if( newworkout.getText().toString().trim().equals(""))
                    {
                        Toast.makeText(getContext(), "Name is mandatory", Toast.LENGTH_SHORT).show();

                        newworkout.setError("Name is required!");
                    }
                    else
                    {
                        boolean isInserted=mydb1.insertData(type2,newworkout.getText().toString()); // add the unique id from random generator and type of body part from workoutmain

                        if(isInserted=true)
                        {
                            Toast.makeText(getContext(),"Data inserted into database", Toast.LENGTH_LONG).show();

                            newworkout.setText(" ");

                            ArrayList<String> listdata = new ArrayList<>();

                            Cursor data1=mydb1.getData(bodytype1);

                            while(data1.moveToNext())
                            {
                                listdata.add(data1.getString(0));
                            }


                            ListAdapter adapter = new ArrayAdapter<>(getActivity() ,android.R.layout.simple_list_item_multiple_choice,listdata);

                            show.setAdapter(adapter);
                        }

                        else

                        {Toast.makeText(getContext(),"Data NOT inserted into database", Toast.LENGTH_LONG).show();}

                        if(isInserted==false)

                        { Toast.makeText(getContext(),"Workout already present",Toast.LENGTH_LONG).show();}
                    }
                }
            }
        });


        selectbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(i);
            }
        });
        return rootView;
    }







}

