package com.example.nathalia.projetofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    private static final String NOME_DB = "Fichas";
    private static final int VERSAO_DB = 4;

    public DataBase(Context ctx){
        super(ctx,NOME_DB,null,VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table Fichas(_id integer primary key autoincrement, nome text not null, classe text not null, raca text not null);");

    }
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2){
        db.execSQL("drop table Fichas");
        onCreate(db);
    }


}