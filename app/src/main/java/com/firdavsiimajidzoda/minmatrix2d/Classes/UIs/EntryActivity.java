package com.firdavsiimajidzoda.minmatrix2d.Classes.UIs;

/**
 * Created by firdavsiimajidzoda on 4/05/17.
 */

import com.firdavsiimajidzoda.minmatrix2d.R;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;


/**
 *  EntryActivity is to determain where user wnats to see examples or inptut matrix data
 */
public class EntryActivity extends AppCompatActivity {
    // Binding views and outlets
    private Button seeExamplesButton;
    private Button inputMatrixButton;
    private TextView orTextView;

    private int screenHeight;

    private int seeExamplesButtonTop;
    private int inputMatrixButtonTop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        // Getting screen size
        getScreenWindowSize();

        // Initializing views
        seeExamplesButton = (Button)findViewById(R.id.seeExamplesButton);
        seeExamplesButton.setBackgroundResource(R.drawable.regular_cell_shape);
        seeExamplesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setMatrixIntent = new Intent();
                setMatrixIntent.setClass(getApplicationContext(), ExamplesActivity.class);
                startActivity(setMatrixIntent);
                finish();
            }
        });


        inputMatrixButton = (Button)findViewById(R.id.inputMatrixButton);
        inputMatrixButton.setBackgroundResource(R.drawable.selected_cell_shape);
        inputMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setMatrixIntent = new Intent();
                setMatrixIntent.setClass(getApplicationContext(), SetMatrixActivity.class);
                startActivity(setMatrixIntent);
                finish();
            }
        });

        orTextView = (TextView)findViewById(R.id.or_text_view);

        // Animation
        setObserver(seeExamplesButton, "aboveScreenDown", null);
        setObserver(inputMatrixButton, "belowScreenUp", null);
        fadeInOut(orTextView, "in", 1000);

    }

    private void getScreenWindowSize(){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
    }

    /**
     *  Set observer and animate view, then remove observer
     * */
    private void setObserver(final View object, final String direction, final Class activity){
        object.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (object == seeExamplesButton){
                    seeExamplesButtonTop = seeExamplesButton.getTop();
                    animateAll(seeExamplesButton, seeExamplesButtonTop, screenHeight, 1000, 0, direction, activity);
                }
                else {
                    inputMatrixButtonTop = inputMatrixButton.getTop();
                    animateAll(inputMatrixButton, inputMatrixButtonTop, screenHeight, 1000, 0, direction, activity);
                }
                object.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }


    /**
     *  Animate view with given details
     * */
    private void animateAll(final View object, float position, float screenCalc, final int duration, final long delay, final String direction, Class activity){
        if (direction.matches("aboveScreenDown")){
            animate(object, position - screenCalc, position, duration, delay, "y", activity);
        } else if (direction.matches("belowScreenUp")){
            animate(object, position + screenCalc, position, duration, delay, "y", activity);
        }
    }


    /**
     *  Animate view
     * */
    private void animate(final View object, float from, float to, int duration, long delay, final String direction, final Class activity){
        ObjectAnimator animator;
        if (direction.matches("x")){
            animator =  ObjectAnimator.ofFloat(object, "x", from, to);
        } else {
            animator =  ObjectAnimator.ofFloat(object, "y", from, to);
        }
        animator.setInterpolator(new LinearInterpolator());
        animator.setStartDelay(delay);
        animator.setDuration(duration);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                object.setAlpha(1f);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }

    /**
     * Animates the view to fade in or out
     * @param view
     * @param inOut
     * @param duration
     */
    private void fadeInOut(View view, String inOut, long duration){
        AlphaAnimation anim;
        if (inOut.matches("in")){
            anim = new AlphaAnimation(0.0f, 1.0f);
        } else{
            anim = new AlphaAnimation(0.1f, 0.0f);
        }

        anim.setDuration(duration);
        view.startAnimation(anim);
    }
}
