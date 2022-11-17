import random


def showGameMainBanner() :
    print("\n")
    print("\t===================")
    print("\t ⚞ JEU DU PENDU ⚟ ")
    print("\t===================")
    
def pauseGame() :
    print("\t ☟ Appuyer une touche  pour continuer ")
    print("\t ☟ Presser CTRL+C pour quitter ")

def printSpace() :
    print("\n ")


def showGameFailure() :
    print("Dommmage")


def showGameSuccess() :
    print("Success")

    
def main() :
    remainingChance = 10

    printSpace()
    givenWord = (input("Entrer le  mot a deviné :-> ??? ") or "").strip()
    givenWordHelpMask = "-" * (len(givenWord))
    playedLetters = ""
    printSpace()


    while (True) :
        print("Devinez le mot (%s tentatives restante) : %s" % ( remainingChance, givenWordHelpMask))

        response = (input("\nDonnez une lettre :-> ") or "").strip()[0]
        # return        


        if (playedLetters.find(response) != -1) :
            formatedPlayedLetters = ", ".join(list(playedLetters))
            print(("Vous avez déja donner les lettres : %s" % formatedPlayedLetters))
            continue
        else :
            playedLetters = playedLetters + response

        indexForLower = givenWord.find(response.lower())
        indexForUpper = givenWord.find(response.upper())

        if (indexForLower == -1 and indexForUpper == -1) :

            remainingChance -= 1

            if (remainingChance == 0) :
                showGameFailure()
                break

        # // replace lower case char
        while (indexForLower >= 0) :
            givenWordHelpMask = givenWordHelpMask[:indexForLower] + response.lower()[0] + givenWordHelpMask[indexForLower+1:]
            indexForLower = givenWord.find(response.lower(), indexForLower + 1)
        
        # // replace upper case char
        while (indexForUpper >= 0) :
            givenWordHelpMask = givenWordHelpMask[:indexForUpper] + response.upper()[0] + givenWordHelpMask[indexForUpper+1:]
            indexForUpper = givenWord.find(response.upper(), indexForUpper + 1)



        if (givenWordHelpMask==(givenWord)) :
            showGameSuccess()
            break
        

def start() :
    showGameMainBanner()
    pauseGame()
    main()
    return


start()