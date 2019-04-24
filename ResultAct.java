package com.example.programmingknowledge;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class ResultAct extends AppCompatActivity {
 EditText txtR;
    MyDb mdb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtR = (EditText) findViewById(R.id.txtresult);
    }

    public void sendFR(View view) {
        mdb =new MyDb(this);
        db=mdb.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from condidat",null);
        cur.moveToFirst();
        String msg = txtR.getText().toString()+"\n" ;
    while (cur.isAfterLast()==false){

           msg +=cur.getString(1)+" has got "+cur.getString(2)+"\n";

    }
    //send result to all voted person
    Cursor cur2  = db.rawQuery("select mobile from voting",null);
    cur2.moveToFirst();
        SmsManager smsmanegr= SmsManager.getDefault();

while (cur2.isAfterLast()==false)
{
 smsmanegr.sendTextMessage(cur2.getString(0),null,msg,null,null);
cur2.moveToNext();
}

    }
}
