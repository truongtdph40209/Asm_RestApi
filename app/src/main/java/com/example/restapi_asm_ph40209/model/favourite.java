package com.example.restapi_asm_ph40209.model;

public class favourite {
    private String _id;
    private String productName;
    private String img;
    private int price;

    public favourite() {
    }

    public favourite(String _id, String productName, String img, int price) {
        this._id = _id;
        this.productName = productName;
        this.img = img;
        this.price = price;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
