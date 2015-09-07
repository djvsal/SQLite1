package com.sqlite.android.sqlite1;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DJ on 9/7/2015.
 */
public class NewContactActivity extends Activity {
    EditText ContactName,ContactMobile,ContactEmail;
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact_layout);
        ContactName=(EditText)findViewById(R.id.contact_name);
        ContactMobile=(EditText)findViewById(R.id.contact_mobile);
        ContactEmail=(EditText)findViewById(R.id.contact_email);

    }

    public void addContact(View view){

        String name=ContactName.getText().toString();
        String mob=ContactMobile.getText().toString();
        String email=ContactEmail.getText().toString();
        userDbHelper =new UserDbHelper(context);
        sqLiteDatabase= userDbHelper.getWritableDatabase();
        userDbHelper.addInformation(name,mob,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"data saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();

    }
}
