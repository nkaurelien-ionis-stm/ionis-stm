package com.kamitbrains.nkaurelien.ionis_stm.intermediaire.geometry;

public class RectangleColore extends Rectangle {

    protected double couleur;

    public RectangleColore(double longueur, double largeur, double couleur) {
        super(longueur, largeur);
        this.couleur = couleur;
    }

    public void affiche() {
        throw new RuntimeException("implement the method");
    }

}
