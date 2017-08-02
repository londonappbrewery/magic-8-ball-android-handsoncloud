package com.londonappbrewery.magiceightball;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
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

        final Button myButton = (Button) findViewById(R.id.button_ask);
        myButton.setOnClickListener(new View.OnClickListener() {

            //AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);

            @Override
            public void onClick(View v) {
                //v.startAnimation(buttonClick);

                //addClickEffect(myButton);

                Random randomNumberGenerator = new Random();
                int number  = randomNumberGenerator.nextInt(5);
                Log.d("Image id", "Image number is " + number);

                ballDisplay.setImageResource(ballArray.get(number));
            }
        });
    }

    void addClickEffect(View view) {
        Drawable drawableNormal = view.getBackground();

        Drawable drawablePressed = view.getBackground().getConstantState().newDrawable();
        drawablePressed.mutate();
        drawablePressed.setColorFilter(Color.argb(50, 0, 0, 0), PorterDuff.Mode.SRC_ATOP);

        StateListDrawable listDrawable = new StateListDrawable();
        listDrawable.addState(new int[] {android.R.attr.state_pressed}, drawablePressed);
        listDrawable.addState(new int[] {android.R.attr.defaultValue}, drawableNormal);

        view.setBackground(listDrawable);
    }
}
