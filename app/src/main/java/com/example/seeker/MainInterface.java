package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainInterface extends AppCompatActivity {
    TextView t;

    private BluetoothAdapter myBluetoothAdapter;
    private Intent btEnablingIntent;
    private int requestCodeForeEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);

        t =findViewById(R.id.text);

        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btEnablingIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        requestCodeForeEnable =1;

        if(myBluetoothAdapter.isEnabled()){
            t.setText("Bluetooth is Enable");
            //Toast.makeText(getApplicationContext(), "Bluetooth is Enable", Toast.LENGTH_SHORT).show();
        }
        else {
            if (!myBluetoothAdapter.isEnabled()) {
                t.setText("Bluetooth is Disable");
                //startActivityForResult(btEnablingIntent, requestCodeForeEnable);
            }
        }

    }
}
