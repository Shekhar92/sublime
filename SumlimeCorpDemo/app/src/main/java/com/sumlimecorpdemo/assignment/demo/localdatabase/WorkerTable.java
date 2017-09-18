package com.sumlimecorpdemo.assignment.demo.localdatabase;

import io.realm.RealmObject;

/**
 * Created by pratiksha on 9/18/2017.
 */

public class WorkerTable extends RealmObject {

    private String workerName;
    private String latitude;
    private String longitude;

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
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
