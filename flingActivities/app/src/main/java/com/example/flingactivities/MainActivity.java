package com.example.flingactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    TextView homeView,eastView,southView, northView, westView;
    GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeView = (TextView) findViewById(R.id.homeView);
        gestureDetector = new GestureDetector(this);

    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float vx, float vy) {
        boolean result = false;
        int trigger = 100;
        float diffx = moveEvent.getX() - downEvent.getX();
        float diffy = moveEvent.getY() - downEvent.getY();
        if(Math.abs(diffx) > Math.abs(diffy)){
            if(Math.abs(diffx)> trigger && Math.abs(vx) > trigger) {


                if (diffx > 0) {
                    onSwipeRight();
                } else {
                    onSwipeLeft();
                }
                result = true;
            }
            }
        else {
            if (Math.abs(diffy) > trigger && Math.abs(vy) > trigger) {
                if (diffy > 0) {
                    onSwipeDown();
                } else {
                    onSwipeUp();
                }
                result = true;
            }

        }
        return result;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void onSwipeDown() {
        Intent intent = new Intent(this, South.class);
        southView = (TextView) findViewById(R.id.southView);
        startActivity(intent);
    }

    private void onSwipeUp() {
        Intent intent = new Intent(this, North.class);
        northView = (TextView) findViewById(R.id.northView);
        startActivity(intent);
    }

    private void onSwipeLeft() {
        Intent intent = new Intent(this, West.class);
        westView = (TextView) findViewById(R.id.westView);
        startActivity(intent);

    }

    private void onSwipeRight() {
        Intent intent = new Intent(this, East.class);
        eastView = (TextView) findViewById(R.id.eastView);
        startActivity(intent);
    }
}