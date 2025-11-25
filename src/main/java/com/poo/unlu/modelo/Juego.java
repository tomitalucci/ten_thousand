package com.poo.unlu.modelo;

import com.poo.unlu.observador.Observable;

import java.util.ArrayList;

// FACHADA. Administra el estado global del juego

//Heredo de Observable para poder avisar a la vista cuando cambia el estado
public class Juego extends Observable {
    private ArrayList<Jugador> jugadores;
    private Cubilete cubilete;
    private CalculadoraPuntaje calculadora;
    private int turnoActual; //indice del jugador dentro de la lista
    private int puntosAcumuladosEnTurno; //hace referencia al pozo temporal antes de que un jugador decida plantarse
    private int dadosDisponibles;
    private Jugador ganador;

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.cubilete = new Cubilete();
        this.calculadora = new CalculadoraPuntaje();
        this.turnoActual = 0;
        this.puntosAcumuladosEnTurno = 0;
        this.dadosDisponibles = 5;
        this.ganador = null;
    }


    public void agregarJugador(String nombre){
        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
    }

    public ResultadoTirada tirarDados(){
        cubilete.tirarDados(dadosDisponibles);
        ArrayList<Integer> valores = cubilete.getManoDeDados();
        ResultadoTirada resultado = calculadora.calcularPuntaje(valores);
        if (resultado.getPuntaje() > 0){
            puntosAcumuladosEnTurno += resultado.getPuntaje();
        }
        if (resultado.getPuntaje() == 0){
            puntosAcumuladosEnTurno = 0;
            cambiarTurno();
        }
        dadosDisponibles -= resultado.getDadosQuePuntuaron();
        if (dadosDisponibles == 0){
            dadosDisponibles = 5;
        }
        notificarObservadores();
        return resultado;
    }

    public Jugador getJugadorActual(){
        return jugadores.get(turnoActual);
    }


    public void cambiarTurno(){
        dadosDisponibles = 5; //reinicio los dados a 5 para la tirada del prox jugador
        puntosAcumuladosEnTurno = 0; //reinicio el pozo
        turnoActual ++; //aumento el indice para hacer referencia al siguiente jugador
        if (turnoActual >= jugadores.size()){ // cuando llego al final de la lista vuelvo el indice a 0 pq es turno del primer jugador
            turnoActual = 0;
        }
        notificarObservadores();
    }

    public void plantarse(){
        Jugador actual = getJugadorActual();
        actual.sumarPuntos(puntosAcumuladosEnTurno); //es la instruccion que hace efectiva la suma de los puntos del jugador
        if (actual.getPuntosTotales() >= 10000){//condicion para la victoria del juego
            ganador = actual;
            notificarObservadores();
        } else {
            cambiarTurno();//si no gano sigue el juego
        }

    }


    public boolean hayGanador(){
        return ganador != null;
    }

    public Jugador getGanador(){
        return ganador;
    }
}