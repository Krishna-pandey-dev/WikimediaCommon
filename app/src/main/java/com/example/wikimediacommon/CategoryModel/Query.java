
package com.example.wikimediacommon.CategoryModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query {

    @SerializedName("allcategories")
    @Expose
    private List<Allcategory> allcategories = null;

    public List<Allcategory> getAllcategories() {
        return allcategories;
    }

    public void setAllcategories(List<Allcategory> allcategories) {
        this.allcategories = allcategories;
    }

}
