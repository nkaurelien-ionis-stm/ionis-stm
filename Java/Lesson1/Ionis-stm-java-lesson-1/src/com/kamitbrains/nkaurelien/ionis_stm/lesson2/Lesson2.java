package com.kamitbrains.nkaurelien.ionis_stm.lesson2;

import java.util.List;
import java.util.Scanner;

public class Lesson2 {


    /**
     * This  function  should  check  if a  letter  is  present in  a  word
     *
     * @param word   A word to test
     * @param letter A letter to check
     * @return true if find false otherwise
     */
    public static boolean isLetterInWord(String word, char letter) {
        return word.indexOf(letter) != -1;
    }


    /**
     * Check if all letter in the word  were found
     *
     * @param word           A word to test
     * @param userCharacters Some letters to test
     * @return true upon success,  false otherwise
     */
    public static boolean allLetterFound(String word, List<Character> userCharacters) {

        return allLetterFound(word, userCharacters, true);
    }

    /**
     * Check if all letter in the word  were found
     *
     * @param word               A word to test
     * @param userCharacters     Some letters to test
     * @param checkCaseSensitive
     * @return true upon success,  false otherwise
     */
    public static boolean allLetterFound(String word, List<Character> userCharacters, boolean checkCaseSensitive) {

        if (!checkCaseSensitive) word = word.toLowerCase();

        for (Character character : word.toCharArray()) {

            System.out.println(character);

            if (!checkCaseSensitive) character = character.toString().toLowerCase().charAt(0);

//            if (userCharacters.indexOf(character) == -1) return false;

            //better
            if (!userCharacters.contains(character)) return false;


        }

        return true;
    }

    /**
     * Check if all letter in the userCharacters list were found in word
     *
     * @param word               A word to test
     * @param userCharacters     Some letters to test
     * @param checkCaseSensitive
     * @return true upon success,  false otherwise
     */
    public static boolean allLetterFound2(String word, List<Character> userCharacters, boolean checkCaseSensitive) {


        if (!checkCaseSensitive) word = word.toLowerCase();

        for (Character character : userCharacters) {

            if (!checkCaseSensitive) character = character.toString().toLowerCase().charAt(0);

            if (word.indexOf(character) == -1) return false;

        }

        return true;
    }

    /**
     * This  function  should  check  if a  letter  is  present in  a  word
     *
     * @param word          A word to test
     * @param userCharacter A letter to check
     */
    public static void printWordWithoutLetter(String word, List<Character> userCharacter) {

        String replacementResult = "";
        char replacementCharacter = '_';

        for (Character character : userCharacter) {

            replacementResult = word.replace(character, replacementCharacter);

        }

        System.out.println(replacementResult);
    }


    /**
     * Ask the user for a new character
     */
    public static char askUserForCharacter() {

        String str = "";

        do {

            Scanner input = new Scanner(System.in);
            str = input.nextLine().trim();

            if (str.length() != 1) {
                System.out.println("Please, give only one character");
            } else break;

        } while (true);

        return str.charAt(0);
    }


}
