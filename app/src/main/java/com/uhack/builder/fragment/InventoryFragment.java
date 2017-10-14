package com.uhack.builder.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.uhack.builder.FirebaseReference;
import com.uhack.builder.R;
import com.uhack.builder.adapters.InventoryListAdapter;
import com.uhack.builder.model.Inventory;

import java.util.ArrayList;


public class InventoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "project-id";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String groupID;
    private String mParam2;


    public InventoryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static InventoryFragment newInstance(String projectID) {
        InventoryFragment fragment = new InventoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, projectID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            groupID = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ArrayList<Inventory> inventoryArrayList;
    private ArrayList<String> inventoryIDs;
    private RecyclerView recyclerView;
    private InventoryListAdapter inventoryListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        recyclerView = view.findViewById(R.id.rv_inventory_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        inventoryArrayList = new ArrayList<>();
        inventoryIDs = new ArrayList<>();
        inventoryListAdapter = new InventoryListAdapter(getActivity(), inventoryArrayList);
        recyclerView.setAdapter(inventoryListAdapter);

        FirebaseReference.projectReference.child(groupID).child("inventoryIDs").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                inventoryArrayList.clear();
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    inventoryIDs.add(data.getValue(String.class));
                }

                updateUI();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    private void updateUI() {
        inventoryArrayList.clear();
        for (int i=0;i<inventoryIDs.size();i++) {
            FirebaseReference.inventoryReference.child(inventoryIDs.get(i)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    inventoryArrayList.add(dataSnapshot.getValue(Inventory.class));
                    inventoryListAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }


}
