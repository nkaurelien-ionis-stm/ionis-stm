package com.kamitbrains.nkaurelien.ionis_stm.intermediaire.geometry;

public class Cercle extends Figure {

    protected double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    public void affiche() {
        throw new RuntimeException("implement the method");
    }

    public double surface() {
        throw new RuntimeException("implement the method");
    }

    public double perimetre() {
        throw new RuntimeException("implement the method");
    }
}
