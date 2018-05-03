package com.repmonk.arnie_android;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHandler extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME= "user.db";
    public static final String TABLE_NAME= "user_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "email";
    public static final String COL_3= "name";
    public static final String COL_4= "uniqueID";

    public DBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
    sqLiteDatabase.execSQL("CREATE table " + TABLE_NAME + "(ID TEXT PRIMARY KEY, email TEXT, name TEXT, uniqueID TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String[] ID, String email, String name, String uniqueID)
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1,ID[0]);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,uniqueID);

        long result= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if(result==-1)
            return  false;
        else
            return true;

    }




    public Cursor getData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT ID From " + TABLE_NAME;
        Cursor data = sqLiteDatabase.rawQuery(query, null);
        return data;
    }



}
