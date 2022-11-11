package com.kamitbrains.nkaurelien.ionis_stm.exo;

import com.kamitbrains.nkaurelien.ionis_stm.utils.Console;

public class HasNbrePairImpairImpl implements IGame {

    public static HasNbrePairImpairImpl newInstance() {
      return   new HasNbrePairImpairImpl();
    }

    public boolean checkPairImpair(int a, int b) {
        return a % b == 0;
    }

    @Override
    public void showGameMainMenu() {

    }

    @Override
    public void showGameMainBanner() {
        System.out.println("\n");
        System.out.println("\t==================================================");
        System.out.println("\t ⚞        JEU DU NOMBRE PAIR ET IMPAIR          ⚟");
        System.out.println("\t==================================================");
    }

    @Override
    public void start() throws ExerciceExitException {

        Console.clearConsole();
        showGameMainBanner();
        showGameMainMenu();
        pauseGame();


    }


}
