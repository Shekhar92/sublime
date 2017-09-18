package com.sumlimecorpdemo.assignment.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sumlimecorpdemo.assignment.demo.localdatabase.CustomerTaskDB;
import com.sumlimecorpdemo.assignment.demo.localdatabase.RegistrationDB;
import com.sumlimecorpdemo.assignment.demo.localdatabase.RegistrationTable;
import com.sumlimecorpdemo.assignment.demo.localdatabase.WorkerDB;
import com.sumlimecorpdemo.assignment.demo.model.App;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

/**
 * Created by Sami on 9/16/2017.
 */

public class WorkerActivity extends Activity {


    @Bind(R.id.ll_registerSection)
    LinearLayout registerSection;
    @Bind(R.id.ll_loginSection)
    LinearLayout loginSection;
    @Bind(R.id.ll_bottomSection)
    LinearLayout ll_bottomSection;
    @Bind(R.id.ll_customer_task)
    LinearLayout ll_customer_task;
    @Bind(R.id.ll_worker_task)
    LinearLayout ll_worker_task;
    @Bind(R.id.et_userName)
    EditText userName;
    @Bind(R.id.et_mobileNo)
    EditText mobileNo;
    @Bind(R.id.et_password)
    EditText passWord;
    @Bind(R.id.et_login_MobileNo)
    EditText et_login_MobileNo;
    @Bind(R.id.et_login_Password)
    EditText et_login_Password;
    @Bind(R.id.et_task)
    EditText et_task;

    String customerUserName;

    @Bind(R.id.tv_login)
    TextView tv_login;

    @Bind(R.id.tv_customer_name)
    TextView tv_task;
    @Bind(R.id.tv_customer_Location)
    TextView tv_customer_Location;
    @Bind(R.id.tv_workerName)
    TextView tv_workerName;
    @Bind(R.id.tv_workerLocation)
    TextView tv_workerLocation;
    @Bind(R.id.tv_role)
    TextView tv_role;

    String keyRole;
    CustomerTaskDB customerTaskDB;
    RegistrationDB registrationDB;
    WorkerDB workerDB;

    ArrayList<String> username = new ArrayList<>();
    ArrayList<String> mobileno = new ArrayList<>();
    ArrayList<String> password = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        ButterKnife.bind(this);
        keyRole = getIntent().getStringExtra("keyRole");
        if (keyRole != null) {
            if (keyRole.equalsIgnoreCase("worker")) {
                tv_role.setText("Worker");
            } else if (keyRole.equalsIgnoreCase("Customer")) {
                tv_role.setText("Customer");
            }
        }
        customerTaskDB = new CustomerTaskDB(this);
        registrationDB = new RegistrationDB(this);
        workerDB = new WorkerDB(this);

    }

    @OnClick(R.id.tv_Register)
    public void registerClicked(View view) {
        registerSection.setVisibility(View.VISIBLE);
        loginSection.setVisibility(View.GONE);
        registrationDB.addRegistrationDetailsTODB(keyRole, userName.getText().toString(), mobileNo.getText().toString(), passWord.getText().toString());
        Snackbar snack = Snackbar.make(view, "Registration Successful", Snackbar.LENGTH_LONG);
        snack.show();
    }

    @OnClick(R.id.tv_login)
    public void loginClicked() {


        registerSection.setVisibility(View.GONE);
        loginSection.setVisibility(View.VISIBLE);
        if (tv_login.getText().toString().equalsIgnoreCase("Ok")) {
            if (keyRole.equalsIgnoreCase("worker")) {
                ll_bottomSection.setVisibility(View.GONE);
                ll_customer_task.setVisibility(View.GONE);
                ll_worker_task.setVisibility(View.VISIBLE);
                loginSection.setVisibility(View.GONE);

                workerDB.addWorkerTODB(tv_workerName.getText().toString(), App.appData().getLatitude(), App.appData().getLongitude());
            } else if (keyRole.equalsIgnoreCase("Customer")) {
                ll_bottomSection.setVisibility(View.GONE);
                ll_customer_task.setVisibility(View.VISIBLE);
                ll_worker_task.setVisibility(View.GONE);
                loginSection.setVisibility(View.GONE);
            }
        }
        getValues();
    }

    public void getValues() {
        RealmResults<RegistrationTable> registrationTables = registrationDB.FetchAllTaskData();
        for (int i = 0; i < registrationTables.size(); i++) {
            RegistrationTable registrationTable = registrationTables.get(i);
            String username = registrationTable.getUserName();
            String moileno = registrationTable.getMobileNo();
            String Password = registrationTable.getPassword();

            if (et_login_MobileNo.getText().toString().equalsIgnoreCase(moileno) && et_login_Password.getText().toString().equalsIgnoreCase(Password)) {
                tv_login.setText("Ok");
                customerUserName = username;
                tv_task.setText("Hello " + username + ", ");
                tv_customer_Location.setText("Current Location : " + App.appData().getLatitude() + ", " + App.appData().getLongitude());
                tv_workerName.setText("Hello " + username + ",");
                tv_workerLocation.setText("Current Location : " + App.appData().getLatitude() + ", " + App.appData().getLongitude());
            }

        }
    }

    @OnClick(R.id.bt_submitButton)
    public void submitButtonClicked(View view) {
        customerTaskDB.addCustomerTaskTODB(keyRole, customerUserName, et_task.getText().toString(), App.appData().getLatitude(), App.appData().getLongitude());
        Snackbar snack = Snackbar.make(view, "Service recorded, Our Executive will call you", Snackbar.LENGTH_LONG);
        snack.show();
        et_task.setText("");
    }
}
