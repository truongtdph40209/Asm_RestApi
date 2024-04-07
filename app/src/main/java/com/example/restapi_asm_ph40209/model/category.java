package com.example.restapi_asm_ph40209.model;

public class category {
    private String _id;
    private String cateName;

    public category() {
    }


    public category(String _id, String cateName) {
        this._id = _id;
        this.cateName = cateName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

}