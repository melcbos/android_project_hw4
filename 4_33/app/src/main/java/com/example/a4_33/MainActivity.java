package com.example.a4_33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editString;
    Button encryptButton, customShiftActivity;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_main);
        editString = (EditText) findViewById(R.id.editString);
        encryptButton = (Button) findViewById(R.id.encryptButton);
        output = (TextView) findViewById(R.id.output);
        customShiftActivity = (Button) findViewById(R.id.activity2);

        encryptButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String cyphered3shift = cypherDefault(editString.getText().toString());
                output.setText(cyphered3shift);

            }
        });

        customShiftActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Encrypt.class);
                Bundle bundle = new Bundle();
                bundle.putString("value", editString.getText().toString());
                i.putExtras(bundle);
                startActivity(i);
            }
        });




    }

    public static String cypherDefault(String input){
        String s = "";
        for(int i = 0; i < input.length(); i++){
            char c = (char)(input.charAt(i) + 3);
            if( c > 'z'){
                s += (char)(input.charAt(i) - (26-3));
            }
            else{
                s += (char)(input.charAt(i) + 3);
            }
        }
        return s;
    }


}