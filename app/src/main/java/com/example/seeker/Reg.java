package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Reg extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        spinner = findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,CountryData.countryName));
        editText = findViewById(R.id.textphonenumber);

        findViewById(R.id.buttonsubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = CountryData.countryAreaCode[spinner.getSelectedItemPosition()];
                String number = editText.getText().toString().trim();

                if(number.isEmpty()){
                    editText.setError("Number is required");
                    editText.requestFocus();
                    return;
                }

                if(number.length()<9 || number.length()>9){
                    editText.setError("Enter Correct Number");
                    editText.requestFocus();
                    return;
                }
                String phoneNumber = "+" +code+number;


                Intent intent = new Intent(Reg.this, ConfirmationCode.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);

            }
        });


        }

    @Override
    protected void onStart() {
        super.onStart();
//        if(FirebaseAuth.getInstance().getCurrentUser() !=null){
//            Intent intent = new Intent( MainActivity.this, Profile.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);        }
        }
}
