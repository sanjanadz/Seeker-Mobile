package com.example.seeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddLocation extends AppCompatActivity {

    private Spinner spinnerProvince, spinnerDis;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        spinnerProvince = findViewById(R.id.spinnerProvince);
        spinnerDis = findViewById(R.id.spinnerDistrict);

        progressDialog = new ProgressDialog(this);

        spinnerProvince.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,LocationData.provinceName));
        spinnerDis.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,LocationData.DisName));

        findViewById(R.id.buttonLSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
//                progressDialog.dismiss();

            }
        });

    }
    public void sendData(){
        Details details = new Details();
        String a = (String) spinnerProvince.getSelectedItem();
        String b = (String) spinnerDis.getSelectedItem();

        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String phone = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Details").child(currentuser);

        details.setPhone(phone);
        details.setUserid(currentuser);
        details.setDistrictl(a);
        details.setProvince(b);

        ref.setValue(details).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
//                    progressDialog.setMessage("Process is Successfull");
//                    progressDialog.show();
                    Intent intent = new Intent(AddLocation.this, BluetoothEnable.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                    Toast.makeText(AddLocation.this,"Process is Successfull", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(AddLocation.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
