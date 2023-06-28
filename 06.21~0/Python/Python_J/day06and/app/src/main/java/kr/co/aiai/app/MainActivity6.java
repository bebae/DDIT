package kr.co.aiai.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    EditText et_dan;
    Button btn1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        et_dan = findViewById(R.id.et_dan);
        btn1 = findViewById(R.id.btn1);
        tv2 = findViewById(R.id.tv5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick();
            }
        });
    }

    public void myClick(){

        String str = et_dan.getText().toString();
        Log.d("Log : ", String.valueOf(str));
        String result = "";

        if (!str.equals("") && str != null) {
            int num = Integer.parseInt(str);

            for (int i = 1; i < 10; i++) {
                result += num +" X "+ i +" = "+ num * i + "\n";
            }
        } else {
            result = "입력 값이 없습니다.";
        }
        tv2.setText(result);
    }
}