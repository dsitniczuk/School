package com.example.android.createfootballstar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int strike=0,pass=0,head=0,defense=0,atack=0,pressing=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void View1(int value){
        TextView View = (TextView) findViewById(R.id.View1);
        View.setText(String.valueOf(value));
    }

    public void View2(int value){
        TextView View = (TextView) findViewById(R.id.View2);
        View.setText(String.valueOf(value));
    }

    public void View3(int value){
        TextView View = (TextView) findViewById(R.id.View3);
        View.setText(String.valueOf(value));
    }

    public void View4(int value){
        TextView View = (TextView) findViewById(R.id.View4);
        View.setText(String.valueOf(value));
    }

    public void View5(int value){
        TextView View = (TextView) findViewById(R.id.View5);
        View.setText(String.valueOf(value));
    }

    public void View6(int value){
        TextView View = (TextView) findViewById(R.id.View6);
        View.setText(String.valueOf(value));
    }

    public void Button1(View v){
        strike=strike-1;
        View1(strike);
    }

    public void Button2 (View v){
        strike=strike+1;
        View1(strike);
    }

    public void Button3 (View v){
        pass=pass-1;
        View2(pass);
    }

    public void Button4 (View v){
        pass=pass+1;
        View2(pass);
    }

    public void Button5 (View v){
        head=head-1;
        View3(head);
    }

    public void Button6 (View v){
        head=head+1;
        View3(head);
    }

    public void Button7 (View v){
        defense=defense-1;
        View4(defense);
    }

    public void Button8 (View v){
        defense=defense+1;
        View4(defense);
    }

    public void Button9 (View v){
        atack=atack-1;
        View5(atack);
    }

    public void Button10 (View v){
        atack=atack+1;
        View5(atack);
    }

    public void Button11 (View v){
        pressing=pressing-1;
        View6(pressing);
    }

    public void Button12 (View v){
        pressing=pressing+1;
        View6(pressing);
    }
}
