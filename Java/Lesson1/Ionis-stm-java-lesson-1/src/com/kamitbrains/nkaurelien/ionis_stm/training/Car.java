package com.kamitbrains.nkaurelien.ionis_stm.training;

public abstract class Car implements  Drive {


    public int getTireNumber() {
        return tireNumber;
    }

    /**
     *
     *
     * private =>interieur de  la  class seulement
     * protected => interieur de  la class et  fils
     * public => tout le  monde
     * rien => les class ou le meme  niveau
     */



    protected int tireNumber = 0;

    private String color = "rose";

    public Car(int tireNumber, String color) {
        this.tireNumber = tireNumber;
        this.color = color;
    }

    @Override
    public void drive() {
        System.out.println("Peut  conduire  vroum vroum");
    }
}
