package com.uhack.builder.fragment;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.uhack.builder.FirebaseReference;
import com.uhack.builder.R;
import com.uhack.builder.model.Project;
import com.uhack.builder.model.Todo;
import com.uhack.builder.utils.FirebaseLinks;
import com.uhack.builder.utils.SuperPrefs;

import java.util.ArrayList;

import uhack.contractor.model.ContractorTemp;

public class AddTodoDialogFragment extends DialogFragment implements FirebaseLinks {

    private EditText etToDoTitle;
    private Button btnDone;
    private ArrayList<String> arrayListToDos;
    private Spinner spnToDoContractorList;
    private ArrayList<ContractorTemp> listOfContractTemp;
    private DatePicker datepicker;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("Add New To Do");
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.MyDialogFragmentStyle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Add New To Do");

        View view= inflater.inflate(R.layout.add_to_do, container);
        initializer(view);
        return view;
    }

    private void initializer(View view) {
        btnDone = (Button) view.findViewById(R.id.btn_add_to_do_done);
        spnToDoContractorList = (Spinner)view.findViewById(R.id.to_do_contractor_list);
        arrayListToDos = new ArrayList<>();
        etToDoTitle = (EditText) view.findViewById(R.id.et_todo_title);
        listOfContractTemp = new ArrayList<>();
        datepicker = new DatePicker(getActivity());

        fillDataInSpinner();
    }

    private void fillDataInSpinner() {
        FirebaseReference.projectReference.child(ContractorsFragment.PROJECT_ID).child("contractorData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot data: dataSnapshot.getChildren()){
                    arrayListToDos.add(data.getValue(ContractorTemp.class).getName());
                    Log.e("To DO tasks ", arrayListToDos.get(arrayListToDos.size()-1));
                    listOfContractTemp.add(data.getValue(ContractorTemp.class));
                }
                ArrayAdapter<String> contractorTimeDurationAdapter = new ArrayAdapter<String>(
                        getActivity(),android.R.layout.simple_spinner_item,
                        arrayListToDos
                );

                contractorTimeDurationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnToDoContractorList.setAdapter(contractorTimeDurationAdapter);



                FirebaseReference.projectReference.child("contractorData").removeEventListener(this);
                btnDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendProjectDetailsToFirebase();
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void sendProjectDetailsToFirebase() {
        SuperPrefs superPrefs = new SuperPrefs(getActivity());
        DatabaseReference databaseReference = FirebaseReference.toDoReference
                .push();

        int pos = spnToDoContractorList.getSelectedItemPosition();
        String contractorID = listOfContractTemp.get(pos).getContractorId();

        Todo temp = new Todo(
                etToDoTitle.getText().toString(),
                superPrefs.getString(FirebaseLinks.BUILDER_ID),
                contractorID,
                databaseReference.getKey(),
                0,
                System.currentTimeMillis(),
                ContractorsFragment.PROJECT_ID
        );
        databaseReference.setValue(temp);
        /*
        databaseReference.setValue(new Project(
                etProjectName.getText().toString(),
                etProjectAddress.getText().toString(),
                Integer.parseInt(etProjectBudget.getText().toString()),
                Integer.parseInt(etProjectExpense.getText().toString()),
                superPrefs.getString(BUILDER_ID),
                databaseReference.getKey(),
                new ArrayList<String>(),
                new ArrayList<String>(),
                new ArrayList<String>()

        ));
*/
        getDialog().dismiss();
    }

    private static ArrayList<String> getList(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        return arrayList;
    }
}
