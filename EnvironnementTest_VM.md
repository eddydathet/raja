# Problèmes rencontrés #

## Data-bases Login ##

### Facteur Maladie ###

Utilisez les identifiants de la base de donnée oracle pour se connecter comme utilisateur : dbuser/dbuser.


---


## Boot Device [résolu] ##

Il faut aller dans la configuration de la vm puis :
  * Stockage
  * Click droit sur Contrôleur SATA -> supprimer
  * Click sur l'icone disque dur de contrôleur IDE
  * OK
Et ça marche !!! GG Aloys


---


## Internet ##

Pour donner à votre vm internet (peut être utile pour installer des packets) vous devez :
  * click droit sur réseau en bas à droite de la vm (petite icone avec 2 écran bleau)
  * mode d'accès m'être NAT
  * dans la vm : Système -> administration -> réseau (mot de passe root)
  * click sur Connexion filaire puis propriété
  * mettre DHCP puis OK
  * sélectionner la connexion pour l'activer (click sur la check box)
  * ça cherche un peu et ça trouve !!

Si ça ne marche pas veuillez installer les additions invités


---


## Additions invités ##

Une fois la VM lancée :
  * Périphérique -> installer les aditions...
  * puis dans un terminal
  * cd Desktop
  * sh install.sh (mot de passe root)
  * redémarrer