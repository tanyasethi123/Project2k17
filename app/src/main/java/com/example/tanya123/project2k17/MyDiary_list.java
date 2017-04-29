package com.example.tanya123.project2k17;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

//import static com.example.tanya123.project2k17.Databasehelper.TABLE_MYDIARY;

public class MyDiary_list extends ListActivity {
    Cursor cs;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diary_list);
        ListView diarylist = (ListView)findViewById(android.R.id.list);

        try{
            SQLiteOpenHelper Databasehelper = new Databasehelper(MyDiary_list.this);
             db= Databasehelper.getReadableDatabase();
            cs = db.query("MYDIARY",new String[]{"_id","DATE1"},
                    null,null,null,null,null);
           final SimpleCursorAdapter diary = new SimpleCursorAdapter(MyDiary_list.this,R.layout.list_item,
                    cs,new String[]{"DATE1"},new int[]{R.id.showdate},0);
            diarylist.setAdapter(diary);

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        cs.close();
        db.close();

    }

    @Override
    public void onListItemClick (ListView listView,
                                 View itemView,
                                 int position,
                                 long id){
        Intent intent = new Intent(MyDiary_list.this, MyDiary_clicklist.class);
        intent.putExtra(MyDiary_clicklist.EXTRA_MESSAGE,(int)id);
        startActivity(intent);

    }
}
