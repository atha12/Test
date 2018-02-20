package com.example.atharva.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by atharva on 19/2/18.
 */

public class CustomAdapter extends BaseAdapter {


    ArrayList<String> name = new ArrayList<>();
    Context context;
    ArrayList<String> url = new ArrayList<>();
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, ArrayList<String> name,ArrayList<String> url) {
        // TODO Auto-generated constructor stub
        this.name = name;
        context=mainActivity;
        this.url = url;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    /*public class Holder
    {
        TextView mName;
        ImageView mMusic;
    }*/
   // @SuppressLint("ViewHolder")
   @Override
   public View getView(int position, View convertView, ViewGroup parent) {

       View grid;

       if(convertView==null){
           grid = new View(context);
           grid=inflater.inflate(R.layout.grid_item, parent, false);
       }else{
           grid = (View)convertView;
       }

       ImageView imageView = (ImageView)grid.findViewById(R.id.music_images);
       TextView textView = grid.findViewById(R.id.texts);

       textView.setText(name.get(position));

       Glide.with(context).load(url.get(position)).into(imageView);

       return grid;
   }

}


