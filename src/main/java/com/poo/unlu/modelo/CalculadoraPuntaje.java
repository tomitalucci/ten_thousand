package com.poo.unlu.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculadoraPuntaje {
    /*
    esta clase la uso para procesar todas las operaciones que tienen que ver con el puntaje.
    no es un metodo dentro de la clase Juego por el principio de responsabilidad unica.
    Juego gestiona el flujo y los turnos. Calcular los puntos es una logica separada.
    si en el futuro cambian las reglas de puntaje solo toco la CalculadoraPuntaje y no rompo la clase Juego.
    */

    public ResultadoTirada calcularPuntaje(ArrayList<Integer> valoresDados){
        HashMap<Integer, Integer> conteo = new HashMap<>(); //lo uso para contar las frecuencias de los numeros que salen
        //clave: cara del dado - valor: cant de veces que salio
        int dadosUsados = 0;
        int puntajeTotal = 0;
        for (Integer valor : valoresDados){
            conteo.put(valor, conteo.getOrDefault(valor, 0) + 1);
        }
        for(int cara = 1; cara <= 6; cara++){
            int cantidad = conteo.getOrDefault(cara, 0);
            //prioridad de busqueda --> trios
            if(cantidad >= 3){
                dadosUsados += 3;
                if (cara == 1){
                    puntajeTotal += 1000; //regla especial del 1
                }
                else {
                    puntajeTotal += (cara * 100); //regla general
                }
                cantidad -= 3; //resto los dados usados para ver si sobran
            }
            // individuales: sumo lo que sobro o si es que no hubo trio
            if (cara == 1){
                puntajeTotal += (cantidad * 100);
                dadosUsados += cantidad;
            }
            if (cara == 5){
                puntajeTotal += (cantidad * 50);
                dadosUsados += cantidad;
            }
        }
        return new ResultadoTirada(puntajeTotal, dadosUsados, valoresDados); // retorno un objeto con la informacion de la tirada en cuestion
    }
}
