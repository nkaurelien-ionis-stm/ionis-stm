package com.kamitbrains.nkaurelien.ionis_stm.intermediaire.lesson3;

public class Director extends Employee implements Directable{

    public Director(int age, int height, Gender gender) {
        super(age, height, gender);
    }

    @Override
    public void work() {
        System.out.println("I'm the Director");
    }

    @Override
    public int getEmployeeNumber() {
        return 0;
    }

    @Override
    public int getCA() {
        return 0;
    }


    int countEmployee() {
        return 0;
    }
}
