# Lundi 20 #

Query : Tous les vector

&lt;String&gt;

 (sauf from) deviennent Vector

&lt;Pair&gt;

String, String>> où le 1er string est le nom de la colonne et le 2eme la valeure
ConditionnaleQuery : Rajout de Vector

&lt;String&gt;

 connector
Tous les ResultSet deviennent des Model (plus facil à ajouter dans le surmodel)
Delete de isQueryMatching car ça sert à rien de faire 2 fois le même travail
SelectQuery : ajout de static DROITE, MILIEU et GAUCHE pour savoir dans le triplet où est ce qu'on cherche + createDescribeQuery qui permet de récupérer un model au lieu de resultSet + selectQueryToDescribe (remplace select par describe) + getQueryWithPrefix pour avoir les prefix d'un query

# Samedi 18 #

Query.SelectQuery : ajout du getWhere et getSelection pour accèder à la partie select de la requete et à la partie where de cette requête

Server.Adapter : Adapter prend en charge la liste des prefix comme ça les composite ont les prefix des OWL et les terminal ont les prefix des N3

# Vendredi 17 #

~~Aloys : Rapport OK, rien à ajouter.~~

# Mercredi 15 #

~~Server.Server : init(String fileConfig, IIndoor indoor)~~

~~Factory : xmlToDataBase, xmlToAdapters, xmlToTerminalAdapter~~

~~Adapter.CompositeAdapter : constructor(file OWL)~~

~~ServerdataBase remove parse(config)~~

~~Translator.N3 : suppression des sous classes Horizontal et Vertical (pb déplacé dans le xml avec getMetaInfo)~~

~~Query Architecture : rajout des constructeurs par défaut : instanciation des vector.~~

~~Query.SelectQuery : herite de IQuery et non plus de ConditionalQuery, l'attribut est String query, donc~~

~~Query.Query : on vire le booleen isSql~~