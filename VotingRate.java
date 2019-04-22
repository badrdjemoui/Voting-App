package com.example.programmingknowledge;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.programmingknowledge.votingapp.R;

public class VotingRate extends AppCompatActivity {

    ListView lv;
     Integer[] photos ={R.drawable.badr4,R.drawable.badr1,R.drawable.badr3,R.drawable.badr2};
      MyDb mdb;
     SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_rate);

        ListView lv = (ListView) findViewById(R.id.voting_liste);
        mdb=new MyDb(this);
        db=mdb.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from cond",null);
        String[]ids=new String[cur.getCount()];
        String[]names=new String[cur.getCount()];
        String[]votes=new String[cur.getCount()];
        int x=0;
        cur.moveToFirst();
        while(cur.isAfterLast()==false){
            ids[x]=cur.getString(0);
            ids[x]=cur.getString(1);
            ids[x]=cur.getString(2);
            x++;
            cur.moveToNext();
        };
Fill_Row fr =new Fill_Row(this,R.layout.my_row,ids,names,votes,photos);
lv.setAdapter(fr);




    }
}
