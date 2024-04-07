package com.example.restapi_asm_ph40209.model;

public class product {


    private String _id;
    private String productName;
    private String description;
    private int price;
    private  String img;
    private String cateId;


    public product(String _id, String productName, String description, int price, String img, String cateId) {
        this._id = _id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.img = img;
        this.cateId = cateId;
    }

    public product() {
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }
}


