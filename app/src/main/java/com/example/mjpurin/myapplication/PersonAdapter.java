package com.example.mjpurin.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mjpurin on 2015/08/19.
 */
public class PersonAdapter extends ArrayAdapter<Person> {
    List<Person> list;
    int resource;
    LayoutInflater inflater;
    public PersonAdapter(Context context, int resource, List<Person> objects) {
        super(context, resource, objects);
        inflater=((Activity)context).getLayoutInflater();
        this.resource=resource;
        this.list=objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person p=list.get(position);
        ViewHolder holder;

        if(convertView == null){
            convertView=inflater.inflate(this.resource,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.cellIV.setImageResource(p.sex.equals("男")?R.mipmap.man:R.mipmap.woman);
        holder.cellNameTV.setText(p.name);
        holder.cellAgeTV.setText(p.age+"歳");
        return convertView;
    }
}

class ViewHolder{
    ImageView cellIV;
    TextView cellNameTV;
    TextView cellAgeTV;

    ViewHolder(View v){
        cellIV=(ImageView)v.findViewById(R.id.cellIV);
        cellNameTV=(TextView)v.findViewById(R.id.cellNameTV);
        cellAgeTV=(TextView)v.findViewById(R.id.cellAgeTV);
    }
}
