import random


def devinette_v1() :

    listepays=["allemagne","angleterre","autriche","bulgarie","chypre","croatie","danemark","espagne","estonie","finlande","france","grece","hongrie","irlande","italie","lettonie","lituanie","luxembourg","malte","hollande","portugal","republique tcheque","roumanie","slovaquie","slovenie","suede"]

    nombre_essai = 10

    print("*******  ⚞ tester votre  culture general - devinez le nom dun  pays ⚟ *******")

    response = input("La premiere lettre ")

    selected_pays = False

    # select le mot a deviné
    for i in range(len(listepays)):
            if listepays[i][0] == response[0]:
                selected_pays = listepays[i]
                break

    if(selected_pays == False) :
        print("Aucun resultat, on reprend  a zero \n\n\n")
        devinette_v1()

    print("le nombre de caractere dans le  nom du pays ", len(selected_pays) )
    # print("Le pays choisi ", selected_pays)
    # return

    while (True) :

        response = input("Tentez votre chance ( " , nombre_essai, " tentatives restantes )", " :->  ??? "  )

        exists = any(elem == response for elem in listepays)
        if(exists) :
            print("⚜⚜⚜☺☺☺☺☺☺☺☺☺☺☺☺☺☺⚜⚜⚜")
            print("Bravo !!!! le mot était " , selected_pays)
            break

        nombre_essai -= 1

        retry = input("Re-Tentez?(o/0)")

        if (len(retry) == 0 or retry[0] != "o") :
            break

        # fin while



devinette_v1()
