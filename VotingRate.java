package com.example.programmingknowledge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.programmingknowledge.votingapp.R;

public class VotingRate extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_rate);

        ListView lv = (ListView) findViewById(R.id.voting_liste);
    }
}
