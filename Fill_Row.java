package com.example.programmingknowledge;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.programmingknowledge.votingapp.R;

public class Fill_Row extends ArrayAdapter<String> {

    Activity context;
    String[] ids;
    String[] names;
    String[] votes;
    Integer[] photos;

    public Fill_Row(Activity context, int resource,String[] i,String[] n,String[] v,Integer[] p) {
        super(context, R.layout.my_row);
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
        ImageView photos = (ImageView) v.findViewById(R.id.cond_photo);

       return v;
    }

}
