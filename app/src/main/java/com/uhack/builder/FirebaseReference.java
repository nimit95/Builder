package com.uhack.builder;

import android.app.Application;

/**
 * Created by piyush on 14/10/17.
 */

public class FirebaseReference extends Application {
    public static FirebaseDatabase database;
    public static DatabaseReference userReference;
    public static DatabaseReference groupsReference;

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(getApplicationContext());
        Realm.init(getApplicationContext());
        database = FirebaseDatabase.getInstance();
        userReference = database.getReference().child("users");
        groupsReference = database.getReference().child("groups");
    }
}
