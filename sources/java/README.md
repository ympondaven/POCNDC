# App4

Pour l'application java App4 à exécuter en mode serverless, là encore, il vous faut adapter le code, notamment :

- pour accéder au stockage objet avec le bon SDK et les bons paramètres (dans l'exmple donné, le SDK AWS est utilisé pour aller récupérer le fichier sur le stockage objet, à adapter donc)
- pour accéder à l'application App3 depuis App4 (ce qui va dépendre, notamment, si vous appelez App3 en interne depuis un namespace, ou si vous utilisez une exposition via un ingress à définir au niveau de App3)

L'archive pocndcserverless.tgz, dans /sources/, vous propose un exemple d'exécution du code applicatif.
