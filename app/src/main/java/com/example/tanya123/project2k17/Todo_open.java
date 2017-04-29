package com.example.tanya123.project2k17;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Todo_open extends AppCompatActivity {
    TextView ug_n_im ,nug_n_im ,ug_n_nim ,nug_n_nim ;
    EditText e1,e2,e3,e4;
    AlertDialog d1,d2,d3,d4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_open);

        Databasehelper da = new Databasehelper(this);
        final SQLiteDatabase db = da.getReadableDatabase();

        ug_n_im = (TextView)findViewById(R.id.UAI);
        nug_n_im =(TextView)findViewById(R.id.NUAI);
        ug_n_nim=(TextView)findViewById(R.id.UANI);
        nug_n_nim=(TextView)findViewById(R.id.NUANI);

        e1 = new EditText(this);
        e2 = new EditText(this);
        e3 = new EditText(this);
        e4 = new EditText(this);

        try {

            Cursor c1 = db.rawQuery("T", new String[]{"URG_n_IMP", "NOTURG_n_IMP", "NOTIMP_n_URG", "NOTURG_n_NOTIMP"});

            String a = c1.getString(0);
            String b = c1.getString(1);
            String c = c1.getString(2);
             String d = c1.getString(3);

            ug_n_im.setText(a);
            nug_n_im.setText(b);
            ug_n_nim.setText(c);
            nug_n_nim.setText(d);

            d1= new AlertDialog.Builder(this).create();
            d2= new AlertDialog.Builder(this).create();
            d3= new AlertDialog.Builder(this).create();
            d4= new AlertDialog.Builder(this).create();

            d1.setTitle("Edit The Text");
            d2.setTitle("Edit The Text");
            d3.setTitle("Edit The Text");
            d4.setTitle("Edit The Text");

            d1.setView(e1);
            d2.setView(e2);
            d3.setView(e3);
            d4.setView(e4);

            d1.setButton(DialogInterface.BUTTON_POSITIVE, "Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ug_n_im.setText(e1.getText());
                    String e3a = ug_n_im.getText().toString();
                    ContentValues value = new ContentValues();
                    value.put("URG_n_IMP",e3a);
                    db.update("T",value,"_id=?",new String[]{Integer.toString(1)});
                }
            });
            ug_n_im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    e1.setText(ug_n_im.getText());
                    d1.show();
                }
            });
            d2.setButton(DialogInterface.BUTTON_POSITIVE, "Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    nug_n_im.setText(e2.getText());
                    String e3b = nug_n_im.getText().toString();
                    ContentValues value = new ContentValues();
                    value.put("NOTURG_n_IMP",e3b);
                    db.update("T",value,"_id=?",new String[]{Integer.toString(1)});
                }
            });
            nug_n_im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    e2.setText(nug_n_im.getText());
                    d2.show();
                }
            });
            d3.setButton(DialogInterface.BUTTON_POSITIVE, "Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ug_n_nim.setText(e3.getText());
                    String e3c = ug_n_nim.getText().toString();
                    ContentValues value = new ContentValues();
                    value.put("URG_n_NOTIMP",e3c);
                    db.update("T",value,"_id=?",new String[]{Integer.toString(1)});
                }
            });
            ug_n_nim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    e3.setText(ug_n_nim.getText());
                    d3.show();
                }
            });
            d4.setButton(DialogInterface.BUTTON_POSITIVE, "Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    nug_n_nim.setText(e4.getText());
                    String e3d = nug_n_nim.getText().toString();
                    ContentValues value = new ContentValues();
                    value.put("NOTURG_n_NOTIMP",e3d);
                    db.update("T",value,"_id=?",new String[]{Integer.toString(1)});
                }
            });
            nug_n_nim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    e4.setText(nug_n_nim.getText());
                    d4.show();
                }
            });


        }catch(Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
