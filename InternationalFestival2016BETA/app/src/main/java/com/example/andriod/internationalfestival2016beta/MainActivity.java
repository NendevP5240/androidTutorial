package com.example.andriod.internationalfestival2016beta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void newPage(View view) {

        String button_text;
        button_text = ((Button) view).getText().toString();
        if(button_text.equals("View"))
        {
            Intent intent = new Intent(this, secondActivity.class);
            startActivity(intent);
        }
    }

}
