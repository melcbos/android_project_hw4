package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;
    private Button btnG;
    private Button btnH;
    private Button btnI;
    private Button btnJ;
    private Button btnK;
    private Button btnL;
    private Button btnM;
    private Button btnN;
    private Button btnO;
    private Button btnP;
    private Button btnQ;
    private Button btnR;
    private Button btnS;
    private Button btnT;
    private Button btnU;
    private Button btnV;
    private Button btnW;
    private Button btnX;
    private Button btnY;
    private Button btnZ;

    private Button btnHint;
    private Button btnNewGame;


    private TextView txtChoose;
    private TextView txtAnswer;
    private TextView txtHint;


    private ImageView imgHangman;

    private final int totalImg = 6;
    private final String winMessage = "You Win! Press new game to play again";
    private final String loseMessage = "You Lost. Press new game to play again";

    private int currentImg = 0;
    private int hintPressed = 0;
    private int lettersLeft = 26;

    private int disabled = Color.parseColor("#CCCCCC");

    // List of image states
    private int[] imgArray = {R.drawable.hangman_copy_0,
            R.drawable.hangman_copy_1, R.drawable.hangman_copy_2,
            R.drawable.hangman_copy_3, R.drawable.hangman_copy_4,
            R.drawable.hangman_copy_5, R.drawable.hangman_copy_6};

    // List of WordBank, the custom class
    List<WordBank> wordBank = new LinkedList<WordBank>();
    WordBank currentWord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtChoose = (TextView) findViewById(R.id.txtChoose);
        txtAnswer = (TextView) findViewById(R.id.txtAnswer);
        txtHint = (TextView) findViewById(R.id.txtHint);

        imgHangman = (ImageView) findViewById(R.id.imgHangman);

        btnHint = (Button) findViewById(R.id.btnHint);
        btnNewGame = (Button) findViewById(R.id.btnNewGame);

        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);
        btnG = (Button) findViewById(R.id.btnG);
        btnH = (Button) findViewById(R.id.btnH);
        btnI = (Button) findViewById(R.id.btnI);
        btnJ = (Button) findViewById(R.id.btnJ);
        btnK = (Button) findViewById(R.id.btnK);
        btnL = (Button) findViewById(R.id.btnL);
        btnM = (Button) findViewById(R.id.btnM);
        btnN = (Button) findViewById(R.id.btnN);
        btnO = (Button) findViewById(R.id.btnO);
        btnP = (Button) findViewById(R.id.btnP);
        btnQ = (Button) findViewById(R.id.btnQ);
        btnR = (Button) findViewById(R.id.btnR);
        btnS = (Button) findViewById(R.id.btnS);
        btnT = (Button) findViewById(R.id.btnT);
        btnU = (Button) findViewById(R.id.btnU);
        btnV = (Button) findViewById(R.id.btnV);
        btnW = (Button) findViewById(R.id.btnW);
        btnX = (Button) findViewById(R.id.btnX);
        btnY = (Button) findViewById(R.id.btnY);
        btnZ = (Button) findViewById(R.id.btnZ);

/* LISTENER EVENTS */
        // For buttons A-Z, when clicked, disable button and check if letter is in word
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnA.setClickable(false);
                btnA.setBackgroundColor(disabled);
                checkLetter("A");
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnB.setClickable(false);
                btnB.setBackgroundColor(disabled);
                checkLetter("B");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnC.setClickable(false);
                btnC.setBackgroundColor(disabled);
                checkLetter("C");
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnD.setClickable(false);
                btnD.setBackgroundColor(disabled);
                checkLetter("D");
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnE.setClickable(false);
                btnE.setBackgroundColor(disabled);
                checkLetter("E");
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnF.setClickable(false);
                btnF.setBackgroundColor(disabled);
                checkLetter("F");
            }
        });
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnG.setClickable(false);
                btnG.setBackgroundColor(disabled);
                checkLetter("G");
            }
        });
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnH.setClickable(false);
                btnH.setBackgroundColor(disabled);
                checkLetter("H");
            }
        });
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnI.setClickable(false);
                btnI.setBackgroundColor(disabled);
                checkLetter("I");
            }
        });
        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnJ.setClickable(false);
                btnJ.setBackgroundColor(disabled);
                checkLetter("J");
            }
        });
        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnK.setClickable(false);
                btnK.setBackgroundColor(disabled);
                checkLetter("K");
            }
        });
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnL.setClickable(false);
                btnL.setBackgroundColor(disabled);
                checkLetter("L");
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnM.setClickable(false);
                btnM.setBackgroundColor(disabled);
                checkLetter("M");
            }
        });
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnN.setClickable(false);
                btnN.setBackgroundColor(disabled);
                checkLetter("N");
            }
        });
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnO.setClickable(false);
                btnO.setBackgroundColor(disabled);
                checkLetter("O");
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnP.setClickable(false);
                btnP.setBackgroundColor(disabled);
                checkLetter("P");
            }
        });
        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnQ.setClickable(false);
                btnQ.setBackgroundColor(disabled);
                checkLetter("Q");
            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnR.setClickable(false);
                btnR.setBackgroundColor(disabled);
                checkLetter("R");
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnS.setClickable(false);
                btnS.setBackgroundColor(disabled);
                checkLetter("S");
            }
        });
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnT.setClickable(false);
                btnT.setBackgroundColor(disabled);
                checkLetter("T");
            }
        });
        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnU.setClickable(false);
                btnU.setBackgroundColor(disabled);
                checkLetter("U");
            }
        });
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnV.setClickable(false);
                btnV.setBackgroundColor(disabled);
                checkLetter("V");
            }
        });
        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnW.setClickable(false);
                btnW.setBackgroundColor(disabled);
                checkLetter("W");
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnX.setClickable(false);
                btnX.setBackgroundColor(disabled);
                checkLetter("X");
            }
        });
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnY.setClickable(false);
                btnY.setBackgroundColor(disabled);
                checkLetter("Y");
            }
        });
        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnZ.setClickable(false);
                btnZ.setBackgroundColor(disabled);
                checkLetter("Z");
            }
        });

        // If hint is pressed, display hint text
        // If hint is pressed twice, disable half of the remaining buttons that aren't right
        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hintPressed++;
                txtHint.setText("Hint: " + currentWord.getHint());
                if(hintPressed == 2) {
                    disableHalf();
                    btnHint.setClickable(false);
                }
                if(hintPressed<=2) { //if this is the user's 1st or 2nd time pressing the button, lose a turn
                    currentImg++;
                    imgHangman.setImageResource(imgArray[currentImg]);
                    if(currentImg >= totalImg) {
                        // you lose ************
                        endGame(loseMessage);
                    }
                }
            }
        });

        // starts a new game
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               reset();
            }
        });

/* List of possible words */
        wordBank.add(new WordBank("Sandwich", "Deli"));
        wordBank.add(new WordBank("Jacket", "Clothing"));
        wordBank.add(new WordBank("Trees", "Outside"));
        wordBank.add(new WordBank("Radio", "Sound"));
        wordBank.add(new WordBank("Water", "Wet"));
        wordBank.add(new WordBank("Beach", "Sand"));
        wordBank.add(new WordBank("Medicine", "Sick"));




        // choose the word for the round and set the image to the first one (these will be updated if there's a bundle in the onRestore method)
        pickWord();
        imgHangman.setImageResource(imgArray[currentImg]);

        // new game can only be pressed if the game is over
        btnNewGame.setClickable(false);
    }

    // pick a random word from the list of possible WordBank and set the answer text accordingly
    private void pickWord() {
        int size = wordBank.size();
        int pickOne = getRandomInteger(size);
        currentWord = wordBank.get(pickOne);
        txtAnswer.setText(currentWord.showCurrentProgress());
    }

    // check if the letter passed in exists within the word the user is trying to solve
    private void checkLetter(String letter) {
        // letter exists in word, so update string text
        if(currentWord.getLetters().contains(letter)) {
            currentWord.getLetters().remove(letter); // remove letter from set so it can't count again
            currentWord.reveal(letter); // update the boolean array to show every place where letter appears
            if(currentWord.getLetters().isEmpty()) {
                // you win ***********
                endGame(winMessage);
            }
        }
        // letter doesn't exist in word, so update hangman
        else {
            currentImg++;
            imgHangman.setImageResource(imgArray[currentImg]);
            if(currentImg >= totalImg) {
                // you lose ************
                endGame(loseMessage);
            }
        }
        // update progress of answer text
        txtAnswer.setText(currentWord.showCurrentProgress());
        lettersLeft--; // remove the amount of remaining letters that user can press
    }

    public static int getRandomInteger(int maximum) {
        return ((int) (Math.random()*(maximum)));
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        outState.putParcelable("currentWord", currentWord);
        outState.putString("txtAnswer", String.valueOf(txtAnswer.getText()));
        outState.putString("txtHint", String.valueOf(txtHint.getText()));

        outState.putInt("currentImg", currentImg);
        outState.putInt("hintPressed", hintPressed);

        outState.putInt("lettersLeft", lettersLeft);


        outState.putBoolean("btnA.isClickable", btnA.isClickable());
        outState.putBoolean("btnB.isClickable", btnB.isClickable());
        outState.putBoolean("btnC.isClickable", btnC.isClickable());
        outState.putBoolean("btnD.isClickable", btnD.isClickable());
        outState.putBoolean("btnE.isClickable", btnE.isClickable());
        outState.putBoolean("btnF.isClickable", btnF.isClickable());
        outState.putBoolean("btnG.isClickable", btnG.isClickable());
        outState.putBoolean("btnH.isClickable", btnH.isClickable());
        outState.putBoolean("btnI.isClickable", btnI.isClickable());
        outState.putBoolean("btnJ.isClickable", btnJ.isClickable());
        outState.putBoolean("btnK.isClickable", btnK.isClickable());
        outState.putBoolean("btnL.isClickable", btnL.isClickable());
        outState.putBoolean("btnM.isClickable", btnM.isClickable());
        outState.putBoolean("btnN.isClickable", btnN.isClickable());
        outState.putBoolean("btnO.isClickable", btnO.isClickable());
        outState.putBoolean("btnP.isClickable", btnP.isClickable());
        outState.putBoolean("btnQ.isClickable", btnQ.isClickable());
        outState.putBoolean("btnR.isClickable", btnR.isClickable());
        outState.putBoolean("btnS.isClickable", btnS.isClickable());
        outState.putBoolean("btnT.isClickable", btnT.isClickable());
        outState.putBoolean("btnU.isClickable", btnU.isClickable());
        outState.putBoolean("btnV.isClickable", btnV.isClickable());
        outState.putBoolean("btnW.isClickable", btnW.isClickable());
        outState.putBoolean("btnX.isClickable", btnX.isClickable());
        outState.putBoolean("btnY.isClickable", btnY.isClickable());
        outState.putBoolean("btnZ.isClickable", btnZ.isClickable());
        outState.putBoolean("btnNewGame.isClickable", btnNewGame.isClickable());
        outState.putBoolean("btnHint.isClickable", btnHint.isClickable());


        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentWord = savedInstanceState.getParcelable("currentWord");
        txtAnswer.setText(savedInstanceState.getString("txtAnswer"));
        currentImg = savedInstanceState.getInt("currentImg");
        hintPressed = savedInstanceState.getInt("hintPressed");
        txtHint.setText(savedInstanceState.getString("txtHint"));
        lettersLeft = savedInstanceState.getInt("lettersLeft");

        imgHangman.setImageResource(imgArray[currentImg]);

        // if the button can't be pressed, gray it out as well
        btnA.setClickable(savedInstanceState.getBoolean("btnA.isClickable"));
        if (!btnA.isClickable()) btnA.setBackgroundColor(disabled);
        btnB.setClickable(savedInstanceState.getBoolean("btnB.isClickable"));
        if (!btnB.isClickable()) btnB.setBackgroundColor(disabled);
        btnC.setClickable(savedInstanceState.getBoolean("btnC.isClickable"));
        if (!btnC.isClickable()) btnC.setBackgroundColor(disabled);
        btnD.setClickable(savedInstanceState.getBoolean("btnD.isClickable"));
        if (!btnD.isClickable()) btnD.setBackgroundColor(disabled);
        btnE.setClickable(savedInstanceState.getBoolean("btnE.isClickable"));
        if (!btnE.isClickable()) btnE.setBackgroundColor(disabled);
        btnF.setClickable(savedInstanceState.getBoolean("btnF.isClickable"));
        if (!btnF.isClickable()) btnF.setBackgroundColor(disabled);
        btnG.setClickable(savedInstanceState.getBoolean("btnG.isClickable"));
        if (!btnG.isClickable()) btnG.setBackgroundColor(disabled);
        btnH.setClickable(savedInstanceState.getBoolean("btnH.isClickable"));
        if (!btnH.isClickable()) btnH.setBackgroundColor(disabled);
        btnI.setClickable(savedInstanceState.getBoolean("btnI.isClickable"));
        if (!btnI.isClickable()) btnI.setBackgroundColor(disabled);
        btnJ.setClickable(savedInstanceState.getBoolean("btnJ.isClickable"));
        if (!btnJ.isClickable()) btnJ.setBackgroundColor(disabled);
        btnK.setClickable(savedInstanceState.getBoolean("btnK.isClickable"));
        if (!btnK.isClickable()) btnK.setBackgroundColor(disabled);
        btnL.setClickable(savedInstanceState.getBoolean("btnL.isClickable"));
        if (!btnL.isClickable()) btnL.setBackgroundColor(disabled);
        btnM.setClickable(savedInstanceState.getBoolean("btnM.isClickable"));
        if (!btnM.isClickable()) btnM.setBackgroundColor(disabled);
        btnN.setClickable(savedInstanceState.getBoolean("btnN.isClickable"));
        if (!btnN.isClickable()) btnN.setBackgroundColor(disabled);
        btnO.setClickable(savedInstanceState.getBoolean("btnO.isClickable"));
        if (!btnO.isClickable()) btnO.setBackgroundColor(disabled);
        btnP.setClickable(savedInstanceState.getBoolean("btnP.isClickable"));
        if (!btnP.isClickable()) btnP.setBackgroundColor(disabled);
        btnQ.setClickable(savedInstanceState.getBoolean("btnQ.isClickable"));
        if (!btnQ.isClickable()) btnQ.setBackgroundColor(disabled);
        btnR.setClickable(savedInstanceState.getBoolean("btnR.isClickable"));
        if (!btnR.isClickable()) btnR.setBackgroundColor(disabled);
        btnS.setClickable(savedInstanceState.getBoolean("btnS.isClickable"));
        if (!btnS.isClickable()) btnS.setBackgroundColor(disabled);
        btnT.setClickable(savedInstanceState.getBoolean("btnT.isClickable"));
        if (!btnT.isClickable()) btnT.setBackgroundColor(disabled);
        btnU.setClickable(savedInstanceState.getBoolean("btnU.isClickable"));
        if (!btnU.isClickable()) btnU.setBackgroundColor(disabled);
        btnV.setClickable(savedInstanceState.getBoolean("btnV.isClickable"));
        if (!btnV.isClickable()) btnV.setBackgroundColor(disabled);
        btnW.setClickable(savedInstanceState.getBoolean("btnW.isClickable"));
        if (!btnW.isClickable()) btnW.setBackgroundColor(disabled);
        btnX.setClickable(savedInstanceState.getBoolean("btnX.isClickable"));
        if (!btnX.isClickable()) btnX.setBackgroundColor(disabled);
        btnY.setClickable(savedInstanceState.getBoolean("btnY.isClickable"));
        if (!btnY.isClickable()) btnY.setBackgroundColor(disabled);
        btnZ.setClickable(savedInstanceState.getBoolean("btnZ.isClickable"));
        if (!btnZ.isClickable()) btnZ.setBackgroundColor(disabled);
        btnNewGame.setClickable(savedInstanceState.getBoolean("btnNewGame.isClickable"));
        btnHint.setClickable(savedInstanceState.getBoolean("btnHint.isClickable"));
        if (!btnHint.isClickable()) btnHint.setBackgroundColor(disabled);


    }

    // reset buttons and other variables to start a new game
    private void reset() {
        int reset = Color.parseColor("#FF6200EE");
        btnA.setClickable(true);
        btnA.setBackgroundColor(reset);
        btnB.setClickable(true);
        btnB.setBackgroundColor(reset);
        btnC.setClickable(true);
        btnC.setBackgroundColor(reset);
        btnD.setClickable(true);
        btnD.setBackgroundColor(reset);
        btnE.setClickable(true);
        btnE.setBackgroundColor(reset);
        btnF.setClickable(true);
        btnF.setBackgroundColor(reset);
        btnG.setClickable(true);
        btnG.setBackgroundColor(reset);
        btnH.setClickable(true);
        btnH.setBackgroundColor(reset);
        btnI.setClickable(true);
        btnI.setBackgroundColor(reset);
        btnJ.setClickable(true);
        btnJ.setBackgroundColor(reset);
        btnK.setClickable(true);
        btnK.setBackgroundColor(reset);
        btnL.setClickable(true);
        btnL.setBackgroundColor(reset);
        btnM.setClickable(true);
        btnM.setBackgroundColor(reset);
        btnN.setClickable(true);
        btnN.setBackgroundColor(reset);
        btnO.setClickable(true);
        btnO.setBackgroundColor(reset);
        btnP.setClickable(true);
        btnP.setBackgroundColor(reset);
        btnQ.setClickable(true);
        btnQ.setBackgroundColor(reset);
        btnR.setClickable(true);
        btnR.setBackgroundColor(reset);
        btnS.setClickable(true);
        btnS.setBackgroundColor(reset);
        btnT.setClickable(true);
        btnT.setBackgroundColor(reset);
        btnU.setClickable(true);
        btnU.setBackgroundColor(reset);
        btnV.setClickable(true);
        btnV.setBackgroundColor(reset);
        btnW.setClickable(true);
        btnW.setBackgroundColor(reset);
        btnX.setClickable(true);
        btnX.setBackgroundColor(reset);
        btnY.setClickable(true);
        btnY.setBackgroundColor(reset);
        btnZ.setClickable(true);
        btnZ.setBackgroundColor(reset);

        btnHint.setClickable(true);
        btnHint.setBackgroundColor(reset);

        currentImg = 0;
        imgHangman.setImageResource(imgArray[currentImg]);

        hintPressed = 0;
        lettersLeft = 26;

        btnNewGame.setClickable(false);
        txtHint.setText("Hint: ");

        currentWord.resetWord(); // update the WordBank object so that if it's selected again, it will be reset

        pickWord(); // choose a new word
    }

    // Show a message to tell user about their win status and disable all buttons except the newGame button
    private void endGame(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        btnNewGame.setClickable(true);

        btnA.setClickable(false);
        btnB.setClickable(false);
        btnC.setClickable(false);
        btnD.setClickable(false);
        btnE.setClickable(false);
        btnF.setClickable(false);
        btnG.setClickable(false);
        btnH.setClickable(false);
        btnI.setClickable(false);
        btnJ.setClickable(false);
        btnK.setClickable(false);
        btnL.setClickable(false);
        btnM.setClickable(false);
        btnN.setClickable(false);
        btnO.setClickable(false);
        btnP.setClickable(false);
        btnQ.setClickable(false);
        btnR.setClickable(false);
        btnS.setClickable(false);
        btnT.setClickable(false);
        btnU.setClickable(false);
        btnV.setClickable(false);
        btnW.setClickable(false);
        btnX.setClickable(false);
        btnY.setClickable(false);
        btnZ.setClickable(false);
        btnHint.setClickable(false);

    }

    // disable half of the remaining buttons that aren't apart of the answer
    private void disableHalf() {
        int lettersLeftToDelete = (lettersLeft - currentWord.getLetters().size())/2; //subtract number of correct letters from the amount of letters the user hasn't pressed yet, then half that number
        while (lettersLeftToDelete > 0) {
            int randomNum = getRandomInteger(26) + 65;
            char randomLetter = (char) randomNum;

            // for every letter, if the button is enabled and not apart of the correct answer, disable it
            // do this until all half of the available letters are disabled
            switch (randomLetter) {
                case 'A':
                    if(btnA.isClickable() && !currentWord.getLetters().contains("A")) {
                        btnA.setClickable(false);
                        btnA.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'B':
                    if(btnB.isClickable() && !currentWord.getLetters().contains("B")) {
                        btnB.setClickable(false);
                        btnB.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'C':
                    if(btnC.isClickable() && !currentWord.getLetters().contains("C")) {
                        btnC.setClickable(false);
                        btnC.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'D':
                    if(btnD.isClickable() && !currentWord.getLetters().contains("D")) {
                        btnD.setClickable(false);
                        btnD.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'E':
                    if(btnE.isClickable() && !currentWord.getLetters().contains("E")) {
                        btnE.setClickable(false);
                        btnE.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'F':
                    if(btnF.isClickable() && !currentWord.getLetters().contains("F")) {
                        btnF.setClickable(false);
                        btnF.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'G':
                    if(btnG.isClickable() && !currentWord.getLetters().contains("G")) {
                        btnG.setClickable(false);
                        btnG.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'H':
                    if(btnH.isClickable() && !currentWord.getLetters().contains("H")) {
                        btnH.setClickable(false);
                        btnH.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'I':
                    if(btnI.isClickable() && !currentWord.getLetters().contains("I")) {
                        btnI.setClickable(false);
                        btnI.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'J':
                    if(btnJ.isClickable() && !currentWord.getLetters().contains("J")) {
                        btnJ.setClickable(false);
                        btnJ.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'K':
                    if(btnK.isClickable() && !currentWord.getLetters().contains("K")) {
                        btnK.setClickable(false);
                        btnK.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'L':
                    if(btnL.isClickable() && !currentWord.getLetters().contains("L")) {
                        btnL.setClickable(false);
                        btnL.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'M':
                    if(btnM.isClickable() && !currentWord.getLetters().contains("M")) {
                        btnM.setClickable(false);
                        btnM.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'N':
                    if(btnN.isClickable() && !currentWord.getLetters().contains("N")) {
                        btnN.setClickable(false);
                        btnN.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'O':
                    if(btnO.isClickable() && !currentWord.getLetters().contains("O")) {
                        btnO.setClickable(false);
                        btnO.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'P':
                    if(btnP.isClickable() && !currentWord.getLetters().contains("P")) {
                        btnP.setClickable(false);
                        btnP.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'Q':
                    if(btnQ.isClickable() && !currentWord.getLetters().contains("Q")) {
                        btnQ.setClickable(false);
                        btnQ.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'R':
                    if(btnR.isClickable() && !currentWord.getLetters().contains("R")) {
                        btnR.setClickable(false);
                        btnR.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'S':
                    if(btnS.isClickable() && !currentWord.getLetters().contains("S")) {
                        btnS.setClickable(false);
                        btnS.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'T':
                    if(btnT.isClickable() && !currentWord.getLetters().contains("T")) {
                        btnT.setClickable(false);
                        btnT.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'U':
                    if(btnU.isClickable() && !currentWord.getLetters().contains("U")) {
                        btnU.setClickable(false);
                        btnU.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'V':
                    if(btnV.isClickable() && !currentWord.getLetters().contains("V")) {
                        btnV.setClickable(false);
                        btnV.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'W':
                    if(btnW.isClickable() && !currentWord.getLetters().contains("W")) {
                        btnW.setClickable(false);
                        btnW.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'X':
                    if(btnX.isClickable() && !currentWord.getLetters().contains("X")) {
                        btnX.setClickable(false);
                        btnX.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'Y':
                    if(btnY.isClickable() && !currentWord.getLetters().contains("Y")) {
                        btnY.setClickable(false);
                        btnY.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
                case 'Z':
                    if(btnZ.isClickable() && !currentWord.getLetters().contains("Z")) {
                        btnZ.setClickable(false);
                        btnZ.setBackgroundColor(disabled);
                        lettersLeftToDelete--;
                        lettersLeft--;
                    }
                    break;
            }
        }
    }

}