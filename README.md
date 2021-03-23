# POCNDC

Vous trouverez dans de dépôt les fichiers nécessaires à la mise en place du PoC NDC.

Tout d'abord, vous trouverez les sources dans le répertoire "sources" : 
- la conf apache
- le code PHP
- le code java
- le dump de la BDD SQL
- le fichier à déposer dans le stockage objet

Vous trouverez ensuite dans le répertoire "binaires"  :
- le bytecode java

Enfin, vous trouverez dans le répertoire "k8s" :
- des conteneurs prégénérés
- des exemples de scripts de déploiement

À noter que des adaptations devront être faites afin de déployer ces différentes applications dans les différents environnements. Les présents fichiers n'incluent pas :
- la création des objets et ressources externes (BDD PaaS, stockage objet, clusters k8s, infra IaaS, etc.)
- la configuration du service mesh (à faire par vos soins)
- les comptes, la gestion des droits (à créer ou ajuster en fonction de vos besoins)
- les éventuels enregistrements et zones DNS locaux

La cible des PoC est toujours disponible et partagés sur le Teams. N'hésitez pas à y faire référence.

Nous sommes à votre disposition sur votre Teams, n'hésitez pas à nous solliciter.

Merci et à bientôt,
