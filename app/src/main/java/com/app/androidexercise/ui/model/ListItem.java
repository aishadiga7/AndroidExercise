package com.app.androidexercise.ui.model;

public class ListItem {
    public String header;
    public String subHeader;
    public String imageUrl;

    public ListItem(String header, String subHeader, String imageUrl) {
        this.header = header;
        this.subHeader = subHeader;
        this.imageUrl = imageUrl;
    }

    public ListItem() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
