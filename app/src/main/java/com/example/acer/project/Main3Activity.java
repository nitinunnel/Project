package com.example.acer.project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acer.project.DB.DBHelper;

public class Main3Activity extends AppCompatActivity {
    Button back;
    TextView textView;
    private SQLiteDatabase db;
    private DBHelper mDb;
    private PotterData potterData;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        back = findViewById(R.id.exit_button);
        textView = findViewById(R.id.textView2);

        // method ที่กำหนดว่าเมื่อมีการ Click ที่ปุ่ม "กลับไปหน้าแรก" จะกลับไปหน้าที่หนึ่ง
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(home);
            }
        });

        mDb = new DBHelper(this);       // ประการศ Object DBHelper เพื่อเรียกใช้งานใน Class
        db = mDb.getReadableDatabase();         // ขอสิทธิ์อ่านข้อมูลใน Database

        // สร้างตัวแปรเพื่อทำการ insert ค่าลง TABLE
        ContentValues cv = new ContentValues();
        cv.put(mDb.COL_COUNT, potterData.score);
        db.insert(mDb.TABLE_NAME, null, cv);
        loadDb();
    }

    // เรียงข้อมูลลง TABLE
    private void loadDb() {
        Cursor cursor = db.query(
                mDb.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()) {

            int score = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_COUNT));
            textView.setText(String.valueOf(score));
        }
        potterData.score = 0;
    }

}
