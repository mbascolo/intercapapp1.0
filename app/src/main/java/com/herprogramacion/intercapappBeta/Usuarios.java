package com.herprogramacion.intercapappBeta;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Usuarios implements Serializable {



    // Atributos
    private String idUsuario;
    private String nombreUsuario;
    private String passUsuario;
    private String resultadoLogin;

    public Usuarios() {
    }

    public Usuarios(String idUsuario, String nombreUsuario, String passUsuario, String resultadoLogin) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passUsuario = passUsuario;
        this.resultadoLogin = resultadoLogin;

    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public String getResultadoLogin() {
        return resultadoLogin;
    }

    public void setResultadoLogin(String resultadoLogin) {
        this.resultadoLogin = resultadoLogin;
    }
}
