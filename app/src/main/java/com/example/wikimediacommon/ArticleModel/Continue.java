
package com.example.wikimediacommon.ArticleModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue {

    @SerializedName("grncontinue")
    @Expose
    private String grncontinue;
    @SerializedName("continue")
    @Expose
    private String _continue;

    public String getGrncontinue() {
        return grncontinue;
    }

    public void setGrncontinue(String grncontinue) {
        this.grncontinue = grncontinue;
    }

    public String get_continue() {
        return _continue;
    }

    public void set_continue(String _continue) {
        this._continue = _continue;
    }

    public Continue(String grncontinue, String _continue) {
        this.grncontinue = grncontinue;
        this._continue = _continue;




    }
}
