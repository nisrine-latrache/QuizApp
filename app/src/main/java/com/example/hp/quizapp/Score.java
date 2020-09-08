package com.example.hp.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.mikephil.charting.charts.PieChart;
import android.content.Intent;
import android.widget.TextView;

import java.lang.Object;



public class Score extends AppCompatActivity {

CircleProgress cprogress;
    TextView tvscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        StringBuffer sb = new StringBuffer();
       // sb.append("Correct answers: " + Quiz1.correct + "\n");
        sb.append(Quiz1.correct );

        cprogress = (CircleProgress)findViewById(R.id.cprogress);
        //tvscore = (TextView) findViewById(R.id.tvscore);
        //Intent intent2 = getIntent();
        //final int score = intent2.getIntExtra("score", 0);
        //tvscore.setText(sb);

        int in = new Integer(sb.toString());
        int i2 = in*10;
        cprogress.setProgress(i2);

    }










}
