package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailAddress, password;
    Button login, cancel;
    TextView textView;

   private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        emailAddress = findViewById(R.id.inputEmailAddress);
        password = findViewById(R.id.inputPassword);
        login = findViewById(R.id.btnLogin);
        cancel = findViewById(R.id.btncancel);
        textView = findViewById(R.id.textviewSignup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Sign_in.class);
                startActivity(intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputEmailAddress = emailAddress.getText().toString();
                String inputPassword = password.getText().toString();

                if (TextUtils.isEmpty(inputEmailAddress)) {
                    Toast.makeText(Login.this, "Email Address is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputPassword)) {
                    Toast.makeText(Login.this, "Password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Uncomment and fix this section to sign in with Firebase Authentication

                /*mAuth.signInWithEmailAndPassword(inputEmailAddress, inputPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // User has successfully signed in
                                // You can navigate to another activity here or perform other actions.
                            } else {
                                Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                */
            }
        });
    }
}