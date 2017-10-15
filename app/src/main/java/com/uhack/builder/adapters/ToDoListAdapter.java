package com.uhack.builder.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uhack.builder.R;
import com.uhack.builder.activities.ProjectDetails;
import com.uhack.builder.model.Project;
import com.uhack.builder.model.Todo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by piyush on 14/10/17.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ProjectViewHolder> {
    ArrayList<Todo> projectArrayList;
    Context context;

    public ToDoListAdapter(ArrayList<Todo> projectArrayList, Context context) {
        this.projectArrayList = projectArrayList;
        this.context = context;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.todo_list_item,parent,false);

        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.tvToDoName.setText(projectArrayList.get(position).getTask());
        holder.tvToDoDueDate.setText(getDate(projectArrayList.get(position).getDueDate(),"dd/MM/yyyy"));

        String st;
        int status = projectArrayList.get(position).getComplete();
        if(status==0)
            st = "Not Completed";
        else
            st = "Completed";
        holder.tvToDoStatus.setText(st);
    }

    public static String getDate(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder{
        private TextView tvToDoName, tvToDoStatus, tvToDoDueDate;
        public ProjectViewHolder(View itemView) {
            super(itemView);
            tvToDoName = (TextView)itemView.findViewById(R.id.tv_todoTitle);
            tvToDoStatus = (TextView)itemView.findViewById(R.id.tv_todo_status);
            tvToDoDueDate = (TextView)itemView.findViewById(R.id.tv_todo_due_date);
        }
    }
}
