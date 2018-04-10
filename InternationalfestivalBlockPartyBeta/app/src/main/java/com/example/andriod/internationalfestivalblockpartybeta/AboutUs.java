package com.example.andriod.internationalfestivalblockpartybeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nenle on 8/11/2016.
 */
public class AboutUs extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
    }

    public void menuPrevClick(View v){
        if(v.getId() == R.id.prev_button)
        {
            Intent i = new Intent(AboutUs.this, MainActivity.class);
            startActivity(i);
        }
    }

}
