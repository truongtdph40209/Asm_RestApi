package com.example.restapi_asm_ph40209.model;

public class category {
    private String CateId;
    private String CateName;

    public category() {
    }

    public category(String cateId, String cateName) {
        CateId = cateId;
        CateName = cateName;
    }

    public String getCateId() {
        return CateId;
    }

    public void setCateId(String cateId) {
        CateId = cateId;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String cateName) {
        CateName = cateName;
    }
}
