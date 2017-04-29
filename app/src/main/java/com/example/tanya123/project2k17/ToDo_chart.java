package com.example.tanya123.project2k17;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToDo_chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_chart);

        Button save = (Button) findViewById(R.id.todosave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText) findViewById(R.id.UAI);
                EditText e2 = (EditText) findViewById(R.id.NUAI);
                EditText e3 = (EditText) findViewById(R.id.UANI);
                EditText e4 = (EditText) findViewById(R.id.NUANI);
                try{

                    String s1 = e1.getText().toString();
                    String s2 = e2.getText().toString();
                    String s3 = e3.getText().toString();
                    String s4 = e4.getText().toString();
                    Databasehelper database2  = new Databasehelper(ToDo_chart.this);
                    SQLiteDatabase db = database2.getWritableDatabase();
                    if(db == null) {
                        database2.inserttodo(db, s1, s2, s3, s4);
                    }
                    else{
                        ContentValues values = new ContentValues();
                        values.put("URG_n_IMP",s1);
                        values.put("NOTURG_n_IMP",s2);
                        values.put("URG_n_NOTIMP",s3);
                        values.put("NOTURG_n_NOTIMP",s4);
                        db.update("T",values,"_id=?",new String[]{Integer.toString(1)});
                    }
                    Toast.makeText(ToDo_chart.this," CHART SAVED",Toast.LENGTH_SHORT).show();

                    finish();

                }catch(Exception e){
                    Toast.makeText(ToDo_chart.this,e.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
