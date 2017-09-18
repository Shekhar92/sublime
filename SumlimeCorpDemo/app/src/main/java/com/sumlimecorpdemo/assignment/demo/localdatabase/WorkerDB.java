package com.sumlimecorpdemo.assignment.demo.localdatabase;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by pratiksha on 9/18/2017.
 */

public class WorkerDB {

    Realm realm;

    public WorkerDB(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void addWorkerTODB(String workerName, String latitude, String longitude){
        realm.beginTransaction();
        WorkerTable workerTable = realm.createObject(WorkerTable.class);
        workerTable.setWorkerName(workerName);
        workerTable.setLatitude(latitude);
        workerTable.setLongitude(longitude);
        realm.commitTransaction();
    }

    public RealmResults<WorkerTable> FetchAllWorkerData(){
        RealmResults<WorkerTable> customerTaskTables = realm.where(WorkerTable.class).findAll();
        return customerTaskTables;
    }
}
