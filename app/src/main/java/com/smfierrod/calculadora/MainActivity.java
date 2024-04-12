package com.smfierrod.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner selectOperation;
    TextView txtNumber1;
    TextView txtNumber2;
    Button btnCompute;
    TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        selectOperation = findViewById(R.id.selectOperation);
        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        btnCompute = findViewById(R.id.btnCompute);
        lblResult = findViewById(R.id.lblResult);


        final List<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");

        ArrayAdapter<String> adp1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);

        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectOperation.setAdapter(adp1);
    }

    public void onClick(View view) {
        String number1 = txtNumber1.getText().toString();
        String number2 = txtNumber2.getText().toString();
        String operation = selectOperation.getSelectedItem().toString();
        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(this, "Ingresa los dos numeros", Toast.LENGTH_SHORT).show();
            return;
        }
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        lblResult.setText("Result: " + result);
    }
}