package com.example.nathalia.projetofinal;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Personagem> {
    private Context context;
    private ArrayList<Personagem> listPerson;

    public PersonAdapter(Context context, ArrayList<Personagem> person){
        super(context,0,person);
        this.listPerson = person;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Personagem p = getItem(position);
        if(convertView == null){
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.listperson,parent,false);
        }
        TextView nome = (TextView)convertView.findViewById(R.id.personNome);
        TextView raca = (TextView)convertView.findViewById(R.id.personRaca);
        TextView classe = (TextView)convertView.findViewById(R.id.personClasse);
        ImageView img = (ImageView)convertView.findViewById(R.id.imagePerson);


        nome.setText(p.getNome());
        raca.setText(p.getRaca());
        classe.setText(p.getClasse());

        String c = p.getClasse();
        if(("Mago").equals(c)){
            img.setImageResource(R.drawable.mage);
        } else if(("Guerreiro").equals(c)){
            img.setImageResource(R.drawable.warrior);
        } else if(("Bárbaro").equals(c)){
            img.setImageResource(R.drawable.barbarian);
        } else if(("Ranger").equals(c)){
            img.setImageResource(R.drawable.ranger);
        } else
            img.setImageResource(R.drawable.unknown);


        return convertView;
    }

    public String getPosition(int position) {
        Personagem p;
        String person;
        p = this.getItem(position);
        person = p.getNome();
        return person;
    }
}