-- Q1 : Afficher  les caracteristiques de toutes les trotinnettes 

SELECT * FROM trotinettes;

SELECT caracteristique FROM trotinettes;

-- Q2 : Afficher les utilisateurs qui ont un prenom commencant  par A

SELECT * FROM utilisateurs WHERE prenom LIKE 'A%';

-- Q3 : Afficher les utilisateurs qui ont un nom et  prenom commencant par A et ordonne par ordre aplha de  nom de famille

SELECT * FROM utilisateurs WHERE  nom LIKE 'A%' AND prenom LIKE 'A%' ORDER BY nom ASC ;

-- Q4 : 




