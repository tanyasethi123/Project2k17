package com.example.tanya123.project2k17;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class welcome_page extends Activity {
    ProgressBar prg;
    Handler h = new Handler();
    int progress ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        prg =  (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for ( progress = 0; progress <=100; progress+=20) {

                    try {

                        Thread.sleep(1000);

                        prg.setProgress(progress);
                        if (progress == prg.getMax()) {
                            Intent i1 = new Intent(welcome_page.this, main_page.class);
                            startActivity(i1);
                        }


                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                    }

                }
                finish();
            }
        }).start();


    }


}
