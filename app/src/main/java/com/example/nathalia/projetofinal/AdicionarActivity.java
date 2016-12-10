package com.example.nathalia.projetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

public class AdicionarActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editNome;
    private Spinner spnRaca, spnClasse;
    private Button btnAdd;
    private ArrayAdapter<String> adpClasse, adpRaca;
    private Controller ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        ctrl = new Controller(this);

        editNome = (EditText)findViewById(R.id.editNome);
        spnRaca = (Spinner)findViewById(R.id.spnRaca);
        adpRaca = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adpRaca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        adpRaca.add("Humano");
        adpRaca.add("Sulfure");
        adpRaca.add("Anão");
        adpRaca.add("Dríade");
        spnRaca.setAdapter(adpRaca);

        spnClasse = (Spinner)findViewById(R.id.spnClasse);
        adpClasse = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adpClasse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adpClasse.add("Guerreiro");
        adpClasse.add("Bárbaro");
        adpClasse.add("Mago");
        adpClasse.add("Ranger");
        spnClasse.setAdapter(adpClasse);


        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v == btnAdd) {
            salvar();
            finish();
        }
    }

    public void salvar(){
        ArrayList<String> dados = new ArrayList<>();
        dados.add(editNome.getText().toString());
        dados.add(spnClasse.getSelectedItem().toString());
        dados.add(spnRaca.getSelectedItem().toString());
        ctrl.salvar(dados);
    }

}
