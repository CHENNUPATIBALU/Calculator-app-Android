package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycalculator.R;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScientificActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPlus,bMinus,bMultiply,bDivision,bSquare;
    Button bEqual,bPlusMinus,bDot,bAC,bClear,bPercent,bMod,bBracket,bSine,bCosine,bTan,bLog,bSquareRoot,bOneByX;
    Button bFactorial,bLn,bModulusOfX,b10PowerX,bPi,bXPowerY;
    String input = "";
    String operators[];
    EditText t;
    boolean calculate = false;
    int choice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientifc);

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
        bBracket = findViewById(R.id.bracketButton);
        bSine = findViewById(R.id.sineButton);
        bCosine = findViewById(R.id.cosineButton);
        bTan = findViewById(R.id.tanButton);
        bLog = findViewById(R.id.logButton);
        bSquareRoot = findViewById(R.id.squareRootButton);
        bOneByX = findViewById(R.id.oneByXButton);
        bSquare = findViewById(R.id.squareButton);
        bFactorial = findViewById(R.id.factorialButton);
        bLn = findViewById(R.id.lnButton);
        bModulusOfX = findViewById(R.id.modulusOfX);
        b10PowerX = findViewById(R.id.tenPowerX);
        bPi = findViewById(R.id.piButton);
        bXPowerY = findViewById(R.id.xPowerY);

        operators = new String[]{"+","-","*","/","%"};


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
            t.setText(t.getText() + operators[0]);
            calculate = false;
        });
        bMinus.setOnClickListener(view -> {
            t.setText(t.getText() + operators[1]);
            calculate = false;
        });
        bMultiply.setOnClickListener(view -> {
            t.setText(t.getText() + operators[2]);
            calculate = false;
        });
        bDivision.setOnClickListener(view -> {
            t.setText(t.getText() + operators[3]);
            calculate = false;
        });
        bDot.setOnClickListener(view -> {
            t.setText(t.getText() + ".");
            calculate = false;
        });
        bPlusMinus.setOnClickListener(view -> {
            t.setText("-" + t.getText());
            calculate = false;
        });

        //Clears the EditText
        bAC.setOnClickListener(view -> {
            if(t.getText().toString().equals(""))
                Toast.makeText(getApplicationContext(),"Number Field is Empty",Toast.LENGTH_LONG).show();
            else
                t.setText("");
        });

        bMod.setOnClickListener(view -> {
            t.setText(t.getText()+operators[4]);
            calculate = false;
        });
        bPercent.setOnClickListener(view -> {
            t.setText(t.getText()+"/100");
            calculate = false;
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

        bBracket.setOnClickListener(view -> {
            for(int i=0;i<operators.length;i++)
            {
                if(t.getText().toString().charAt(0)==operators[i].charAt(0))
                {
                    t.setText(t.getText()+")");
                    break;
                }
                else
                    t.setText(t.getText()+"(");break;
            }

        });

        bSine.setOnClickListener(view -> {
            t.setText("sin("+t.getText());
            choice = 1;
            calculate = true;
        });

        bCosine.setOnClickListener(view -> {
            t.setText("cos("+t.getText());
            choice = 2;
            calculate = true;
        });

        bTan.setOnClickListener(view -> {
            t.setText("tan("+t.getText());
            choice = 10;
            calculate = true;
        });

        bLog.setOnClickListener(view -> {
            t.setText("log("+t.getText());
            choice = 3;
            calculate = true;
        });

        bOneByX.setOnClickListener(view -> {
            t.setText("1/"+t.getText());
            calculate = false;
        });

        bSquareRoot.setOnClickListener(view -> {
            t.setText("√"+t.getText());
            choice = 4;
            calculate = true;
        });

        bSquare.setOnClickListener(view -> {
            t.setText("square("+t.getText());
            choice = 5;
            calculate = true;
        });

        bLn.setOnClickListener(view -> {
            t.setText("ln("+t.getText());
            choice = 6;
            calculate = true;
        });

        bFactorial.setOnClickListener(view -> {
            t.setText(t.getText()+"!");
            choice = 7;
            calculate = true;
        });

        bPi.setOnClickListener(view -> {
            t.setText(t.getText()+""+Math.PI);
            choice = 8;
            calculate = false;
        });

        bModulusOfX.setOnClickListener(view -> {
            t.setText("abs("+t.getText());
            choice = 9;
            calculate = true;
        });

        b10PowerX.setOnClickListener(view -> {
            t.setText("10^"+t.getText());
            choice = 11;
            calculate = true;
        });

        bXPowerY.setOnClickListener(view -> {
            t.setText(t.getText()+"^");
            choice = 12;
            calculate = true;
        });

        //Equal('=') button for evaluating expressions
        bEqual.setOnClickListener(view -> {
            if(!calculate) {
                try {
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByExtension("js");
                    t.setText(engine.eval(t.getText().toString()) + "");
                } catch (ScriptException e) {
                }
            }
            else{
                try {
                    if(choice==1)
                    {
                        t.setText(""+(Math.sin(Math.toRadians(Double.parseDouble(t.getText().toString().substring(4))))));
                    }
                    if(choice==2)
                    {
                        t.setText(""+(Math.cos(Math.toRadians(Double.parseDouble(t.getText().toString().substring(4))))));
                    }
                    if(choice==3)
                    {
                        t.setText(""+Math.log10(Double.parseDouble(t.getText().toString().substring(4))));
                    }
                    if(choice==4)
                    {
                        t.setText(""+Math.sqrt(Double.parseDouble(t.getText().toString().substring(1))));
                    }
                    if(choice==5)
                    {
                        double s = Double.parseDouble(t.getText().toString().substring(7));
                        t.setText(""+s*s);
                    }
                    if(choice==6)
                    {
                        t.setText(""+Math.log(Double.parseDouble(t.getText().toString().substring(3))));
                    }
                    if(choice==7)
                    {
                        int factorial = fact(Integer.parseInt(t.getText().toString().substring(0,t.getText().length()-1)));
                        t.setText(""+factorial);
                    }
                    if(choice==8)
                    {
                        t.setText(""+Math.PI*Double.parseDouble(t.getText().toString()));
                    }
                    if(choice==9)
                    {
                        t.setText(""+Math.abs(Double.parseDouble(t.getText().toString().substring(4))));
                    }
                    if(choice==10)
                    {
                        t.setText(""+(Math.tan(Math.toRadians(Double.parseDouble(t.getText().toString().substring(4))))));
                    }
                    if(choice==11)
                    {
                        t.setText(""+Math.pow((int)10,Double.parseDouble(t.getText().toString().substring(3))));
                    }
                    if(choice==12)
                    {
                        String s[] = new String[2];
                        String st[] = t.getText().toString().split("\\^");
                        for(int i=0;i<st.length;i++)
                            if(st[i]!="^")
                                s[i] = st[i];
                        t.setText(""+Math.pow(Double.parseDouble(s[0]),Double.parseDouble(s[1])));
                    }
                }
                catch (Exception exception)
                {

                }

            }
        });

    }
    private int fact(int n)
    {
        if(n==0)
            return 1;
        else
            return n*fact(n-1);
    }
}