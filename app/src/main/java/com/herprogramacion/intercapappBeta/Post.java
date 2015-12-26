package com.herprogramacion.intercapappBeta;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Post implements Serializable {
    // Atributos
    private String nroPool;
    private String descripcion;
    private String pathImagenBannerMiniatura;

    public Post() {
    }

    public Post(String descripcion, String nroPool, String pathImagenBannerMiniatura) {
        this.nroPool = nroPool;
        this.descripcion = descripcion;
        this.pathImagenBannerMiniatura = pathImagenBannerMiniatura;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getnroPool() {
        return nroPool;
    }

    public void setnroPool(String nroPool) {
        this.nroPool = nroPool;
    }

    public String getpathImagenBannerMiniatura() {
        return pathImagenBannerMiniatura;
    }

    public void setpathImagenBannerMiniatura(String pathImagenBannerMiniatura) {
       this.pathImagenBannerMiniatura = pathImagenBannerMiniatura;
    }
}
