import random

def poesie() :
    noms = ["Vos yeux","Vos sourires","Vos cheveux","Vos mains","Vos regards"]
    verbes = ["sont tels","me font penser à", "m'évoquent", "me font perdre dans", "me donnent", "me conduisent à","me apportent","m'amènent à","me font penser à"]
    complements = ["un air de Mozart","un clair de lune","un coucher de soleil","une aurore boréale","une sonate de Bach","un concerto de Vivaldi"]
    adjectifs = ["magnifique","féérique", "magique", "fabuleux", "extraordinaire","inimaginable","incroyable"]
    complement_temps = ["à Acapulco","sur les hauts plateaux tibétains","dans la baie du Mékong","au bord de la Seine","au sommet de la tour Eiffel", "dans la roseraie unique du monde","dans le pays immaginaire","sur le port d'Amsterdam","au sommet d'Himalaya"]


    nom = random.choice(noms)
    verbe = random.choice(verbes)
    complement = random.choice(complements)
    adjectif = random.choice(adjectifs)
    complement_temp = random.choice(complement_temps)

    poeme  = ' '.join([nom, verbe, complement, adjectif, complement_temp])

    return poeme

for i in range(5):
    print(poesie())