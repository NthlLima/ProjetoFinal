package com.example.nathalia.projetofinal;

public class Personagem {
    private long id;
    private String nome;
    private String classe;
    private String raca;
    private int posClasse, posRaca;
    private int forc, des, cos, inte, sab, car;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse(){ return classe; }
    public void setClasse(String classe){ this.classe = classe; }
    public int getPosClasse(){
        return posClasse;
    }
    public void setPosClasse(int posClasse){
        this.posClasse = posClasse;
    }
    public String getRaca(){ return raca; }
    public void setRaca(String raca){ this.raca = raca; }
    public int getPosRaca(){return posRaca;}
    public void setPosRaca(int posRaca) { this.posRaca = posRaca;}
    public int getForc() {return forc;}
    public void setForc(int forc) {this.forc = forc;}
    public int getDes() {return des;}
    public void setDes(int des) {this.des = des;}
    public int getCos() { return cos;}
    public void setCos(int cos) {this.cos = cos;}
    public int getInte() {return inte;}
    public void setInte(int inte) {this.inte = inte;}
    public int getSab() { return sab;}
    public void setSab(int sab) { this.sab = sab;}
    public int getCar() {return car;}
    public void setCar(int car) {this.car = car;}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}