package com.michealbadu.rssweatherapp.Models;

public class Item {
    private String title, link, description, pubDate, guid, dcDate, georssPoint;

    public Item(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public Item(String title, String link, String description, String pubDate, String guid, String dcDate, String georssPoint) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.guid = guid;
        this.dcDate = dcDate;
        this.georssPoint = georssPoint;
    }

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDcDate() {
        return dcDate;
    }

    public void setDcDate(String dcDate) {
        this.dcDate = dcDate;
    }

    public String getGeorssPoint() {
        return georssPoint;
    }

    public void setGeorssPoint(String georssPoint) {
        this.georssPoint = georssPoint;
    }
}
