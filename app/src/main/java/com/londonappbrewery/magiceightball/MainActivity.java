package com.londonappbrewery.magiceightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ballDisplay = (ImageView) findViewById(R.id.image_eightBall);

        final List<Integer> ballArray = new ArrayList<Integer>();
        ballArray.add(R.drawable.ball1);
        ballArray.add(R.drawable.ball2);
        ballArray.add(R.drawable.ball3);
        ballArray.add(R.drawable.ball4);
        ballArray.add(R.drawable.ball5);

        Button myButton = (Button) findViewById(R.id.button_ask);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random randomNumberGenerator = new Random();
                int number  = randomNumberGenerator.nextInt(5);
                Log.d("Image id", "Image number is " + number);

                ballDisplay.setImageResource(ballArray.get(number));
            }
        });
    }
}
