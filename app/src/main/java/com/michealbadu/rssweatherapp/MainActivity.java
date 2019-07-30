package com.michealbadu.rssweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.michealbadu.rssweatherapp.Adapter.ItemAdapter;
import com.michealbadu.rssweatherapp.Services.ItemResponseData;
import com.michealbadu.rssweatherapp.Utilities.Globall;
import com.michealbadu.rssweatherapp.Models.Item;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView itemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("===Main Activity===", "Test");
        itemListView = findViewById(R.id.item_item);



        // get xml data
        try {
            Globall.getItems(new ItemResponseData() {
                @Override
                public void onSuccess(ArrayList<Item> items) {

                    ListAdapter adapter = new ItemAdapter(MainActivity.this, 0, items);
                    itemListView.setAdapter(adapter);

                    Log.e("======Passed=====", items.get(0).getGeorssPoint());
                }

                @Override
                public void onFailed(String string) {
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
