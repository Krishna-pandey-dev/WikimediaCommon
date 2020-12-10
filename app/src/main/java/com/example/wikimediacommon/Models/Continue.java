
package com.example.wikimediacommon.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue {

    @SerializedName("gcmcontinue")
    @Expose
    private String gcmcontinue;
    @SerializedName("continue")
    @Expose
    private String _continue;

    public String getGcmcontinue() {
        return gcmcontinue;
    }

    public void setGcmcontinue(String gcmcontinue) {
        this.gcmcontinue = gcmcontinue;
    }

    public String getContinue() {
        return _continue;
    }

    public void setContinue(String _continue) {
        this._continue = _continue;
    }

}
