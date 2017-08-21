package com.j4ftech.simplemeditation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MeditationActivity extends AppCompatActivity {


    String[] wordsArray = new String[4];
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_meditation);



        wordsArray[0]="RELAX";
        wordsArray[1]="NO STRESS";
        wordsArray[2]="ENJOY";
        wordsArray[3]="BE FREE";
        TextView positiveWordTextView = (TextView) findViewById(R.id.positive_word);
        int rndIndex = new Random().nextInt(wordsArray.length);
        positiveWordTextView.setText(wordsArray[rndIndex]);

        Intent intent = getIntent();
        int meditationTime = intent.getIntExtra("meditation_time",3)*60*1000;
        final TextView timerTextView = (TextView)findViewById(R.id.timer);

        Log.d("M_TIME",String.valueOf(meditationTime));

        //set timer
         timer = new CountDownTimer(meditationTime, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTextView.setText(""+millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextView.setText("done!");
            }
        };

        timer.start();

        findViewById(R.id.back_to_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }


}
