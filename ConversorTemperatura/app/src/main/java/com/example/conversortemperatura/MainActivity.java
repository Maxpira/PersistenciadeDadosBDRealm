 package com.example.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
    EditText et_tempC;
    Button bt_temperatura;
    TextView tv_tempF;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_tempC = findViewById(R.id.et_tempC);
        bt_temperatura = findViewById(R.id.bt_temperatura);
        tv_tempF = findViewById(R.id.tv_tempF);

        bt_temperatura.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             double tempC = Double.parseDouble(et_tempC.getText().toString());
              double tempF = tempC * 1.8 + 32;
               tv_tempF.setText(String.valueOf(tempF));
            }
        });
    }
}