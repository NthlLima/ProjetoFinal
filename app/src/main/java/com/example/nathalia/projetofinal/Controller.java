package com.example.nathalia.projetofinal;

import android.content.Context;
import java.util.ArrayList;


public class Controller {
    private DBAdapter dbAdp;

    public Controller(Context ctx){
        dbAdp = new DBAdapter(ctx);
    }

    public void salvar(ArrayList<String> dados){
       dbAdp.addPerson(dados);
    }

}
