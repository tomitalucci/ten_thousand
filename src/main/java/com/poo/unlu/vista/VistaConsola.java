package com.poo.unlu.vista;

import com.poo.unlu.controlador.Controlador;
import com.poo.unlu.modelo.ResultadoTirada;
import com.poo.unlu.observador.Observador;

import java.util.Scanner;

public class VistaConsola implements Observador { //implemento la interfaz para recibir avisos de cambio del juego
    private Controlador controlador;
    private Scanner scanner;


    public VistaConsola(Controlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        this.controlador.registrarObservador(this); //se suscribe a la lista de observadores y esta al tanto de cambios en el juego
    }


    public void iniciar(){
        System.out.println("--- REGISTRO DE JUGADORES --- ");
        System.out.println("(Escribe 'exit' cuando hayas terminado de agregar jugadores)");
        int cantidadJugadores = 0;
        boolean registrando = true;

        while(registrando){
            System.out.print("Ingrese nombre del jugador " + (cantidadJugadores + 1) + ": ");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("exit")){
                if (cantidadJugadores < 2){
                    System.out.println("Error: Se necesitan al menos 2 jugadores.");
                } else {
                    registrando = false;
                }
            } else if (!nombre.trim().isEmpty()) {
                controlador.agregarJugador(nombre);
                cantidadJugadores ++;
                System.out.println("Jugador agregado.");
            }else {
                System.out.println("El nombre no puede estar vacio.");
            }

        }

        mostrarMenu();
    }

    public void mostrarMenu(){
        boolean jugando = true;
        while (jugando && !controlador.juegoTerminado()){
            System.out.println("\n --- Turno de: " + controlador.getNombreJugadorActual() + " ---");
            System.out.println("Puntos totales: " + controlador.getPuntosTotalesJugadorActual());
            System.out.println("1. Tirar Dados");
            System.out.println("2. Plantarse");
            System.out.println("3. Salir");
            System.out.println("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    ResultadoTirada resultado = controlador.lanzarDados();
                    System.out.println("------------------------");
                    System.out.println("Tirada finalizada.");
                    System.out.println("Dados: " + resultado.getValores().toString());
                    System.out.println("Puntos obtenidos en este tiro: " + resultado.getPuntaje());
                    System.out.println("Dados que puntuaron: " + resultado.getDadosQuePuntuaron());
                    if (resultado.getPuntaje() == 0){
                        System.out.println("No sumaste puntos y perdiste el turno.");
                    }
                    System.out.println("------------------------");
                    break;
                case 2:
                    controlador.plantarse();
                    System.out.println("!Jugador se planto!");
                    break;
                case 3:
                    jugando = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            if (controlador.juegoTerminado()){
                System.out.println("\n--- !JUEGO TERMINADO! ---");
                System.out.println("El ganador es: " + controlador.getNombreGanador());
            }

        }
    }



    @Override
    public void actualizar() {
        System.out.println("\n[EVENTO] !El estado del juego ha cambiado!");
    }
}
