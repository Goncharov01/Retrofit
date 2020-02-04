package com.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class ModelMotos {

    @SerializedName("id")
    public String id;

    @SerializedName("userId")
    public String userId;

    @SerializedName("model")
    public String model;

    @SerializedName("volume")
    public String volume;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String modelm) {
        this.model = modelm;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }


}
