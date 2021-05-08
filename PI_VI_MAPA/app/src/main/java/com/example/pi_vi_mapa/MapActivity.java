package com.example.pi_vi_mapa;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/****
 * Criado em 05/05/2021
 * Por:Max Alexandre de Soza
 */

public class MapActivity  extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Lendo Mapa", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: Lendo o Mapa");
        mMap = googleMap;

    }

    private static final String TAG = "MapActivity2";


    private static final String FINE_LOCATTION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATTION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATTION_PERSSION_REQUEST_CODE = 1234;

    // Variaveis

    private Boolean mLocattionPermissionGranted = false;
    private GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        getLocationPermission();
    }

    private void initMap() {
        Log.d(TAG, "initMap: inicializando Mapa");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapActivity.this);


    }


    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission: Recebendo Permissao de Localização");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATTION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATTION) == PackageManager.PERMISSION_GRANTED) {
                mLocattionPermissionGranted = true;
            } else {
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATTION_PERSSION_REQUEST_CODE);


            }
        }
    }

    @Override
    public void onRequestPermissionsResul(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: chamando");
        mLocattionPermissionGranted = false;
        switch (requestCode) {
            case LOCATTION_PERSSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocattionPermissionGranted = false;
                            Log.d(TAG,"onRequestPermissionsResult: Falha na Permissão");
                            return;
                        }
                    }
                    Log.d(TAG,"onRequestPermissionsResult: Permissão  Concedida");

                    mLocattionPermissionGranted = true;

                    // Iniciando o Mapa
                    initMap();
                }
            }
        }
    }
}


