package com.herprogramacion.intercapappBeta;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.herprogramacion.intercapappBeta.Usuarios;

import com.google.gson.Gson;
import com.herprogramacion.intercapappBeta.Db.UsuariosDataSource;
import com.herprogramacion.mysocialmediapotenciado.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Activity context;
    ProgressDialog pd;

    private TextView nombre_usuario,pass_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre_usuario = (TextView)findViewById(R.id.txtUsuario);
        pass_usuario = (TextView)findViewById(R.id.txtPass);

        context=this;



    }

    public void OnClick(View v){

        BackTask bt=new BackTask();
        bt.execute("http://www.intercapweb.com.ar/TiendaVirtualv3/rs/usuario/login/"+nombre_usuario.getText()+"/"+pass_usuario.getText());


    }



    //background process to download the file from internet
    private class BackTask extends AsyncTask<String,Integer,Void>{
        String text="";
        protected void onPreExecute(){
            super.onPreExecute();
            //display progress dialog
            pd = new ProgressDialog(context);
            pd.setTitle("Comprobando datos");
            pd.setMessage("Espere por favor.");
            pd.setCancelable(true);
            pd.setIndeterminate(false);
            pd.show();

        }



        protected Void doInBackground(String...params){
            URL url;
            try {
                //create url object to point to the file location on internet
                url = new URL(params[0]);
                //make a request to server
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                //get InputStream instance
                InputStream is=con.getInputStream();
                //create BufferedReader object
                BufferedReader br=new BufferedReader(new InputStreamReader(is));
                String line;
                //read content of the file line by line
                while((line=br.readLine())!=null){
                    text+=line;

                }

                br.close();

            }catch (Exception e) {
                e.printStackTrace();
                //close dialog if error occurs
                if(pd!=null) pd.dismiss();
            }

            return null;

        }


        protected void onPostExecute(Void result){
            //close dialog
            if(pd!=null)
                pd.dismiss();


            //display read text in TextVeiw
            //resultado.setText(text);

            if(text.equals("Autorizado")){

                Intent principal = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(principal);

            } else if (text.equals("Password incorrecto")) {

                Toast.makeText(LoginActivity.this,"Datos incorrectos",Toast.LENGTH_SHORT).show();

            } else if (text.equals("")) {

                Toast.makeText(LoginActivity.this,"Ingrese su usuario y contraseņa por favor.",Toast.LENGTH_SHORT).show();
            }

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
