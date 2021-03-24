# Instructions d'installation

Dans cette arborescence, vous trouverez des exemples de manifestes à utiliser pour déployer les applications dans Kubernetes.

Nous vous laissons les adapter à vos besoins, notamment la différenciation App2 / App3, les modifications de code pour le stockage objet, le nombre de replicas, les liens entre composants et notamment avec la base de données PaaS, les expositions publiques / privées, le service mesh...

```
kubectl apply -f manifests/lamp-k8s-namespace.yaml
kubectl apply -f manifests
kubectl get all -n lamp-k8s
```

