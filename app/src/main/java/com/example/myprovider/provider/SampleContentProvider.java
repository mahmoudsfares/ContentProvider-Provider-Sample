package com.example.myprovider.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.example.myprovider.data.AppDao;
import com.example.myprovider.data.DatabaseClient;
import com.example.myprovider.data.PinProviderContract;

public class SampleContentProvider extends ContentProvider {

    public SampleContentProvider() { }

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static { sURIMatcher.addURI(PinProviderContract.AUTHORITY, PinProviderContract.PATH, 10); }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if(sURIMatcher.match(uri) == 10){
            AppDao dao = DatabaseClient.getInstance(getContext()).getAppDatabase().appDao();
            final Cursor cursor = dao.get();
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
            return cursor;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}