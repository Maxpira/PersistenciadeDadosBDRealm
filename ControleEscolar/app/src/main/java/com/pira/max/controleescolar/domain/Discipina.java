package com.pira.max.controleescolar.domain;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Discipina  extends RealmObject {
    public static final String ID = "com.pira.max.controleescolar.domain.RealmObject.ID";
    @Index
    @Required
    @PrimaryKey
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome == null ? "" : nome;
    }

    public void setNome(String nome) {

    }
}
