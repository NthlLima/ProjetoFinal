package com.example.nathalia.projetofinal;

public class Personagem {
    private long id;
    private String nome;
    private String classe;
    private String raca;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse(){ return classe; }
    public void setClasse(String classe){ this.classe = classe; }
    public String getRaca(){ return raca; }
    public void setRaca(String raca){ this.raca = raca; }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}