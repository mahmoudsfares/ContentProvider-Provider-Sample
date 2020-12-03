package com.example.myprovider.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/*
This class defines the entities and version of the DB
 */

@Database(entities = {com.example.myprovider.data.DevicePin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}