package com.example.seeker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BluetoothEnable extends AppCompatActivity {
    private Button Bcancel, Benable;

    private BluetoothAdapter myBluetoothAdapter;
    private Intent btEnablingIntent;
    private int requestCodeForeEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_enable);

        Benable = findViewById(R.id.bluetoothEnable);
        //Bcancel = findViewById(R.id.bluetoothCancel);

        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        btEnablingIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        requestCodeForeEnable =1;

        BluetoothONMethod();
       // BluetoothOFFMethod();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == requestCodeForeEnable) {
            if (resultCode== RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Bluetooth is Enable", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( BluetoothEnable.this, MainInterface.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Bluetooth is Canceled", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( BluetoothEnable.this, MainInterface.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }

        }
    }

    private void BluetoothONMethod() {
        Benable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myBluetoothAdapter == null) {
                    Toast.makeText(getApplicationContext(), "Bluetooth does not support on this Device", Toast.LENGTH_SHORT).show();
                } else if(myBluetoothAdapter.isEnabled()){
                    Toast.makeText(getApplicationContext(), "Bluetooth is Enable", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent( BluetoothEnable.this, MainInterface.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {
                    if (!myBluetoothAdapter.isEnabled()) {
                        startActivityForResult(btEnablingIntent, requestCodeForeEnable);
                    }
                }
            }
        });
    }

//    private void BluetoothOFFMethod() {
//        Bcancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(myBluetoothAdapter.isEnabled()){
//                    myBluetoothAdapter.disable();
//                    Toast.makeText(getApplicationContext(), "Bluetooth is now Disabled", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Bluetooth is not on", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }




}
