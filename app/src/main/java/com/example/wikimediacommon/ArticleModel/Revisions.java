package com.example.wikimediacommon.ArticleModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Revisions {
    @SerializedName("contentformat")
    @Expose
    private String contentformat;
    @SerializedName("contentmodel")
    @Expose
    private String contentmodel;
    @SerializedName("*")
    @Expose
    private String articlefile;

    public Revisions(String contentformat, String contentmodel, String articlefile) {
        this.contentformat = contentformat;
        this.contentmodel = contentmodel;
        this.articlefile = articlefile;
    }


    public String getContentformat() {
        return contentformat;
    }

    public void setContentformat(String contentformat) {
        this.contentformat = contentformat;
    }

    public String getContentmodel() {
        return contentmodel;
    }

    public void setContentmodel(String contentmodel) {
        this.contentmodel = contentmodel;
    }

    public String getArticlefile() {
        return articlefile;
    }

    public void setArticlefile(String articlefile) {
        this.articlefile = articlefile;
    }
}
