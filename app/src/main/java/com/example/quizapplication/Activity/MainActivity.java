package com.example.quizapplication.Activity;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.ModelClass.QuestionClass;
import com.example.quizapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //set controls
    TextView tvQueConter, tvTimer, tvQue;

    Button btOpt1, btOpt2, btOpt3, btOpt4;

    //list for que
    ArrayList<QuestionClass> queList = new ArrayList<>();

    int conter = 0;

    CountDownTimer tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find view by ids
        tvQue = findViewById(R.id.tvQue);
        tvQueConter = findViewById(R.id.tvQueConter);
        tvTimer = findViewById(R.id.tvTimer);

        btOpt1 = findViewById(R.id.btopt1);
        btOpt2 = findViewById(R.id.btopt2);
        btOpt3 = findViewById(R.id.btopt3);
        btOpt4 = findViewById(R.id.btopt4);

        //load data
        queList.add(new QuestionClass("Aşağıdakilerden hangisi Android ve IOS platformlarında kullanılan veri tabanıdır?", "SQLite", "Bottom Navigation",
                "Listview", "Adapter", "SQLite"));
        queList.add(new QuestionClass("Asagidakilerden hangisi Android uygulamalarinin paketlenmis halidir?", "SDK", "APK",
                "ART", "AVD", "APK"));
        queList.add(new QuestionClass("Aşağıdakilerden hangisi Android projesini inşa ederken kullnılan araçtır. ", "Emilatör", "Java",
                "Gradle", "Activitty", "Gradle"));
        //init conter
        conter = 0;

        //load ques and ans
        loadQuetions(conter);

        tvTimer.setText("12");
        //countdown time
        tm = new CountDownTimer(12 * 1000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

                Toast.makeText(MainActivity.this, "Quiz Bitti", Toast.LENGTH_SHORT).show();
            }
        };


    }

    public void loadQuetions(int n) {

        final QuestionClass q = queList.get(n);

        tvQueConter.setText((n + 1) + "/" + queList.size());

        tvTimer.setText("" + 12);
        if (tm != null) {
            tm.start();
        }

        tvQue.setText("SORU-" + (n + 1) + " " + q.getQue());
        btOpt1.setText("" + q.getOpt1());
        btOpt2.setText("" + q.getOpt2());
        btOpt3.setText("" + q.getOpt3());
        btOpt4.setText("" + q.getOpt4());

        btOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt1.getText().equals(q.getRightOpt())) {
                    Toast.makeText(MainActivity.this, "Cevap Doğru", Toast.LENGTH_SHORT).show();

                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(MainActivity.this, "Tüm Sorular Cevaplandı!", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(MainActivity.this, "Cevap Yanlış", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //btn2
        btOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt2.getText().equals(q.getRightOpt())) {

                    Toast.makeText(MainActivity.this, "Cevap Doğru", Toast.LENGTH_SHORT).show();

                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(MainActivity.this, "Tüm Sorular Cevaplandı!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Cevap Yanlış", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //btn 3
        btOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt3.getText().equals(q.getRightOpt())) {

                    Toast.makeText(MainActivity.this, "Cevap Doğru", Toast.LENGTH_SHORT).show();
                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(MainActivity.this, "Tüm Sorular Cevaplandı!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Cevap Yanlış", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //btn4
        btOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt4.getText().equals(q.getRightOpt())) {

                    Toast.makeText(MainActivity.this, "Cevap Doğru", Toast.LENGTH_SHORT).show();
                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(MainActivity.this, "Tüm Sorular Cevaplandı", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Cevap Yanlış", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}






