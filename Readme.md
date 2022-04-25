Etudiants : De Buyst Harold / Hocquet Colin / Lazaro Adrien / Senicourt Mathis (Tous GROUPE I)

- Description des activités/responsabilités de chaque membre de l'équipe (rappel: les responsabilités doivent être équilibrées) :

RENDU NUMERO 1 :

Harold :
Pour ce premier livrable, je me suis occupé de certaines choses essentielles.
Dans un premier temps, j'ai modifié la classe Face dans le but de l'utiliser pour le parser du fichier PLY.
Je me suis donc occupé de l'écriture de la classe qui s'occupe du parsing d'un fichier PLY, mais aussi d'une classe qui permet de récupérer les informations importantes comme les sommets, le nombre de sommets, les faces etc.
Pour ce parser, Adrien et Colin ont réglés quelques erreurs, ce qui a permi de rendre le parser 100% utilisable.
Après ça, j'ai implémenté quelques fonctions supplémentaires à la classe Matrice, classe composé de méthodes d'homothétie, rotations en X Y Z etc.
Pour compléter cela, j'ai créer une classe de test, où il manque encore quelques fonctions de tests.
Dans l'ensemble, lorsque quelqu'un avait une difficulté ou une erreur, on était tous volontaires pour essayer d'aider et solutionner ces mêmes problèmes.

Colin :
Durant cette première partie de projet, j'étais en charge de l'affichage 2D. 
Tout d'abord, j'ai configuré maven dans le projet.
Ensuite , j'ai effectué un affichage basique d'une fenêtre javaFX. J'y ai implémenté petit à petit des méthodes (affichages des ply(TreeItem) , canvas  et dernièrement un label). J'ai réglé avec Adrien la lecture du PLYParser qu'a fait Harold. Il y avait quelques petites erreurs dans une méthode mais tout le reste fonctionnait bien.
J'ai réussi à faire un affichage correct des ply mais je n'arrivais pas a régler la taille de tout les ply. Certains étaient trop petits et d'autres trop grand. De ce fait , j'ai demandé de l'aide à Adrien qui m'a beaucoup aidé par la suite pour avoir un affichage correct.
J'ai aussi aidé Adrien par moment quand il faisait la translation et la mise à échelle des ply.
Enfin, dans le but d'avoir une fenêtre javaFX correcte , j'ai changé la disposition et la taille des éléments de la  fenêtre javafx de façon à ce qu'il y ait moins de bugs et que ce soit plus jolie.

Adrien : 
Pour ce premier rendu je me suis occupé dans un premier temps de la classe matrice et de la classe point.J'ai régler avec Colin des erreur sur le PLYParser. Puis je me suis occupé de programmer la partie affichage 2d en toujours collaboration avec Colin. Pour cette partie je me suis concentré sur la mise a l'echelle des image resultante des .PLY Ainsi que sur la translation des image en 2d

Mathis :
Pour ce premier livrable, j'ai fais l'ajout de la fonctions 2D a sa forme la plus brut qui a ensuite etait modifiée par Colin pour repondre aux attentes en fonction des contraintes des differents fichiers.
Je me suis aussi occupé de l'ajout de fichier externe aux sources des modeles qui n'est pas encore opperationnel au niveau de la lecture.


- Toutes précisions qui vous semblent importantes pour la bonne évaluation de votre projet (problème spécifique par exemple une absence prolongée de l'un des membres, réalisation dont vous êtes particulièrement fiers, ...) :

Problèmes Techniques :
.Maven
Nous avons perdu énormement de temps avec Maven. Son utilisation était flou et non expliqué. Nous avons eu beaucoup de bug de versions d'eclipse et d'import avec maven. C'était un gros problème , nous avons bien pris une semaine voir plus à le régler pour l'ensemble des membres sauf pour Harold qui a encore un problème que nous ne comprenons pas.
.executable.jar
Nous n'avons également pas réussi à créer le executable.jar. Il y a un problème de version avec les modules de JavaFX qui ne permettent pas de faire fonctionner le .jar. Nous nous en excusons sincérement.  

Problèmes organisation : 

Nous n'avons pas assez travaillé chaque semaine sur le projet. Cependant, nous avons plutôt énormement travailler sur quelques semaines bien précises pour avancer une bonne fois d'un coup. C'est un méthode qui a beaucoup de défauts nous nous en rendons compte et c'est pour cela que par la suite nous allons essayer de plus être constant dans la progression du projet. Beaucoup de méthodes sont encore en phase de test et comme elles ne fonctionne pas très bien , nous ne les avons pas encore ajouter pour éviter des potentiels bugs.



RENDU NUMERO 2 : 

Harold : Lors ce cette 2ème partie du projet, j'ai commencé à travailler assez tard, vers décembre.
Cependant j'ai pu réaliser pas mal de choses. On avait presque tout de bon, mais l'homothétie ne fonctionnait pas. Pourtant toutes les méthodes permettant celle-ci étaient implémentées.
On avait fait Adrien, Colin et moi plusieurs méthodes et j'ai pu régler le problème d'homothétie en remplaçant une fonction par une autre.
Après avoir trouvé l'erreur, j'ai pu rendre fonctionnel dans la même nuit, les rotations en X Y Z, le zoom avec la molette et les translations à l'aide de bouttons.
J'ai aussi implémenter une méthode pour regarder quelle face était la plus proche d'un futur point lumière que Colin essayait de réaliser, en faisant en sorte de rendre les faces comparables.
Après ça j'ai rédigé le XML de règles PMD qu'on devait respecter ainsi que son rapport html.
Pour finir ou presque, j'étais énormément en collaboration avec Colin pour rendre le code plus clean, en commentant les méthodes, attributs pas forcément intuitifs et en suivant les signalements du XML PMD.
J'ai entre temps fait en sorte de rendre l'auto-rotatation (controlleur horloge) fonctionnel que Colin essayait de réaliser.
J'ai aussi essayé d'implémenter des tests mais jUnit me repportais des "failures" que je n'ai jamais compris.
Pour finir j'ai réalisé la documentation javadoc.








Colin : Pour cette 2ème partie du projet , j'ai été en charge de l'implémentation MVC Je travaillais en parallèle avec Adrien qui m'aidait à comprendre le MVC et moi je l'aidais à faire les translations. Grace à cette méthode avec Adrien, nous avons réussis à avancer bien plus vite qu'auparavant! Il a beaucoupé aidé dans le projet. Cela nous a pris beaucoup de temps à comprendre et à réussir à implémenter le MVC mais maintenant tout fonctionne , normalement. J'ai crée les méthodes pour zoomer et les boutons associés car Harold avait déjà fait l'homothétie. J'ai aussi fait le bouton Centrer la figure(centrer la figure en cliquant sur le bouton et aussi au lancement du ply). Je me suis chargé de la javaDoc des classes et des méthodes que j'écrivais tout comme les autres. J'ai créer une nouvelle fenêtre de vue indépendante afin de pouvoir manipuler 2 ply
différents en même temps. J'ai également fait quelques tests (baryCentre , translation , Point/Face , Zoom ). J'ai essayé d'implémenter la lumière mais mes calculs étaient faux et je n'arrivais pas à faire fonctionenr les tests associés. J'ai donc laissé ça de côté mais je n'ai jamais réussi à le faire fonctionner par la suite. En attendant j'ai voulu faire une rotationAutomatique grace à un TimeLine. Je n'arrivais pas à faire bouclé la rotation et j'ai donc demandé de l'aide à Harold qui a refait toute la méthode et l'a fait fonctionner. Ensuite nous avons avec Harold implémenter des règles PMD et avons cleanCode le projet afin de le rendre plus lisible et plus correcte.
















Adrien : 




















Mathis : Pour ce deuxième livrable, je me suis occupé entierement de la parties specifique a l'affichage des faces et des segments qui comprenait :
-l'affichage des faces ou/et des segments selon le choix de l'utilisateur.
(cette partie permetait de recevoir les modifications de couleurs selons la lumieres recus, bien que cette fonctionnalitée n'ait pas aboutie)
-la selection de la couleur du modele directement depuis l'insertion d'un code couleur en hexadecimale, avec un bouton permettant de redefinir la couleur du modele a la couleur initiale.
-l'implementation du mode crazy color visant a colorer de maniere aléatoire toutes les faces a chaque nouveau calcul de position de celles ci si l'utilisateur le shouaitait bien sûr.
-ajout de l'affichage d'une ombre suivant l'affichage du modéle (faces = ombre faces / segements = ombre segments).
-je me suis occupé de l'affichage propre et disctinct des differents groupes de bouton des fonctionalitées ajouté lors de ce second livrable.
Lors de l'ajout de ces fonctionalitées j'ai souvent travaillé seul tout en gardant une bonne communiquation avec les membres du groupe pour toujour garder la même vision du projet. Mong groupe etait bien sûr avec moi si je me posais des questtions vis à vis du projet.
-UML du diagramme de classe fait avec Harold










- Toutes précisions qui vous semblent importantes pour la bonne évaluation de votre projet (problème spécifique par exemple une absence prolongée de l'un des membres, réalisation dont vous êtes particulièrement fiers, ...) :

Problèmes organisation :

Nous n'avons pas vraiment eu de problèmes d'organisation, mais peut être un petit manque de temps dû aux examens qu'il fallait réviser. C'était parfois dur trouver du temps pour avancer sur le projet (d'où la certaines irrégularité des commits).
Mais nous avons eu un problème concernant l'absence d'Adrien. Adrien avait beaucoup donné avant mi-décembre, cependant il n'a pu continuer, la cause étant un important problème familial.


Revue du projet :

Nous sommes fier d'avoir travaillé sur ce projet car nous avons appris pleins de choses utiles dans notre métier. Déjà nous avons été confronté à un projet avec très peu d'aide et juste nous pour nous débrouillé. Cela était très pertubant au début mais nous avons vite gagné des habitudes qui nous ont servies tout au long du projet. Durant cette 2ème partie du projet , nous avons constaté une nette augmentation et facilité du travail en équipe. Nous avons réussi à nous partager les taches bien plus efficacements qu'au 1er livrable car nous avons accumulés de l'expérience au fil des mois. Le projet fut très enrichissant pour nous car nous avons aussi bien appris des individuellements à coder plus proprement et efficacement , mais aussi à travailler en groupe et communiquer par la même occasion.








