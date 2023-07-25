package com.example.androidtutionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {


    RadioButton rbAJ,rbA;
    TextView tvres;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        initializer();
        eventHandler();

    }

    public void initializer(){

        rbAJ=findViewById(R.id.radioButtonAJ);
        rbA=findViewById(R.id.radioButtonA);
        tvres=findViewById(R.id.textViewRes);
        btnSubmit=findViewById(R.id.buttonS);
    }
    public void eventHandler(){

        btnSubmit.setOnClickListener(view -> {


            if (rbAJ.isChecked()) {
                tvres.setText("Advance Java");

            } else if (rbA.isChecked()) {
                tvres.setText("Android");

            }
            Intent ii=new Intent(FourthActivity.this,Fifth_Activity.class);
            ii.putExtra("sub",tvres.getText().toString());
            startActivity(ii);



        });
    }
}

