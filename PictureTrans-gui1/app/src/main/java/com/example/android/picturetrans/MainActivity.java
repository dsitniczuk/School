package com.example.android.picturetrans;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

public class MainActivity extends AppCompatActivity {

    Bitmap map;
    ImageView image;
    BitmapFactory.Options opt;
    SeekBar seekbarLine;
    SeekBar seekbarPower;
    SeekBar seekbarNegative;
    int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        opt = new BitmapFactory.Options();
        opt.inMutable = true;

        map = BitmapFactory.decodeResource(getResources(), R.drawable.ic_original2,opt);
        height =map.getHeight();
        width =map.getWidth();

        image = (ImageView) findViewById(R.id.new_image);

        seekbarLine =(SeekBar)findViewById(R.id.seekbar_line);
        seekbarPower =(SeekBar)findViewById(R.id.seekbar_power);
        seekbarNegative = (SeekBar) findViewById(R.id.seekbar_negative);


        changeLine();
        changePower();
        changeNegative();
    }



    public void changeLine(){
        seekbarLine.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        int value=seekBar.getProgress() - 50;
                        if(value>0){
                            changeColorBlackLine(value);
                        }else{
                            changeColorWhiteLine(value);
                        }

                    }
                }
        );
    }

    public void changeColorWhiteLine(int value) {
        map = BitmapFactory.decodeResource(getResources(), R.drawable.ic_original2,opt);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixelse = map.getPixel(i, j);

                int kolor1 = Color.alpha(pixelse);
                int kolor2 = Color.red(pixelse);
                int kolor3 = Color.green(pixelse);
                int kolor4 = Color.blue(pixelse);

                kolor2 = Math.min(255, kolor2 - value);
                kolor3 = Math.min(255, kolor3 - value);
                kolor4 = Math.min(255, kolor4 - value);

                pixelse = Color.argb(kolor1, kolor2, kolor3, kolor4);
                map.setPixel(i, j, pixelse);
            }
        }
        image.setImageBitmap(map);
    }

    public void changeColorBlackLine(int value) {
        map = BitmapFactory.decodeResource(getResources(), R.drawable.ic_original2,opt);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixelse = map.getPixel(i, j);

                int kolor1 = Color.alpha(pixelse);
                int kolor2 = Color.red(pixelse);
                int kolor3 = Color.green(pixelse);
                int kolor4 = Color.blue(pixelse);

                kolor2 = Math.max(0, kolor2 - value);
                kolor3 = Math.max(0, kolor3 - value);
                kolor4 = Math.max(0, kolor4 - value);

                pixelse = Color.argb(kolor1, kolor2, kolor3, kolor4);

                map.setPixel(i, j, pixelse);
            }
        }
        image.setImageBitmap(map);
    }

    public void changePower(){
        seekbarPower.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        float value = seekBar.getProgress();
                        value=value/10;

                        changeColorPower(value);
                    }
                }
        );
    }

    public void changeColorPower(float value){

        map = BitmapFactory.decodeResource(getResources(), R.drawable.ic_original2,opt);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixelse = map.getPixel(i, j);

                int kolor1 = Color.alpha(pixelse);
                int kolor2a = Color.red(pixelse);
                int kolor3a = Color.green(pixelse);
                int kolor4a = Color.blue(pixelse);



                double kolor2 = (double)kolor2a/255;
                double kolor3= (double)kolor3a/255;
                double kolor4=(double)kolor4a/255;

                kolor2 = Math.pow(kolor2,value);
                kolor3 = Math.pow(kolor3,value);
                kolor4 = Math.pow(kolor4,value);

                kolor2=kolor2*255;
                int kolor2i=(int)kolor2;
                kolor3=kolor3*255;
                int kolor3i=(int)kolor3;
                kolor4=kolor4*255;
                int kolor4i=(int)kolor4;

                pixelse = Color.argb(kolor1, kolor2i, kolor3i, kolor4i);

                map.setPixel(i, j, pixelse);
            }
        }
        image.setImageBitmap(map);

    }

    public void changeNegative(){
        seekbarNegative.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        int value = seekBar.getProgress();
                        if(value==2||value==0){
                            changeColorNegative(2);
                        }else{
                            map = BitmapFactory.decodeResource(getResources(), R.drawable.ic_original2,opt);
                            image.setImageBitmap(map);
                        }

                    }
                }
        );
    }

    public void changeColorNegative(int value){
        map = BitmapFactory.decodeResource(getResources(), R.drawable.ic_original2,opt);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixelse = map.getPixel(i, j);

                int kolor1 = Color.alpha(pixelse);
                int kolor2 = Color.red(pixelse);
                int kolor3 = Color.green(pixelse);
                int kolor4 = Color.blue(pixelse);

                kolor2 = (255*value) - kolor2;
                kolor3 = (255*value) - kolor3;
                kolor4 = (255*value) - kolor4;

                pixelse = Color.argb(kolor1, kolor2, kolor3, kolor4);

                map.setPixel(i, j, pixelse);
            }
        }
        image.setImageBitmap(map);
    }




}
