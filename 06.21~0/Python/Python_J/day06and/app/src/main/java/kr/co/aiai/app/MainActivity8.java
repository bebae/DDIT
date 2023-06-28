package kr.co.aiai.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity8 extends AppCompatActivity {

    TextView tv1;
    Button btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        tv1 = findViewById(R.id.tv1);
        btn_call = findViewById(R.id.btn_call);

        Button[] numberButtons = new Button[10];
        int[] buttonIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = findViewById(buttonIds[i]);
            final int number = i; // 현재 반복된 숫자 값을 변수로 저장

            numberButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str = tv1.getText().toString();
                    str += String.valueOf(number);
                    tv1.setText(str);
                }
            });
        }

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick();
            }
        });


    }

    public void myClick(){
        System.out.println("얼쩔팅빌");
    }
}