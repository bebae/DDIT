package kr.co.aiai.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity4 extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick();
            }
        });
    }

    public void myClick(){
        Integer[] numbers = new Integer[45];

        for (int i = 0; i < 45; i++) {
            numbers[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(numbers));

        et1.setText(String.valueOf(numbers[0]));
        et2.setText(String.valueOf(numbers[1]));
        et3.setText(String.valueOf(numbers[2]));
        et4.setText(String.valueOf(numbers[3]));
        et5.setText(String.valueOf(numbers[4]));
        et6.setText(String.valueOf(numbers[5]));
    }
}