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

import java.util.ArrayList;

import uhack.contractor.model.ContractorTemp;

/**
 * Created by piyush on 14/10/17.
 */

public class ContractorListAdapter extends RecyclerView.Adapter<ContractorListAdapter.ProjectViewHolder> {
    ArrayList<ContractorTemp> projectArrayList;
    Context context;

    public ContractorListAdapter(ArrayList<ContractorTemp> projectArrayList, Context context) {
        this.projectArrayList = projectArrayList;
        this.context = context;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.contractor_list,parent,false);

        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.tvCPrice.setText(""+projectArrayList.get(position).getAmount());
        holder.tvCDuration.setText(""+projectArrayList.get(position).getDuration());
        holder.tvCName.setText(""+projectArrayList.get(position).getName());

        int ctype =projectArrayList.get(position).getType();
        String type="";

        if(ctype==0)
            type="Carpenter";
        if(ctype==1)
            type="Electritian";
        if(ctype==2)
            type="Plumber";
        if(ctype==3)
            type="Painter";
        else if(ctype==4)
            type="Mason";

        holder.tvCType.setText(""+ type);
    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCName,tvCDuration,tvCPrice,tvCType;
        public ProjectViewHolder(View itemView) {
            super(itemView);
            tvCName = (TextView) itemView.findViewById(R.id.tv_cname);
            tvCDuration = (TextView) itemView.findViewById(R.id.tv_cduration);
            tvCPrice = (TextView) itemView.findViewById(R.id.tv_cprice);
            tvCType = (TextView) itemView.findViewById(R.id.tv_ctype);
        }
    }
}
