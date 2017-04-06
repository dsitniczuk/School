package com.example.android.changecolors;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class MainActivity extends AppCompatActivity {


    public static SeekBar seekBarHeight;
    public static SeekBar seekBarWidth;
    public static ImageView image;
    public static int screenHeight;
    public static int screenWidth;
    public static int imageHeight;
    public static int imageWidth;
    public static int positionNewPointX;
    public static int positionNewPointY;
    public static Bitmap map ;
    public static EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
        getSizeScreen();
        maxValueOnSeekbar();
        map = Bitmap.createBitmap(imageWidth,imageHeight, Bitmap.Config.ARGB_8888);
        text = (EditText) findViewById(R.id.textable);

    }

    public void getSizeScreen(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        screenHeight=metrics.heightPixels;
        screenWidth=metrics.widthPixels;
    }



    public void createPoint(String temp){
        temp="#"+temp;

        int newColor=Color.parseColor(temp);

        map.setPixel(positionNewPointX,positionNewPointY,newColor);

        image.setImageBitmap(map);
    }

    public void maxValueOnSeekbar(){
        imageHeight=screenWidth/20;
        imageWidth=screenHeight/10;

        seekBarWidth = (SeekBar) findViewById(R.id.seekbar_width);
        seekBarHeight = (SeekBar) findViewById(R.id.seekbar_height);
        image = (ImageView) findViewById(R.id.imageFront);

        seekBarWidth.setMax(imageHeight-1);
        seekBarHeight.setMax(imageWidth-1);


        seekBarWidth.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, ""+seekBar.getProgress(), Toast.LENGTH_SHORT).show();
                        //positionNewPointX=seekBar.getProgress();

                    }
                }
        );

        seekBarHeight.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, ""+seekBar.getProgress(), Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    public void Submit(View view){
        positionNewPointY=seekBarWidth.getProgress();
        positionNewPointX=seekBarHeight.getProgress();
        createPoint(text.getText().toString());
    }
}
