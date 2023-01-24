package com.seeksolution.myapplication.model;

public class TrendingModel {
    private String TrendingImageUrls;

    public TrendingModel(String imageUrls) {
        this.TrendingImageUrls = imageUrls;
    }

    public String getImageUrls() {
        return TrendingImageUrls;
    }
}
