package com.kamitbrains.nkaurelien.ionis_stm.exo;

import java.util.Scanner;

public interface IGame {


    public void showGameMainMenu();

    public void showGameMainBanner();

    public void start() throws ExerciceExitException;


    default public void restartGame()  {
        System.out.println("RESTART NOT AVAILABLE ");

    }

    default public void pauseGame()  {
        System.out.println("\t ☟ Appuyer une touche  pour continuer ");
        System.out.println("\t ☟ Presser CTRL+C pour quitter ");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }


    default public void exitGame() throws ExerciceExitException {
        throw new ExerciceExitException();
    }
}
