package com.sildtech.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView inputField;
    TextView result;

    double firstNumber;
    double secondNumber;
    double resultNumber;
    boolean isUserClickedDot = false;
    boolean isNumberNegative = false;
    int codeOp = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        result = findViewById(R.id.result);
    }

    public void onDigitClick(View view) {
        Button digitBtn = (Button) view;
        inputField.append(digitBtn.getText());
    }

    public void onClickDot(View view) {
        if(!isUserClickedDot && (!inputField.getText().equals(""))){
            inputField.append(".");
            isUserClickedDot = true;
        }
    }

    public void onClickClear(View view) {
        firstNumber = 0;
        secondNumber = 0;
        isUserClickedDot = false;
        inputField.setText("");
        result.setText("");
    }

    public void onClickDel(View view) {
        try {
            if(!inputField.getText().equals("")){
                String str = inputField.getText().toString();
                String strNew = str.substring(0, str.length()-1);
                inputField.setText(strNew);
            }
            else{
                isUserClickedDot = false;
            }
        }
        catch (Exception ignored){}
    }

    public void onClickPlusMinus(View view){
        String str = inputField.getText().toString();
        if(!isNumberNegative){
            str = "-" + str;
            inputField.setText(str);
        }
        else{
            String strNew = str.substring(1);
            inputField.setText(strNew);
        }
        isNumberNegative = !isNumberNegative;
    }

    public void onClickOps(View view){
        firstNumber = Double.parseDouble(inputField.getText().toString());

        isUserClickedDot = false;
        inputField.setText("");
        result.setText("");

        if(view == findViewById(R.id.plus)){
            result.append(" + ");
            codeOp = 0;
        }
        else if(view == findViewById(R.id.mult)){
            result.append(" * ");
            codeOp = 1;
        }
        else if(view == findViewById(R.id.minus)){
            result.append(" - ");
            codeOp = 2;
        }
        else if(view == findViewById(R.id.div)){
            result.append(" / ");
            codeOp = 3;
        }
    }

    public void onClickSqrt(View view){
        try {
            resultNumber = Double.parseDouble(inputField.getText().toString());
            resultNumber = Math.sqrt(resultNumber);

            String str = inputField.getText().toString();
            str = "√" + str;
            inputField.setText(str);
        }
        catch (Exception e) {
            result.setText("Error");
        }
    }

    public void onClickEqual(View view){
        try{
            secondNumber = Double.parseDouble(inputField.getText().toString());

            switch (codeOp){
                case 0:
                    resultNumber = firstNumber + secondNumber;
                    break;
                case 1:
                    resultNumber = firstNumber * secondNumber;
                    break;
                case 2:
                    resultNumber = firstNumber - secondNumber;
                    break;
                case 3:
                    resultNumber = firstNumber / secondNumber;
                    break;
            }

            String res = String.valueOf(resultNumber);
            result.setText(res);
        }
        catch(Exception ignored) {}
    }

    public void onClickOnex(View view){
        try {
            resultNumber = Double.parseDouble(inputField.getText().toString());
            resultNumber = 1 / resultNumber;

            String str = inputField.getText().toString();
            str = "1/" + str;
            inputField.setText(str);
        }
        catch (Exception e) {
            result.setText("Error");
        }
    }
}