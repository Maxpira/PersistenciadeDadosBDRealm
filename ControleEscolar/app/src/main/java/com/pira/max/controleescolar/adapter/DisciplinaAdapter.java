package com.pira.max.controleescolar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.pira.max.controleescolar.AddUpdateDisciplinaActivity;
import com.pira.max.controleescolar.R;
import com.pira.max.controleescolar.domain.Discipina;

import java.util.zip.Inflater;

import io.realm.Realm;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

public class DisciplinaAdapter  extends RealmBaseAdapter<Discipina> implements ListAdapter {

    public  DisciplinaAdapter(Context  context, RealmResults<Discipina> realmResults, boolean  automaticUpdate){
     super( context, realmResults, automaticUpdate);

    }


    public View getView(int position, View convertView, ViewGroup parent, Inflater inflater, String context){

        CustonWiewHolder holder;
        if (convertView == null ){
            convertView = inflater.inflate(R.layout.item_disciplina, parent, false);
            holder = new CustonWiewHolder();
            convertView.setTag(holder);


            holder.twNome = (TextView) convertView.findViewById(R.id.tw_nome);
            holder.btUpdate = (Button) convertView.findViewById(R.id.bt_update);
            holder.btRemove = (Button) convertView.findViewById(R.id.btRemove);

        }
        else{

            holder = (CustonWiewHolder) convertView.getTag();

        }


      final   Discipina d = realmResult.get(position);
        holder.btUpdate.setText(d.getNome());


        holder.btUpdate.setOnClickListener(new View.OnClickListener() {
                      @Override
            public void onClick(View v) {
                Intent it = new Intent( context,  AddUpdateDisciplinaActivity.class);
                it.putExtra(Discipina.ID, d.getId());
                context.startActivity(it);
            }
        });

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm realm = Realm.getInstance(context);
                realm.beginTransaction();
                d.removeFromRealm();
                realm.commitTransaction();
                realm.close();
            }
        });

        return convertView;
    }

    private static class CustonWiewHolder{
        TextView twNome;
        Button btUpdate;
        Button btRemove;


    }
}
