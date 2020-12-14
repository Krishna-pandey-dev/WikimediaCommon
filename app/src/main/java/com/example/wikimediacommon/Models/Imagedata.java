
package com.example.wikimediacommon.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Imagedata {

    @SerializedName("continue")
    @Expose
    private Continue _continue;


    /**
     * No args constructor for use in serialization
     * 
     */
    public Imagedata() {
    }

    /**
     * 
     * @param _continue
     * @param
     * @param
     */
    public Imagedata( Continue _continue) {
        super();

        this._continue = _continue;

    }

    public Continue getContinue() {
        return _continue;
    }

    public void setContinue(Continue _continue) {
        this._continue = _continue;
    }


}
