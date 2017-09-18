package com.sumlimecorpdemo.assignment.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.sumlimecorpdemo.assignment.demo.localdatabase.CustomerTaskDB;
import com.sumlimecorpdemo.assignment.demo.localdatabase.CustomerTaskTable;
import com.sumlimecorpdemo.assignment.demo.localdatabase.WorkerDB;
import com.sumlimecorpdemo.assignment.demo.localdatabase.WorkerTable;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

public class AdminActivity extends AppCompatActivity {

    ArrayList<String> userNameList;
    ArrayList<String> taskList;
    ArrayList<String> lat;
    ArrayList<String> lon;
    ArrayList<String> samelocation;
    CustomerTaskDB customerTaskDB;
    WorkerDB workerDB;
    CustomerTaskAdapter customerTaskAdapter;
    Context context;

    @Bind(R.id.et_login_MobileNo)
    EditText et_login_MobileNo;
    @Bind(R.id.et_login_Password)
    EditText et_login_Password;
    @Bind(R.id.ll_loginSection)
    LinearLayout ll_loginSection;
    @Bind(R.id.rv_tasklist)
    RecyclerView rv_tasklist;
    @Bind(R.id.cv)
    CardView cv;
    String customer_longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ButterKnife.bind(this);
        customerTaskDB = new CustomerTaskDB(this);
        workerDB = new WorkerDB(this);
        userNameList = new ArrayList<>();
        taskList = new ArrayList<String>();
        samelocation = new ArrayList<>();

        lat = new ArrayList<>();
        lon = new ArrayList<>();

        RealmResults<CustomerTaskTable> customerTaskTables = customerTaskDB.FetchAllTaskData();
        for (int i = 0; i < customerTaskTables.size(); i++) {
            CustomerTaskTable customerTaskTable = customerTaskTables.get(i);
            String username = customerTaskTable.getUserName();
            String task = customerTaskTable.getTask();
            String latitude = customerTaskTable.getLatitude();
            customer_longitude = customerTaskTable.getLongitude();
            taskList.add(task);
            userNameList.add(username);
            lat.add(latitude);
            lon.add(customer_longitude);

        }
        sortWorkers();
//            lat.add(latitude);
//            lon.add(longitude);
        // shirtFilePath = shirtString.split(",");

        customerTaskAdapter = new CustomerTaskAdapter(taskList, userNameList, lat, lon, samelocation);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        rv_tasklist.setLayoutManager((new LinearLayoutManager(this)));
        rv_tasklist.setItemAnimator(new DefaultItemAnimator());
        rv_tasklist.setHasFixedSize(false);
        rv_tasklist.setAdapter(customerTaskAdapter);
        customerTaskAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        taskList.clear();
        userNameList.clear();
    }

    @OnClick(R.id.bt_login)
    public void loginCliked(){
        if (et_login_MobileNo.getText().toString().equalsIgnoreCase("123456") && et_login_Password.getText().toString().equalsIgnoreCase("123456")){
            ll_loginSection.setVisibility(View.GONE);
            cv.setVisibility(View.VISIBLE);
        }
    }
    public void sortWorkers() {
        RealmResults<WorkerTable> workerTables = workerDB.FetchAllWorkerData();
        for (int i = 0; i < workerTables.size(); i++) {
            WorkerTable workerTable = workerTables.get(i);
            String workername = workerTable.getWorkerName();
            String latitude = workerTable.getLatitude();
            String longitude = workerTable.getLongitude();
            for (int j = i; j< lon.size();j++){
                if (longitude.equalsIgnoreCase(customer_longitude)){
                    samelocation.add(workername);
                }
            }
        }
    }
}
