package com.example.wikimediacommon.ArticleModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainArticleData {

    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("ns")
    @Expose
    private Integer ns;
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("revisions")
    @Expose
    private List<Revisions> revisions = null;
    @SerializedName("images")
    @Expose
    private List<Articleimages> images = null;

    public MainArticleData(Integer pageid, Integer ns, String title, List<Revisions> revisions, List<Articleimages> images) {
        this.pageid = pageid;
        this.ns = ns;
        this.title = title;
        this.revisions = revisions;
        this.images = images;
    }

    public MainArticleData() {
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Revisions> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<Revisions> revisions) {
        this.revisions = revisions;
    }

    public List<Articleimages> getImages() {
        return images;
    }

    public void setImages(List<Articleimages> images) {
        this.images = images;
    }
}
