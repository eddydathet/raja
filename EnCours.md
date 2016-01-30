# Introduction #

Chacun peu mettre ce qu'il fait à chaque moment pour pas faire deux fois la même chose. De plus je propose de laisser tout comme ça ça fera un historique !!

# Jeudi 30 Décembre #
Audrey : Equivalent class dans le composite
Romain : Version graphique

# Samedi 18 Décembre #
Audrey : implémentation de AdaptaterComposite pour la partie du select, et des requêtes permettant de faire remonter les schémas locaux de chaque base.

Romain : implémentation d'Adapteur donc je toucherais au fichier XML et à la factory

# Vendredi 17 Décembre #

Aloys : M'occupant des query je ferai aussi la queryfactory vu que le code permettant de savoir quel type de requête il faut créer sera dans les classes query.

Audrey : Implémentation de SelectQuery (non terminé)

# Jeudi 16 Décembre #

Romain : ~~je continue car j'ai pas fini hier ! J'ai fais tout le reste de la fabrique mais c'est pas opérationnel donc je commit pas !! Donc je le ferais après comme ça je mergerais !~~

Romain et Audrey : implémentation de N3 translator et les adaptaters niveau ontologique

# Mercredi 15 Décembre #

Aloys : Je m'occupe de l'architecture de Query, ajout des constructeurs, reconstruction des requêtes puis parsage des requêtes, avec des regex je pense (puisque le pattern est bien spécifié dans le rapport), je vois juste ?
>>Romain :
Oui pourquoi pas !! Par contre pense que si c'est RDF il faut pas que tu le touche donc tu le met juste dans _query de Query sinon audrey pourra rien faire !!_

Romain : ~~encore un poil d'uml (ajout des packages + réflexion sur les fabriques + réflexion sur le parsing fichier de config) + débuggage virtualBox (réinstallation du grub = croisons les doigts)~~
~~UML ne sera plus touché pour générer le code !! Pas réussi à faire marcher vm (ON DOIT EN REPARLER TOUS ENSEMBLE) du coup je met en place le code source java (package et résolution d'erreur dû à l'autogénération !!~~
Je m'occupe du parsage XML (donc peu être que j'empièterais sur la fabrique !! Merci de me la laisser (notemment Aloys^^) !!

Audrey : ~~Modification, correction et mise en page du rapport~~


# Mardi 14 Décembre #

Romain : je modifie l'UML et je fais la génération !! Attention alois j'espère que t'as eu mon message !! ++