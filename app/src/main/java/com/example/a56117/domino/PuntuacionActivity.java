package com.example.a56117.domino;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PuntuacionActivity extends AppCompatActivity {
    TextView p1,p2,p3,p4;
    int c1,c2,c3,c4;
    String nom[];
    Button btnPuntos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nom=this.getIntent().getStringArrayExtra("nombres");
        p1=(TextView)findViewById(R.id.p1);
        p2=(TextView)findViewById(R.id.p2);
        p3=(TextView)findViewById(R.id.p3);
        p4=(TextView)findViewById(R.id.p4);
        actualizarEtiquetas();

        Button btnReiniciar= (Button) findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnPuntos=(Button) findViewById(R.id.btnPuntos);
        btnPuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(PuntuacionActivity.this,PuntosActivity.class);
                i.putExtra("nombres",nom);
                startActivityForResult(i, 1234);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void actualizarEtiquetas() {
        p1.setText(nom[0]+"\t"+c1);
        p2.setText(nom[1]+"\t"+c2);
        p3.setText(nom[2]+"\t"+c3);
        p4.setText(nom[3]+"\t"+c4);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if(requestCode==1234 && resultCode==RESULT_OK)
        {
            int puntos=data.getExtras().getInt("puntos");
            int part=data.getExtras().getInt("part");
            int total=0;
            switch (part) {
                case 0:
                    c1 += puntos;
                    total = c1;
                    break;
                case 1:
                    c2 += puntos;
                    total = c2;
                    break;
                case 2:
                    c3 += puntos;
                    total = c3;
                    break;
                case 3:
                    c4 += puntos;
                    total = c4;
                    break;

            }
            actualizarEtiquetas();
            //Toast.makeText(PuntuacionActivity.this, puntos + " puntos guardados a " + nom[part], Toast.LENGTH_LONG).show();
            if(total>=100){
                Toast.makeText(PuntuacionActivity.this, "gano " + nom[part], Toast.LENGTH_LONG).show();
                btnPuntos.setEnabled(false);
            }
        }

    }

}
