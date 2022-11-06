-- Q1 : Afficher  les caracteristiques de toutes les trotinnettes 

SELECT * FROM trotinettes;

SELECT trottinettes.details_complementaires FROM trotinettes;

-- Q2 : Afficher les utilisateurs qui ont un prenom commencant  par A

SELECT * FROM utilisateurs WHERE prenom LIKE 'A%';

-- Q3 : Afficher les utilisateurs qui ont un nom et  prenom commencant par A et ordonne par ordre aplha de  nom de famille

SELECT * FROM utilisateurs WHERE  nom LIKE 'A%' AND prenom LIKE 'A%' ORDER BY nom ASC ;

-- Q4 : Afficher le numéro de série de chaque trottinette ordonné par ordre croissant de sa position en longitude

SELECT serial_number FROM trottinettes ORDER BY MAX(longitude) ASC ;


-- Q5 : Afficher le nom et prénom de tous les utilisateurs qui ont pris une trottinette durant le mois de mai par ordre décroissant de prix, afficher l'historique des courses

SELECT 
U.nom , 
U.prenom , 
L.trottinettes_serial_number,
L.date_enreg , 
F.cout 
FROM locations L
	LEFT JOIN utilisateurs U ON L.utilisateurs_id = utilisateurs.id  
	LEFT JOIN factures F ON F.locations_id = L.id  
WHERE MONTH(L.date_enreg) = 5 
ORDER BY F.cout DESC;