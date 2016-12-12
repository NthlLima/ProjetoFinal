package com.example.nathalia.projetofinal;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class Controller {
    private DBAdapter dbAdp;
    private Adaptadores adp;

    public Controller(Context ctx){
        dbAdp = new DBAdapter(ctx);
        adp = new Adaptadores(ctx);
    }


    public ArrayAdapter<String> setClasses(Context ctx){
        return adp.setClasses(ctx);
    }

    public ArrayAdapter<String> setRacas(Context ctx){
        return adp.setRacas(ctx);
    }

    public void salvar(ArrayList<String> dados, ArrayList<Integer> dadosint){
       dbAdp.addPerson(dados,dadosint);
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

    public ArrayList<Integer> buscarInt(String nome){
        ArrayList<Integer> inteiros = new ArrayList<>();
        Personagem p = dbAdp.loadPerson(nome);
        inteiros.add(p.getPosClasse());
        inteiros.add(p.getPosRaca());
        inteiros.add(p.getForc());
        inteiros.add(p.getDes());
        inteiros.add(p.getCos());
        inteiros.add(p.getInte());
        inteiros.add(p.getSab());
        inteiros.add(p.getCar());
        return inteiros;
    }

    public  void editPerson (String nome,ArrayList<String> newdados, ArrayList<Integer> newpos ){
        dbAdp.editPerson(nome,newdados,newpos);
    }

    public void excluirPerson (String nome){
        this.dbAdp.excluirPerson(nome);

    }


    public int imgHeader(int p){

        int imgs[] = adp.setImg;
        return imgs[p];
    }

}
