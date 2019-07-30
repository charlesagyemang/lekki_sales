package com.michealbadu.rssweatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.michealbadu.rssweatherapp.Services.ItemResponseData;
import com.michealbadu.rssweatherapp.Utilities.Globall;
import com.michealbadu.rssweatherapp.Utilities.Item;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("===Main Activity===", "Test");



        // get xml data
        try {
            Globall.getItems(new ItemResponseData() {
                @Override
                public void onSuccess(ArrayList<Item> items) {
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
