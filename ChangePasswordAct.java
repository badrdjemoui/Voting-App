package com.example.programmingknowledge;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.programmingknowledge.votingapp.R;

public class ChangePasswordAct extends AppCompatActivity {


    EditText txtNP,txtCP;
    MyDb mdb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        txtNP = (EditText) findViewById(R.id.newPassword);
        txtCP = (EditText) findViewById(R.id.confirmPassword);
    }
    public void ChangePassword(View v){

        if (txtNP.getText().toString().equals( txtCP.getText().toString())) {
            mdb = new MyDb(this);
            db = mdb.getWritableDatabase();
            db.execSQL("update users set password = ? where username = ?",
                    new String[]{txtNP.getText().toString(), MyDb.username});

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }
        else{
            Toast.makeText(this,"the new password and their confirmation are not aqual",Toast.LENGTH_LONG).show();
        }

    }
}
