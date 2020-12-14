package com.example.wikimediacommon.ArticleModel;

public  class ItemArticleImagePOJO {
    String imageurl;
    String title;

    public ItemArticleImagePOJO(String imageurl, String title) {
        this.imageurl = imageurl;
        this.title = title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
