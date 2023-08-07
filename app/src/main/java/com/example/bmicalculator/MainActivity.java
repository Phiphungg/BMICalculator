package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvBmi, tvInfo;
    EditText editHeight, editWeight;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectView();

        btn.setOnClickListener(this);
    }

    private void connectView() {
        btn = (Button) findViewById(R.id.btnResult);
        editHeight = (EditText) findViewById(R.id.editInput1);
        editWeight = (EditText) findViewById(R.id.editInput2);
        tvBmi = (TextView) findViewById(R.id.tvBMI);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }


    @Override
    public void onClick(View view) {
        try {
            double height = Double.parseDouble(editHeight.getText().toString());
            double weight = Double.parseDouble(editWeight.getText().toString());
            DecimalFormat df = new DecimalFormat("0.00");
            double BMI = weight / Math.pow(height, 2) * 10000;
            switch (view.getId()) //lấy id của các Button
            {
                case R.id.btnResult:
                    tvBmi.setText(df.format(BMI) + "");
                    if (BMI < 18.5)
                        tvInfo.setText("You are categorized as underweight");
                    else if (BMI < 24.9)
                        tvInfo.setText("You are categorized as normal weight");
                    else if (BMI < 29.9)
                        tvInfo.setText("You are categorized as overweight");
                    else if (BMI < 34.9)
                        tvInfo.setText("You are categorized as obese class I");
                    else if (BMI < 39.9)
                        tvInfo.setText("You are categorized as obese class II");
                    else if (39.9 <= BMI)
                        tvInfo.setText("You are categorized as obese class III");
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Input Info, please!", Toast.LENGTH_SHORT).show();
        }
    }
}




