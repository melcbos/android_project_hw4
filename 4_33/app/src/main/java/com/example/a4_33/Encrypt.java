package com.example.a4_33;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Encrypt extends AppCompatActivity {
    TextView textResult;
    EditText shiftNumber;
    Button retMainButton;
    Integer numShift;
    private static final String SHIFT_AMOUNT="shift_amount";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main_2);
        SharedPreferences prefs = getSharedPreferences(SHIFT_AMOUNT, MODE_PRIVATE);
        textResult = (TextView)findViewById(R.id.textResult);
        shiftNumber = (EditText)findViewById(R.id.shiftNumber);
        if(prefs.getString("shift", null) != null){
            shiftNumber.setText(prefs.getString("shift", null));
        }
        retMainButton = (Button)findViewById(R.id.retMainButton);
        Bundle bundle = getIntent().getExtras();
        textResult.setText(bundle.getString("value"));
        shiftNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    numShift = Integer.parseInt(shiftNumber.getText().toString());
                    if(numShift < 26 && numShift >= 0){
                        textResult.setText(cypher(bundle.getString("value"), numShift));
                        SharedPreferences.Editor editor = getSharedPreferences(SHIFT_AMOUNT, MODE_PRIVATE).edit();
                        editor.putString("shift", numShift.toString());
                        editor.apply();
                        return true;
                    }
                    else{
                        textResult.setText("Enter a valid Number");
                        return false;
                    }
                }
                return false;
            }
        });
        retMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Encrypt.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    public static String cypher(String input, int shift){
        String s = "";
        for(int i = 0; i < input.length(); i++){
            char c = (char)(input.charAt(i) + shift);
            if( c > 'z'){
                s += (char)(input.charAt(i) - (26-shift));
            }
            else{
                s += (char)(input.charAt(i) + shift);
            }
        }
        return s;
    }
}
