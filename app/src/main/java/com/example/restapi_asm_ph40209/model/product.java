package com.example.restapi_asm_ph40209.model;

public class product {

    private int image;

    private String ProductId;
    private String ProductName;
    private String Desc;
    private double Price;
    private String CateId;


    public product(int image, String productId, String productName, String desc, double price) {
        this.image = image;
        ProductId = productId;
        ProductName = productName;
        Desc = desc;
        Price = price;
    }

    public product(String cateId) {
        CateId = cateId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public product() {
    }



    public String getCateId() {
        return CateId;
    }

    public void setCateId(String cateId) {
        CateId = cateId;
    }
}
