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

    public void addPerson(ArrayList<String> dados, ArrayList<Integer> dadosint){
        ContentValues data = new ContentValues();
        Personagem person = new Personagem();
        // ArrayList
        person.setNome(dados.get(0));
        person.setClasse(dados.get(1));
        person.setPosClasse(dadosint.get(0));
        person.setRaca(dados.get(2));
        person.setPosRaca(dadosint.get(1));
        person.setForc(dadosint.get(2));
        person.setDes(dadosint.get(3));
        person.setCos(dadosint.get(4));
        person.setInte(dadosint.get(5));
        person.setSab(dadosint.get(6));
        person.setCar(dadosint.get(7));
        // Data
        data.put("nome", person.getNome());
        data.put("classe", person.getClasse());
        data.put("posclasse", person.getPosClasse());
        data.put("raca", person.getRaca());
        data.put("posraca", person.getPosRaca());
        data.put("forca", person.getForc());
        data.put("des", person.getDes());
        data.put("cos", person.getCos());
        data.put("inte", person.getInte());
        data.put("sab", person.getSab());
        data.put("car", person.getCar());
        db.insert("Personagens",null,data);
    }


    public  void editPerson(String nome, ArrayList<String> newdados, ArrayList<Integer> newint){
        ContentValues data = new ContentValues();
        Personagem p = this.loadPerson(nome);
        if(p.getId() != 0) {
            // ArrayList
            p.setNome(newdados.get(0));
            p.setClasse(newdados.get(1));
            p.setPosClasse(newint.get(0));
            p.setRaca(newdados.get(2));
            p.setPosRaca(newint.get(1));
            p.setForc(newint.get(2));
            p.setDes(newint.get(3));
            p.setCos(newint.get(4));
            p.setInte(newint.get(5));
            p.setSab(newint.get(6));
            p.setCar(newint.get(7));


            //Data
            data.put("nome", p.getNome());
            data.put("classe", p.getClasse());
            data.put("posclasse", p.getPosClasse());
            data.put("raca", p.getRaca());
            data.put("posraca", p.getPosRaca());
            data.put("forca", p.getForc());
            data.put("des", p.getDes());
            data.put("cos", p.getCos());
            data.put("inte", p.getInte());
            data.put("sab", p.getSab());
            data.put("car", p.getCar());
            long id = p.getId();
            String _id = String.valueOf(id);
            db.update("Personagens", data, "_id=?", new String[]{_id});
        }
    }


    public void excluirPerson(String nome){
        Personagem p = this.loadPerson(nome);
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
                p.setPosClasse(c.getInt(3));
                p.setRaca(c.getString(4));
                p.setPosRaca(c.getInt(5));
                p.setForc(c.getInt(6));
                p.setDes(c.getInt(7));
                p.setCos(c.getInt(8));
                p.setInte(c.getInt(9));
                p.setSab(c.getInt(10));
                p.setCar(c.getInt(11));
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
                p.setPosClasse(c.getInt(3));
                p.setRaca(c.getString(4));
                p.setPosRaca(c.getInt(5));
                p.setForc(c.getInt(6));
                p.setDes(c.getInt(7));
                p.setCos(c.getInt(8));
                p.setInte(c.getInt(9));
                p.setSab(c.getInt(10));
                p.setCar(c.getInt(11));
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
