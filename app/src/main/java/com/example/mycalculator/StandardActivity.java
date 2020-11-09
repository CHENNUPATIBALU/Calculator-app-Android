package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StandardActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPlus,bMinus,bMultiply,bDivision,bEqual,bPlusMinus,bDot,bAC,bClear,bPercent,bMod;
    String input = "";
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        //Referencing Buttons
        b0 = findViewById(R.id.zeroButton);
        b1 = findViewById(R.id.oneButton);
        b2 = findViewById(R.id.twoButton);
        b3 = findViewById(R.id.threeButton);
        b4 = findViewById(R.id.fourButton);
        b5 = findViewById(R.id.fiveButton);
        b6 = findViewById(R.id.sixButton);
        b7 = findViewById(R.id.sevenButton);
        b8 = findViewById(R.id.eightButton);
        b9 = findViewById(R.id.nineButton);
        bPlus = findViewById(R.id.additionButton);
        bMinus = findViewById(R.id.subtractionButton);
        bMultiply = findViewById(R.id.multiplyButton);
        bDivision = findViewById(R.id.divideButton);
        bEqual = findViewById(R.id.equalButton);
        bPlusMinus = findViewById(R.id.plusByMinus);
        bDot = findViewById(R.id.dotButton);
        bAC = findViewById(R.id.allClearButton);
        bClear = findViewById(R.id.deleteButton);
        bPercent = findViewById(R.id.percentButton);
        bMod = findViewById(R.id.modButton);


        t = findViewById(R.id.standardCalciTextNumber);
        t.setBackgroundColor(Color.WHITE);

        //Adding onClick Listeners to Numeric Buttons
        b0.setOnClickListener(view -> t.setText(t.getText() + "0"));
        b1.setOnClickListener(view -> t.setText(t.getText() + "1"));
        b2.setOnClickListener(view -> t.setText(t.getText() + "2"));
        b3.setOnClickListener(view -> t.setText(t.getText() + "3"));
        b4.setOnClickListener(view -> t.setText(t.getText() + "4"));
        b5.setOnClickListener(view -> t.setText(t.getText() + "5"));
        b6.setOnClickListener(view -> t.setText(t.getText() + "6"));
        b7.setOnClickListener(view -> t.setText(t.getText() + "7"));
        b8.setOnClickListener(view -> t.setText(t.getText() + "8"));
        b9.setOnClickListener(view -> t.setText(t.getText() + "9"));

        // Adding onClick Listeners to MathOperation Buttons
        bPlus.setOnClickListener(view -> {
            t.setText(t.getText() + "+");
        });
        bMinus.setOnClickListener(view -> {
            t.setText(t.getText() + "-");
        });
        bMultiply.setOnClickListener(view -> {
            t.setText(t.getText() + "*");
        });
        bDivision.setOnClickListener(view -> {
            t.setText(t.getText() + "/");
        });
        bDot.setOnClickListener(view -> {
            t.setText(t.getText() + ".");
        });
        bPlusMinus.setOnClickListener(view -> {
            t.setText("-" + t.getText());
        });

        //Clears the EditText
        bAC.setOnClickListener(view -> t.setText(""));

        bMod.setOnClickListener(view -> {
            t.setText(t.getText()+"%");
        });
        bPercent.setOnClickListener(view -> {
            t.setText(t.getText()+"/100");
        });
        //Clears the last occurrence in the EditText
        bClear.setOnClickListener(view -> {
            try
            {
                t.setText(t.getText().toString().substring(0,t.getText().length()-1));
            }
            catch(Exception ex)
            {
                Toast.makeText(getApplicationContext(),"Number Field is Empty",Toast.LENGTH_LONG).show();
            }
        });

        //Equal('=') button for evaluating expressions
        bEqual.setOnClickListener(view -> {
            try {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByExtension("js");
                t.setText(engine.eval(t.getText().toString())+"");
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        });
    }
}