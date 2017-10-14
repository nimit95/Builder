package com.uhack.builder.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uhack.builder.R;
import com.uhack.builder.fragment.dialogs.AddContractor;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContractorsFragment extends Fragment {

    private FloatingActionButton fabAddContractor;
    public ContractorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contractors, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getChildFragmentManager();
                AddContractor addContractor = new AddContractor();
                addContractor.show(fragmentManager,"TAG");
            }
        });
        return view;
    }

}
