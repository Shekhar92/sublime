package com.sumlimecorpdemo.assignment.demo.localdatabase;

import io.realm.RealmObject;

/**
 * Created by pratiksha on 9/17/2017.
 */

public class CustomerTaskTable extends RealmObject {

    private String keyRole;
    private String userName;
    private String task;
    private String latitude;
    private String longitude;

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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
