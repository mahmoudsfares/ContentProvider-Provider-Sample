package com.example.myprovider.data;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


/*
This class is for CRUD operations
 */
@Dao
public interface AppDao {

    @Query("SELECT * FROM `device-pin` ORDER BY ROWID DESC LIMIT 1")
    Cursor get();

    @Insert
    void insert(DevicePin pin);
}
