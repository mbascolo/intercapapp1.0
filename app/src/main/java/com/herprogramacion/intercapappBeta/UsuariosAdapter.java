package com.herprogramacion.intercapappBeta;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.herprogramacion.mysocialmediapotenciado.R;


public class UsuariosAdapter extends ArrayAdapter {

    // Atributos
    private String URL_BASE = "http://intercapweb.com.ar/TiendaVirtualv3/rs/usuarios";
    private static final String URL_JSON = "/lista";
    private static final String TAG = "UsuariosAdapter";
    ListaUsuarios usuarios;

    public UsuariosAdapter(Context context) {
        super(context,0);

        // Añadir petición GSON a la cola
        MySocialMediaSingleton.getInstance(getContext()).addToRequestQueue(
                new GsonRequest<ListaUsuarios>(
                        URL_BASE+URL_JSON,
                        ListaUsuarios.class,
                        null,
                        new Response.Listener<ListaUsuarios>(){
                            @Override
                            public void onResponse(ListaUsuarios response) {
                                usuarios = response;
                                notifyDataSetChanged();
                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley:"+ error.getMessage());
                            }
                        }
                )

        );
    }

    @Override
    public int getCount() {
        return usuarios != null ? usuarios.getItems().size() : 0;
    }



}
