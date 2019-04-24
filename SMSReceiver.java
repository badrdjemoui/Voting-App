package com.example.programmingknowledge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    MyDb mdb;
    SQLiteDatabase db;
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle =intent.getExtras();

        SmsMessage[] msgs=null;

        String messageReceived ="";

        if (bundle!=null){

            Object[] pdus=(Object[]) bundle.get("pdus");

            msgs=new SmsMessage[pdus.length];

            for (int i=0;i<msgs.length;i++){

                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                messageReceived += msgs[i].getMessageBody().toString();

                messageReceived += "\n";
            }

           // Toast.makeText(context,messageReceived,Toast.LENGTH_SHORT).show();
           // Toast.makeText(context,msgs[0].getOriginatingAddress(),Toast.LENGTH_SHORT).show();

            mdb=new MyDb(context);
            db=mdb.getWritableDatabase();
            db.execSQL("insert into voting values(?,?);",new String[]{messageReceived,msgs[0].getOriginatingAddress()});
            db.execSQL("update condidat set votes =votes+1 where id=?",new String[]{messageReceived});
    }
    }
}
