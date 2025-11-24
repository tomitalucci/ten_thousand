package com.poo.unlu.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculadoraPuntaje {


    public ResultadoTirada calcularPuntaje(ArrayList<Integer> valoresDados){
        HashMap<Integer, Integer> conteo = new HashMap<>();
        int dadosUsados = 0;
        int puntajeTotal = 0;
        for (Integer valor : valoresDados){
            conteo.put(valor, conteo.getOrDefault(valor, 0) + 1);
        }
        for(int cara = 1; cara <= 6; cara++){
            int cantidad = conteo.getOrDefault(cara, 0);
            if(cantidad >= 3){
                dadosUsados += 3;
                if (cara == 1){
                    puntajeTotal += 1000;
                }
                else {
                    puntajeTotal += (cara * 100);
                }
                cantidad -= 3;
            }
            if (cara == 1){
                puntajeTotal += (cantidad * 100);
                dadosUsados += cantidad;
            }
            if (cara == 5){
                puntajeTotal += (cantidad * 50);
                dadosUsados += cantidad;
            }
        }
        return new ResultadoTirada(puntajeTotal, dadosUsados, valoresDados);
    }
}
