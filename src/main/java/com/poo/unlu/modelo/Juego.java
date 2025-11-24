package com.poo.unlu.modelo;

import com.poo.unlu.observador.Observable;

import java.util.ArrayList;

public class Juego extends Observable {
    private ArrayList<Jugador> jugadores;
    private Cubilete cubilete;
    private CalculadoraPuntaje calculadora;
    private int turnoActual;
    private int puntosAcumuladosEnTurno;
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
        dadosDisponibles = 5;
        puntosAcumuladosEnTurno = 0;
        turnoActual ++;
        if (turnoActual >= jugadores.size()){
            turnoActual = 0;
        }
        notificarObservadores();
    }

    public void plantarse(){
        Jugador actual = getJugadorActual();
        actual.sumarPuntos(puntosAcumuladosEnTurno);
        if (actual.getPuntosTotales() >= 10000){
            ganador = actual;
            notificarObservadores();
        } else {
            cambiarTurno();
        }

    }


    public boolean hayGanador(){
        return ganador != null;
    }

    public Jugador getGanador(){
        return ganador;
    }
}