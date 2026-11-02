/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafodirigido;

/**
 *
 * @author acost
 */


import java.util.ArrayList;

public class Nodo {

    private String nombre;
    private ArrayList<Nodo> vecinos;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.vecinos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Nodo> getVecinos() {
        return vecinos;
    }

    public void agregarVecino(Nodo nodo) {
        if (!vecinos.contains(nodo)) {
            vecinos.add(nodo);
        }
    }

    public boolean tieneVecino(Nodo nodo) {
        return vecinos.contains(nodo);
    }
}
