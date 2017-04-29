package com.example.tanya123.project2k17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class To_do extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        Button add1 = (Button)findViewById(R.id.add1);
        Button open1 = (Button)findViewById(R.id.open1);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(To_do.this,ToDo_chart.class);
                startActivity(in);
            }
        });
        open1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(To_do.this,Todo_open.class);
                startActivity(in);
            }
        });
    }
}
