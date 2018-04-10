package com.example.andriod.floatingmenubuttonbeta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab_menu,fab_map,fab_booth;
    Animation FabOpen,FabClose,FabRClockwise,FabRAnticlockwise;
    boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_menu = (FloatingActionButton)findViewById(R.id.fab_menu);
        fab_map = (FloatingActionButton)findViewById(R.id.fab_map);
        fab_booth = (FloatingActionButton)findViewById(R.id.fab_booth);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRAnticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        fab_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen)
                {
                    fab_map.startAnimation(FabClose);
                    fab_booth.startAnimation(FabClose);
                    fab_menu.startAnimation(FabRAnticlockwise);
                    fab_map.setClickable(false);
                    fab_booth.setClickable(false);
                    isOpen = false;
                }
                else
                {
                    fab_map.startAnimation(FabOpen);
                    fab_booth.startAnimation(FabOpen);
                    fab_menu.startAnimation(FabRClockwise);
                    fab_map.setClickable(true);
                    fab_booth.setClickable(true);
                    isOpen = true;
                }
            }
        });
    }
}
