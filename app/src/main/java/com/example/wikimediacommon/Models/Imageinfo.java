
package com.example.wikimediacommon.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imageinfo {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("descriptionurl")
    @Expose
    private String descriptionurl;
    @SerializedName("descriptionshorturl")
    @Expose
    private String descriptionshorturl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Imageinfo() {
    }

    /**
     * 
     * @param descriptionurl
     * @param descriptionshorturl
     * @param user
     * @param url
     * @param timestamp
     */
    public Imageinfo(String timestamp, String user, String url, String descriptionurl, String descriptionshorturl) {
        super();
        this.timestamp = timestamp;
        this.user = user;
        this.url = url;
        this.descriptionurl = descriptionurl;
        this.descriptionshorturl = descriptionshorturl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescriptionurl() {
        return descriptionurl;
    }

    public void setDescriptionurl(String descriptionurl) {
        this.descriptionurl = descriptionurl;
    }

    public String getDescriptionshorturl() {
        return descriptionshorturl;
    }

    public void setDescriptionshorturl(String descriptionshorturl) {
        this.descriptionshorturl = descriptionshorturl;
    }

}
