package com.example.wikimediacommon.Models;

public  class ItemPOJO {
    String imageurl;
    String title;
    String description;

    public ItemPOJO(String imageurl, String title, String description) {
        this.imageurl = imageurl;
        this.title = title;
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
