package com.example.hangman;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashSet;
import java.util.Locale;

/*
* A custom class made to simplify the addition of new words to the list. Each WordBank
* object contains the word itself and a hint given by us, but also has a set of the letters,
* the length of the word and a boolean that represents the word as (visible) or (invisible) to
* the user. These values are calculated in the constructor from the given word. The class
* implements Parcelable so that we can pass it through onSavedInstanceState.
* */

public class WordBank implements Parcelable {
    private String word;
    private String hint;
    private HashSet<String> letters;
    private int length;
    private boolean[] hidden;

    public WordBank(String word, String hint) {
        this.word = word.toUpperCase();
        length = word.length();
        this.hint = hint.toUpperCase();

        letters = new HashSet<String>();
        hidden = new boolean[length];

        // set all letters to invisible at the start
        // put all possible letters into the set
        for (int i = 0; i < length; i++) {
            String toAdd = this.word.substring(i, i+1);
            letters.add(toAdd);
            hidden[i] = true;
        }
    }

    private WordBank (Parcel in) {
        word = in.readString();
        hint = in.readString();
        length = in.readInt();

        hidden = (boolean[]) in.readSerializable();

        letters = (HashSet<String>) in.readSerializable();

    }

    // getter methods
    public String getWord() {
        return word;
    }
    public String getHint() {
        return hint;
    }
    public HashSet getLetters() {
        return letters;
    }
    public int getLength() {
        return length;
    }

    // Goes through the boolean array to determine what to
    // show to the the user. If invisible, draw a blank, else
    // draw the letter
    public String showCurrentProgress() {
        String toBeShown = "";
        for (int i = 0; i < length; i++) {
            if(hidden[i]) {
                toBeShown += " _ ";
            }
            else {
                toBeShown += word.charAt(i);
            }
        }
        return toBeShown;
    }

    // for every instance of the letter in the word, set the respective index to visible
    public void reveal(String letter) {
        for(int i = 0; i < length; i++) {
            if(word.substring(i, i+1).equals(letter)) {
                hidden[i] = false;
            }
        }
    }

    // reset all letters back to hidden and put letters back into set
    public void resetWord() {
        for (int i = 0; i < length; i++) {
            String toAdd = this.word.substring(i, i+1);
            letters.add(toAdd);
            hidden[i] = true;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(word);
        dest.writeString(hint);
        dest.writeInt(length);
        dest.writeSerializable(hidden);
        dest.writeSerializable(letters);
    }

    public static final Parcelable.Creator<WordBank> CREATOR = new Parcelable.Creator<WordBank>() {
        public WordBank createFromParcel(Parcel in) {
            return new WordBank(in);
        }

        public WordBank[] newArray(int size) {
            return new WordBank[size];
        }
    };


}
