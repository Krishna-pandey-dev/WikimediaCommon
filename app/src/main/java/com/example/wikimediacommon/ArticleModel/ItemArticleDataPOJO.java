package com.example.wikimediacommon.ArticleModel;

public class ItemArticleDataPOJO {
    String model;
    String format;
    String data;

    public ItemArticleDataPOJO() {
    }

    public ItemArticleDataPOJO(String model, String format, String data) {
        this.model = model;
        this.format = format;
        this.data = data;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
