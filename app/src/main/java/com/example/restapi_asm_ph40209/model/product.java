package com.example.restapi_asm_ph40209.model;

public class product {

    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;

    private int id;
    private int image;
    private String tensp;
    private int luuluong;
    private double gia;
    private String desc;
    private int type;


    public product() {
    }

    public product(int id, int image, String tensp, int luuluong, double gia, String desc, int type) {
        this.id = id;
        this.image = image;
        this.tensp = tensp;
        this.luuluong = luuluong;
        this.gia = gia;
        this.desc = desc;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getLuuluong() {
        return luuluong;
    }

    public void setLuuluong(int luuluong) {
        this.luuluong = luuluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
