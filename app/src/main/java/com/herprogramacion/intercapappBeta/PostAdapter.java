package com.herprogramacion.intercapappBeta;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.herprogramacion.mysocialmediapotenciado.R;


public class PostAdapter extends ArrayAdapter {

    // Atributos
    private String URL_BASE = "http://intercapweb.com.ar/TiendaVirtualv3/rs/ve";
    private static final String URL_JSON = "/lista";
    private static final String TAG = "PostAdapter";
    ListaPost pool;

    public PostAdapter(Context context) {
        super(context,0);

        // Añadir petición GSON a la cola
        MySocialMediaSingleton.getInstance(getContext()).addToRequestQueue(
                new GsonRequest<ListaPost>(
                        URL_BASE+URL_JSON,
                        ListaPost.class,
                        null,
                        new Response.Listener<ListaPost>(){
                            @Override
                            public void onResponse(ListaPost response) {
                                pool = response;
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
        return pool != null ? pool.getItems().size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // View auxiliar
        View listItemView;

        //Comprobando si el View no existe
        if (null == convertView) {
            //Si no existe, entonces inflarlo
            listItemView = layoutInflater.inflate(
                    R.layout.post,
                    parent,
                    false);
        } else listItemView = convertView;


        // Obtener el item actual
        Post item = pool.getItems().get(position);

        // Obtener Views
        TextView textoTitulo = (TextView) listItemView.
                findViewById(R.id.textoTitulo);
        TextView textoDescripcion = (TextView) listItemView.
                findViewById(R.id.textoDescripcion);
        NetworkImageView imagenPost = (NetworkImageView) listItemView.
                findViewById(R.id.imagenPost);

        // Actualizar los Views
        textoTitulo.setText(item.getdescripcion());
        textoDescripcion.setText(item.getnroPool());

        // Petición el image loader
        ImageLoader imageLoader= MySocialMediaSingleton.getInstance(getContext()).getImageLoader();
        // Petición
        //imagenPost.setImageUrl(URL_BASE +item.getpathImagenBannerMiniatura(), imageLoader);
        imagenPost.setImageUrl(item.getpathImagenBannerMiniatura(), imageLoader);

        return listItemView;
    }


}
