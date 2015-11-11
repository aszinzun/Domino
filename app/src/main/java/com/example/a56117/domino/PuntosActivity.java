package com.example.a56117.domino;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PuntosActivity extends AppCompatActivity {
    String nom[];
    Spinner spi;
    NumberPicker unidades,decenas;
    int u,d;
    int part;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nom=this.getIntent().getStringArrayExtra("nombres");


        // you need to have a list of data that you want the spinner to display
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add(nom[0]);
        spinnerArray.add(nom[1]);
        spinnerArray.add(nom[2]);
        spinnerArray.add(nom[3]);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi= (Spinner)findViewById(R.id.spinner);
        spi.setAdapter(adapter);

        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                part=position;


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        unidades= (NumberPicker)findViewById(R.id.unidades);

        decenas= (NumberPicker)findViewById(R.id.decenas);

        unidades.setMinValue(0);
        unidades.setMaxValue(9);
        unidades.setWrapSelectorWheel(false);

        unidades.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub

                String Old = "Old Value : ";
                String New = "New Value : ";
                u=newVal;
                //Toast.makeText(PuntosActivity.this, Old.concat(String.valueOf(oldVal)), Toast.LENGTH_LONG).show();
                //Toast.makeText(PuntosActivity.this, New.concat(String.valueOf(newVal)), Toast.LENGTH_LONG).show();
            }
        });

        decenas.setMinValue(0);
        decenas.setMaxValue(10);
        decenas.setWrapSelectorWheel(false);

        decenas.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub

                String Old = "Old Value : ";
                String New = "New Value : ";
                d=newVal;
                //Toast.makeText(PuntosActivity.this,Old.concat(String.valueOf(oldVal)),Toast.LENGTH_LONG).show();
                //Toast.makeText(PuntosActivity.this, New.concat(String.valueOf(newVal)),Toast.LENGTH_LONG).show();
            }
        });



        Button btnCancelar= (Button)findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btnGuardar= (Button)findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int puntos=d*10+u;
                Intent i= new Intent();
                i.putExtra("puntos",puntos);
                i.putExtra("part",part);
                setResult(RESULT_OK,i);
                finish();
                //Toast.makeText(PuntosActivity.this,puntos +" puntos guardados a "+ part,Toast.LENGTH_LONG).show();


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

}
