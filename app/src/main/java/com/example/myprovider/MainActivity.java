package com.example.myprovider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myprovider.data.AppDatabase;
import com.example.myprovider.data.DatabaseClient;
import com.example.myprovider.data.DevicePin;
import com.example.myprovider.data.PinProviderContract;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }

    public void showAlertDialog(View v){
        if(!et.getText().toString().equals("6543210"))
            et.setError("Wrong password!");

        else{
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Insert device pin code:");
            alertDialog.setCancelable(false);
            final EditText input = new EditText(this);
            input.setPadding(50, 50, 50, 50);
            input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            alertDialog.setView(input);
            alertDialog.setPositiveButton("OK", (dialog, which) -> saveInDatabase(input.getText().toString()));
            alertDialog.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
            alertDialog.show();
        }
    }

    private void saveInDatabase(String pin){
        DevicePin p = new DevicePin(pin);
        new Thread(() -> {
            //adding to database
            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                    .appDao()
                    .insert(p);
        }).start();
    }
}