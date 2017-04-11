package com.example.android.quizpuns;

import android.content.Intent;
import android.media.ExifInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.button;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class MainActivity extends AppCompatActivity {

    public static int nextStep=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void button(View view){
        Button but = (Button)findViewById(R.id.button1);
        nextStep++;

        if(nextStep==1){

            but.setText("PRESS AGAIN");
        }

        if(nextStep==2){

        TextView text =(TextView) findViewById(R.id.chase);
        text.setText("THIS BUTTON IS YOUR\nFRIEND, BUT IT CAN\nBE A POINT THIEF        ");
            RelativeLayout.LayoutParams layout = (RelativeLayout.LayoutParams)but.getLayoutParams();
            layout.setMargins(0,0,30,5);

            layout.width=100;
        but.setLayoutParams(layout);
        but.setText("");

        }

        if(nextStep==3){
            Intent intent = new Intent(MainActivity.this, Frame2.class);
            nextStep=0;
            startActivity(intent);
            finish();
        }



    }
}
