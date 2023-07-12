package kr.co.aiai.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText tn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tn1 = findViewById(R.id.et1);
        btn2 = findViewById(R.id.btn_call);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClick();
            }
        });
    }

    public void myClick(){
        int num1 = Integer.parseInt(tn1.getText().toString());
        num1++;
        tn1.setText(String.valueOf(num1));
        Log.d("Log", String.valueOf(num1));
    }
}