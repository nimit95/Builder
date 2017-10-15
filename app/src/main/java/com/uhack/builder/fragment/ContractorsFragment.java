package com.uhack.builder.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.uhack.builder.FirebaseReference;
import com.uhack.builder.R;
import com.uhack.builder.adapters.ContractorListAdapter;
import com.uhack.builder.fragment.dialogs.AddContractor;
import com.uhack.builder.utils.FirebaseLinks;

import java.util.ArrayList;

import uhack.contractor.model.ContractorTemp;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContractorsFragment extends Fragment {

    private FloatingActionButton fabAddContractor;
    public ContractorsFragment() {
        // Required empty public constructor
    }

    public static String PROJECT_ID;

    public ContractorsFragment(String stringExtra) {
        PROJECT_ID = stringExtra;
    }

    private ArrayList<ContractorTemp> fetchedContractors;
    private ContractorListAdapter contracterListAdapter;
    private RecyclerView rvCOntractors;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contractors, container, false);

        fabAddContractor = (FloatingActionButton) view.findViewById(R.id.fab_add_contractor);
        fabAddContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                AddContractor addContractor = new AddContractor();
                addContractor.show(fragmentManager,"TAG");
            }
        });
        rvCOntractors = (RecyclerView) view.findViewById(R.id.rv_contractors);
        fetchedContractors = new ArrayList<>();
        contracterListAdapter = new ContractorListAdapter(fetchedContractors,
                getActivity());

        rvCOntractors.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCOntractors.setAdapter(contracterListAdapter);

        FirebaseReference.projectReference.child(
                PROJECT_ID
        ).child(FirebaseLinks.CONTRACTOR_DATA).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ContractorTemp> temp = new ArrayList<ContractorTemp>();

                for (DataSnapshot data: dataSnapshot.getChildren()){
                    temp.add(data.getValue(ContractorTemp.class));
                    Log.e("hey: ",temp.get(temp.size()-1).getContractorId() );
                }
                fetchedContractors = temp;
                //contracterListAdapter.notifyDataSetChanged();
                contracterListAdapter = new ContractorListAdapter(fetchedContractors,getActivity());
                rvCOntractors.setAdapter(contracterListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }

}
