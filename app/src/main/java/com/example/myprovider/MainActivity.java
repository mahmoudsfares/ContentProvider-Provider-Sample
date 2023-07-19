package com.example.myprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myprovider.data.DatabaseClient;
import com.example.myprovider.models.DevicePin;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.pinEt);
    }

    public void showAlertDialog(View v) {
        if (et.getText().toString().isEmpty()) {
            Toast.makeText(this, "Pin can't be empty", Toast.LENGTH_SHORT).show();
        } else {
            DevicePin p = new DevicePin(et.getText().toString());
            addPinToDatabase(p);
        }
    }

    private void addPinToDatabase(DevicePin p) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .appDao()
                        .insert(p);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                executor.shutdown();
            }
        });
    }
}
