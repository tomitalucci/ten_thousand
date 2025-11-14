package com.poo.unlu.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Dado {
    private int caraSuperior;
    private Random random = new Random();



    public int lanzar(){
        this.caraSuperior = random.nextInt(6) + 1;
        return caraSuperior;
    }

    public int getCaraSuperior() {
        return caraSuperior;
    }
}
