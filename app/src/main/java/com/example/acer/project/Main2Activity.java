package com.example.acer.project;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
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

    static private ArrayList<Potter> aList = PotterData.potterList;
    private int[] Array = new int[100];
    Button mcorrect, mwrong;
    TextView mquiz;
    ImageView mpic;
    private int score = 0;
    private DBHelper mDb;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mcorrect = findViewById(R.id.button1);
        mwrong = findViewById(R.id.button2);
        mquiz = findViewById(R.id.quiz_text);
        mpic = findViewById(R.id.pic);

        if (savedInstanceState == null) {
            aList.add(new Potter(getString(R.string.quiz_1), (R.drawable.quiz1), getString(R.string.ans_1), getString(R.string.wrong_1)));
            aList.add(new Potter(getString(R.string.quiz_2), (R.drawable.quiz2), getString(R.string.ans_2), getString(R.string.wrong_2)));
            aList.add(new Potter(getString(R.string.quiz_3), (R.drawable.quiz3), getString(R.string.ans_3), getString(R.string.wrong_3)));
            aList.add(new Potter(getString(R.string.quiz_4),(R.drawable.quiz4), getString(R.string.ans_4), getString(R.string.wrong_4)));
            aList.add(new Potter(getString(R.string.quiz_5),(R.drawable.quiz5), getString(R.string.ans_5), getString(R.string.wrong_5)));
            aList.add(new Potter(getString(R.string.quiz_6), (R.drawable.quiz6), getString(R.string.ans_6), getString(R.string.wrong_6)));
            aList.add(new Potter(getString(R.string.quiz_7), (R.drawable.quiz7), getString(R.string.ans_7), getString(R.string.wrong_7)));
            aList.add(new Potter(getString(R.string.quiz_8), (R.drawable.quiz8), getString(R.string.ans_8), getString(R.string.wrong_8)));
            aList.add(new Potter(getString(R.string.quiz_9), (R.drawable.quiz9), getString(R.string.ans_9), getString(R.string.wrong_9)));
            aList.add(new Potter(getString(R.string.quiz_10), (R.drawable.quiz10), getString(R.string.ans_10), getString(R.string.wrong_10)));
        }
        Bundle bundle = getIntent().getExtras();
        int i = bundle.getInt("i");
        //ContentValues cv = new ContentValues();
        mquiz.setText(aList.get(i).quiz);
        mpic.setImageResource(aList.get(i).picture);


        if(i % 2 == 0) {
            mcorrect.setText(aList.get(i).rightans);
            mwrong.setText(aList.get(i).wrongans);
            if (mwrong.isClickable()) {
                score += 10;
                mwrong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }

            if (mcorrect.isClickable()) {
                mcorrect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }
            if(i == 0){
                Intent a1 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(a1);
            }
        }else  {
            mwrong.setText(aList.get(i).rightans);
            mcorrect.setText(aList.get(i).wrongans);
            if (mwrong.isClickable()) {
                mwrong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }

            if (mcorrect.isClickable()) {
                score += 10;
                mcorrect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        }

        Intent pScore = new Intent(Main2Activity.this,Main3Activity.class);
        pScore.putExtra("score",score);
        startActivity(pScore);

    }
}
