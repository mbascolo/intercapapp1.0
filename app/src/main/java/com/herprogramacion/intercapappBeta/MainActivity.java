package com.herprogramacion.intercapappBeta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.herprogramacion.intercapappBeta.Email.FormReservaActivity;
import com.herprogramacion.intercapappBeta.Email.SendMailActivity;
import com.herprogramacion.mysocialmediapotenciado.R;


@SuppressWarnings("serial")
public class MainActivity extends AppCompatActivity {

    // Atributos
    ListView listView;
    ArrayAdapter adapter;
    private TextView titulo_extra , descrip_extra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo_extra = (TextView)findViewById(R.id.textoTitulo);
        descrip_extra = (TextView)findViewById(R.id.textoDescripcion);


        // Obtener instancia de la lista
        listView= (ListView) findViewById(R.id.listView);

        // Crear adaptador
        adapter = new PostAdapter(this);
        listView.setAdapter(adapter);

        //Click en items
       // listView.setClickable(true);

        //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         //   @Override
         //  public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
         //      Post elegido = (Post) parent.getItemAtPosition(posicion);

          //     CharSequence texto = "Seleccionado: " + elegido.getdescripcion();
          //     Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
          //     toast.show();
          // }
         //});
    }


    public void onMasInfo(View v) {
        Intent DetalleProducto = new Intent(getApplicationContext(),DetalleProducto.class);

        //DetalleProducto.putExtra("descPool",descrip_extra.getText().toString());
        DetalleProducto.putExtra("descPool","Descripcion del Pool");
        DetalleProducto.putExtra("tituloPool","Titulo del Pool");
        startActivity(DetalleProducto);
    }

    public void onReservar(View v){

        Intent ReservaProducto = new Intent(getApplicationContext(),FormReservaActivity.class);

        //ReservaProducto.putExtra("nroPool","1254");
        ReservaProducto.putExtra("nroVta","1253");
        ReservaProducto.putExtra("tituloVta","Este es el ttulo de la ve");
        startActivity(ReservaProducto);


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
            Intent envioEmail = new Intent(getApplicationContext(), FormReservaActivity.class);
            startActivity(envioEmail);
        }

        return super.onOptionsItemSelected(item);
    }
}
