
package com.example.wikimediacommon.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _8454277 {

    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("ns")
    @Expose
    private Integer ns;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imagerepository")
    @Expose
    private String imagerepository;
    @SerializedName("imageinfo")
    @Expose
    private List<Imageinfo____> imageinfo = null;

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

    public String getImagerepository() {
        return imagerepository;
    }

    public void setImagerepository(String imagerepository) {
        this.imagerepository = imagerepository;
    }

    public List<Imageinfo____> getImageinfo() {
        return imageinfo;
    }

    public void setImageinfo(List<Imageinfo____> imageinfo) {
        this.imageinfo = imageinfo;
    }

}
