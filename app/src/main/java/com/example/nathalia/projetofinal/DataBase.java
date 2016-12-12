package com.example.nathalia.projetofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {

    private static final String NOME_DB = "Personagens";
    private static final int VERSAO_DB = 9;

    public DataBase(Context ctx){
        super(ctx,NOME_DB,null,VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table Personagens(_id integer primary key autoincrement, nome text not null, classe text not null, posclasse integer not null, raca text not null, posraca integer not null, forca integer not null, des integer not null, cos integer not null, inte integer not null, sab integer not null, car integer not null);");

    }
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2){
        db.execSQL("drop table Personagens");
        onCreate(db);
    }


}