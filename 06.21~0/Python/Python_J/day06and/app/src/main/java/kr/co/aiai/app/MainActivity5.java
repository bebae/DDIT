package kr.co.aiai.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity {

    EditText et_mine;
    EditText et_com;
    EditText et_result;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        et_mine = findViewById(R.id.et_mine);
        et_com = findViewById(R.id.et_com);
        et_result = findViewById(R.id.et_result);
        btn1 = findViewById(R.id.btn_call);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick();
            }
        });
    }

    public void myClick(){
        Random random = new Random();

        String[] strArr = {"홀", "짝"};
        String str1 = et_mine.getText().toString();
//        String str1 = strArr[random.nextInt(2)];
        String str2 = strArr[random.nextInt(2)];
        String result = "";
        
        if (str1.equals(str2)) {
            result = "승리";
        } else {
            result = "패배";
        }
//        et_mine.setText(String.valueOf(str1));
        et_com.setText(String.valueOf(str2));
        et_result.setText(String.valueOf(result));
    }
}