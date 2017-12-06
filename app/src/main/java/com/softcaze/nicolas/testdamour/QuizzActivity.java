package com.softcaze.nicolas.testdamour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizzActivity extends Activity {
    int score = 0;
    TextView answer1;
    TextView answer2;
    TextView answer3;

    String name1, name2;

    Quizz monQuizz;

    TextView numQuestion;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        Intent intent = getIntent();
        name1 = intent.getStringExtra("name1");
        name2 = intent.getStringExtra("name2");

        answer1 = (TextView)findViewById(R.id.answer1);
        answer2 = (TextView)findViewById(R.id.answer2);
        answer3 = (TextView)findViewById(R.id.answer3);

        numQuestion = (TextView)findViewById(R.id.numQuestion);
        question = (TextView)findViewById(R.id.question);

        monQuizz = new Quizz(getApplicationContext());

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                score += r.nextInt(9 - 5) + 5;
                handledQuizz();
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                score += r.nextInt(17 - 10) + 10;
                handledQuizz();
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                score += r.nextInt(20 - 18) + 18;
                handledQuizz();
            }
        });
    }

    public void handledQuizz(){
        if(monQuizz.qActu.getNum() == 5){
            Intent intent = new Intent(QuizzActivity.this, ResultActivity.class);
            intent.putExtra("score", score + "");
            intent.putExtra("name1", name1);
            intent.putExtra("name2", name2);
            QuizzActivity.this.startActivity(intent);
        }
        else {
            monQuizz.setQActu(0);

            question.setText(monQuizz.qActu.getQuestion());
            answer1.setText(monQuizz.qActu.getAnswer1());
            answer2.setText(monQuizz.qActu.getAnswer2());
            answer3.setText(monQuizz.qActu.getAnswer3());

            numQuestion.setText(monQuizz.qActu.getNum() + "/5");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        score = 0;
    }
}
