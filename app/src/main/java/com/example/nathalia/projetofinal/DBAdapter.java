package com.example.nathalia.projetofinal;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;


public class DBAdapter {

    public DBAdapter(Context ctx){
    }

    public void addPerson(ArrayList<String> dados){
        ContentValues data = new ContentValues();
        Personagem person = new Personagem();
        // ArrayList
        person.setNome(dados.get(0));
        person.setClasse(dados.get(1));
        person.setRaca(dados.get(2));
        // Data
        data.put("nome", person.getNome());
        data.put("classe", person.getClasse());
        data.put("raca", person.getRaca());
        //db.insert("Fichas",null,data);
    }



}
