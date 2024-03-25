package com.example.restapi_asm_ph40209.model;

public class bill {
    private String BillId;
    private String Date;
    private String Email;

    public bill() {
    }

    public bill(String billId, String date, String email) {
        BillId = billId;
        Date = date;
        Email = email;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
