package com.kamitbrains.nkaurelien.ionis_stm.lesson2.lependule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * This function should check if a letter is present in a word
     * Hint: Maybe a loop could be useful here...
     *
     * @param word   A word to test
     * @param letter A letter to check
     * @return true if found false otherwise
     */
    public static boolean isLetterInWord(String word, char letter) {
//        throw new RuntimeException("You must implement this function first!"); // FIXME: This should be removed

        return word.indexOf(letter) != -1;

    }

    /**
     * Print the word while replacing every character not present in userCharacter by underscores "_".
     * For example if I input "truffade" and the list contains 'f' and 'a' it will print "___ffa__".
     * Hint: Should I type "word." in my IDE to see all the available functions? Also, I like loop!
     *
     * @param word          A word to print
     * @param userCharacter A list of character
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
     * Ask the user for a new character (only one). If more than one ask again he is dumb.
     * Hint: A Scanner could be a great way to do this...
     *
     * @return the new character
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

    /**
     * Check if all the letter in the word were found.
     *
     * @param word           A word to check
     * @param userCharacters Some letters to test
     * @return true upon success, false otherwise
     */
    public static boolean allLetterFound(String word, List<Character> userCharacters) {
        return allLetterFound(word, userCharacters, true);
    }


    /**
     * Check if all the letter in the word were found.
     *
     * @param word           A word to check
     * @param userCharacters Some letters to test
     * @param checkCaseSensitive Define  if the checking are in sensitive case
     * @return true upon success, false otherwise
     */
    public static boolean allLetterFound(String word, List<Character> userCharacters, boolean checkCaseSensitive) {
        if (!checkCaseSensitive) word = word.toLowerCase();

        for (Character character : word.toCharArray()) {

            if (!checkCaseSensitive) character = character.toString().toLowerCase().charAt(0);

//            if (userCharacters.indexOf(character) == -1) return false;

            //better
            if (!userCharacters.contains(character)) return false;


        }

        return true;
    }

    public static void main(String[] args) {
       /*
            Let's hang a pirate!
            Do you remember how this game works?
            Someone give a word, did I ever tell you about my love for good old Scanner?
            Then another person give a letter. Then check if the letter is in the word.
            If it is, print the word without the letter which were not inputted. the ask again
            the user for a character. Until the user give 7 wrong character the game
            should continue. Once there is 7 mistakes or if he found all the letter print
            either "Congratulations you won!" or print "You are not very good at this game,
            the word was" and them display the word. Easy write?
        */

        // Some function to test
        test("Letter not in word", !isLetterInWord("truffade", 'c'));
        test("Letter in word", isLetterInWord("truffade", 'a'));

        // test for all letter in  word
        List<Character> chars = Arrays.asList('a','u','r','e', 'l',  'i', 'e', 'n');
        test("All letter not found in word with checking in sensitive case", !allLetterFound("Aurelien", chars, true));
        test("All letter found in word without checking in sensitive case", allLetterFound("Aurelien", chars, false));

//        List<Character> userList = new ArrayList<>();
//        userList.add('c'); // To add an element to a list
//        userList.remove('c'); // remove the first occurrence
//        userList.size(); // Get the size
//        userList.get(0); // Get the element at the index 0 (could be anything)
    }

    // Some function to print test
    private static void test(String name, boolean cond) {
        System.out.print(name + " ");
        if (cond)
            printOk();
        else
            printKo();
    }

    private static void printOk() {
        System.out.println("[" + ANSI_GREEN + "OK" + ANSI_RESET + "]");
    }

    private static void printKo() {
        System.out.println("[" + ANSI_RED + "KO" + ANSI_RESET + "]");
    }
}
