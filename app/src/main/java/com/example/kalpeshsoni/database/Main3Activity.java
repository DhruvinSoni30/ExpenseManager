package com.example.kalpeshsoni.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Button lgn,reg;
    TextView txt,ds;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lgn = findViewById(R.id.lgin);
        reg = findViewById(R.id.regis);
        txt = findViewById(R.id.expense);
        ds = findViewById(R.id.ds);
        iv = findViewById(R.id.imageView);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        lgn.startAnimation(myanim);
        reg.startAnimation(myanim);
        txt.startAnimation(myanim);
        ds.startAnimation(myanim);
        iv.startAnimation(myanim);

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
