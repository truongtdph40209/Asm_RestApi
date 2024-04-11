package com.example.restapi_asm_ph40209.model;

public class cart {
    private String _id;
    private String productName;
    private String img;
    private int price;
    private int soluong;

    public cart(String _id, String productName, String img, int price, int soluong) {
        this._id = _id;
        this.productName = productName;
        this.img = img;
        this.price = price;
        this.soluong = soluong;
    }

    public cart() {
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
