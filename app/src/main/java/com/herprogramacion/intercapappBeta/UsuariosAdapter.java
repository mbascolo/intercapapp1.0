package com.herprogramacion.intercapappBeta;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.herprogramacion.mysocialmediapotenciado.R;

import javax.xml.transform.Result;


public class UsuariosAdapter extends ArrayAdapter {

    // Atributos

    private static final String URL_JSON_USUARIO = "http://intercapweb.com.ar/TiendaVirtualv3/rs/usuario/login/";
    private static final String URL_JSON_PASS = "http://intercapweb.com.ar/TiendaVirtualv3/rs/usuario/login/"+URL_JSON_USUARIO+"/";
    private static final String TAG = "UsuariosAdapter";
    ResultadoLogin resultadoLogin;

    public UsuariosAdapter(Context context) {
        super(context,0);




    }





}
