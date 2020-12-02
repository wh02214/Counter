package com.example.thecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(MainActivity.this, "keep", null, 1);
        Button turn = (Button) findViewById(R.id.turn_detail);
        editText = (EditText) findViewById(R.id.add);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        textView = (TextView) findViewById(R.id.show);
        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Button add = (Button) findViewById(R.id.button1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        String inputTest = editText.getText().toString();
                        if (inputTest.equals("")) {
                            Toast.makeText(MainActivity.this, "你倒是输啊", Toast.LENGTH_SHORT).show();
                        } else {
                            textView.setText(inputTest);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        Button button = (Button) findViewById(R.id.create);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });


    }
}