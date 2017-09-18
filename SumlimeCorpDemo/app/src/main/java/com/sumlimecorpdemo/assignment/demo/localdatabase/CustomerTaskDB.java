package com.sumlimecorpdemo.assignment.demo.localdatabase;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by pratiksha on 9/17/2017.
 */

public class CustomerTaskDB {

    Realm realm;

    public CustomerTaskDB(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void addCustomerTaskTODB(String keyRole,String username, String task, String latitude, String longitude){
        realm.beginTransaction();
        CustomerTaskTable customerTaskTable = realm.createObject(CustomerTaskTable.class);
        customerTaskTable.setKeyRole(keyRole);
        customerTaskTable.setUserName(username);
        customerTaskTable.setTask(task);
        customerTaskTable.setLatitude(latitude);
        customerTaskTable.setLongitude(longitude);
        realm.commitTransaction();
    }

    public RealmResults<CustomerTaskTable> FetchAllTaskData(){
        RealmResults<CustomerTaskTable> customerTaskTables = realm.where(CustomerTaskTable.class).findAll();
        return customerTaskTables;
    }
}
