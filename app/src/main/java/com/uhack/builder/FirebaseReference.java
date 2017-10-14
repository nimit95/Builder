package com.uhack.builder;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by piyush on 14/10/17.
 */

public class FirebaseReference extends Application {

    public static FirebaseDatabase database;
    public static DatabaseReference projectReference;
    public static DatabaseReference builderReference;
<<<<<<< HEAD
    public static DatabaseReference inventoryReference;

=======
    public static DatabaseReference contractorReference;
>>>>>>> 8617ea102491718e073e0ce48743db49b707817f

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(getApplicationContext());
        database = FirebaseDatabase.getInstance();

        projectReference = database.getReference();

        projectReference = database.getReference().child("Projects");
        builderReference = database.getReference().child("Builder");
<<<<<<< HEAD
        inventoryReference = database.getReference().child("Inventory");

=======
        contractorReference = database.getReference().child("Contractor");
>>>>>>> 8617ea102491718e073e0ce48743db49b707817f
    }
}
