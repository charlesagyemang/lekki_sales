package com.michealbadu.rssweatherapp.Services;

import com.michealbadu.rssweatherapp.Utilities.Item;

import java.util.ArrayList;

public interface ItemResponseData {
    void onSuccess (ArrayList<Item> items);
    void onFailed (String string);
}
