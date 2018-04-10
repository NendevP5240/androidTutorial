package com.example.andriod.internationalfestivalblockpartybeta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity{

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView tvEvent;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSeconds);
        tvEvent = (TextView) findViewById(R.id.tvhappyevent);

        countDownStart();
    }
    public void onButtonClick(View v){
        if(v.getId() == R.id.menu_button)
        {
            Intent i = new Intent(MainActivity.this, DisplayMenu.class);
            startActivity(i);
        }
    }

    public void prevbutton2(View v){
        if(v.getId() == R.id.prevclick)
        {
            Intent i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);
        }
    }


    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {

            public void run(){
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date futureDate = dateFormat.parse("2016-08-20");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)){
                        long diff = futureDate.getTime() - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 *60 * 1000);
                        long hours = diff / ( 60 * 60 * 1000);
                        diff -= hours * (60 *60 * 1000);
                        long minutes = diff / ( 60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText(""+ String.format("%02d", days));
                        txtTimerHour.setText(""+ String.format("%02d", hours));
                        txtTimerMinute.setText(""+ String.format("%02d", minutes));
                        txtTimerSecond.setText(""+ String.format("%02d", seconds));
                    }
                    else {
                        tvEvent.setVisibility(View.VISIBLE);
                        tvEvent.setText("The festival has started");
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

             };
        handler.postDelayed(runnable, 1 * 1000);
    }
    public void textViewGone() {
        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
        findViewById(R.id.textview2).setVisibility(View.GONE);
    }

}
