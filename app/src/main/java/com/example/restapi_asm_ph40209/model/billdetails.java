package com.example.restapi_asm_ph40209.model;

public class billdetails {
    private String BillId;
    private String ProductId;
    private int Quantity;

    public billdetails() {
    }

    public billdetails(String billId, String productId, int quantity) {
        BillId = billId;
        ProductId = productId;
        Quantity = quantity;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
