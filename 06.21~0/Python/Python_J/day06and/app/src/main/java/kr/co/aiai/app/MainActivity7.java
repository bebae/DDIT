package kr.co.aiai.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {

    EditText et_first, et_last;
    Button btn1;
    TextView tv5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        et_first = findViewById(R.id.et_first);
        et_last = findViewById(R.id.et_last);
        btn1 = findViewById(R.id.btn1);
        tv5 = findViewById(R.id.tv5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick();
            }
        });
    }

    public void myClick(){

        String str1 = et_first.getText().toString();
        String str2 = et_last.getText().toString();
        Log.d("Log : ", String.valueOf(str1));
        String result = "";

        if (!str1.equals("") && str1 != null && !str2.equals("") && str2 != null) {
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            for (int i = num1; i <= num2; i++) {
                for (int j = 0; j < i; j++){
                    result += "*";
                }
                result += "\n";

            }
            for (int i = num2-1; i >= num1; i--) {
                for (int j = 0; j < i; j++){
                    result += "*";
                }
                result += "\n";
            }

        } else {
            result = "입력 값이 잘못됬습니다.";
        }
        tv5.setText(result);
    }
}