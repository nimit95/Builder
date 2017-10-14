package com.uhack.builder;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import com.uhack.builder.adapters.ProjectListAdapter;
import com.uhack.builder.fragment.AddProjectDialogFragment;
import com.uhack.builder.model.Project;

import com.uhack.builder.utils.FirebaseLinks;
import com.uhack.builder.utils.SuperPrefs;

import java.util.ArrayList;

public class FirstViewActivity extends AppCompatActivity implements FirebaseLinks{

    private ArrayList<String> listOfProjectIDs;
    private RecyclerView recyclerView;
    private SuperPrefs superPrefs;

    private ProjectListAdapter projectListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv_project_list);
        superPrefs = new SuperPrefs(this);


        // builder reference
        listOfProjectIDs = new ArrayList<>();
        setUpAdapter();

        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddProjectDialogFragment addProjectDialogFragment = new AddProjectDialogFragment();
        addProjectDialogFragment.show(fragmentManager,"TAG");*/

        FirebaseReference.builderReference.child(superPrefs.getString(BUILDER_ID)).child(PROJECT_IDS).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //DataSnapshot dataSnapshot1 = dataSnapshot.getChildren();

                        listOfProjectIDs.clear();
                        for (DataSnapshot itr:dataSnapshot.getChildren()) {
                            listOfProjectIDs.add(itr.getValue(String.class));
                            Log.e("onDataChange: ", itr.getValue(String.class));
                        }
                        updateUI();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );
    }


    private void setUpAdapter() {
        projectListAdapter = new ProjectListAdapter(
                new ArrayList<Project>(),
                FirstViewActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(projectListAdapter);
    }

    private void updateUI() {
        final ArrayList<Project> alp = new ArrayList<>();
        for( int k=0;k<listOfProjectIDs.size();k++){

            FirebaseReference.projectReference.child(listOfProjectIDs.get(k)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    alp.add(dataSnapshot.getValue(Project.class));
                    //FirebaseReference.projectReference.child(listOfProjectIDs.get(i.getVal())).removeEventListener(this);
                    projectListAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }


}
