Bienvenue dans Share, pour utiliser nos services veuillez suivre ces étapes :

	-Choisir les modules à implémenter (le module Profil est obligatoire)

	-Pour le serveur, aller dans le dossier RMI-Server. 
	 Ici copier dans le dossier bin les fichiers .class se trouvant dans les modules choisis.
	-Pour lancer le serveur rentrer la ligne de commande depuis le dossier bin de RMI-Server :
		java -Djava.security.policy=policyServer Server 'numero de port'    

	-Pour le client, aller dans le dossier RMI-Client. 
	 Ici copier dans le dossier bin les fichiers .class se trouvant dans les modules choisis.
	 Ensuite copier tout les fichiers .class de votre IHM.
	-Pour lancer le serveur rentrer la ligne de commande depuis le dossier bin de RMI-Client :
		java -Djava.security.policy=policyClient Client 'numero de port' 'adresse IP du server'