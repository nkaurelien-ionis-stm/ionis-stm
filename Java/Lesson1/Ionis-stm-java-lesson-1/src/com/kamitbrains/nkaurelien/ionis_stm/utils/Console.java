package com.kamitbrains.nkaurelien.ionis_stm.utils;

import java.util.Scanner;

public class Console {

    public static void clearConsole() {

        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    public static void printWords(String string) {
        System.out.print(string);
    }

    public static void printSpace(int lineCount) {
        System.out.print("\n".repeat(lineCount));
    }

    public static void printSpace() {
        System.out.print("\n".repeat(6));
    }


    public static void printLine() {
        System.out.println();
    }
    public static void printLine(String string) {
        System.out.println(string);
    }

    public static String readLine(String string) {
        System.out.print(string);
        System.out.print(": ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }


    public static String readFirstLetter(String string) {
        System.out.print(string);
        System.out.print(": ");
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim().charAt(0) + "";
    }
}
