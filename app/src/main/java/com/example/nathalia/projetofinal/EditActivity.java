package com.example.nathalia.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editNome;
    private Spinner editClasse, editRaca;
    private FloatingActionButton fabSalvar;
    private Controller ctrl;
    private String nome;
    // Tabela de Habilidades
    private ImageButton btnFLeft, btnDLeft, btnCoLeft, btnILeft, btnSLeft, btnCaLeft ;
    private ImageButton btnFRight, btnDRight, btnCoRight, btnIRight, btnSRight, btnCaRight;
    private TextView numFOR, numDES, numCOS, numINT, numSAB, numCAR;
    private TextView numTotalM, numModF, numModD, numModCo, numModI, numModS, numModCa;

    private int modTotal=15, numF=10, numD=10, numCo=10, numI=10, numS=10, numCa=10;
    private int modF, modD, modCo, modI, modS, modCa;



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

        //Tabela de Habilidades
        //Botões
        btnFLeft = (ImageButton)findViewById(R.id.btnFLeft);
        btnFRight = (ImageButton)findViewById(R.id.btnFRight);
        btnDLeft = (ImageButton)findViewById(R.id.btnDLeft);
        btnDRight = (ImageButton)findViewById(R.id.btnDRight);
        btnCoLeft = (ImageButton)findViewById(R.id.btnCoLeft);
        btnCoRight = (ImageButton)findViewById(R.id.btnCoRight);
        btnILeft = (ImageButton)findViewById(R.id.btnILeft);
        btnIRight = (ImageButton)findViewById(R.id.btnIRight);
        btnSLeft = (ImageButton)findViewById(R.id.btnSLeft);
        btnSRight = (ImageButton)findViewById(R.id.btnSRight);
        btnCaLeft = (ImageButton)findViewById(R.id.btnCaLeft);
        btnCaRight = (ImageButton)findViewById(R.id.btnCaRight);

        // Textos de num
        numTotalM = (TextView)findViewById(R.id.numTotalM);
        numFOR = (TextView)findViewById(R.id.numFOR);
        numModF = (TextView)findViewById(R.id.numModF);
        numDES = (TextView)findViewById(R.id.numDES);
        numModD = (TextView)findViewById(R.id.numModD);
        numCOS = (TextView)findViewById(R.id.numCOS);
        numModCo = (TextView)findViewById(R.id.numModCo);
        numINT = (TextView)findViewById(R.id.numINT);
        numModI = (TextView)findViewById(R.id.numModI);
        numSAB = (TextView)findViewById(R.id.numSAB);
        numModS = (TextView)findViewById(R.id.numModS);
        numCAR = (TextView)findViewById(R.id.numCAR);
        numModCa = (TextView)findViewById(R.id.numModCa);

        //Clique button
        btnFLeft.setOnClickListener(this);
        btnFRight.setOnClickListener(this);
        btnDLeft.setOnClickListener(this);
        btnDRight.setOnClickListener(this);
        btnCoLeft.setOnClickListener(this);
        btnCoRight.setOnClickListener(this);
        btnILeft.setOnClickListener(this);
        btnIRight.setOnClickListener(this);
        btnSLeft.setOnClickListener(this);
        btnSRight.setOnClickListener(this);
        btnCaLeft.setOnClickListener(this);
        btnCaRight.setOnClickListener(this);




        Intent intent = getIntent();
        if(intent != null){
            Bundle b = intent.getExtras();
            if(b != null){
                nome = b.getString("nome");
                editNome.setText(nome);
                editClasse.setSelection(b.getInt("posclasse"));
                editRaca.setSelection(b.getInt("posraca"));
                numF = (b.getInt("forca"));
                numD = (b.getInt("des"));
                numCo = (b.getInt("cos"));
                numI = (b.getInt("inte"));
                numS = (b.getInt("sab"));
                numCa = (b.getInt("car"));

                // Set Texto
                numTotalM.setText("0");
                numFOR.setText(""+numF);
                numModF.setText("0"+setMod(numF));
                numDES.setText(""+numD);
                numModD.setText("0"+setMod(numD));
                numCOS.setText(""+numCo);
                numModCo.setText("0"+setMod(numCo));
                numINT.setText(""+numI);
                numModI.setText("0"+setMod(numI));
                numSAB.setText(""+numS);
                numModS.setText("0"+setMod(numS));
                numCAR.setText(""+numCa);
                numModCa.setText("0"+setMod(numCa));
            }
        }


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



    public void onClick(View v) {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setNeutralButton("OK", null);
        if(v == fabSalvar){

            if((editNome.getText().toString()).equals("")){
                dlg.setMessage("Campos em branco");
                dlg.show();
            }
            else{
                if (modTotal == 0) {
                    editar();
                    Bundle b = new Bundle();
                    Intent it = new Intent(this,exibirActivity.class);
                    it.putExtras(b);
                    it.putExtra("nome",nome);
                    startActivityForResult(it,0);
                    finish();
                }
                else{
                    dlg.setMessage("Pontos de Habilidades Restantes");
                    dlg.show();
                }

            }

        }


        //Tabela de Habilidades
        if(v == btnFLeft || v == btnFRight){
            //FORÇA
            if (v == btnFLeft) {
                if (numF < 0 || numF == 0) {
                    numF = 0;

                } else {
                    numF = numF - 1;
                    modF = (numF - 10) / 2;
                    modTotal = modTotal + 1;
                    numTotalM.setText("" + modTotal);
                    if (numF < 10) {
                        numFOR.setText("0" + numF);
                        numModF.setText("" + modF);
                    } else if (numF > 9) {
                        numFOR.setText("" + numF);
                        numModF.setText("+" + modF);
                    }
                }
            } else if (v == btnFRight && modTotal > 0 && numF < 18) {
                numF = numF + 1;
                modF = (numF - 10) / 2;
                modTotal = modTotal - 1;
                numTotalM.setText("" + modTotal);
                if (numF < 10) {
                    numFOR.setText("0" + numF);
                    numModF.setText("" + modF);
                } else if (numF > 9) {
                    numFOR.setText("" + numF);
                    numModF.setText("+" + modF);
                }
            }
        }

        else if(v == btnDLeft || v == btnDRight) {
            // DESTREZA
            if (v == btnDLeft) {
                if (numD < 0 || numD == 0) {
                    numD = 0;

                } else {
                    numD = numD - 1;
                    modD = (numD - 10) / 2;
                    modTotal = modTotal + 1;
                    numTotalM.setText("" + modTotal);
                    if (numD < 10) {
                        numDES.setText("0" + numD);
                        numModD.setText("" + modD);
                    } else if (numD > 9) {
                        numDES.setText("" + numD);
                        numModD.setText("+" + modD);
                    }
                }
            } else if (v == btnDRight && modTotal > 0 && numD < 18) {
                numD = numD + 1;
                modD = (numD - 10) / 2;
                modTotal = modTotal - 1;
                numTotalM.setText("" + modTotal);
                if (numD < 10) {
                    numDES.setText("0" + numD);
                    numModD.setText("" + modD);
                } else if (numD > 9) {
                    numDES.setText("" + numD);
                    numModD.setText("+" + modD);
                }
            }

        }
        else if(v == btnCoLeft || v == btnCoRight) {
            // CONSTITUIÇÃO
            if (v == btnCoLeft) {
                if (numCo < 0 || numCo == 0) {
                    numCo = 0;

                } else {
                    numCo = numCo - 1;
                    modCo = (numCo - 10) / 2;
                    modTotal = modTotal + 1;
                    numTotalM.setText("" + modTotal);
                    if (numCo < 10) {
                        numCOS.setText("0" + numCo);
                        numModCo.setText("" + modCo);
                    } else if (numCo > 9) {
                        numCOS.setText("" + numCo);
                        numModCo.setText("+" + modCo);
                    }
                }
            } else if (v == btnCoRight && modTotal > 0 && numCo < 18) {
                numCo = numCo + 1;
                modCo = (numCo - 10) / 2;
                modTotal = modTotal - 1;
                numTotalM.setText("" + modTotal);
                if (numCo < 10) {
                    numCOS.setText("0" + numCo);
                    numModCo.setText("" + modCo);
                } else if (numCo > 9) {
                    numCOS.setText("" + numCo);
                    numModCo.setText("+" + modCo);
                }
            }

        }
        else if(v == btnILeft || v == btnIRight) {
            // INTELIGÊNCIA
            if (v == btnILeft) {
                if (numI < 0 || numI == 0) {
                    numI = 0;

                } else {
                    numI = numI - 1;
                    modI = (numI - 10) / 2;
                    modTotal = modTotal + 1;
                    numTotalM.setText("" + modTotal);
                    if (numI < 10) {
                        numINT.setText("0" + numI);
                        numModI.setText("" + modI);
                    } else if (numI > 9) {
                        numINT.setText("" + numI);
                        numModI.setText("+" + modI);
                    }
                }
            } else if (v == btnIRight && modTotal > 0 && numI < 18) {
                numI = numI + 1;
                modI = (numI - 10) / 2;
                modTotal = modTotal - 1;
                numTotalM.setText("" + modTotal);
                if (numI < 10) {
                    numINT.setText("0" + numI);
                    numModI.setText("" + modI);
                } else if (numI > 9) {
                    numINT.setText("" + numI);
                    numModI.setText("+" + modI);
                }
            }

        }
        else if(v == btnSLeft || v == btnSRight) {
            // SABEDORIA
            if (v == btnSLeft) {
                if (numS < 0 || numS == 0) {
                    numS = 0;

                } else {
                    numS = numS - 1;
                    modS = (numS - 10) / 2;
                    modTotal = modTotal + 1;
                    numTotalM.setText("" + modTotal);
                    if (numS < 10) {
                        numSAB.setText("0" + numS);
                        numModS.setText("" + modS);
                    } else if (numS > 9) {
                        numSAB.setText("" + numS);
                        numModS.setText("+" + modS);
                    }
                }
            } else if (v == btnSRight && modTotal > 0 && numS < 18) {
                numS = numS + 1;
                modS = (numS - 10) / 2;
                modTotal = modTotal - 1;
                numTotalM.setText("" + modTotal);
                if (numS < 10) {
                    numSAB.setText("0" + numS);
                    numModS.setText("" + modS);
                } else if (numS > 9) {
                    numSAB.setText("" + numS);
                    numModS.setText("+" + modS);
                }
            }

        }

        else if(v == btnCaLeft || v == btnCaRight) {
            // CARISMA
            if (v == btnCaLeft) {
                if (numCa < 0 || numCa == 0) {
                    numCa = 0;

                } else {
                    numCa = numCa - 1;
                    modCa = (numCa - 10) / 2;
                    modTotal = modTotal + 1;
                    numTotalM.setText("" + modTotal);
                    if (numCa < 10) {
                        numCAR.setText("0" + numCa);
                        numModCa.setText("" + modCa);
                    } else if (numCa > 9) {
                        numCAR.setText("" + numCa);
                        numModCa.setText("+" + modCa);
                    }
                }
            } else if (v == btnCaRight && modTotal > 0 && numCa < 18) {
                numCa = numCa + 1;
                modCa = (numCa - 10) / 2;
                modTotal = modTotal - 1;
                numTotalM.setText("" + modTotal);
                if (numCa < 10) {
                    numCAR.setText("0" + numCa);
                    numModCa.setText("" + modCa);
                } else if (numCa > 9) {
                    numCAR.setText("" + numCa);
                    numModCa.setText("+" + modCa);
                }
            }
        }


    }


    public void editar(){
        ArrayList<String> dados = new ArrayList<>();
        ArrayList<Integer> dadosint = new ArrayList<>();
        dados.add(editNome.getText().toString());
        dados.add(editClasse.getSelectedItem().toString());
        dados.add(editRaca.getSelectedItem().toString());
        dadosint.add(editClasse.getSelectedItemPosition());
        dadosint.add(editRaca.getSelectedItemPosition());
        dadosint.add(numF);
        dadosint.add(numD);
        dadosint.add(numCo);
        dadosint.add(numI);
        dadosint.add(numS);
        dadosint.add(numCa);

        ctrl.editPerson(nome, dados, dadosint);
    }

}
