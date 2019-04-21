package com.example.programmingknowledge.votingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileAct extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tv = (TextView) findViewById(R.id.tvWelcome);
        tv.setText("welcome"+MyDb.username);
    }

public void goToAct(View v){

        if (v.getId()==R.id.button2)
    {
        Intent i = new Intent(this ,ChangePasswordAct.class);
        startActivity(i);
    }
    }
}
