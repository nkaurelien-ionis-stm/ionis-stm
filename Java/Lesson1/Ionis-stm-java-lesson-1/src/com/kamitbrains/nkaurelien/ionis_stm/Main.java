package com.kamitbrains.nkaurelien.ionis_stm;

import com.kamitbrains.nkaurelien.ionis_stm.exo.Exercice;
import com.kamitbrains.nkaurelien.ionis_stm.exo.ExerciceExitException;
import com.kamitbrains.nkaurelien.ionis_stm.lesson2.Lesson2;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        try {

//            runlesson1();

            runlesson2();


        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }

    }

    public static void runlesson2() {



//------------------------------------------------------

//        List<Character> chars = Arrays.asList(new Character[]{'a','e','i','o','u'});

        // A best  way to declare without redundancy
        List<Character> chars = Arrays.asList('a','e','i','u', 'o');

        if (Lesson2.allLetterFound("Aurelien", chars, false)) {
            System.out.println("All found");
        } else {
            System.out.println("All not found");
        }

//------------------------------------------------------

//        Lesson2.askUserForCharacter();

//-------------------------------------------------------
//        boolean isLetterInWord = Lesson2.isLetterInWord("ludovic", 'c');
//
//        if (isLetterInWord) {
//
//            System.out.println("In word ");
//
//        }

    }

    public static void runlesson1() {
        try {
//            HasPenduImpl.newInstance().start();

            Exercice.getInstance().start();


        } catch (ExerciceExitException e) {
            System.out.println(" ");
            System.out.println("⚡⚡ Au revoir !!! ");
        }

    }
}