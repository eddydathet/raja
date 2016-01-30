# A FINIR #

## EquivalentClass ##

**Audrey**

  * Récupérer le model du execute des sous\_adaptater
  * Effectuer une requete du type :
    * SELECT ?b ?c WHERE {?a rdf:type owl:equivalentClass . ?b rdf:type ?a UNION ?c rdf:type ?a . ?c <> ?b}
  * Appliquer la méthode de la prof sur ?b et ?c

## Horizontal découpage ##

Donner un préfixe différent par base : règle le pb du select
Pour les autres vérifier que INSERT FROM XXX.table, ba XXX = préfixe

# Interface graphique #

**Romain**

Projet externe au notre (dans eclipse) qui doit juste importer le notre. Il suffit de redéfinir IIndoor et de créer un serveur en lui passant en paramètre. Ensuite le serveur appellera successivement la fonction read() et la fonction write() (tant que read ne retourne pas "")

# Extracteur d'info OMS #

Créer un petit logiciel qui ira parser les pages de l'OMS pour remplir nos BD en créant un fichier texte et en y inscrivant chaque chose à rentrer sous forme SQL (=INSERT FROM table VALUES('', ...) voir la syntaxe exacte SQL et non pas MySQL ou Oracle). Il nous suffira alors de créer un IIndoorFile avec comme paramètre le fichier généré !!

# N3 connector #

Permettre au N3 de se connecter par programmation (dans le code) et non plus dans le fichier xxx.N3 afin de n'avoir à configurer que le config.xml !! Bien vérifié que personne ne travail sur le fichier (conflit SVN) avant de commiter celui-là !!

# A vous de trouver la suite... #

Tout est bon à prendre si vous avez une idée, une envoe n'hésitez pas !!