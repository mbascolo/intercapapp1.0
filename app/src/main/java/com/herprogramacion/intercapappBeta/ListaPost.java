package com.herprogramacion.intercapappBeta;

import java.util.List;

public class ListaPost {
    // Encapsulamiento de Posts
    private List<Post> pool;

    public ListaPost(List<Post> items) {
        this.pool = items;
    }

    public void setItems(List<Post> items) {
        this.pool = items;
    }

    public List<Post> getItems() {
        return pool;
    }
}
