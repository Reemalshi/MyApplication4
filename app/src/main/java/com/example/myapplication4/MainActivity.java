package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int firstNumber = 0;
    private int secondNumber=0;
    private String operation1 = "";
    private boolean operation2 = true;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text2 = findViewById(R.id.text2);
    }

    public void onNumClick(View view) {
        if (operation2) {
            text2.setText("");
            operation2 = false;
        }

        String currentText = text2.getText().toString();
        String digit = ((Button) view).getText().toString();

        if (currentText.equals("0")) {
            text2.setText(digit);
        } else {
            text2.append(digit);
        }
    }

    public void onClick2(View view) {
        String operation = ((Button) view).getText().toString();

        if (!operation1.isEmpty()) {
            result1();
        }
       operation2 = true;
        firstNumber = (int) Double.parseDouble(text2.getText().toString());
        operation1 = operation;
    }

    public void onClick4(View view) {
        result1();
        operation2 = true;
        operation1 = "";
        firstNumber = 0;
        String resultText = text2.getText().toString();
        text2.setText(resultText);
    }

    public void onClick3(View view) {
        if (!text2.getText().toString().contains(".")) {
            text2.append(".");
            operation2 = false;
        }
    }

    public void onClearClick(View view) {
        text2.setText("0");
        operation1 = "";
        firstNumber = 0;
        operation2 = true;
    }

    private void result1() {
         secondNumber = (int) Double.parseDouble(text2.getText().toString());
        int result = 0;

        switch (operation1) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    text2.setText("Error");
                    return;
                }
                break;
        }

        text2.setText(String.valueOf(result));
    }
}
