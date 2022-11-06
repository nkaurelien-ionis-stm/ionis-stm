<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="Nom Nkumbe Aurelien&#xa;Classe Msc 1 Info" courant="AFFICHER z"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2defaut="" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param epaisseurPoint="2" epaisseurLigne="2" nbDecimales="8" maxBoucle="500000" totalAffichages="1000" totalBoucles="5000000" arrondiAuto="vrai"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="x EST_DU_TYPE NOMBRE" code="1#NOMBRE#x"/>
        <item algoitem="z EST_DU_TYPE NOMBRE" code="1#NOMBRE#z"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Donner un nbre X&quot;" code="4#Donner un nbre X#0"/>
        <item algoitem="LIRE x" code="2#x#pasliste"/>
        <item algoitem="z PREND_LA_VALEUR -3 * x + 2" code="5#z#-3 * x + 2#pasliste"/>
        <item algoitem="AFFICHER &quot;La resultat \n&quot;" code="4#La resultat \n#0"/>
        <item algoitem="AFFICHER z" code="3#z#0#pasliste"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
