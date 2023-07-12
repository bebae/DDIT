package kr.co.aiai.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity9 extends AppCompatActivity {

    EditText et_num;
    Button btn;
    TextView tv;

    private List<Integer> answer; // 랜덤으로 생성된 3자리 숫자를 저장할 리스트

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        et_num = findViewById(R.id.et_num1);
        btn = findViewById(R.id.btn_call);
        tv = findViewById(R.id.tv5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick();
            }
        });
        generateRandomNumber(); // 랜덤으로 3자리 숫자 생성
    }


    private void generateRandomNumber() {
        answer = new ArrayList<>();
        Random random = new Random();

        // 중복되지 않는 3자리 숫자를 생성하여 answer 리스트에 저장
        while (answer.size() < 3) {
            int digit = random.nextInt(9) + 1; // 1부터 9까지의 숫자 생성
            if (!answer.contains(digit)) {
                answer.add(digit);
            }
        }
    }


    public void myClick(){
        String str = et_num.getText().toString();
        String str_old = tv.getText().toString();

        Log.d("myLog : ", str);

        if (str.length() != 3) {
            tv.setText("3자리 숫자를 입력해주세요.");
            return;
        }

        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            guess[i] = Character.getNumericValue(str.charAt(i)); // 입력한 숫자를 배열에 저장
        }

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer.get(i)) {
                strike++;
            } else if (answer.contains(guess[i])) {
                ball++;
            }
        }

        if (strike >= str.length()){
            Toast myToast = Toast.makeText(this.getApplicationContext(), "홈런입니다!", Toast.LENGTH_SHORT);
            myToast.show();
        }
        String str_new = str + " : " + strike + "S " + ball + "B\n";
        tv.setText(str_new+str_old);
    }
}