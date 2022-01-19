package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button clear, divide, plus, minus, multiplication, equal, dot, zero, one, two, three, four, five, six, seven, eight, nine;
    TextView result, operation;
    String operator="";
    double x = 0;
    double y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        dot.setOnClickListener(this);
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("0");
                result.setText("0");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("/");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("-");
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("*");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIt();
            }
        });

    }




    private void init() {
        clear = findViewById(R.id.clear);
        divide = findViewById(R.id.divide);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiplication = findViewById(R.id.multiplication);
        equal = findViewById(R.id.equal);
        dot = findViewById(R.id.btndot);
        zero = findViewById(R.id.btn0);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        result = findViewById(R.id.result);
        operation = findViewById(R.id.operation);


    }

    @Override
    public void onClick(View v) {
        setOperationText(((Button)v).getText());
    }

    private void setOperationText(CharSequence text) {
        if (operation.getText().toString().trim().equals("0") && text.equals(".")) {
            operation.setText("0.");

        } else if (operation.getText().toString().trim().equals("0")) {
            operation.setText(text);

        } else {
            operation.setText(String.format("%s%s", operation.getText().toString().trim(), text));
        }


    }

    private void setOperation(String s) {
        if (Double.parseDouble(result.getText().toString()) != 0 && Double.parseDouble(operation.getText().toString())
                != 0 && !operator.isEmpty()) {
            doIt();


        }


        result.setText(operation.getText().toString());
        x = Double.parseDouble(operation.getText().toString());
        operator = s;
        operation.setText("0");

    }

    private void doIt() {
        if (!operator.isEmpty()) {

            y = Double.parseDouble(operation.getText().toString());
            switch (operator.charAt(0)) {
                case '/':
                    operation.setText(String.format("%s", x / y));
                    break;

                case '+':
                    operation.setText(String.format("%s", x + y));
                    break;

                case '-':
                    operation.setText(String.format("%s", x - y));
                    break;

                case '*':
                    operation.setText(String.format("%s", x * y));
                    break;

                default:
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

            }
            result.setText("0");
            operator="";


        }

    }
}
