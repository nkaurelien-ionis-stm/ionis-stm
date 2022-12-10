package com.kamitbrains.nkaurelien.ionis_stm.intermediaire;

import com.kamitbrains.nkaurelien.ionis_stm.intermediaire.lesson3.Director;
import com.kamitbrains.nkaurelien.ionis_stm.intermediaire.lesson3.Employee;
import com.kamitbrains.nkaurelien.ionis_stm.intermediaire.lesson3.Human;
import com.kamitbrains.nkaurelien.ionis_stm.intermediaire.lesson3.Worker;

public class Main {


    public static void main(String[] args) {

        Employee e1 = new Director(10, 78, Human.Gender.MEN);
        Employee e2 = new Employee(10, 64, Human.Gender.WOMEN);
        Human e3 = new Employee(10, 70, Human.Gender.OTHER);

        if (e1 instanceof Worker) {
            ( (Worker) e1).work();
        }

    }
}
