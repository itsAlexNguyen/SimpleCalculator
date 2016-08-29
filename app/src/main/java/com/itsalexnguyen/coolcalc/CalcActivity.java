package com.itsalexnguyen.coolcalc;

import android.app.Activity;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    //TextView Outlets
    TextView resultView;

    public enum Operation {
        ADD, SUBSTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    //Variables
    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        //Button Outlets
        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        Button threeBtn = (Button) findViewById(R.id.threeBtn);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) findViewById(R.id.sixBtn);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        Button nineBtn = (Button) findViewById(R.id.nineBtn);
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);
        Button clearBtn = (Button) findViewById(R.id.clearBtn);

        //Image Button Outlets
        ImageButton calcBtn = (ImageButton) findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multiplyBtn);
        ImageButton subtractcBtn = (ImageButton) findViewById(R.id.subtractBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);

        resultView = (TextView) findViewById(R.id.resultsTxt);

        //Set the text to empty
        resultView.setText("0");


        oneBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(1);
            }
        });
        twoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(2);
            }
        });
        threeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });
        fourBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });
        fiveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });
        sixBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });
        sevenBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });
        eightBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });
        nineBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });
        zeroBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });
        subtractcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBSTRACT);
            }
        });
        multiplyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);
            }
        });
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                processOperation(Operation.EQUAL);
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                leftValueStr = "";
                rightValueStr = "";
                runningNumber = "";
                currentOperation = null;
                resultView.setText("0");
            }
        });
    }
    void processOperation(Operation operation) {
        if (currentOperation != null){
            if (runningNumber != "") {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBSTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }
                leftValueStr = String.valueOf(result);
                resultView.setText(leftValueStr);
            }
        } else {
            leftValueStr = runningNumber;
            runningNumber = "";
        }

        currentOperation = operation;
    }
    void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultView.setText(runningNumber);
    }
}
