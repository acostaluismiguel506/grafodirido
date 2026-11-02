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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Grafo {

    private HashMap<String, Nodo> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    // Agregar un nuevo vértice
    public void agregarNodo(String nombre) {

        if (!nodos.containsKey(nombre)) {
            nodos.put(nombre, new Nodo(nombre));
            System.out.println("Nodo agregado correctamente.");
        } else {
            System.out.println("El nodo ya existe.");
        }
    }

    // Agregar una arista dirigida
    public void agregarArista(String origen, String destino) {

        Nodo nodoOrigen = nodos.get(origen);
        Nodo nodoDestino = nodos.get(destino);

        if (nodoOrigen == null || nodoDestino == null) {
            System.out.println("Uno o ambos nodos no existen.");
            return;
        }

        if (nodoOrigen.tieneVecino(nodoDestino)) {
            System.out.println("La arista ya existe.");
            return;
        }

        nodoOrigen.agregarVecino(nodoDestino);

        System.out.println("Arista agregada: " + origen + " -> " + destino);
    }

    // Mostrar el grafo
    public void mostrarGrafo() {

        if (nodos.isEmpty()) {
            System.out.println("El grafo está vacío.");
            return;
        }

        System.out.println("\n========== GRAFO DIRIGIDO ==========");

        for (Nodo nodo : nodos.values()) {

            System.out.print(nodo.getNombre() + " -> ");

            if (nodo.getVecinos().isEmpty()) {
                System.out.println("Sin conexiones");
            } else {

                for (Nodo vecino : nodo.getVecinos()) {
                    System.out.print(vecino.getNombre() + " ");
                }

                System.out.println();
            }
        }
    }

    // Calcular grado de entrada y salida
    public void mostrarGrados() {

        System.out.println("\n========== GRADOS ==========");

        for (Nodo nodo : nodos.values()) {

            int gradoSalida = nodo.getVecinos().size();
            int gradoEntrada = 0;

            for (Nodo otroNodo : nodos.values()) {

                for (Nodo vecino : otroNodo.getVecinos()) {

                    if (vecino == nodo) {
                        gradoEntrada++;
                    }
                }
            }

            System.out.println(
                    nodo.getNombre()
                    + " | Entrada: " + gradoEntrada
                    + " | Salida: " + gradoSalida
            );
        }
    }

    // Recorrido BFS
    public void BFS(String inicio) {

        Nodo nodoInicio = nodos.get(inicio);

        if (nodoInicio == null) {
            System.out.println("El nodo no existe.");
            return;
        }

        Set<Nodo> visitados = new HashSet<>();
        Queue<Nodo> cola = new LinkedList<>();

        cola.add(nodoInicio);
        visitados.add(nodoInicio);

        System.out.println("\n========== BFS ==========");

        while (!cola.isEmpty()) {

            Nodo actual = cola.poll();

            System.out.print(actual.getNombre() + " ");

            for (Nodo vecino : actual.getVecinos()) {

                if (!visitados.contains(vecino)) {

                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        System.out.println();
    }

    // Recorrido DFS
    public void DFS(String inicio) {

        Nodo nodoInicio = nodos.get(inicio);

        if (nodoInicio == null) {
            System.out.println("El nodo no existe.");
            return;
        }

        Set<Nodo> visitados = new HashSet<>();

        System.out.println("\n========== DFS ==========");

        DFSRecursivo(nodoInicio, visitados);

        System.out.println();
    }

    private void DFSRecursivo(Nodo nodo, Set<Nodo> visitados) {

        visitados.add(nodo);

        System.out.print(nodo.getNombre() + " ");

        for (Nodo vecino : nodo.getVecinos()) {

            if (!visitados.contains(vecino)) {

                DFSRecursivo(vecino, visitados);
            }
        }
    }

    // Buscar si existe un camino
    public boolean existeCamino(String origen, String destino) {

        Nodo nodoOrigen = nodos.get(origen);
        Nodo nodoDestino = nodos.get(destino);

        if (nodoOrigen == null || nodoDestino == null) {
            return false;
        }

        Set<Nodo> visitados = new HashSet<>();

        return buscarCamino(nodoOrigen, nodoDestino, visitados);
    }

    private boolean buscarCamino(
            Nodo actual,
            Nodo destino,
            Set<Nodo> visitados) {

        if (actual == destino) {
            return true;
        }

        visitados.add(actual);

        for (Nodo vecino : actual.getVecinos()) {

            if (!visitados.contains(vecino)) {

                if (buscarCamino(vecino, destino, visitados)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Detectar ciclos
    public boolean tieneCiclo() {

        Set<Nodo> visitados = new HashSet<>();
        Set<Nodo> enRecorrido = new HashSet<>();

        for (Nodo nodo : nodos.values()) {

            if (detectarCiclo(nodo, visitados, enRecorrido)) {
                return true;
            }
        }

        return false;
    }

    private boolean detectarCiclo(
            Nodo nodo,
            Set<Nodo> visitados,
            Set<Nodo> enRecorrido) {

        if (enRecorrido.contains(nodo)) {
            return true;
        }

        if (visitados.contains(nodo)) {
            return false;
        }

        visitados.add(nodo);
        enRecorrido.add(nodo);

        for (Nodo vecino : nodo.getVecinos()) {

            if (detectarCiclo(vecino, visitados, enRecorrido)) {
                return true;
            }
        }

        enRecorrido.remove(nodo);

        return false;
    }
}