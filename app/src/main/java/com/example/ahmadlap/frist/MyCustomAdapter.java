package com.example.ahmadlap.frist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ahmad lap on 2/3/2015.
 */
public class MyCustomAdapter extends ArrayAdapter<String> {
    Context context;
    List<String> names;
    List<Integer> photos;
                        //  activity         ,layout to deal with
    public MyCustomAdapter(Context context, int resource, List<String> names, List<Integer> photos) {
        super(context, resource, names);
        context=this.context;
        photos= this.photos;
        names=this.names;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View myView=  inflater.inflate(R.layout.list_item,parent,false);
        ImageView iv= (ImageView) myView.findViewById(R.id.imageView);
        iv.setImageResource(photos.get(position));
        TextView tv= (TextView) myView.findViewById(R.id.textView);
        tv.setText(names.get(position));

        return myView;
    }
}
