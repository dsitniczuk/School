package com.example.android.grafikagra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9;
    String endbutton1,endbutton2,endbutton3,endbutton4,endbutton5,endbutton6,endbutton7,endbutton8,endbutton9;
    int licz;
    ArrayList<Button> listOfButtons =new ArrayList<Button>();

    public void textOnEndGame(String namePlayer){
        Toast.makeText(MainActivity.this,"PLAYER "+namePlayer+" WIN",Toast.LENGTH_SHORT).show();
    }


    public void endGame(){
        endbutton1=button1.getText().toString();
        endbutton2=button2.getText().toString();
        endbutton3=button3.getText().toString();
        endbutton4=button4.getText().toString();
        endbutton5=button5.getText().toString();
        endbutton6=button6.getText().toString();
        endbutton7=button7.getText().toString();
        endbutton8=button8.getText().toString();
        endbutton9=button9.getText().toString();



        if(endbutton1.equals(endbutton2)&&(endbutton1.equals(endbutton3))){
            textOnEndGame(endbutton1);
        }

        if(endbutton4.equals(endbutton5)&&(endbutton4.equals(endbutton6))){
            textOnEndGame(endbutton4);
        }

        if(endbutton7.equals(endbutton8)&&(endbutton7.equals(endbutton9))){
            textOnEndGame(endbutton7);
        }

        if(endbutton1.equals(endbutton4)&&(endbutton1.equals(endbutton7))){
            textOnEndGame(endbutton1);
        }

        if(endbutton2.equals(endbutton5)&&(endbutton2.equals(endbutton8))){
            textOnEndGame(endbutton2);
        }

        if(endbutton3.equals(endbutton6)&&(endbutton3.equals(endbutton9))){
            textOnEndGame(endbutton3);
        }

        if(endbutton1.equals(endbutton5)&&(endbutton1.equals(endbutton9))){
            textOnEndGame(endbutton1);
        }

        if(endbutton3.equals(endbutton5)&&(endbutton3.equals(endbutton7))){
            textOnEndGame(endbutton3);
        }
    }




    public void Logic(Button button){
        Button temp;
        listOfButtons.remove(button);
        licz= listOfButtons.size();
        if(licz>0){
            temp= listOfButtons.get((int)(Math.random()*licz));
            temp.setText("O");
            temp.setClickable(false);
            listOfButtons.remove(temp);}
        else
            endGame();
    }

    public void userOnClick(Button button){
        button.setText("X");
        button.setClickable(false);
        Logic(button);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1= (Button)findViewById(R.id.button1);
        button2= (Button)findViewById(R.id.button2);
        button3= (Button)findViewById(R.id.button3);
        button4= (Button)findViewById(R.id.button4);
        button5= (Button)findViewById(R.id.button5);
        button6= (Button)findViewById(R.id.button6);
        button7= (Button)findViewById(R.id.button7);
        button8= (Button)findViewById(R.id.button8);
        button9= (Button)findViewById(R.id.button9);

        listOfButtons.add(button1);
        listOfButtons.add(button2);
        listOfButtons.add(button3);
        listOfButtons.add(button4);
        listOfButtons.add(button5);
        listOfButtons.add(button6);
        listOfButtons.add(button7);
        listOfButtons.add(button8);
        listOfButtons.add(button9);

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                userOnClick(button1);
            }
        });


        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userOnClick(button9);
            }
        });




    }
}