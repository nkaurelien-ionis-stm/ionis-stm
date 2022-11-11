package com.kamitbrains.nkaurelien.ionis_stm.exo;

import com.kamitbrains.nkaurelien.ionis_stm.utils.Console;

import java.util.Scanner;

public class Exercice implements HasNbrePairImpair, HasPendu, IGame {

    private static final int EXO_NOMBRE_PAIR_IMPAIR = 1;
    private static final int EXO_NOMBRE_PENDU = 2;
    private static final int EXIT = 0;

    private static Exercice instance;


    public static Exercice getInstance() {
        if (instance == null) {
            instance = new Exercice();
        }
        return instance;
    }


    public void showGameMainBanner() {
        System.out.println("\n");
        System.out.println("\t=====================");
        System.out.println("\t ⛬ EXCERCICE JAVA ⛬ ");
        System.out.println("\t=====================");


    }

    public void showGameMainMenu() {

        System.out.println("");
        System.out.println("\tChoisir  un exercice: ");
        System.out.println("\t1 ☛  Nombre le jeux de de nombre Pair-Impair  ");
        System.out.println("\t2 ☛  Lancer le pendu  ");
//        System.out.println("");
        System.out.println("\t0 ☛  Arreter le jeu  ");
        System.out.println();


    }

    public void start() throws ExerciceExitException {

        Console.clearConsole();
        showGameMainBanner();
        showGameMainMenu();


        System.out.print("⛬ Choisir un exercice dans la liste ");
        System.out.print(": ");
        Scanner input = new Scanner(System.in);
        String numExo = input.nextLine();

        while (numExo.equals("")) {
            numExo = Console.readLine("⛊ Vous devez donner une reponse correcte \n⛬ Choisir un exercice dans la liste");
        }

        if (Integer.parseInt(numExo) == EXIT) {
            exitGame();
        }

        switch (Integer.parseInt(numExo)) {

            case EXO_NOMBRE_PAIR_IMPAIR -> {
                runNbrePairImpair();
            }

            case EXO_NOMBRE_PENDU -> {
                runPendu();
            }

            default -> restartGame();
        }

    }

    @Override
    public void runNbrePairImpair() throws ExerciceExitException {
        HasNbrePairImpairImpl.newInstance().start();
    }

    @Override
    public void runPendu() throws ExerciceExitException {
        HasPenduImpl.newInstance().start();
    }
}
