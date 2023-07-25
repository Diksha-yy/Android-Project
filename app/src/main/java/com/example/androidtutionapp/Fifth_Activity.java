package com.example.androidtutionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Fifth_Activity extends AppCompatActivity {
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        tv=findViewById(R.id.textViewview);
        btn=findViewById(R.id.button3);

        tv.setText(getIntent().getExtras().getString("sub"));



                if (tv.equals("Android Java")) {
                    tv.setText(getIntent().getExtras().getString("sub"));

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent iii = new Intent(Fifth_Activity.this, sixthActivity.class);
                            startActivity(iii);
                        }
                    });


                } else {
                    tv.setText(getIntent().getExtras().getString("sub"));

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           Intent iii = new Intent(Fifth_Activity.this, SevenActivity.class);
                           startActivity(iii);
                        }
                    });


                }

    }
}


