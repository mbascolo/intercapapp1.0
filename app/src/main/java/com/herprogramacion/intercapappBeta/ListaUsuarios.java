package com.herprogramacion.intercapappBeta;

import java.util.List;

/**
 * Created by Matias on 29/01/2016.
 */
public class ListaUsuarios {

    private List<Usuarios> usuarios;

    public ListaUsuarios(List<Usuarios> items) {this.usuarios = items;}

    public void setItems (List<Usuarios> items) {this.usuarios = items;}

    public List<Usuarios> getItems() {return usuarios;}


}
