package com.example.acer.project;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acer.project.DB.DBHelper;

public class Main3Activity extends AppCompatActivity {
    Button exit;
    TextView textView;
    private SQLiteDatabase db;
    private DBHelper mDb;
    private PotterData potterData;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        exit = findViewById(R.id.exit_button);
        textView = findViewById(R.id.textView2);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(home);

            }
        });

        mDb = new DBHelper(this);
        db = mDb.getReadableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(mDb.COL_COUNT, potterData.score);
        db.insert(mDb.TABLE_NAME, null, cv);
        loadDb();
    }
    private void loadDb() {
        Cursor cursor = db.query(
            mDb.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null);

        while (cursor.moveToNext()){

            int score = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_COUNT));
            textView.setText(String.valueOf(score));
        }
    }

}
