package com.uhack.builder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.uhack.builder.R;

import java.util.ArrayList;



/**
 * Created by piyush on 14/10/17.
 */

public class ContractorsListAdapter extends BaseAdapter {
    private ArrayList<String> contractorsList;
    private Context context;
    private ArrayList<String> contractorTypeList;
    public ContractorsListAdapter(ArrayList<String> contractorsList, Context context) {
        this.contractorsList = contractorsList;
        this.context = context;
        this.contractorTypeList = getList();
    }

    private static ArrayList<String> getList(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Carpenter");
        arrayList.add("Plumber");
        arrayList.add("Electrician");
        return arrayList;
    }
    @Override
    public int getCount() {
        return contractorsList.size();
    }

    @Override
    public Object getItem(int position) {
        return contractorsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.contractor_list_item,parent,false);

        ((TextView)view.findViewById(R.id.tv_contractor_type)).setText(contractorTypeList.get(position));
        ((EditText)view.findViewById(R.id.et_contractor_id)).setText(contractorsList.get(position));
        return view;
    }
}
