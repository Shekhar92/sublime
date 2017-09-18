package com.sumlimecorpdemo.assignment.demo.localdatabase;

import io.realm.RealmObject;

/**
 * Created by pratiksha on 9/18/2017.
 */

public class RegistrationTable extends RealmObject {

    private String keyRole;
    private String userName;
    private String mobileNo;
    private String password;

    public String getKeyRole() {
        return keyRole;
    }

    public void setKeyRole(String keyRole) {
        this.keyRole = keyRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
