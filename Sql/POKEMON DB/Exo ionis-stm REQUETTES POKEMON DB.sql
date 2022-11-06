
-- recuperer le id et  nom de tout les pokemons
SELECT  pok_id, pok_name  FROM  pokemon;

-- recuperer pokemon de  type slowbro
SELECT t.*, p.pok_name FROM  pokemon p 
INNER JOIN pokemon_types pt ON p.pok_id = pt.pok_id 
INNER JOIN types t ON t.type_id = pt.type_id WHERE p.pok_name LIKE "slowbro";


-- donner  le  nombre de  types existants
SELECT COUNT(*) FROM types;


-- 5 recuperer  les stats de  base du pokemon  chameleon
SELECT p.pok_name, b.* FROM  pokemon p 
INNER JOIN base_stats b ON p.pok_id = b.pok_id 
WHERE p.pok_name LIKE "charmeleon";

-- 6  contre quel type le  pokemom 'fighthing' est le plus efficace

-- 7 quel est le  niveau  minimum  pour qu'un ivysaur evolue?
   
-- 8  quel est le  nom du  pokemon  le  plus  lourd

