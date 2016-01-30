package com.herprogramacion.intercapappBeta;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.herprogramacion.intercapappBeta.Db.UsuariosDataSource;
import com.herprogramacion.mysocialmediapotenciado.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private TextView nombre_usuario,pass_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre_usuario = (TextView)findViewById(R.id.txtUsuario);
        pass_usuario = (TextView)findViewById(R.id.txtPass);

        //Creamos nuevo objeto de base de datos
        UsuariosDataSource dataSource = new UsuariosDataSource(this);
    }

    public void OnClick(View v){

        validaUsuario(nombre_usuario.getText().toString(), pass_usuario.getText().toString());

    }

    public void validaUsuario(String usuario, String pass) {

        if(usuario.equals("admin") && pass.equals("admin")){
            Intent principal = new Intent(this,HomeActivity.class);
            startActivity(principal);

        } else if (usuario.equals("") && pass.equals("")) {

            Toast.makeText(LoginActivity.this,"Ingrese los datos por favor",Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
