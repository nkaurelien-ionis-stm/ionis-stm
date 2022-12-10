package com.kamitbrains.nkaurelien.ionis_stm.intermediaire.lesson3;

public class Employee extends Human implements Worker{
    public Employee(int age, int height, Gender gender) {
        super(age, height, gender);
    }

    @Override
    public void work() {
        System.out.println("I can work");

    }
}
