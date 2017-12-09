package com.example.acer.project;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2;
    static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // method ที่กำหนดว่าเมื่อมีการ Click ที่ปุ่ม Start จะให้ทำการส่งค่า i ไปยังหน้า Main2Activity
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (i = 0; i <= 9; i++) {
                    Intent a = new Intent(MainActivity.this, Main2Activity.class);
                    a.putExtra("i", i);
                    startActivity(a);
                }
            }
        });

        // method ที่กำหนดว่าเมื่อมีการ Click ที่ปุ่ม Exit จะทำการปิดแอพพลิเคชั่น
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

    }
}
