package com.example.part2flingingmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    //forces user to scroll more slowly
    private static final float SCROLL_MAX_OFF_PATH = 200;
    //max velocity for scroll in the y axis, if above this threshold, then its a fling
    public static final int MAX_VELOCITY_FOR_SCROLL = 30;
    EditText euros;
    TextView dollars, yen, rupis, mexicanPesos;
    Button btnConvert;
    float eurosVal, toDollars, toYen, toRupis, toMexicanPesos;

    private GestureDetector GD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euros = (EditText) findViewById(R.id.editTextEuros);
        dollars = (TextView) findViewById(R.id.textViewDollars);
        yen = (TextView) findViewById(R.id.textViewYen);
        rupis = (TextView) findViewById(R.id.textViewRupi);
        mexicanPesos = (TextView) findViewById(R.id.textViewMexicanPesos);
        btnConvert = (Button) findViewById(R.id.convert);

        GD = new GestureDetector(this, this);

        btnConvert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                eurosVal = Float.parseFloat(euros.getText().toString());
                conversion(eurosVal);


            }
        });

    }

    private void conversion(float euros) {
        //convert
        toDollars = Math.round(euros * 1.16f * 100.0f) /100.0f;
        toYen =  Math.round(euros * 128.75f * 100.0f)/ 100.0f;
        toRupis = Math.round(euros * 86f*100.0f)/100.0f;
        toMexicanPesos = Math.round(euros * 23.73f*100.0f)/100.0f;

        dollars.setText(toDollars + "");
        yen.setText(toYen + "");
        rupis.setText(toRupis+"");
        mexicanPesos.setText(toMexicanPesos + "");



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.GD.onTouchEvent(event);
        return super.onTouchEvent(event);
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
        //dollars.setText(toDollars + 0.05f + "");
        //Math.abs(motionEvent.getY() - motionEvent1.getY()) > SCROLL_MAX_OFF_PATH


        if (Math.abs(v1) > MAX_VELOCITY_FOR_SCROLL) return false; //don't consume this event, fling will be used instead
        else{
            //if it scrolls for a long distance don't count it
            if(Math.abs(motionEvent.getY() - motionEvent1.getY()) > SCROLL_MAX_OFF_PATH) return false;
            if (motionEvent.getY() < motionEvent1.getY()){
                eurosVal =  Math.round((eurosVal - 0.05f)*100.0f)/100.0f;
                conversion(eurosVal);
                euros.setText(eurosVal+"");
                dollars.setText(toDollars + "");
                yen.setText(toYen + "");
                rupis.setText(toRupis+"");
                mexicanPesos.setText(toMexicanPesos+"");
                Log.d("lfa", "Scroll Down");
            }
//            if(motionEvent.getY() > motionEvent1.getY()){
            else{
                eurosVal =  Math.round((eurosVal + 0.05f)*100.0f)/100.0f;
                conversion(eurosVal);
                euros.setText(eurosVal+"");
                dollars.setText(toDollars + "");
                yen.setText(toYen + "");
                rupis.setText(toRupis+"");
                mexicanPesos.setText(toMexicanPesos+"");
                Log.d("lfa", "SCROLL UP");
            }
            return true;

        }

    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if (motionEvent.getY() < motionEvent1.getY()){
            eurosVal =  Math.round((eurosVal - 1.00f)*100.0f)/100.0f;
            conversion(eurosVal);
            euros.setText(eurosVal+"");
            dollars.setText(toDollars + "");
            yen.setText(toYen + "");
            rupis.setText(toRupis+"");
            mexicanPesos.setText(toMexicanPesos+"");
            Log.d("lfa", "Fling Down");
        }
        if(motionEvent.getY() > motionEvent1.getY()){
            eurosVal =  Math.round((eurosVal + 1.00f)*100.0f)/100.0f;
            conversion(eurosVal);
            euros.setText(eurosVal+"");
            dollars.setText(toDollars + "");
            yen.setText(toYen + "");
            rupis.setText(toRupis+"");
            mexicanPesos.setText(toMexicanPesos+"");
            Log.d("lfa", "FLING UP");
        }

        return true;
    }
}