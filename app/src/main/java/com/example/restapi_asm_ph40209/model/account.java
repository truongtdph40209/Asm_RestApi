package com.example.restapi_asm_ph40209.model;

public class account {
    private String Email;
    private String Fullname;
    private String Password;
    private String Sdt;
    private String Birday;

    public account() {
    }

    public account(String email, String fullname, String password, String sdt, String birday) {
        Email = email;
        Fullname = fullname;
        Password = password;
        Sdt = sdt;
        Birday = birday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getDate() {
        return Birday;
    }

    public void setDate(String birday) {
        Birday = birday;
    }
}
