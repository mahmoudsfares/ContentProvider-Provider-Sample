package com.example.myprovider.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "device-pin")
public class DevicePin {

    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo (name = "pin")
    private String pin;

    public DevicePin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
