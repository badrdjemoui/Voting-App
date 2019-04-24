package com.example.programmingknowledge;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText txtU,txtP;
    MyDb mdb;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtU =(EditText) findViewById(R.id.login);
        txtP =(EditText) findViewById(R.id.password);

    }
    public void login(View v){
      mdb =new MyDb(this) ;
      db=mdb.getReadableDatabase();

        Cursor cur = db.rawQuery("select * from users where username =? and password =?",
                new String[]{txtU.getText().toString(),txtP.getText().toString()});

        if (cur.getCount()==0 )
            Toast.makeText(this,"uername or password is wrong",Toast.LENGTH_LONG).show();
        else

            {

            MyDb.username=txtU.getText().toString();

            Intent i = new Intent(this, ProfileAct.class);
            startActivity(i);

            }


    }

}
