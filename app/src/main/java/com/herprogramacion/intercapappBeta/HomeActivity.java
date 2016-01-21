package com.herprogramacion.intercapappBeta;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.herprogramacion.intercapappBeta.Email.FormReservaActivity;
import com.herprogramacion.intercapappBeta.Email.SendMailActivity;
import com.herprogramacion.mysocialmediapotenciado.R;

public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Instancio los botones
        Button btn_ventas = (Button)findViewById(R.id.btn_ventas);
        Button btn_catalogo = (Button)findViewById(R.id.btn_catalogo);
        Button btn_ctacte = (Button)findViewById(R.id.btn_ctacte);
        Button btn_enviar_correo = (Button)findViewById(R.id.btn_enviar_correo);

        btn_ventas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn_catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,CatalogoActivity.class);
                startActivity(intent);
            }
        });

        btn_ctacte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,CtacteActivity.class);
                startActivity(intent);
            }
        });

        btn_enviar_correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,FormReservaActivity.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
