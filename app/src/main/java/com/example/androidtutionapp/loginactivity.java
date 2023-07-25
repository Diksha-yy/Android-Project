package com.example.androidtutionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.jar.Attributes;

public class loginactivity extends AppCompatActivity {
    //TextView tvRes, Tv;
    EditText ed1, ed2;
    LinearLayout Ly;
    DBHelper DB;
    Button btnsub, btnCancel;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        //tvRes = findViewById(R.id.textView);
        //Tv = findViewById(R.id.textView1);
        ed1 = findViewById(R.id.editTextemail);
        ed2 = findViewById(R.id.editTextPassword);
        btnsub = findViewById(R.id.buttonsubmit);
        btnCancel = findViewById(R.id.buttoncancel);
        String user = ed1.getText().toString().trim();
        String password = ed2.getText().toString().trim();

        DB = new DBHelper(this);


        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed1.getText().toString();
                String pass = ed2.getText().toString();

                if (email.equals("") || pass.equals(""))
                    Toast.makeText(loginactivity.this, "Please Enter All the feilds", Toast.LENGTH_SHORT).show();

                else {
                    Boolean checkemailpass = DB.checkemailpass(email,pass);
                    if (checkemailpass ==true) {
                        Toast.makeText(loginactivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(loginactivity.this, FourthActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(loginactivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                ed1.setText(null);
                ed2.setText(null);

            }
        });
    }
}