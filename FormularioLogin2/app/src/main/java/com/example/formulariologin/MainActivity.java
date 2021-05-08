package com.example.formulariologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_nome, et_senha;
    Button bt_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome = findViewById(R.id.et_nome);
        et_senha = findViewById(R.id.et_senha);
        bt_login = findViewById(R.id.bt_login);


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = et_nome.getText().toString();
                String senha = et_senha.getText().toString();


                if (nome.equals("user") && senha.equals("pass")) {
                    Toast.makeText(MainActivity.this, "Acesso Válido!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (MainActivity.this, MainActivity2.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(MainActivity.this,"Acesso Inválido!", Toast.LENGTH_SHORT).show();

                }
                et_nome.setText("");
                et_senha.setText("");
            }


        });
    }
}