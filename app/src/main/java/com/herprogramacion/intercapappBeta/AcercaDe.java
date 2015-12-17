package com.herprogramacion.intercapappBeta;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.herprogramacion.intercapappBeta.ListaPost;
import com.herprogramacion.mysocialmediapotenciado.R;

public class AcercaDe extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ventas_especiales) {
            Intent listaVentas = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(listaVentas);
        }

        if  (id == R.id.acerca_de) {
            Intent acercaDe = new Intent(getApplicationContext(),AcercaDe.class);
            startActivity(acercaDe);
        }

        if  (id == R.id.activity_email) {
            Intent envioEmail = new Intent(getApplicationContext(),EmailActivity.class);
            startActivity(envioEmail);
        }



        return super.onOptionsItemSelected(item);
    }
}
