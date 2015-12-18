package com.herprogramacion.intercapappBeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.herprogramacion.mysocialmediapotenciado.R;

public class CatalogoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        //Sipnners (menus selección)

        final String[] datosMarcas = new String[]{"Pirelli", "Ama", "Motul"};
        ArrayAdapter<String> adaptadorMarcas = new ArrayAdapter<String>(this,R.layout.ebiz_spinner_item,datosMarcas);
        Spinner spinnerMarcas = (Spinner)findViewById(R.id.spinnerMarcas);
        adaptadorMarcas.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerMarcas.setAdapter(adaptadorMarcas);


        final String[] datosTipos = new String[]{"Accesorios", "Amortiguadores", "Barrales"};
        Spinner spinnerTipos = (Spinner)findViewById(R.id.spinnerTipos);
        ArrayAdapter<String> adaptadorTipos = new ArrayAdapter<String>(this,R.layout.ebiz_spinner_item,datosTipos);
        adaptadorTipos.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerTipos.setAdapter(adaptadorTipos);

        final String[] datosSubtipos = new String[]{"Bidones", "Bielas", "Cubiertas"};
        ArrayAdapter<String> adaptadorSubtipos = new ArrayAdapter<String>(this,R.layout.ebiz_spinner_item,datosSubtipos);
        Spinner spinnerSubtipos = (Spinner)findViewById(R.id.spinnerSubtipos);
        adaptadorSubtipos.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerSubtipos.setAdapter(adaptadorSubtipos);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_catalogo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
