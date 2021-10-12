package com.example.part1_flashlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private EditText etxtAction;
    private Switch switchPower;
    private ConstraintLayout CLMain;
    private ConstraintLayout.LayoutParams CLP;

    private GestureDetector GD;

    private CameraManager mCameraManager;
    private String mCameraId;

    private final String MyFlag = "aloha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/* Set up EditText view the normal way */
        etxtAction = (EditText) findViewById(R.id.etxtAction);

/* Set up the power switch dynamically and add it to the layout*/
        switchPower = new Switch(MainActivity.this);
        switchPower.setText("FlashLight");

        CLMain = (ConstraintLayout) findViewById(R.id.CLMain);
        CLP = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switchPower.setLayoutParams(CLP);
        switchPower.setGravity(Gravity.CENTER);

        CLMain.addView(switchPower);

/* Check to see whether phone has a flashlight or not */
        boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isFlashAvailable) {
            Toast.makeText(MainActivity.this, "There is no flashlight on this device!", Toast.LENGTH_LONG).show();
        }

/* Initialize the Camera Manager so that we can use the flashlight on the phone*/
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            mCameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            Log.e(MyFlag, "Error at initialization of camera manager occurred");
            e.printStackTrace();
        }

/* Set up the Gesture Detector for our onFling method*/
        GD = new GestureDetector(this, this);   //Context, Listener as per Constructor Doc.
        GD.setOnDoubleTapListener(this);   //DoubleTaps implemented a bit differently, must be bound like this.


/* LISTENER EVENTS */
        // whenever the "done" button is pressed on the keyboard, grab the text and check it
        etxtAction.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    checkAction(v.getText().toString());
                }
                return false;
            }
        });
        // whenever the switch is changed, update the flashlight to reflect the change
        switchPower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        mCameraManager.setTorchMode(mCameraId, isChecked);
                    }
                } catch (CameraAccessException e) {
                    Log.e(MyFlag, "Error at onCheckedChanged occurred");
                    e.printStackTrace();
                }
            }
        });
    }

    // Method to switch the Switch to the appropriate place based on the command typed
    private void checkAction(String actionEntered) {
        String action = actionEntered.toUpperCase();
        Log.e(MyFlag, "Action entered: " + action);
        switch (action) {
            case "ON":
                switchPower.setChecked(true);
                break;
            case "OFF":
                switchPower.setChecked(false);
                break;
        }
        etxtAction.setText("");
    }

    // Need this so Android will actually capture the touches
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.GD.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // Fling will determine whether light turns on or off based on direction
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.i(MyFlag, "Fling Occurred");
        int fastEnough = 5000; // the velocity we deemed fast enough to be considered a purposeful fling
        if( v1 < fastEnough ) {
            switchPower.setChecked(true);
        }
        if(v1 > fastEnough) {
            switchPower.setChecked(false);
        }
        return false;
    }




    /* These have to be here since there's an interface, nothing happens here*/
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
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
///////////////////////////////////////////////////////////////////////////////////////////////////
}