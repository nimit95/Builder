package com.uhack.builder.fragment.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.uhack.builder.FirebaseReference;
import com.uhack.builder.R;
import com.uhack.builder.model.Contractor;

import java.util.ArrayList;


/**
 * Created by piyush on 14/10/17.
 */

public class AddContractor extends DialogFragment {
    private FloatingActionButton fabAddContractor;
    private static ArrayList<String> listOfContractorTypes;
    private Spinner spnContractorType,spnContractorList;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Add New Project");
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.MyDialogFragmentStyle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Add New Project");

        View view= inflater.inflate(R.layout.fragment_add_contractor, container);

        initializer(view);
        return view;
    }

    private void initializer(View view) {
        listOfContractorTypes = new ArrayList<>();
        listOfContractorTypes.add("Carpenter");
        listOfContractorTypes.add("Electrician");
        listOfContractorTypes.add("Plumber");
        listOfContractorTypes.add("Painter");
        listOfContractorTypes.add("Mason");
        spnContractorList = (Spinner)view.findViewById(R.id.spn_contractor_list);
        spnContractorType = (Spinner)view.findViewById(R.id.spn_contractor_type);
        fabAddContractor = (FloatingActionButton)view.findViewById(R.id.fab_add_contractor);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_spinner_item,
                        listOfContractorTypes); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spnContractorType.setAdapter(spinnerArrayAdapter);


        spnContractorType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateOtherSpinner(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void updateOtherSpinner(final int position) {
        final ArrayList<Contractor>  contractorList = new ArrayList<>();
        // get query result in above;


        FirebaseReference.contractorReference.child(String.valueOf(position)).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ArrayList<String> namesOfContractors = new ArrayList<>();

                        for(int i=0;i<contractorList.size();i++)
                            namesOfContractors.add(contractorList.get(i).getContractorName());

                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                                (getActivity(), android.R.layout.simple_spinner_item,
                                        namesOfContractors); //selected item will look like a spinner set from XML
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                                .simple_spinner_dropdown_item);
                        spnContractorType.setAdapter(spinnerArrayAdapter);
                        FirebaseReference.contractorReference.child(String.valueOf(position)).removeEventListener(this);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );

    }
}
