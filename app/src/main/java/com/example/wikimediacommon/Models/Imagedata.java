
package com.example.wikimediacommon.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imagedata {

    @SerializedName("batchcomplete")
    @Expose
    private String batchcomplete;
    @SerializedName("continue")
    @Expose
    private Continue _continue;
    @SerializedName("query")
    @Expose
    private Query query;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Imagedata() {
    }

    /**
     * 
     * @param _continue
     * @param batchcomplete
     * @param query
     */
    public Imagedata(String batchcomplete, Continue _continue, Query query) {
        super();
        this.batchcomplete = batchcomplete;
        this._continue = _continue;
        this.query = query;
    }

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Continue getContinue() {
        return _continue;
    }

    public void setContinue(Continue _continue) {
        this._continue = _continue;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

}
