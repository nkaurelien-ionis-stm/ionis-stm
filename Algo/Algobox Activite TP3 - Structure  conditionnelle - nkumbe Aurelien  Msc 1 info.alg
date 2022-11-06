<?xml version="1.0" encoding="UTF-8"?>
<Algo>
    <description courant="FIN_SINON" texte="Nom: Nkumbe Aurelien&#xa;Classe: Msc 1 info"/>
    <extension extnom="inactif"/>
    <fonction fctetat="inactif" fctcode=""/>
    <F2 F2lignes="" F2defaut="" F2etat="inactif" F2para=""/>
    <repere repcode="-10#10#-10#10#2#2" repetat="inactif"/>
    <param totalBoucles="5000000" epaisseurLigne="2" nbDecimales="8" maxBoucle="500000" epaisseurPoint="2" totalAffichages="1000" arrondiAuto="vrai"/>
    <item code="200#declarationfonctions" algoitem="FONCTIONS_UTILISEES"/>
    <item code="100#declarationsvariables" algoitem="VARIABLES">
        <item code="1#NOMBRE#x" algoitem="x EST_DU_TYPE NOMBRE"/>
        <item code="1#NOMBRE#moduleDuNbre" algoitem="moduleDuNbre EST_DU_TYPE NOMBRE"/>
    </item>
    <item code="101#debutalgo" algoitem="DEBUT_ALGORITHME">
        <item code="4#Je m'appelle nkumbe Aurelien , je suis en Msc 1 info#1" algoitem="AFFICHER &quot;Je m'appelle nkumbe Aurelien , je suis en Msc 1 info&quot;"/>
        <item code="4#Donner un nbre X#0" algoitem="AFFICHER &quot;Donner un nbre X&quot;"/>
        <item code="2#x#pasliste" algoitem="LIRE x"/>
        <item code="5#moduleDuNbre#x%2#pasliste" algoitem="moduleDuNbre PREND_LA_VALEUR x%2"/>
        <item code="6#moduleDuNbre == 0" algoitem="SI (moduleDuNbre == 0) ALORS">
            <item code="7#debutsi" algoitem="DEBUT_SI"/>
            <item code="4#Pair#0" algoitem="AFFICHER &quot;Pair&quot;"/>
            <item code="8#finsi" algoitem="FIN_SI"/>
            <item code="9#sinon" algoitem="SINON">
                <item code="10#debutsinon" algoitem="DEBUT_SINON"/>
                <item code="4#Impair \n#0" algoitem="AFFICHER &quot;Impair \n&quot;"/>
                <item code="11#finsinon" algoitem="FIN_SINON"/>
            </item>
        </item>
    </item>
    <item code="102#finalgo" algoitem="FIN_ALGORITHME"/>
</Algo>
