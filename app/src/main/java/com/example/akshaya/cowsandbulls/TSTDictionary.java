package com.example.akshaya.cowsandbulls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by sivagami on 21/9/16.
 */

public class TSTDictionary implements CBDictionary {

    private TernarySearchTree root;
    String random_word;
    public TSTDictionary(InputStream wordListStream) throws IOException{
        Random rn = new Random();
        int no = rn.nextInt() % 5;
        int count=0;
        BufferedReader in= new BufferedReader(new InputStreamReader(wordListStream));
        root = new TernarySearchTree();
        String line=null;
        while((line =in.readLine())!=null){
            String word=line.trim();
            if(word.length()==MIN_WORD_LENGTH) {

                if (count == no) random_word = word;
                root.insert(line.trim());
                count++;
            }
        }
    }
    public boolean search(String word) {return root.search(word);}
    public String getRandomWord(){ return random_word;}
}
