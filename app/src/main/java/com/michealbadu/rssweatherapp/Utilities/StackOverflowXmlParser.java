package com.michealbadu.rssweatherapp.Utilities;

import android.util.Xml;

import com.michealbadu.rssweatherapp.Models.Item;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class StackOverflowXmlParser {
    // We don't use namespaces
    private static final String ns = null;

    public static ArrayList<Item> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            in.close();
        }
    }

    private static ArrayList<Item> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Item> entries = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "rss");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG ) {
                continue;
            }
            parser.require(XmlPullParser.START_TAG, ns, "channel");
            while (parser.next() != XmlPullParser.END_TAG){
                if (parser.getEventType() != XmlPullParser.START_TAG ) {
                    continue;
                }
                String name = parser.getName();
                // Starts by looking for the entry tag
                if (name.equals("item")) {
                    entries.add(readEntry(parser));
                }else {
                    skip(parser);
                }
            }

        }
        return entries;
    }

    private static Item readEntry(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "item");
        Item item = new Item();
        String title;
        String link;
        String description;
        String pubDate;
        String dcDate;
        String geoPort;
        String guid;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
//            Log.e("+++server+++", name);
            String titleString = "title";
            String descString = "description";
            String linkString = "link";
            String dateString = "pubDate";
            String guidString = "guid";
            String dcDateString     = "dc:date";
            String geoPointString   = "georss:point";

            if (name.equals(titleString)) {
                title = readTextValue(parser, titleString);
                item.setTitle(title);

            } else if (name.equals(linkString)) {
                link = readTextValue(parser, linkString);
                item.setLink(link);

            } else if (name.equals(descString)) {
                description = readTextValue(parser,descString);
                item.setDescription(description);


            } else if (name.equals(guidString)) {
                guid = readTextValue(parser, guidString);
                item.setGuid(guid);

            }else if (name.equals(dcDateString)) {
                dcDate = readTextValue(parser, dcDateString);
                item.setDcDate(dcDate);

            }else if (name.equals(geoPointString)) {
                geoPort = readTextValue(parser, geoPointString);
                item.setGeorssPoint(geoPort);

            }else if (name.equals(dateString)) {
                pubDate = readTextValue(parser, dateString);
                item.setPubDate(pubDate);

            } else {
                skip(parser);
            }
        }

        return item;
    }


    private static String readTextValue(XmlPullParser parser, String string) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, string);
        String returnString = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, string);
        return returnString;
    }

    private static String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }


    private static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }


}
