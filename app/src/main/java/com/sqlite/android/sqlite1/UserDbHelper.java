package com.sqlite.android.sqlite1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DJ on 9/6/2015.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATEBASE_NAME="USERINFO.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.USER_NAME+" TEXT,"+UserContract.NewUserInfo.USER_MOB+" TEXT,"+ UserContract.NewUserInfo.USER_EMAIL+" TEXT);";

    public UserDbHelper(Context context){
     super(context,DATEBASE_NAME,null,DATABASE_VERSION);//creates database
        Log.e("DATABASE OPERATION","database created/opened....");

    }
    @Override                                             //to create the table we need the object of SQLiteDatabase
    public void onCreate(SQLiteDatabase db) {//system will call onCreate method if the table is already not exists i.e if the db is created for the first time otherwise not called

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATION", "table created/opened....");

    }

    public void addInformation(String name,String mob,String email,SQLiteDatabase db){//method for db operation

        ContentValues contentValues=new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContract.NewUserInfo.USER_MOB,mob);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContract.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATION", "one row inserted....");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }//provides some methods to performs some db operations
}
