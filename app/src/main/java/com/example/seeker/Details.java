package com.example.seeker;

public class Details {
    private String userid, phone, province, districtl;

    public Details() {
    }

    public Details(String userid, String phone, String province, String districtl) {
        this.userid = userid;
        this.phone = phone;
        this.province = province;
        this.districtl = districtl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrictl() {
        return districtl;
    }

    public void setDistrictl(String districtl) {
        this.districtl = districtl;
    }
}
