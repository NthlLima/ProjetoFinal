package com.example.nathalia.projetofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBAdapter {
    private SQLiteDatabase db;

    public DBAdapter(Context ctx){
        DataBase auxdb = new DataBase(ctx);
        db = auxdb.getWritableDatabase();
    }

    public void addPerson(ArrayList<String> dados){
        ContentValues data = new ContentValues();
        Personagem person = new Personagem();
        // ArrayList
        person.setNome(dados.get(0));
        person.setClasse(dados.get(1));
        String c = dados.get(1);
        person.setRaca(dados.get(2));
        // Data
        data.put("nome", person.getNome());
        data.put("classe", person.getClasse());
        data.put("raca", person.getRaca());
        db.insert("Personagens",null,data);
    }


    public  void editPerson(Personagem p){
        ContentValues data = new ContentValues();
        data.put("nome", p.getNome());
        data.put("classe", p.getClasse());
        data.put("raca", p.getRaca());
        long id = p.getId();
        String _id = String.valueOf(id);
        db.update("Personagens", data, "_id=?",new String[]{_id});
    }


    public void excluirPerson(Personagem p){
        db.delete("Personagens", "_id = "+p.getId(), null);
    }


    public PersonAdapter loadLista(Context context){
        PersonAdapter adaptador = new PersonAdapter(context,new ArrayList<Personagem>());
        Cursor c = load();
        if(c.getCount() > 0){
            c.moveToFirst();
            do{
                Personagem p = new Personagem();
                p.setId(c.getLong(0));
                p.setNome(c.getString(1));
                p.setClasse(c.getString(2));
                p.setRaca(c.getString(3));
                adaptador.add(p);
            }while(c.moveToNext());
        };
        return adaptador;
    }

    public Personagem loadPerson(String nome){
        Personagem p = new Personagem();
        Cursor c = load();
        if(c.getCount() > 0){
            c.moveToFirst();
            do{
                p.setId(c.getLong(0));
                p.setNome(c.getString(1));
                p.setClasse(c.getString(2));
                p.setRaca(c.getString(3));
                String n = p.getNome();
                if((n).equals(nome)){
                    break;
                }
            }while(c.moveToNext());
        };
        return p;
    }




    public Cursor load() {
        final Cursor c = db.query("Personagens",null,null,null,null,null,null);
        return c;
    }

}
