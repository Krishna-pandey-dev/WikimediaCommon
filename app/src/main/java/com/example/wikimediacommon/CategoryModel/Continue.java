
package com.example.wikimediacommon.CategoryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue {

    @SerializedName("accontinue")
    @Expose
    private String accontinue;
    @SerializedName("continue")
    @Expose
    private String _continue;

    public String getAccontinue() {
        return accontinue;
    }

    public void setAccontinue(String accontinue) {
        this.accontinue = accontinue;
    }

    public String getContinue() {
        return _continue;
    }

    public void setContinue(String _continue) {
        this._continue = _continue;
    }

}
