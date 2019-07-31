package com.michealbadu.rssweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.michealbadu.rssweatherapp.Adapter.ItemAdapter;
import com.michealbadu.rssweatherapp.Services.ItemResponseData;
import com.michealbadu.rssweatherapp.Utilities.Globall;
import com.michealbadu.rssweatherapp.Models.Item;
import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView itemListView;
    ProgressDialog pdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("===Main Activity===", "Test");
        itemListView = findViewById(R.id.item_item);
        pdialog=new ProgressDialog(this);

        Intent sentIntent  = getIntent();
        final Bundle b = sentIntent.getExtras();
        //start dialog
        pdialog.setTitle("Loading.....");
        pdialog.setIndeterminate(true);
        pdialog.show();




        // get xml data
        try {
            Globall.getItems(b.get("locationID").toString(), new ItemResponseData() {
                @Override
                public void onSuccess(ArrayList<Item> items) {
                    pdialog.dismiss();

                    ListAdapter adapter = new ItemAdapter(MainActivity.this, 0, items);
                    itemListView.setAdapter(adapter);

                    Log.e("======Passed=====", items.get(0).getGeorssPoint());
                }

                @Override
                public void onFailed(String string) {
                    pdialog.dismiss();
                    Log.e("======Failed=====", string);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }
}
