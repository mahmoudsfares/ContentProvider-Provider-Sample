package com.example.myprovider.data;

import android.net.Uri;

public class PinProviderContract {

    public static final String AUTHORITY = "com.example.myprovider.provider";
    public static final String PATH = "device-pin";

    private static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);

    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);
}
