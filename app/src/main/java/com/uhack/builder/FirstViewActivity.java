package com.uhack.builder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.uhack.builder.adapters.ProjectListAdapter;
import com.uhack.builder.model.Project;
import com.uhack.builder.utils.FirebaseLinks;
import com.uhack.builder.utils.SuperPrefs;

import java.util.ArrayList;

public class FirstViewActivity extends AppCompatActivity implements FirebaseLinks{

    private ArrayList<String> listOfProjectIDs;
    private RecyclerView recyclerView;
    private SuperPrefs superPrefs;
    private ProjectListAdapter projectListAdapter;
    private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv_project_list);
        superPrefs = new SuperPrefs(this);

        // builder reference
        setUpAdapter();

        FirebaseReference.projectReference.child(superPrefs.getString(BUILDER_ID)).child(PROJECT_IDS).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //DataSnapshot dataSnapshot1 = dataSnapshot.getChildren();

                        listOfProjectIDs.clear();
                        for (DataSnapshot itr:dataSnapshot.getChildren()
                                ) {
                            listOfProjectIDs.add(itr.getValue().toString());
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
        recyclerView.setAdapter(projectListAdapter);
    }

    private void updateUI() {
        final ArrayList<Project> alp = new ArrayList<>();
        for( i=0;i<listOfProjectIDs.size();i++){

            FirebaseReference.projectReference.child(listOfProjectIDs.get(i)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    alp.add(dataSnapshot.getValue(Project.class));
                    FirebaseReference.projectReference.child(listOfProjectIDs.get(i)).removeEventListener(this);
                    projectListAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

}
