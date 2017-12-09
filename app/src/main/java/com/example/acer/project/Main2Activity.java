package com.example.acer.project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.project.DB.DBHelper;
import com.example.acer.project.model.Potter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    public ArrayList<Potter> aList = new ArrayList<>();
    Button mUp, mBot;
    TextView mquiz;
    ImageView mpic;
    private DBHelper mDb;
    private SQLiteDatabase db;

    private PotterData potterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        potterData = new PotterData();

        mUp = findViewById(R.id.button1);
        mBot = findViewById(R.id.button2);
        mquiz = findViewById(R.id.quiz_text);
        mpic = findViewById(R.id.pic);

        // เก็บข้อมูลลงใน ArrayList
        if (savedInstanceState == null) {
            aList.add(new Potter(getString(R.string.quiz_1), (R.drawable.quiz1), getString(R.string.ans_1), getString(R.string.wrong_1)));
            aList.add(new Potter(getString(R.string.quiz_2), (R.drawable.quiz2), getString(R.string.ans_2), getString(R.string.wrong_2)));
            aList.add(new Potter(getString(R.string.quiz_3), (R.drawable.quiz3), getString(R.string.ans_3), getString(R.string.wrong_3)));
            aList.add(new Potter(getString(R.string.quiz_4), (R.drawable.quiz4), getString(R.string.ans_4), getString(R.string.wrong_4)));
            aList.add(new Potter(getString(R.string.quiz_5), (R.drawable.quiz5), getString(R.string.ans_5), getString(R.string.wrong_5)));
            aList.add(new Potter(getString(R.string.quiz_6), (R.drawable.quiz6), getString(R.string.ans_6), getString(R.string.wrong_6)));
            aList.add(new Potter(getString(R.string.quiz_7), (R.drawable.quiz7), getString(R.string.ans_7), getString(R.string.wrong_7)));
            aList.add(new Potter(getString(R.string.quiz_8), (R.drawable.quiz8), getString(R.string.ans_8), getString(R.string.wrong_8)));
            aList.add(new Potter(getString(R.string.quiz_9), (R.drawable.quiz9), getString(R.string.ans_9), getString(R.string.wrong_9)));
            aList.add(new Potter(getString(R.string.quiz_10), (R.drawable.quiz10), getString(R.string.ans_10), getString(R.string.wrong_10)));
        }

        // เรียกค่าจากหน้าที่หนึ่ง
        Bundle bundle = getIntent().getExtras();
        final int i = bundle.getInt("i");

        mquiz.setText(aList.get(i).quiz);
        mpic.setImageResource(aList.get(i).picture);

        //เช็ค i ที่รับมาว่าเป็นเลขคู่หรือไม่ถ้าใช่จะให้ตำตอบที่ถูกอยู่ที่ button ด้านบน ถ้าคำตอบผิดอยู่ button ด้านล่าง
        if (i % 2 == 0) {
            mUp.setText(aList.get(i).rightans);
            mBot.setText(aList.get(i).wrongans);

            //ถ้า Click ที่ button จะแสดง Toast ที่บอกว่าคำตอบนั้นเป็นคำตาบที่ Wrong
            mBot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    if (i == 0) {       //เช็ค i=0 เพื่อเปิดไปทำงานใน Main3Activity
                        Intent a1 = new Intent(Main2Activity.this, Main3Activity.class);
                        startActivity(a1);
                    } else {
                        finish();
                    }
                }
            });

            //ถ้า Click ที่ button จะแสดง Toast ที่บอกว่าคำตอบนั้นเป็นคำตาบที่ Correct
            mUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    potterData.score += 10;     //เมื่อตอบถูกจะเพิ่มทีละ 10 คะแนน
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    if (i == 0) {
                        Intent a1 = new Intent(Main2Activity.this, Main3Activity.class);
                        startActivity(a1);
                    } else {
                        finish();
                    }
                }
            });

            // i ที่เป็นเลขคี่จะให้คำตอบที่ถูกต้องอยู่ด้านล่าง คำตอบที่ผิดอยู่ด้านบน
        } else {
            mBot.setText(aList.get(i).rightans);
            mUp.setText(aList.get(i).wrongans);
            mBot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    potterData.score += 10;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });

            mUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }

    }
}
