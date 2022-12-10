package com.kamitbrains.nkaurelien.ionis_stm.intermediaire.geometry;

public abstract class Figure implements Printable {

    protected double x;
    protected double y;

    Figure() {
        this.x = 0;
        this.y = 0;
    }

    protected Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void affiche() {
        throw new RuntimeException("implement the method");
    }

    public void setCentre() {
        throw new RuntimeException("implement the method");
    }
}
