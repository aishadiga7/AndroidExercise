package com.app.androidexercise.ui.model;

import java.util.Objects;

/**
 * UI model to represent a Feed list item to be used in the {@link com.app.androidexercise.ui.FeedsAdapter}
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItem listItem = (ListItem) o;
        return Objects.equals(header, listItem.header) &&
                Objects.equals(subHeader, listItem.subHeader) &&
                Objects.equals(imageUrl, listItem.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, subHeader, imageUrl);
    }
}
