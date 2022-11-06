<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description texte="Somme de  Nombre" courant="// Done"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2para="" F2etat="inactif" F2defaut="" F2lignes=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param epaisseurPoint="2" epaisseurLigne="2" nbDecimales="8" maxBoucle="500000" totalAffichages="1000" totalBoucles="5000000" arrondiAuto="vrai"/>
    <item algoitem="FONCTIONS_UTILISEES" code="200#declarationfonctions"/>
    <item algoitem="VARIABLES" code="100#declarationsvariables">
        <item algoitem="Nb1 EST_DU_TYPE NOMBRE" code="1#NOMBRE#Nb1"/>
        <item algoitem="Nb2 EST_DU_TYPE NOMBRE" code="1#NOMBRE#Nb2"/>
        <item algoitem="SOMME EST_DU_TYPE NOMBRE" code="1#NOMBRE#SOMME"/>
    </item>
    <item algoitem="DEBUT_ALGORITHME" code="101#debutalgo">
        <item algoitem="AFFICHER &quot;Donner le premier nbr&quot;" code="4#Donner le premier nbr#0"/>
        <item algoitem="LIRE Nb1" code="2#Nb1#pasliste"/>
        <item algoitem="AFFICHER &quot;Donner le deuxieme nbr&quot;" code="4#Donner le deuxieme nbr#0"/>
        <item algoitem="LIRE Nb2" code="2#Nb2#pasliste"/>
        <item algoitem="SOMME PREND_LA_VALEUR Nb1+Nb2" code="5#SOMME#Nb1+Nb2#pasliste"/>
        <item algoitem="AFFICHER &quot;La somme \n&quot;" code="4#La somme \n#0"/>
        <item algoitem="AFFICHERCALCUL SOMME" code="20#SOMME#0"/>
        <item algoitem="// Done" code="19# Done"/>
    </item>
    <item algoitem="FIN_ALGORITHME" code="102#finalgo"/>
</Algo>
