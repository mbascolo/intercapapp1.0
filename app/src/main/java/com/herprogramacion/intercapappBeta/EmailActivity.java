package com.herprogramacion.intercapappBeta;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.herprogramacion.mysocialmediapotenciado.R;

public class EmailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    public void onClick(View v){
        String[] to = {"mbascolo@intercap.com.ar"};
        String[] cc = {"mbascolo@gmail.com"};
        enviar(to, cc, "Reserva desde App", "El cliente Matias ha realizado una reserva");
    }

    private void enviar (String[] to,String[] cc,String asunto, String mensaje) {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_email, menu);
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
