/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafodirigido;

/**
 *
 * @author acost
 */


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Grafo grafo = new Grafo();

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("       GRAFO DIRIGIDO");
            System.out.println("=================================");
            System.out.println("1. Agregar nodos");
            System.out.println("2. Agregar aristas");
            System.out.println("3. Mostrar grafo");
            System.out.println("4. Mostrar grados");
            System.out.println("5. Recorrido BFS");
            System.out.println("6. Recorrido DFS");
            System.out.println("7. Buscar camino");
            System.out.println("8. Detectar ciclos");
            System.out.println("9. Salir");
            System.out.println("=================================");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                // =========================================
                // 1. AGREGAR VARIOS NODOS
                // =========================================
                case 1:

                    System.out.println("\n========== AGREGAR NODOS ==========");
                    System.out.println("Escriba 0 para terminar.");

                    while (true) {

                        System.out.print("Ingrese el nombre del nodo: ");
                        String nombre = entrada.nextLine();

                        if (nombre.equals("0")) {
                            break;
                        }

                        if (nombre.trim().isEmpty()) {
                            System.out.println("El nombre no puede estar vacio.");
                        } else {
                            grafo.agregarNodo(nombre);
                        }
                    }

                    break;


                // =========================================
                // 2. AGREGAR VARIAS ARISTAS
                // =========================================
                case 2:

                    System.out.println("\n========== AGREGAR ARISTAS ==========");
                    System.out.println("Escriba 0 como nodo de origen para terminar.");

                    while (true) {

                        System.out.print("Ingrese nodo de origen: ");
                        String origen = entrada.nextLine();

                        if (origen.equals("0")) {
                            break;
                        }

                        System.out.print("Ingrese nodo de destino: ");
                        String destino = entrada.nextLine();

                        if (destino.equals("0")) {
                            break;
                        }

                        grafo.agregarArista(origen, destino);

                        System.out.println();
                    }

                    break;


                // =========================================
                // 3. MOSTRAR GRAFO
                // =========================================
                case 3:

                    grafo.mostrarGrafo();

                    break;


                // =========================================
                // 4. MOSTRAR GRADOS
                // =========================================
                case 4:

                    grafo.mostrarGrados();

                    break;


                // =========================================
                // 5. BFS
                // =========================================
                case 5:

                    System.out.println("\n========== RECORRIDO BFS ==========");
                    System.out.println("Escriba 0 para regresar al menu.");

                    while (true) {

                        System.out.print("Ingrese nodo inicial para BFS: ");
                        String inicioBFS = entrada.nextLine();

                        if (inicioBFS.equals("0")) {
                            break;
                        }

                        grafo.BFS(inicioBFS);

                        System.out.println();
                    }

                    break;


                // =========================================
                // 6. DFS
                // =========================================
                case 6:

                    System.out.println("\n========== RECORRIDO DFS ==========");
                    System.out.println("Escriba 0 para regresar al menu.");

                    while (true) {

                        System.out.print("Ingrese nodo inicial para DFS: ");
                        String inicioDFS = entrada.nextLine();

                        if (inicioDFS.equals("0")) {
                            break;
                        }

                        grafo.DFS(inicioDFS);

                        System.out.println();
                    }

                    break;


                // =========================================
                // 7. BUSCAR CAMINO
                // =========================================
                case 7:

                    System.out.println("\n========== BUSCAR CAMINO ==========");
                    System.out.println("Escriba 0 como nodo de origen para terminar.");

                    while (true) {

                        System.out.print("Ingrese nodo de origen: ");
                        String origenCamino = entrada.nextLine();

                        if (origenCamino.equals("0")) {
                            break;
                        }

                        System.out.print("Ingrese nodo de destino: ");
                        String destinoCamino = entrada.nextLine();

                        if (destinoCamino.equals("0")) {
                            break;
                        }

                        if (grafo.existeCamino(origenCamino, destinoCamino)) {

                            System.out.println(
                                    "Si existe un camino entre "
                                    + origenCamino
                                    + " y "
                                    + destinoCamino
                            );

                        } else {

                            System.out.println(
                                    "No existe un camino entre "
                                    + origenCamino
                                    + " y "
                                    + destinoCamino
                            );
                        }

                        System.out.println();
                    }

                    break;


                // =========================================
                // 8. DETECTAR CICLOS
                // =========================================
                case 8:

                    System.out.println("\n========== DETECCION DE CICLOS ==========");

                    if (grafo.tieneCiclo()) {

                        System.out.println(
                                "El grafo contiene al menos un ciclo."
                        );

                    } else {

                        System.out.println(
                                "El grafo no contiene ciclos."
                        );
                    }

                    break;


                // =========================================
                // 9. SALIR
                // =========================================
                case 9:

                    System.out.println("\nPrograma finalizado.");

                    break;


                // =========================================
                // OPCIÓN NO VÁLIDA
                // =========================================
                default:

                    System.out.println(
                            "\nOpcion no valida."
                    );
            }

        } while (opcion != 9);

        entrada.close();
    }
}
