package com.kamitbrains.nkaurelien.ionis_stm.intermediaire.geometry;

public class Rectangle extends Figure {

    protected double longueur;
    protected double largeur;

    protected Color couleur;

    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public Rectangle(double longueur, double largeur, Color couleur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.couleur = couleur;
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

    public enum Color {
        RED, YELLOW
    }
}
