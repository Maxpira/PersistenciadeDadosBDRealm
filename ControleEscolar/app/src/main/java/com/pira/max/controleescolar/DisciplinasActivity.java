package com.pira.max.controleescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pira.max.controleescolar.adapter.DisciplinaAdapter;
import com.pira.max.controleescolar.domain.Discipina;

public class DisciplinasActivity  extends AppCompatActivity {
    private  Realm realm;
    private RealmResults<Discipina> discipinas;
    private ListView lwDisciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);

        realm = Realm.getInstance(this);
        discipinas = realm.where(Discipina.class).findAll();

        lwDisciplinas = (ListView) findViewById(R.id.lw_disciplinas);
        lwDisciplinas.setAdapter(new DisciplinaAdapter(this, discipinas, true));
    }

    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }
    // Listener
     @Override public void callAddDisciplina(View view){
         Intent it = new Intent( this, AddUpdateDisciplinaActivity.class);
         startActivity(it);
     }
}
