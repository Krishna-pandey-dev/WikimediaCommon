package com.example.wikimediacommon.ArticleModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleData {

    @SerializedName("continue")
    @Expose
    private Continue _continue;

    public ArticleData(Continue _continue) {
        this._continue = _continue;
    }

    public ArticleData() {
    }

    public Continue get_continue() {
        return _continue;
    }

    public void set_continue(Continue _continue) {
        this._continue = _continue;
    }
}
