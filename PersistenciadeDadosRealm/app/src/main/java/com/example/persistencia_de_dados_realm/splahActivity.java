package com.example.persistencia_de_dados_realm;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class splahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);

   getSupportActionBar().hide();
   getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
          startActivity( new Intent(getBaseContext(), MainActivity.class));
          finish();
        }
    }, 5000);

    }


}