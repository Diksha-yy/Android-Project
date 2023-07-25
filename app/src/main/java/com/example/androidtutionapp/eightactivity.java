package com.example.androidtutionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class eightactivity extends AppCompatActivity {

    TextView tvres;
    EditText edtname,edtemail,edtpassword,edtconfirm;
    Button btnreg;

    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eightactivity);

        tvres = findViewById(R.id.textView);
        edtname = findViewById(R.id.editTextName);
        edtemail = findViewById(R.id.editTextEmail);
        edtpassword = findViewById(R.id.editTextPassword);
        btnreg = findViewById(R.id.buttonReg);
        edtconfirm=findViewById(R.id.editTextPass);

        DB = new DBHelper(this);


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = edtname.getText().toString();
                String emil = edtemail.getText().toString();
                String pass = edtpassword.getText().toString();
                String cpass=edtconfirm.getText().toString();

                if (user.equals("")|| emil.equals("")||pass.equals(""))
                    Toast.makeText(eightactivity.this, "Please Enter All Feilds", Toast.LENGTH_SHORT).show();

                else {
                    if (pass.equals(cpass)) {
                        Boolean checkname = DB.checknameuser(user);
                        if (checkname == false) {
                            Boolean insert = DB.insertData(user, emil,pass,cpass);
                            if (insert = true) {
                                Toast.makeText(eightactivity.this, "Registered Susseccfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), loginactivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(eightactivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            Toast.makeText(eightactivity.this, "User Already Exists Please Signin", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(eightactivity.this, "Password Not Maching ", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}