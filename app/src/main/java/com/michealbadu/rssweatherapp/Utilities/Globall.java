package com.michealbadu.rssweatherapp.Utilities;


import android.util.Log;

import com.michealbadu.rssweatherapp.Services.APISERVICE;
import com.michealbadu.rssweatherapp.Services.ItemResponseData;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Globall {
    public static void getItems (final ItemResponseData itemResponseData) throws IOException, XmlPullParserException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APISERVICE service = retrofit.create(APISERVICE.class);
        Call<ResponseBody> result = service.getCalls("1545752");
        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ArrayList<Item> items = StackOverflowXmlParser.parse(response.body().byteStream());
                    itemResponseData.onSuccess(items);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("===Data Failed===", call.request().body().toString());
                itemResponseData.onFailed(t.getLocalizedMessage());
            }
        });

    }
}
