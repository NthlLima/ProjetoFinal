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
    private ArrayList<Integer> inteiros;
    private TextView nomePerson, classePerson, racaPerson, forPerson, modforca, desPerson, moddes,cosPerson, modcos, intPerson, modint, sabPerson, modsab, carPerson, modcar;
    private ImageView img;
    private FloatingActionButton fabEditar;
    private FloatingActionButton fabExcluir;
    private String nome;
    private int i;


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
        forPerson = (TextView)findViewById(R.id.forPerson);
        modforca = (TextView)findViewById(R.id.modforca);
        desPerson = (TextView)findViewById(R.id.desPerson);
        moddes = (TextView)findViewById(R.id.moddes);
        cosPerson = (TextView)findViewById(R.id.cosPerson);
        modcos = (TextView)findViewById(R.id.modcos);
        intPerson = (TextView)findViewById(R.id.intPerson);
        modint = (TextView)findViewById(R.id.modint);
        sabPerson = (TextView)findViewById(R.id.sabPerson);
        modsab = (TextView)findViewById(R.id.modsab);
        carPerson = (TextView)findViewById(R.id.carPerson);
        modcar = (TextView)findViewById(R.id.modcar);

        img = (ImageView)findViewById(R.id.imgHeader);
        fabExcluir = (FloatingActionButton)findViewById(R.id.fabExcluir);
        fabEditar = (FloatingActionButton)findViewById(R.id.fabEditar);

        Intent intent = getIntent();
        if(intent != null){
            Bundle b = intent.getExtras();
            if(b != null){
                String p;
                int h;
                p = (b.getString("nome"));
                dados = ctrl.buscarPersonagem(p);
                inteiros = ctrl.buscarInt(p);
                nomePerson.setText(""+dados.get(0));
                classePerson.setText(""+dados.get(1));
                racaPerson.setText(""+dados.get(2));

                forPerson.setText(""+inteiros.get(2));
                modforca.setText(""+setMod(inteiros.get(2)));

                desPerson.setText(""+inteiros.get(3));
                moddes.setText(""+setMod(inteiros.get(3)));

                cosPerson.setText(""+inteiros.get(4));
                modcos.setText(""+setMod(inteiros.get(4)));

                intPerson.setText(""+inteiros.get(5));
                modint.setText(""+setMod(inteiros.get(5)));

                sabPerson.setText(""+inteiros.get(6));
                modsab.setText(""+setMod(inteiros.get(6)));

                carPerson.setText(""+inteiros.get(7));
                modcar.setText(""+setMod(inteiros.get(7)));

                nome = dados.get(0);
                h = (inteiros.get(0));
                i = ctrl.imgHeader(h);
                img.setImageResource(i);
            } // if(b!= null) acaba aqui
        }

        fabExcluir.setOnClickListener(this);
        fabEditar.setOnClickListener(this);
    }

    private String setMod(int i){
        int m = (i - 10) / 2;
        String mod;
        if(m > 0) {
            mod = ("+" + m);
        }
        else
            mod = Integer.toString(m);
        return mod;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = getIntent();
        if(intent != null){
            Bundle b = intent.getExtras();
            if(b != null){
                String p;
                int h;
                p = (b.getString("nome"));
                dados = ctrl.buscarPersonagem(p);
                inteiros = ctrl.buscarInt(p);
                nomePerson.setText(""+dados.get(0));
                classePerson.setText(""+dados.get(1));
                racaPerson.setText(""+dados.get(2));

                forPerson.setText(""+inteiros.get(2));
                modforca.setText(""+setMod(inteiros.get(2)));

                desPerson.setText(""+inteiros.get(3));
                moddes.setText(""+setMod(inteiros.get(3)));

                cosPerson.setText(""+inteiros.get(4));
                modcos.setText(""+setMod(inteiros.get(4)));

                intPerson.setText(""+inteiros.get(5));
                modint.setText(""+setMod(inteiros.get(5)));

                sabPerson.setText(""+inteiros.get(6));
                modsab.setText(""+setMod(inteiros.get(6)));

                carPerson.setText(""+inteiros.get(7));
                modcar.setText(""+setMod(inteiros.get(7)));

                nome = dados.get(0);
                h = (inteiros.get(0));
                i = ctrl.imgHeader(h);
                img.setImageResource(i);

            } // if(b!= null) acaba aqui
        }
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
            it.putExtra("posclasse", inteiros.get(0));
            it.putExtra("posraca", inteiros.get(1));
            it.putExtra("forca", inteiros.get(2));
            it.putExtra("des", inteiros.get(3));
            it.putExtra("cos", inteiros.get(4));
            it.putExtra("inte", inteiros.get(5));
            it.putExtra("sab", inteiros.get(6));
            it.putExtra("car", inteiros.get(7));
            finish();
            startActivityForResult(it,0);
        }
    }

}
