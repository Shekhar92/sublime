package com.sumlimecorpdemo.assignment.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pratiksha on 6/28/2017.
 */

public class CustomerTaskAdapter extends RecyclerView.Adapter<CustomerTaskAdapter.CustomerTaskViewHolder> {

    ArrayList<String> task;
    ArrayList<String> userNameList;
    ArrayList<String> lat;
    ArrayList<String> lon;
    ArrayList<String> arrayList;

    WorkerAdapter workerAdapter;

    Context context;

    public CustomerTaskAdapter(ArrayList<String> task, ArrayList<String> userNameList, ArrayList<String> lat, ArrayList<String> lon, ArrayList<String> samelocation) {
        this.task = task;
        this.userNameList = userNameList;
        this.lat = lat;
        this.lon = lon;
        this.arrayList = samelocation;
    }

    @Override
    public CustomerTaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customertaskcellview, parent, false);
        return new CustomerTaskViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final CustomerTaskViewHolder holder, int position) {

        String tasks = task.get(position);
        String cust = userNameList.get(position);
        String area = lat.get(position);
        String city = lon.get(position);

        holder.task.setText(tasks.trim());
        holder.customerName.setText(cust);
        holder.tv_location.setText(area +", " + city);

//        workerAdapter = new WorkerAdapter(arrayList, lon);
//        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
//        holder.rv_workerlist.setLayoutManager((new LinearLayoutManager(context)));
//        holder.rv_workerlist.setItemAnimator(new DefaultItemAnimator());
//        holder.rv_workerlist.setHasFixedSize(false);
//        holder.rv_workerlist.setAdapter(workerAdapter);
    }

    @Override
    public int getItemCount() {
        return task.size();
    }

    public class CustomerTaskViewHolder extends RecyclerView.ViewHolder {

        public TextView task, customerName, tv_location;
        public RecyclerView rv_workerlist;
        public LinearLayout pairImageScreenShot;

        public CustomerTaskViewHolder(View itemView) {
            super(itemView);
            task = (TextView) itemView.findViewById(R.id.tv_customer_name);
            customerName = (TextView) itemView.findViewById(R.id.tv_customer);
            rv_workerlist = (RecyclerView) itemView.findViewById(R.id.rv_workerlist);
            tv_location = (TextView) itemView.findViewById(R.id.tv_location);
        }
    }
}
