package com.example.nathalia.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editNome;
    private Spinner editClasse, editRaca;
    private FloatingActionButton fabSalvar;
    private Controller ctrl;
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ctrl = new Controller(this);

        editNome = (EditText)findViewById(R.id.editNome);
        editClasse = (Spinner) findViewById(R.id.editClasse);
        editClasse.setAdapter(ctrl.setClasses(this));
        editRaca = (Spinner)findViewById(R.id.editRaca);
        editRaca.setAdapter(ctrl.setRacas(this));


        fabSalvar = (FloatingActionButton)findViewById(R.id.fabSalvar);
        fabSalvar.setOnClickListener(this);


        Intent intent = getIntent();
        if(intent != null){
            Bundle b = intent.getExtras();
            if(b != null){
                nome = b.getString("nome");
                editNome.setText(nome);
                //int c = setClasse(b.getString("classe"));
                editClasse.setSelection(b.getInt("posclasse"));
                //int r = setRaca(b.getString("raca"));
                editRaca.setSelection(b.getInt("posraca"));
            }
        }


    }

    public void onClick(View v) {
        if(v == fabSalvar){
            ArrayList<String> dados = new ArrayList<>();
            ArrayList<Integer> posicoes = new ArrayList<>();
            dados.add(editNome.getText().toString());
            dados.add(editClasse.getSelectedItem().toString());
            dados.add(editRaca.getSelectedItem().toString());
            posicoes.add(editClasse.getSelectedItemPosition());
            posicoes.add(editRaca.getSelectedItemPosition());

            ctrl.editPerson(nome, dados, posicoes);
            Bundle b = new Bundle();
            Intent it = new Intent(this,exibirActivity.class);
            it.putExtras(b);
            it.putExtra("nome",nome);
            startActivityForResult(it,0);
            finish();
        }
    }


}
