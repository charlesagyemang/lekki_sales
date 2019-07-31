package com.michealbadu.rssweatherapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.michealbadu.rssweatherapp.Models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Context context, int resource, List<Item> items){
        super(context, android.R.layout.simple_list_item_1 ,items);

//        Toast.makeText(context, "There are " + items.size() + "items in the list", Toast.LENGTH_LONG).show();
    }

    @Override
    public int getPosition(Item item) {
        return super.getPosition(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inf = LayoutInflater.from(getContext());
            convertView = inf.inflate(android.R.layout.simple_list_item_2, null);


            viewHolder = new ViewHolder();
            viewHolder.lineOne = convertView.findViewById(android.R.id.text1);
            viewHolder.lineTwo = convertView.findViewById(android.R.id.text2);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.lineOne.setText("Title:  " + item.getTitle());
        viewHolder.lineTwo.setText("Description: " + item.getDescription());

        return convertView;
    }

    private static class ViewHolder {
        TextView lineOne;
        TextView lineTwo;
    }
}
