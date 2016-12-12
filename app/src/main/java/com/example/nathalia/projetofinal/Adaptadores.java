package com.example.nathalia.projetofinal;


import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Adaptadores {

    public Adaptadores(Context context){}

    public ArrayAdapter<String> setClasses(Context ctx){
        ArrayAdapter<String> classes = new ArrayAdapter<String> (ctx, android.R.layout.simple_spinner_dropdown_item);
        classes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classes.add("Guerreiro");
        classes.add("Bárbaro");
        classes.add("Mago");
        classes.add("Ranger");
        return classes;
    }

    public ArrayAdapter<String> setRacas(Context ctx){
        ArrayAdapter<String> racas = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_dropdown_item);
        racas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        racas.add("Humano");
        racas.add("Sulfure");
        racas.add("Anão");
        racas.add("Dríade");

        return racas;
    }


    public  int[] setImg = new int[]{
            R.drawable.headewarrior,
            R.drawable.headerbar,
            R.drawable.heademage,
            R.drawable.headeranger
    };
}
