package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2 ;
    int number1=0, number2=0;
    TextView display;
    String str_number1="0";
    String str_number2="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.display);
        num1=findViewById(R.id.number1);
        num2=findViewById(R.id.number2);



        num1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                 str_number1=num1.getText().toString();
                if (str_number1.length() != 0) {
                        display.setText(str_number1);
                    }


            }
        });


//        num2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                String str_number1=num1.getText().toString();
//                String str_number2=num2.getText().toString();
//                if(isNumeric(str_number1) && isNumeric(str_number2)){
//                    float sum = Float.parseFloat(str_number1) + Float.parseFloat(str_number2) ;
//                    String display_sum= Float.toString(sum);
//                    display.setText(display_sum);
//                }
//
//
//            }
//        });

        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {
                float sum;
                str_number1 = num1.getText().toString();
                if (str_number1.length() != 0) {
                    if (isNumeric(str_number1)) {

                        if (str_number2.length() != 0) {
                            sum = Float.parseFloat(str_number1) + Float.parseFloat(str_number2);
                            String display_sum = Float.toString(sum);
                            display.setText(display_sum);
                        }
                        else
                        {
                            sum = Float.parseFloat(str_number1) ;
                            String display_sum = Float.toString(sum);
                            display.setText(display_sum);
                        }

                    }
                }
                else
                {
                    String display_sum = Float.toString(0);
                    display.setText(display_sum);
                }

            }
        });


        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                }


            @Override
            public void afterTextChanged(Editable s) {
                float sum;
                str_number2 = num2.getText().toString();
                if (str_number2.length() != 0) {
                if (isNumeric(str_number2)) {

                    if (str_number1.length() != 0) {
                        sum = Float.parseFloat(str_number1) + Float.parseFloat(str_number2);
                        String display_sum = Float.toString(sum);
                        display.setText(display_sum);
                    }
                    else
                    {
                        sum = Float.parseFloat(str_number2) ;
                        String display_sum = Float.toString(sum);
                        display.setText(display_sum);
                    }
                }
                }
                else
                {
                    String display_sum = Float.toString(0);
                    display.setText(display_sum);
                }
            }
        });




    }


    public boolean isNumeric(String strNum) {
        if (strNum == null) {
//            Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}