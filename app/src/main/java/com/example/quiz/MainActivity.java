package com.example.quiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"The modulus operator (%) in Java can be used only with variables of integer type.",
            " Declarations must appear at the start of the body of a Java method.",
            "All bitwise operations are carried out with the same level of precedence in Java.",
            " All bitwise operations are carried out with the same level of precedence in Java."};
    private boolean[] Ans = {false, false, false, true,};
    private int score = 0;
    Button yes;
    Button no;
    TextView Question;

    private int index= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        Question = findViewById(R.id.Questions);
        Question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    if (Ans[index]) {
                        score++;
                    }
                index++;
                if (index <= questions.length - 1) {
                    Question.setText(questions[index]);
                } else {
                    Toast.makeText(MainActivity.this, "Your Score Is:" + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                }
            }
                else {
                    Toast.makeText(MainActivity.this, "Restart The App To Play Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index<=questions.length-1) {
                    if (!Ans[index]) {
                        score++;
                    }

                    index++;
                    if (index <= questions.length - 1) {
                        Question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your Score Is:" + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                 else {
                    Toast.makeText(MainActivity.this, "Restart The App To Play Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}