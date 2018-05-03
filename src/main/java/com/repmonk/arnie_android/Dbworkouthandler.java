
package com.repmonk.arnie_android;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.repmonk.arnie_android.main_workout.name;


public class Dbworkouthandler extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "workout8.db";
    public static final String TABLE_NAME = "workout_table";
    public static final String COL_1 = "serialno";
    public static final String COL_2 = "uniqueid";
    public static final String COL_3 = "_body_type";
    public static final String COL_4 = "name";

    String body_type, name;

    public Dbworkouthandler(Context context)
    {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
       {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "( serialno INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,   uniqueid  VARCHAR(10),  _body_type  VARCHAR(10),  name  VARCHAR(10) UNIQUE)");
        //preloaded workouts
           //chest
           String sql1="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','chest','Barbell Bench Press')";
           String sql2="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','chest','Dips')";
           String sql3="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','chest','Machine Decline Press')";
           String sql4="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','chest','Cable Fly')";
           String sql5="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','chest','Dumbbell Press')";
           sqLiteDatabase.execSQL(sql1);
           sqLiteDatabase.execSQL(sql2);
           sqLiteDatabase.execSQL(sql3);
           sqLiteDatabase.execSQL(sql4);
           sqLiteDatabase.execSQL(sql5);

           //shoulder
           String sql6="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','shoulder','Cable Row')";
           String sql7="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','shoulder','Front Raise')";
           String sql8="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','shoulder','Rear-Delt Fly')";
           String sql9="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','shoulder','Shoulder Press')";
           String sql10="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','shoulder','Upright Row')";

           sqLiteDatabase.execSQL(sql6);
           sqLiteDatabase.execSQL(sql7);
           sqLiteDatabase.execSQL(sql8);
           sqLiteDatabase.execSQL(sql9);
           sqLiteDatabase.execSQL(sql10);


           //arms
           String sql11="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'arms','Triceps Extension')";
           String sql12="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','arms','Barbell Curl')";
           String sql13="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','arms','Cable Curl')";
           String sql14="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','arms','Wrist Curl')";
           String sql15="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234','arms','Diamond Pushup')";
           sqLiteDatabase.execSQL(sql11);
           sqLiteDatabase.execSQL(sql12);
           sqLiteDatabase.execSQL(sql13);
           sqLiteDatabase.execSQL(sql14);
           sqLiteDatabase.execSQL(sql15);

           //legs
           String sql16="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'legs','Barbell Back Squat')";
           String sql17="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'legs','Barbell Lunge')";
           String sql18="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'legs','Hack Squat Sled')";
           String sql19="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'legs','Leg Curl')";
           String sql20="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'legs','Leg Press')";
           sqLiteDatabase.execSQL(sql16);
           sqLiteDatabase.execSQL(sql17);
           sqLiteDatabase.execSQL(sql18);
           sqLiteDatabase.execSQL(sql19);
           sqLiteDatabase.execSQL(sql20);

           //back
           String sql21="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'back','Deadlift')";
           String sql22="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'back','Wide Grip Pull-up')";
           String sql23="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'back','Standing T-Bar Row')";
           String sql24="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'back','Close-Grip Pull Down')";
           String sql25="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'back','Row')";
           sqLiteDatabase.execSQL(sql21);
           sqLiteDatabase.execSQL(sql22);
           sqLiteDatabase.execSQL(sql23);
           sqLiteDatabase.execSQL(sql24);
           sqLiteDatabase.execSQL(sql25);

           //abs

           String sql26="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'abs','Squat')";
           String sql27="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'abs','HamString Curl')";
           String sql28="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'abs','Bentover row')";
           String sql29="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'abs','Bench Press')";
           String sql30="INSERT  INTO  "+TABLE_NAME+"  (uniqueid , _body_type, name) VALUES('1234', 'abs','Triceps Dip')";
           sqLiteDatabase.execSQL(sql26);
           sqLiteDatabase.execSQL(sql27);
           sqLiteDatabase.execSQL(sql28);
           sqLiteDatabase.execSQL(sql29);
           sqLiteDatabase.execSQL(sql30);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
       {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
       }


    public boolean insertData( String type2, String name1)
    {
        int a=1234;
        body_type=type2;
        name=name1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("uniqueid",1234);
        contentValues.put("type",body_type);
        contentValues.put("name",name);


        String sql1="INSERT INTO  "+TABLE_NAME+" (uniqueid , _body_type, name) VALUES('1234','"+body_type+"','"+name+"')";


       // String sql1="INSERT INTO  "+TABLE_NAME+" (uniqueid , _body_type, name) VALUES('"+a+"','"+body_type+"','"+name+"')";

        sqLiteDatabase.execSQL(sql1);

        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues );

        if (result == -1)
            return false;

        else
            return true;
    }

    public Cursor getData(String body_type)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String query = ("SELECT name From " + TABLE_NAME+" WHERE _body_type = '"+body_type+"'");  // make this query by defining new variables

        Cursor data = sqLiteDatabase.rawQuery(query, null);

        return data;
    }

}


