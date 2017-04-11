package com.example.android.quizpuns;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by PC on 2017-04-08.
 */

public class Other extends AppCompatActivity { //SILNIK QUIZU, wpieprzamy wszystkie funkcje z pytań oraz z podsumowania

    public int firstB=0,secondB=0,thirdB=0,fourthB=0; //TOAST
    public int firstHint=0,secondHint=0,thirdHint=0,fourthHint=0; //podpowiedzi z poszczególnej zakładki
    public int firstScore=0,secondScore=0,thirdScore=0,fourthScore=0; //wynik z poszczególnej zakładki
    public int firstGood=0,secondGood=0,thirdGood=0,fourthGood=0; //dobre odpowiedzi z poszczególnej zakładki
    public int firstBad=0,secondBad=0,thirdBad=0,fourthBad=0; //złe odpowiedzi z poszczególnej zakładki

    public Integer textHint =0,textScore=0,textGood=0,textBad=0; //suma wszystkich zakładek

//BUTTONS

    public void buttonFirstQuestion(View view){
        Resources res = getResources();

        ImageView image = (ImageView)findViewById(R.id.imageFirstQuestion);
        Button button = (Button) findViewById(R.id.buttonFirstQ);

        firstB++;
        firstScore=-firstB;
        firstHint=firstB;


        if(firstB==1){

            image.setImageDrawable(res.getDrawable(R.drawable.okulary2));
        }else if(firstB==2){
            image.setImageDrawable(res.getDrawable(R.drawable.okulary3));
            Toast.makeText(Other.this, "GO NEXT STEP!", Toast.LENGTH_SHORT).show();
            button.setClickable(false);
            firstB=0;
        }
    }

    public void buttonSecondQuestion(View view){
        Resources res = getResources();

        ImageView image = (ImageView)findViewById(R.id.imageSecondQuestion);
        Button button = (Button) findViewById(R.id.buttonSecondQ);

        secondB++;
        secondScore=-secondB;
        secondHint=secondB;

        if(secondB==1){

            image.setImageDrawable(res.getDrawable(R.drawable.hustawka2));
        }else if(secondB==2){
            image.setImageDrawable(res.getDrawable(R.drawable.hustawka3));
            Toast.makeText(Other.this, "GO NEXT STEP!", Toast.LENGTH_SHORT).show();
            button.setClickable(false);
            secondB=0;
        }
    }

    public void buttonThirdQuestion(View view){
        Resources res = getResources();

        ImageView image = (ImageView)findViewById(R.id.imageThirdQuestion);
        Button button = (Button) findViewById(R.id.buttonThirdQ);

        thirdB++;
        thirdScore=-thirdB;
        thirdHint=thirdB;

        if(thirdB==1){

            image.setImageDrawable(res.getDrawable(R.drawable.motyl2));
        }else if(thirdB==2){
            image.setImageDrawable(res.getDrawable(R.drawable.motyl3));
            Toast.makeText(Other.this, "GO NEXT STEP!", Toast.LENGTH_SHORT).show();
            button.setClickable(false);
            thirdB=0;
        }
    }

    public void buttonFourthQuestion(View view){
        Resources res = getResources();

        ImageView image = (ImageView)findViewById(R.id.imageFourthQuestion);
        Button button = (Button) findViewById(R.id.buttonFourthQ);

        fourthB++;
        fourthScore=-fourthB;
        fourthHint=fourthB;

        if(fourthB==1){

            image.setImageDrawable(res.getDrawable(R.drawable.swieczka2));
        }else if(fourthB==2){
            image.setImageDrawable(res.getDrawable(R.drawable.swieczka3));
            Toast.makeText(Other.this, "GO NEXT STEP!", Toast.LENGTH_SHORT).show();
            button.setClickable(false);
            fourthB=0;
        }
    }

    //RADIO

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio1:
                if (checked)
                    thirdGood=1;
                    thirdBad=0;
                    break;
            case R.id.radio2:
                if (checked)
                    thirdGood=0;
                    thirdBad=1;
                    break;
            case R.id.radio3:
                if(checked)
                    thirdGood=0;
                    thirdBad=1;
                    break;
        }
    }

    //CHECK

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        CheckBox che1=(CheckBox)findViewById(R.id.check1);
        CheckBox che2=(CheckBox)findViewById(R.id.check2);
        CheckBox che3=(CheckBox)findViewById(R.id.check3);

        if(che1.isChecked()||che2.isChecked()||che3.isChecked()){
            fourthGood=1;
            fourthBad=0;
        } else {
            fourthBad=1;
            fourthGood=0;
        }

    }

    public void Count(){
        textHint = firstHint+secondHint+thirdHint+fourthHint;
        textGood = firstGood+secondGood+thirdGood+fourthGood;
        textBad = firstBad+secondBad+thirdBad+fourthBad;
        textScore = firstScore+secondScore+thirdScore+fourthScore+textGood-textBad;


    }



}
