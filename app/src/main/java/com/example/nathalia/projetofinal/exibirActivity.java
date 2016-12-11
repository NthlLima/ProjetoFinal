package com.example.nathalia.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class exibirActivity extends AppCompatActivity implements View.OnClickListener{
    private Controller ctrl;
    private ArrayList<String> dados;
    private TextView nomePerson, classePerson, racaPerson;
    private ImageView img;
    private FloatingActionButton fabEditar;
    private FloatingActionButton fabExcluir;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ctrl = new Controller(this);
        nomePerson = (TextView)findViewById(R.id.nomePerson);
        classePerson = (TextView)findViewById(R.id.classePerson);
        racaPerson = (TextView)findViewById(R.id.racaPerson);
        img = (ImageView)findViewById(R.id.imgHeader);
        fabExcluir = (FloatingActionButton)findViewById(R.id.fabExcluir);
        fabEditar = (FloatingActionButton)findViewById(R.id.fabEditar);

        Intent intent = getIntent();
        if(intent != null){
            Bundle b = intent.getExtras();
            if(b != null){
                String c, p;
                p = (b.getString("nome"));
                dados = ctrl.buscarPersonagem(p);
                nomePerson.setText(""+dados.get(0));
                classePerson.setText(""+dados.get(1));
                racaPerson.setText(""+dados.get(2));

                nome = dados.get(0);
                c = dados.get(1);
                if(("Mago").equals(c)){
                    img.setImageResource(R.drawable.heademage);
                } else if(("Guerreiro").equals(c)){
                    img.setImageResource(R.drawable.headewarrior);
                } else if(("Bárbaro").equals(c)){
                    img.setImageResource(R.drawable.headerbar);
                } else if(("Ranger").equals(c)){
                    img.setImageResource(R.drawable.headeranger);
                } else
                    img.setImageResource(R.drawable.headeno);

            } // if(b!= null) acaba aqui
        }

        fabExcluir.setOnClickListener(this);
        fabEditar.setOnClickListener(this);
    }


    public void onClick(View v) {
        if(v == fabExcluir){
           ctrl.excluirPerson(nome);
            finish();
        }
        if(v == fabEditar){
            Bundle b = new Bundle();
            Intent it = new Intent(this,EditActivity.class);
            it.putExtras(b);
            it.putExtra("nome",dados.get(0));
            it.putExtra("classe", dados.get(1));
            it.putExtra("raca", dados.get(2));
            startActivityForResult(it,0);
        }
    }

}
