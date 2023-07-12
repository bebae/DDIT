package kr.co.aiai.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        int[] buttonIds = {R.id.btn0, R.id.btn_call, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = findViewById(buttonIds[i]);
            final int number = i; // 현재 반복된 숫자 값을 변수로 저장

            numberButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myClick(v);
                    String str = tv1.getText().toString();
                    str += String.valueOf(number);
                    tv1.setText(str);
                }
            });
        }


        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick1();
            }
        });
    }

    public void myClick(View v){
        Button imsi = (Button) v;
        Log.d("myLog : ", imsi.getText().toString());
    }
    public void myClick1(){
        String str_tel = tv1.getText().toString();
        Toast myToast = Toast.makeText(this.getApplicationContext(), "CALLING "+str_tel, Toast.LENGTH_LONG);
        myToast.show();
    }
}