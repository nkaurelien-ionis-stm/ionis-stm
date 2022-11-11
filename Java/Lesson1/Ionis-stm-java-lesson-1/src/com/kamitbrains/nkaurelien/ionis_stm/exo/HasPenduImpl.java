package com.kamitbrains.nkaurelien.ionis_stm.exo;

import com.kamitbrains.nkaurelien.ionis_stm.utils.Console;

import java.util.Random;

public class HasPenduImpl implements IGame {


    public static int NB_ERREURS_MAX = 2; //Le nombre d'erreur maximale toélérées
    public int remainingChance; //
    private String givenWord;

    public HasPenduImpl() {
        remainingChance = NB_ERREURS_MAX;
    }


    public static HasPenduImpl newInstance() {
        return new HasPenduImpl();
    }


    @Override
    public void showGameMainMenu() {

    }

    @Override
    public void showGameMainBanner() {
        System.out.println("\n");
        System.out.println("\t===================");
        System.out.println("\t ⚞ JEU DU PENDU ⚟ ");
        System.out.println("\t===================");
    }

    @Override
    public void start() throws ExerciceExitException {
        Console.clearConsole();
        showGameMainBanner();
        showGameMainMenu();
        pauseGame();
        main();
    }


    public void main() {


        givenWord = Console.readLine("Entrer le  mot a deviné").trim();
        String givenWordHelpMask = "-".repeat(givenWord.length());
        String playedLetters = "";
        Console.printSpace();

        do {
            Console.printLine(String.format("Devinez le mot (%s tentatives restante) : %s", remainingChance, givenWordHelpMask));

            String response = Console.readFirstLetter("\nDonnez une lettre").trim();


            if (playedLetters.lastIndexOf(response) != -1) {
                String formatedPlayedLetters = String.join(", ", playedLetters.split(""));
                Console.printLine(String.format("Vous avez déja donner les lettres : %s", formatedPlayedLetters));
                continue;
            } else {
                playedLetters = playedLetters.concat(response);
            }

            StringBuilder nextGivenWordHelpMask = new StringBuilder(givenWordHelpMask);

            int indexForLower = givenWord.indexOf(response.toLowerCase());
            int indexForUpper = givenWord.indexOf(response.toUpperCase());

            if (indexForLower == -1 && indexForUpper == -1) {

                decrementRemainingChance();

                if (remainingChance == 0) {
                    showGameFailure();
                    break;
                }

            }

            // replace lower case char
            while (indexForLower >= 0) {

                nextGivenWordHelpMask.setCharAt(indexForLower, response.toLowerCase().charAt(0));

                indexForLower = givenWord.indexOf(response.toLowerCase(), indexForLower + 1);
            }
            // replace upper case char
            while (indexForUpper >= 0) {

                nextGivenWordHelpMask.setCharAt(indexForUpper, response.toUpperCase().charAt(0));

                indexForUpper = givenWord.indexOf(response.toUpperCase(), indexForUpper + 1);
            }

            givenWordHelpMask = nextGivenWordHelpMask.toString();


            if (givenWordHelpMask.equals(givenWord)) {
                showGameSuccess();
                break;
            }

        } while (true);

    }

    private void showGameSuccess() {
        Console.printLine();
        Console.printLine("☛ Vous trouver le mot : " + givenWord);
        Console.printLine();
        Console.printLine("⚜⚜⚜☺☺☺☺☺☺☺☺☺☺☺☺⚜⚜⚜");
        Console.printLine("⚜⚜⚜ Houhaa!!! Vous avez gagner ⚜⚜⚜");
        Console.printLine("⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜⚜");
    }

    private void showGameFailure() {
        Console.printLine("");
        Console.printLine("☢☢☢☢☢☢☢☢☢☢☢☢");
        Console.printLine("Ohh noo!!! Vous avez perdu");
        Console.printLine("☢☢☢☢☢☢☢☢☢☢☢☢");
        Console.printLine("");
        Console.printLine("☛ Le mot etait " + givenWord);
        Console.printLine();
    }

    public void decrementRemainingChance() {
        remainingChance--;
    }

    public static void mainBackup() {


        int i; //Une variable de boucle

        String tabMots[] = {"ablation", "hypocrisie", "interminable", "revolution", "erudit", "feudiste", "accueil", "explosion", "reliure", "niais", "petit", "piquet", "blond", "punk"};//Tableau contenant tous les mots a trouver.

        Random rand = new Random(); //Déclaration de l'objet rand, qui servira a utiliser des nombre aléatoire.

        int nbAleatoire = rand.nextInt(tabMots.length); //Cette variable contient un nombre compris entre 0 et la valeur de la taille du tableau des mots a chercher.

        String motADeviner = tabMots[nbAleatoire]; //On insère dans la variable motAdeviner le mots qui a été tiré au hasard

        int longueurMotAChercher = motADeviner.length(); //On stock dans cette variable la longueur du mot a Deviner.

        char tabMotAChercher[]; //On créer un tableau de caractère de même taille que la longueur du mot a chercher

        tabMotAChercher = new char[longueurMotAChercher];

        char lettreSaisie; //Servira pour la saisi de la lettre

        boolean motTrouve = false; //Nous permettra de savoir si le mot est trouve ou pas.

        int nbLettresBonnes = 0; //Le nombre de bonnes lettres trouvés.

        boolean bonneLettre = false; //Nous permettra de savoir si l'utilisateur a entrée une lettre qui se trouve dans le mot ou non?

        int nbErreur = 0; //Le nombre d'erreur.

        boolean identique = false; //Nous permettra de savoir si l'utilisateur a saisi une lettre identique, qui est déjà afficher a l'écran dans le mot.

        String continuer = ""; //Afin de faire des pauses dans le programme

        int k = 0;//Permettra de décaler les cases du tableau de lettres fausse de 1 a chaque erreur.

        boolean difference;//Nous permettra de juger si la lettre que l'utilisateur a saisi est différente ou non du mot.

        boolean identique2 = false; //Nous permettra de savoir si l'utilisateur a saisi une lettre identique, qui n'est pas contenu dans le mot mais qui a été déjà saisie par l'utilisateur.

        char verifSaisie[];//Ce tableau contiendra toutes les lettre fausses saisie par l'utilisateur, sa taille est égal au nombre d'erreur.

        verifSaisie = new char[NB_ERREURS_MAX];

        //ENTETE

        System.out.println("*********************************");
        System.out.println("*Bienvenue dans le jeu du pendu!*");
        System.out.println("*********************************");
        System.out.println("");
        //FIN ENTETE


        //On insère les différents lettres du mots a l'aide de cette boucle

        System.out.print("Voici le mot a trouver: ");


        for (i = 0; i < tabMotAChercher.length; i++) {

            if (i == 0) { //On insére la première lettre du mot dans la case 0

                tabMotAChercher[i] = motADeviner.charAt(i);
            } else if (i == tabMotAChercher.length - 1) { //On insère la dernière lettres du mot dans la dernière case

                tabMotAChercher[i] = motADeviner.charAt(i);


            } else {

                tabMotAChercher[i] = '-'; //Pour le reste entre on insère des tirets
            }

            System.out.print(tabMotAChercher[i]); //Affichage des caractères.
        }


        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("");

        do {

            nbLettresBonnes = 0; //Pour l'instant aucune lettre est bonnes.

            bonneLettre = false; //Idem.


            do
            { //Tant que l'utilisateur a saisi des lettres qu'il a déjà saisi auparavant on execute les instruction ci dessous.


                if ((identique != false) || (identique2 != false)) {

                    System.out.println("");
                    System.out.println("-------------------------------------");
                    continuer = Console.readLine("ERREUR:Cette lettre a deja ete saisie dans le mot (Appuez sur entree pour continuer)");
                    System.out.println("-------------------------------------");
                    System.out.println("");
                    System.out.print("RAPPEL: le mot a chercher est: ");


                    for (i = 0; i < tabMotAChercher.length; i++) { //On réaffiche le mot a chercher en cas de saisie de lettre déjà saisie.

                        System.out.print(tabMotAChercher[i]);


                    }

                    System.out.println("");
                    System.out.println("");

                }

                lettreSaisie = Console.readLine("Quelle lettre desirez vous entrer? ").toLowerCase().charAt(0); //On demande a l'utilisateur de saisir une lettre, on converti cette lettre en minuscule grace a toLowerCase afin d'éviter tout ambiguité

                difference = true;

                identique = false;
                identique2 = false;

                for (i = 0; i < NB_ERREURS_MAX; i++) { //Cette boucle parcours le tableau des lettres érronés, si la lettre saisie par l'utilisateur est déjà contenu dans le tableau alors on considère cette lettre saisie a été saisie auparavant.

                    if (verifSaisie[i] == lettreSaisie) {

                        identique2 = true;
                    }
                }


                for (i = 1; i < tabMotAChercher.length - 1; i++) {//Si l'utilisateur a saisie une lettre qui est contenu dans le mot ou si la lettre saisie  se trouve dans le tableau des lettres fausses déjà saisie, alors difference devient faux. L'utilisateur a donc juste.

                    if ((lettreSaisie == motADeviner.charAt(i)) || (identique2 == true)) {

                        difference = false;

                    }
                }


                if (difference == true) { //Si difference est vrai cela signifie que l'utilisateur s'est trompé on met alors la lettre fausse dans le tabmeau des lettre fausse VerifSaisie.


                    verifSaisie[k] = lettreSaisie;

                    k = k + 1;

                }


                for (i = 1; i < tabMotAChercher.length - 1; i++) {//On regarde si la lettre saisie par l'utilisateur n'est pas déjà visible a l'écran.

                    if (lettreSaisie == tabMotAChercher[i]) {

                        identique = true;
                    }

                }


            }

            while ((identique != false) || (identique2 != false));


            System.out.println("");


            //On utilise cette boucle pour vérifier si la lettre saisie correspond bien avec une des lettre dans le mot.

            for (i = 1; i < tabMotAChercher.length - 1; i++) {


                if (lettreSaisie == motADeviner.charAt(i)) {


                    tabMotAChercher[i] = lettreSaisie;//S'il ya correspondance alors on remplace le tirer par la lettre.

                    bonneLettre = true;//Cela est donc une bonne lettre
                }


            }

            if (bonneLettre != true) { //Si l'utilisateur s'est trompé alors on lui ajoute une erreur

                nbErreur = nbErreur + 1;

                continuer = Console.readLine("Aucune lettre ne correspond a votre saisie il vous reste : " + (NB_ERREURS_MAX - nbErreur) + " Chances! (Appuyez sur entree pour continuer)");
                System.out.println("");
            }


            if (nbErreur != NB_ERREURS_MAX) {


                for (i = 1; i < tabMotAChercher.length - 1; i++) {


                    if (tabMotAChercher[i] == motADeviner.charAt(i)) { //On comptabilise le nombre de bonnes lettre trouvé.

                        nbLettresBonnes = nbLettresBonnes + 1;


                    }

                    if (nbLettresBonnes == motADeviner.length() - 2) { //Si le nombre de bonnes lettres correspond au nombre de tirets dans le mots alors MotTrouve prends vrai l'utilisateur a gagner.

                        motTrouve = true;

                        System.out.println("Vous avez trouvez le mot feliciations!");
                        System.out.println("");
                        System.out.println("Le mot etait: " + motADeviner);


                    }

                }


                if (motTrouve != true) {


                    System.out.println("Vous avez trouve en tout " + nbLettresBonnes + " lettres."); //Si le mot n'est pas trouvé alors on affiche le nombre de lettre trouvé en tout
                    System.out.println("");
                    System.out.print("Maintenant le mot devient: ");

                    for (i = 0; i < tabMotAChercher.length; i++) {

                        System.out.print(tabMotAChercher[i]); //On affiche le mot après que l'utilisateur est trouver une des lettres


                    }

                    System.out.println("");
                    System.out.println("");

                }
                System.out.println("-----------------------------------");
            }
        }

        while ((motTrouve == false) && (nbErreur != NB_ERREURS_MAX)); // On execute les blocs d'instruction du dessus tant que le joueur n'a pas perdu ou tant que le mot a trouver n'est pas trouvé.

        if (nbErreur == NB_ERREURS_MAX) { //Quand on atteint le nombre d'erreur max le joueur perds...
            System.out.println("-----------------------------------");
            System.out.println("Fin de partie vous avez perdu!");
            System.out.println("");
            System.out.println("Le mot etait: " + motADeviner);

        }
    }
}
