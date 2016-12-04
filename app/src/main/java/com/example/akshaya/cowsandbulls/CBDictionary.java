package com.example.akshaya.cowsandbulls;

/**
 * Created by sivagami on 21/9/16.
 */

public interface CBDictionary {
    public final static int MIN_WORD_LENGTH = 4;
    boolean search(String word);
    String getRandomWord();
}
