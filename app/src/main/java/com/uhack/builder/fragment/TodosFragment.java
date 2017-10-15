package com.uhack.builder.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.uhack.builder.adapters.ToDoListAdapter;
import com.uhack.builder.fragment.dialogs.AddContractor;
import com.uhack.builder.model.Todo;
import com.uhack.builder.utils.FirebaseLinks;
import com.uhack.builder.utils.SuperPrefs;

import java.util.ArrayList;

public class TodosFragment extends Fragment {

    RecyclerView rvTodos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todos, container, false);

        rvTodos = (RecyclerView)view.findViewById(R.id.rv_todo_list);

        (view.findViewById(R.id.fab_add_todo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                AddTodoDialogFragment addTodoDialogFragment = new AddTodoDialogFragment();
                addTodoDialogFragment.show(fragmentManager,"TAG");
            }
        });

        setUpListener();
        return view;
    }

    private void setUpListener() {
        SuperPrefs superPrefs = new SuperPrefs(getActivity());
        final String projectID = ContractorsFragment.PROJECT_ID;
        final String builderID = superPrefs.getString(FirebaseLinks.BUILDER_ID);

                FirebaseReference.toDoReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Todo> arrayListToDo = new ArrayList<Todo>();

                for(DataSnapshot data: dataSnapshot.getChildren()){
                    Todo temp = data.getValue(Todo.class);

                    if(temp.getBuilderID().contentEquals(builderID)
                            && temp.getProjectId().contentEquals(projectID))
                        arrayListToDo.add(temp);
                }

                ToDoListAdapter todoListAdapter = new ToDoListAdapter(arrayListToDo,getActivity());
                rvTodos.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvTodos.setAdapter(todoListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
