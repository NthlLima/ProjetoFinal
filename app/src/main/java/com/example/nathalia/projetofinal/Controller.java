package com.example.nathalia.projetofinal;

import android.content.Context;
import java.util.ArrayList;


public class Controller {
    private DBAdapter dbAdp;
    private PersonAdapter personAdp;

    public Controller(Context ctx){
        dbAdp = new DBAdapter(ctx);
    }

    public void salvar(ArrayList<String> dados){
       dbAdp.addPerson(dados);
    }

    public PersonAdapter buscarLista(Context context){
        return dbAdp.loadLista(context);
    }


    public ArrayList<String> buscarPersonagem(String nome){
        ArrayList<String> dados = new ArrayList<>();
        Personagem p = dbAdp.loadPerson(nome);
        dados.add(p.getNome());
        dados.add(p.getClasse());
        dados.add(p.getRaca());
        return dados;
    }

    public  void editPerson (String nome,ArrayList<String> newdados ){
        Personagem p = dbAdp.loadPerson(nome);
        if(p.getId() != 0){
            p.setNome(newdados.get(0));
            this.dbAdp.editPerson(p);

        }
    }

    public void excluirPerson (String nome){
        Personagem p = dbAdp.loadPerson(nome);
        this.dbAdp.excluirPerson(p);

    }

}
