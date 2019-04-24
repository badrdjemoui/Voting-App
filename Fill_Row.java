package com.example.programmingknowledge;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;




public class Fill_Row extends ArrayAdapter<String> {

    Activity context;
    String[] ids;
    String[] names;
    String[] votes;
    Integer[] photos;

//, int resource  second parametre in Fill_Row consructor
    public Fill_Row(Activity context,String[] i,String[] n,String[] v,Integer[] p) {
        super(context, R.layout.my_row,i);
        this.context = context;
        ids = i;
        names=n;
        votes=v;
        photos=p;

    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View v=inflater.inflate(R.layout.my_row,null,true);

        TextView tvID = (TextView) v.findViewById(R.id.cond_id);
        TextView name = (TextView) v.findViewById(R.id.cond_name);
        TextView vote = (TextView) v.findViewById(R.id.cond_vote);
        ImageView  iv = (ImageView) v.findViewById(R.id.cond_photo);

        tvID.setText(ids[position]);
        name.setText(names[position]);
        vote.setText(votes[position]);
        iv.setImageResource(photos[position]);


       return v;
    }

}
