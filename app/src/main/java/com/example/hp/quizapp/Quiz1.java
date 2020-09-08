package com.example.hp.quizapp;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Quiz1 extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    ImageView imageV;

   // int imageIDs []=

         //   {R.drawable.a1, R.drawable.aa, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.download, R.drawable.download};
    String questions[] = {
            "Le feu est vert depuis longtemps",
            "Pour tourner à droite : ",
            "Une femme enceinte peut être dispensée du port de la ceinture de sécurité sur certificat médical d’un médecin agrée ",
            "Téléphoner au volant perturbe la recherche visuelle des indices du conducteur :",
            "Sur un trajet de 500 km, rouler a 120km/h u lieu e 130 km/h sur autoroute permet d’economiser jusqu’à :",
            "Lorsque je ralentis, je diminue mon temps de réaction ",
            "Au stop, je m’arrête :",
            "Conduire en ayant consommé de l’alcool accentue le risque d’éblouissement",
            "Sur une autoroute, quand pouvez-vous circuler dans la voie de gauche?",
               "Une fine pluie tombe depuis plus d’une heure. Parmi les stratégies suivantes, choisissez celles qui sont appropriées;"
    };
    String answers[] = {"J'accélère","Je serre le trottoir de droite","Non","Oui","3 litres de carburant","Oui","A la limite de la chaussée abordée","Oui","Pour depasser","2 et 3"};
    String opt[] = {
            "Je freine","J'accélère","Je ralentis","Je retourne en arriere",
            "Je maintiens mon placement sur la chaussée","Je serre le trottoir de droite","|=","=",
            "Oui","Non","Parfois","Aucune reponse ",
            "Oui","Non","Parfois","Aucune reponse",
            "2 litres de carburant","3 litres de carburant","4 litres de carburant","5 litres de carburant",
            "Oui","Non","Parfois","Aucune reponse",
            "A hauteur du panneau","float","A la limite de la chaussée abordée","=",
            "Non","Oui","Parfois","Aucune reponse",
            "Oui","Non","Parfois","Aucune reponse",
            "Quand il y a pas de circulation","Quand vous le voulez","Pour depasser","2 et 3",
            "Continuer à la même vitesse", "Augmenter la distance avec le véhicule qui vous précède", "Éviter les changements brusques de direction","2 et 3",

    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        final TextView score = (TextView) findViewById(R.id.textView4);
       // TextView textView = (TextView) findViewById(R.id.DispName);
        //Intent intent = getIntent();

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);
        imageV= (ImageView)findViewById(R.id.imageV);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        //imageV.setImageResource(imageIDs[flag]);

        //imageV.setImageResource(imageIDs[flag]);

        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), Score.class);
                    //in.putExtra("score", correct);
                    startActivity(in);


                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Score.class);
                startActivity(intent);

            }
        });

    }
}
