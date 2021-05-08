package com.example.pi_vi_mapa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (isServicesOk()){

        }
    }

    public void init(){
        Button btnMapa = (Button) findViewById(R.id.btnMapa);
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MapActivity.class);
                startActivity(intent);
            }
        });

    }
    public boolean isServicesOk(){
        Log.d(TAG, "isServicesOk: checando  a versão do google services");
        int avalible = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity2.this);
        if (avalible == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServiceOk: O serviço Google Play esta ativo");
            return true;

        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(avalible)) {
            Log.d(TAG, "isServiceOk: Um erro ocorreu mas nos iremos concerta-lo");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity2.this, avalible, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this,"você não pode fazer solicitações de mapas", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}