package com.uhack.builder.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.uhack.builder.FirebaseReference;
import com.uhack.builder.R;
import com.uhack.builder.adapters.ContractorsListAdapter;
import com.uhack.builder.model.Inventory;
import com.uhack.builder.model.Project;
import com.uhack.builder.utils.FirebaseLinks;
import com.uhack.builder.utils.SuperPrefs;

import java.util.ArrayList;


/**
 * Created by piyush on 14/10/17.
 */

public class AddInventoryFragment extends DialogFragment implements FirebaseLinks {

    private EditText etInventoryName, etInventoryQty;
    private Button btnDone;
    private String projectID;


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

        View view = inflater.inflate(R.layout.fragment_add_project, container);
        initializer(view);
        // lvContractors.setAdapter(new ContractorsListAdapter(getList(),getActivity()));
        return view;
    }

    private void initializer(View view) {
        etInventoryName = (EditText) view.findViewById(R.id.et_inventory_name);
        etInventoryQty = (EditText) view.findViewById(R.id.et_inventory_qty);

        btnDone = (Button) view.findViewById(R.id.btn_done);
        // lvContractors = (ListView) view.findViewById(R.id.lv_contractors);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendProjectDetailsToFirebase();
            }
        });
    }

    private void sendProjectDetailsToFirebase() {
        // SuperPrefs superPrefs = new SuperPrefs(getActivity());
        DatabaseReference databaseReference = FirebaseReference.inventoryReference
                .push();
        databaseReference.setValue(new Inventory(
                databaseReference.getKey(),
                etInventoryName.getText().toString(),
                etInventoryQty.getText().toString()
        ));

       /* FirebaseReference.builderReference.child(superPrefs.getString(FirebaseLinks.BUILDER_ID))
                .child(FirebaseLinks.PROJECT_IDS).push().setValue(databaseReference.getKey());*/
        FirebaseReference.projectReference.child(projectID).child("inventoryIDs").push().setValue(databaseReference.getKey());

        getDialog().dismiss();
    }

    private static ArrayList<String> getList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        return arrayList;
    }
}
