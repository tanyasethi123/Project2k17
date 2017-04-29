package com.example.tanya123.project2k17;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyDiary_text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diary_text);

        final EditText date =(EditText)findViewById(R.id.date1);
        final EditText diarytext =(EditText)findViewById(R.id.diary);
        Button savediary =(Button) findViewById(R.id.diarysave);

        savediary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = date.getText().toString();
                String d2 = diarytext.getText().toString();
                try{
                    Databasehelper database1  = new Databasehelper(MyDiary_text.this);
                    SQLiteDatabase db = database1.getWritableDatabase();
                    database1.insertmydiary(db,d1,d2);

                    Toast.makeText(MyDiary_text.this,"SAVED",Toast.LENGTH_SHORT).show();

                    finish();
                }catch(Exception e) {
                    Toast.makeText(MyDiary_text.this,e.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
