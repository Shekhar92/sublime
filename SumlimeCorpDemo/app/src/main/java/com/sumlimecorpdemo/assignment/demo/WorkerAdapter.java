package com.sumlimecorpdemo.assignment.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pratiksha on 9/17/2017.
 */

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder>  {

    ArrayList<String> worker;
    ArrayList<String> lon;
    CustomerTaskAdapter customerTaskAdapter;

    Context context;

    public WorkerAdapter(ArrayList<String> task, ArrayList<String> lon) {
        this.worker = task;
        this.lon = lon;
    }

    @Override
    public WorkerAdapter.WorkerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.worker_adapter_cellview, parent, false);
        return new WorkerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WorkerAdapter.WorkerViewHolder holder, int position) {
        String workerName = worker.get(position);
        String city = lon.get(position);

        holder.worker.setText(workerName);
        holder.worker_location.setText(city);
    }

    @Override
    public int getItemCount() {
        return worker.size();
    }

    public class WorkerViewHolder extends RecyclerView.ViewHolder {

        public TextView worker, worker_location;

        public WorkerViewHolder(View itemView) {
            super(itemView);
            worker = (TextView) itemView.findViewById(R.id.tv_worker);
            worker_location = (TextView) itemView.findViewById(R.id.tv_worker_location);
        }
    }
}
