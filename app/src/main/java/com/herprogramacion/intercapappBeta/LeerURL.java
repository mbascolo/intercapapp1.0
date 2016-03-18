package com.herprogramacion.intercapappBeta;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.herprogramacion.mysocialmediapotenciado.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeerURL extends AppCompatActivity {

    Activity context;
    TextView txtview;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_url);
        context=this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leer_url, menu);
        return true;
    }


   // public void onStart(){
    //    super.onStart();

    //    BackTask bt=new BackTask();
    //    bt.execute("http://www.intercapweb.com.ar/TiendaVirtualv3/rs/usuario/login/MOTOINP/MOTOEBIZ30");


    // }

    public void OnClick (View v) {

        BackTask bt=new BackTask();
        bt.execute("http://www.intercapweb.com.ar/TiendaVirtualv3/rs/usuario/login/MOTOINP/MOTOEBIZ30");


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
            txtview=(TextView)findViewById(R.id.text_view);
            //display read text in TextVeiw
            txtview.setText(text);

        }


    }

}
