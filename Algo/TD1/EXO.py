


# ------------------


def exercice7 () :


    LIMIT = 10
    list_nombres_paires = [] 

    print("Trouver les  nombres  paires consecutifs")

    nb = int(input("Entrer un nombre entier <--  "))

    while (len(list_nombres_paires) < LIMIT) :
        if (nb % 2 == 0) :
            list_nombres_paires.append(nb)
        nb += 1

    print("Les nombres  paires consecutifs trouvés", list_nombres_paires)




def exercice8 () :

    produit = 1

    print("Trouver le produit des entiers")

    nb = int(input("Entrer un nombre  <--  "))

    for x in range(1, nb + 1) :
        produit *= x

    print("Le produit factoriel de", nb ,"est", produit)



# Exo 9
def exercice9_test_nombre_armstrong(nombre) :
    charaters = list(str(nombre)) 
    result = 0
    for item in charaters :
        nb = int(item)
        result = result + pow(nb,3)
    return int(result) == int(nombre)

def exercice9 () :
    # Nombre d'Armstrong
    print("Nombre d'Armstrong")
    nb = input("Entrer le nombre a vérifié <--  ")
    nb = int(nb)
    for nb_rank in range(1,nb):
        if (exercice9_test_nombre_armstrong(nb_rank)) :
            print(nb_rank)

def exercice10_1 () :

    LIMIT = 10
    max = 0
    for n in range (LIMIT) :
        nb = input("Entrer le ("+ str(n + 1) +") nombre <--") or 0
        nb = int(nb)
        if (nb > max) :
            max = nb
    print("Le max est", max)

def exercice10_2 () :

    LIMIT = 10
    liste_nombres = [] #++++
    max = 1
    for n in range (LIMIT) :
        nb = input("Entrer le ("+ str(n + 1) +") nombre <--") or 0
        nb = int(nb)
        liste_nombres.insert(n, nb) #++++
        if (nb > max) :
            max = nb
    print("Le max est", max)


def exercice10_3 () :

    LIMIT = 10
    liste_nombres = []
    max = 0
    max_idx = None  #++++
    for n in range (LIMIT) :
        nb = input("Entrer le ("+ str(n + 1) +") nombre <--") or 0
        nb = int(nb)
        liste_nombres.insert(n, nb) 
        if (nb > max) :
            max = nb
            max_idx = n + 1 #++++
    print("Le max est", max, " et d'indice " , max_idx) #++++


import random

def exercice11_random_integer_list(limit = 100):
    list_1_to_100 = [] 
    for x in range(1, limit + 1): 
        x = round(random.random() * limit) 
        list_1_to_100.append(x)
    return list_1_to_100

def exercice11_somme(liste):
    s = 0
    for x in liste: 
        s += x
    return s


def exercice11_main():
    list_1_to_100 = exercice11_random_integer_list(100)
    somme = exercice11_somme(list_1_to_100)
    print("La sommme donne", somme)



def exercice11 ():

    LIMIT = 100
    list_1_to_100 = [] 
    somme = 0 
    for x in range(1, LIMIT + 1): 
        x = round(random.random() * LIMIT) 
        list_1_to_100.append(x)
        somme += x
    # print(list_1_to_100)
    print("La sommme donne", somme)

import math
def exercice12 ():

    UNIT_M3 = 8

    print("Calcul du  nombre de radiateur pour chauffer un piece par 8 m3")

    hauteur = input("Entrer la hauteur <--") or 0
    largeur = input("Entrer la largeur <--") or 0
    longeur = input("Entrer la longeur <--") or 0

    aire = float(longeur) * float(largeur) * float(hauteur)

    nb_radiateurs = aire / UNIT_M3

    print("Le nombre de radiateurs necessaires est", math.ceil(nb_radiateurs))

def exercice13 ():
    print("Voir algobox_nkumb_TD1_exo_13.pdf")
    print("ou TP-TD 1 Algo.docx")


def exercice14 ():

    UNIT_LKM = 100

    cout = None

    print("Calcul cout du carburant pour le voyage")


    distance_km = input("Entrer la distance du voyage <--") or 0
    prix_litre = input("Entrer le prix du litre de carburant <--") or 0
    consommation_moy_l_km = input("Entrer la consommation moyenne (en L/"+ str(UNIT_LKM) +"km) <--") or 0

    # Raisonnement par la regle de 3
    # consommation_moy_l_km -----> UNIT_LKM
    # nb_litre ?????            -----> distance_km

    nb_litre = float(distance_km)  * float(consommation_moy_l_km) / UNIT_LKM 
    cout = nb_litre * float(prix_litre)

    print("Le cout du carburant pour le voyage est", math.ceil(cout))




exercice14()