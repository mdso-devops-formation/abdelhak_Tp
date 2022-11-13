# abdelhak

Tp DevOps  

Etape 1 :
1. Créer un backend sur github
2. Créer la partie CI (build + création de l'image docker + push image docker sur dockerhub)
3. Créer un namespace sur Minikube + déployer votre composant sur k8s (les fichiers k8s doivent être commité aussi sur le repo git pour la traçabilité.

Etape 2 : 
Faire les mêmes actions que l'étape 1 mais cette fois pour un frontend

Etape 3 : 
Faire communiquer le frontend avec le backend au sein du même cluster k8s

Bonus : 
1. Créer le déploiement k8s d'une base de données (postgres par exemple)
2. Faire brancher le backend sur cette bdd

###  requirment 

you need to install:

mvn 3.8.6

nodejs 14 or 16 >>

mysql server and you have to create a database called "employeemanager"


###  run project in the local

1 to run the angular enter the front repo  and run 
	this command will install all the dependecie you need	
		npm install
	this command wil lunch the angular server
		ng serve

2 to run the spring-boot enter the back repo and run
	this command wil install and run the project 
		mvn package 
	or  
		mvn spring-boot:run
	


 

