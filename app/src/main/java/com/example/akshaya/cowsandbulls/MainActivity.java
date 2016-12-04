package com.example.akshaya.cowsandbulls;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    private TSTDictionary dictionary;
    String comp_word;
   // int countBull = 0;
    //int countCow = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager assetManager = getAssets();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cows and Bulls");

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SecondPage.class);
                startActivity(i);
            }
        });

        try {
            InputStream inputStream = assetManager.open("word.txt");
            dictionary = new TSTDictionary(inputStream);
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
            toast.show();
        }

        comp_word = dictionary.getRandomWord();
        final TextView textElement;
        textElement = (TextView) findViewById(R.id.textView2);
        String t = (String) textElement.getText();
        t = t + Integer.toString(comp_word.length());
        textElement.setText(t);

      /*  final EditText tv1=(EditText) findViewById(R.id.editText9);
        final EditText tv2 = (EditText) findViewById(R.id.editText10);

       for (int i = 9; i <= 14; ++i) {
            String eid = "editText"+Integer.toString(i);*/
           // TextView  tv1 =(TextView) findViewById(R.id.textView3);
            //TextView  tv2 =(TextView) findViewById(R.id.textView4);
            EditText ev1 = (EditText) findViewById(R.id.editText9);
            validate(ev1);
           /* tv1.setText(Integer.toString(countCow));
            tv2.setText(Integer.toString(countBull));

          tv1 =(TextView) findViewById(R.id.textView5);
            tv2 =(TextView) findViewById(R.id.textView6);*/
            ev1 = (EditText) findViewById(R.id.editText10);
            validate(ev1);//tv1.setText(Integer.toString(countCow));
            /*tv2.setText(Integer.toString(countBull));


          tv1 =(TextView) findViewById(R.id.textView7);
          tv2 =(TextView) findViewById(R.id.textView8);*/
            ev1 = (EditText) findViewById(R.id.editText11);
            validate(ev1);
           /*tv1.setText(Integer.toString(countCow));
           // tv2.setText(Integer.toString(countBull));



       tv1 =(TextView) findViewById(R.id.textView9);
        tv2 =(TextView) findViewById(R.id.textView10);*/
           ev1 = (EditText) findViewById(R.id.editText12);
            validate(ev1);
          /*  tv1.setText(Integer.toString(countCow));
            tv2.setText(Integer.toString(countBull));

        tv1 =(TextView) findViewById(R.id.textView11);
        tv2 =(TextView) findViewById(R.id.textView12);*/
           ev1 = (EditText) findViewById(R.id.editText13);
             validate(ev1);
            /* tv1.setText(Integer.toString(countCow));
             tv2.setText(Integer.toString(countBull));


        tv1 =(TextView) findViewById(R.id.textView12);
        tv2 =(TextView) findViewById(R.id.textView14);*/
            ev1 = (EditText) findViewById(R.id.editText14);
            validate(ev1);
           /*   tv1.setText(Integer.toString(countCow));
              tv2.setText(Integer.toString(countBull));*/
        }
   // }

    public void validate(final EditText tv1)
    {
        tv1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String entered_word = (String) tv1.getText().toString();
                    check_validity( entered_word);
                }
            }
        });


    }

    public void check_validity(String entered_word) {
        if (entered_word.length() == 0)
            Toast.makeText(getApplicationContext(), "Not entered", Toast.LENGTH_SHORT).show();
        else if (dictionary.search(entered_word)) {
            if (entered_word.equals(comp_word))
                Toast.makeText(getApplicationContext(), "You got it right!!", Toast.LENGTH_SHORT).show();

                check_cows_bulls(entered_word);
        } else
            Toast.makeText(getApplicationContext(), "Not a valid word!", Toast.LENGTH_SHORT).show();



    }

    public void check_cows_bulls(String entered_word)
    {
       int  countBull = 0;
       int  countCow = 0;
        int[] arr1 = new int[27];
        int[] arr2 = new int[27];

        for (int i = 0; i < comp_word.length(); i++) {
            char c1 = comp_word.charAt(i);
            char c2 = entered_word.charAt(i);

            if (c1 == c2)
                countBull++;
            else {
                arr1[c1 - 'a']++;
                arr2[c2 - 'a']++;
            }
        }

        for (int i = 0; i < 27; i++) {
            countCow += Math.min(arr1[i], arr2[i]);}
            Toast.makeText(getApplicationContext(),"Bulls"+ Integer.toString(countBull) +"Cows" +Integer.toString(countCow), Toast.LENGTH_SHORT).show();


    }





}
