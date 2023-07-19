package com.example.myprovider.data;


import android.content.Context;
import androidx.room.Room;

/*
This class creates DB object instance, because it's an expensive procedure.
 */
public class DatabaseClient {

    private static DatabaseClient mInstance;
    private final AppDatabase appDatabase;

    private DatabaseClient(Context mCtx) {
        //third parameter "String" is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "pin-db").build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}