package com.kamitbrains.nkaurelien.ionis_stm.intermediaire.lesson3;

public abstract class Human {

    protected int age;

    protected int height;

    protected Gender gender;

    public enum Gender {
        MEN, WOMEN, OTHER
    }

    public Human(int age, int height, Gender gender) {
        this.age = age;
        this.height = height;
        this.gender = gender;
    }



}
