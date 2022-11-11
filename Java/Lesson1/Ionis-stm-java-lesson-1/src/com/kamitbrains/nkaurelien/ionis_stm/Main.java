package com.kamitbrains.nkaurelien.ionis_stm;

import com.kamitbrains.nkaurelien.ionis_stm.exo.Exercice;
import com.kamitbrains.nkaurelien.ionis_stm.exo.ExerciceExitException;
import com.kamitbrains.nkaurelien.ionis_stm.exo.HasPenduImpl;

public class Main {


    public static void main(String[] args) {
        try {
//            HasPenduImpl.newInstance().start();

            Exercice.getInstance().start();
        } catch (ExerciceExitException e) {
            System.out.println(" ");
            System.out.println("⚡⚡ Au revoir !!! ");
        }

    }
}