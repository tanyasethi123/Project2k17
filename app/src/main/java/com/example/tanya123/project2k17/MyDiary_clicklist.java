package com.example.tanya123.project2k17;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import static android.R.string.no;

public class MyDiary_clicklist extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "no";
     SQLiteDatabase db;
    Cursor c1;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diary_clicklist);


        Button deletemydiary = (Button)findViewById(R.id.delete1);
        final ViewSwitcher switcher= (ViewSwitcher)findViewById(R.id.viewswitcher);
        TextView date = (TextView) findViewById(R.id.date1);
        final TextView diary = (TextView) findViewById(R.id.diary);
        save =(Button)findViewById(R.id.savemydiary);
        final EditText e1= (EditText)switcher.findViewById(R.id.hidden_edit_view);
        save.setVisibility(View.INVISIBLE);
        final int no = (Integer) getIntent().getExtras().get(EXTRA_MESSAGE);
        try {
            final Databasehelper Database2 = new Databasehelper(MyDiary_clicklist.this);
           db = Database2.getReadableDatabase();
            //String s="SELECT * FROM DETAILS";
           c1= db.query("MYDIARY",
                    new String[]{"DATE1", "DEAR_DIARY"},
                    "_id=?",
                    new String[]{Integer.toString(no)}, null, null, null, null);
            if (c1.moveToFirst()) {
                final String a1 = c1.getString(0);
                final String a2 = c1.getString(1);

                date.setText(a1);

                diary.setText(a2);

            }
           deletemydiary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Database2.removemydiary(db,no);
                }
            });
            diary.isClickable();
            diary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switcher.showNext();


                    save.setVisibility(View.VISIBLE);
                    e1.setText(diary.getText());

                    String str= e1.getText().toString();
                    Clicked(str);

                }
            });


        } catch (Exception e) {
            Toast.makeText(MyDiary_clicklist.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        c1.close();
        db.close();

    }

    public void Clicked(final String str) {

         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ContentValues val = new ContentValues();
                 val.put("DEAR_DIARY",str);
                 db.update("MYDIARY",val,"_id=?",new  String[]{Integer.toString(no)});
                 finish();
             }
         });


        }
    }

