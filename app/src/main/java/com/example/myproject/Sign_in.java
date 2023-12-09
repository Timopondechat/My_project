package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {
    String[] item = {"Male,Female"};
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    EditText surname, given_name,date_of_birth,religion, sex, telephone_number;
    Button submit;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth = FirebaseAuth.getInstance();

        surname = findViewById(R.id.Surname);
        given_name = findViewById(R.id.Givenname);
        date_of_birth = findViewById(R.id.DateofBirth);
        religion = findViewById(R.id.Religion);
        sex = findViewById(R.id.Sex);
        telephone_number = findViewById(R.id.Phonenumber);

        submit = findViewById(R.id.btn_submit);

        TextView btn=findViewById(R.id.Onlineregistration);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_in.this, Login.class));
            }
        });
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView4);
        adapterItems = new ArrayAdapter<String>(this, R.layout.dropdown_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

            }
        });

    }
}