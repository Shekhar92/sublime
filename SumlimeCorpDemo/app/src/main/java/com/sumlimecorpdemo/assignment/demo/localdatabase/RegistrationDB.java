package com.sumlimecorpdemo.assignment.demo.localdatabase;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by pratiksha on 9/18/2017.
 */

public class RegistrationDB {

    Realm realm;

    public RegistrationDB(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void addRegistrationDetailsTODB(String keyRole, String username, String mobileNo, String password){
        realm.beginTransaction();
        RegistrationTable refgistrationTable = realm.createObject(RegistrationTable.class);
        refgistrationTable.setKeyRole(keyRole);
        refgistrationTable.setUserName(username);
        refgistrationTable.setMobileNo(mobileNo);
        refgistrationTable.setPassword(password);

        realm.commitTransaction();
    }

    public RealmResults<RegistrationTable> FetchAllTaskData(){
        RealmResults<RegistrationTable> customerTaskTables = realm.where(RegistrationTable.class).findAll();
        return customerTaskTables;
    }
}
