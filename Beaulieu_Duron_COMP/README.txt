Compilation :
se positionner dans le src 
$	./make.sh
Le programme ./make.sh va juste faire "cd .." et executé le makefile fournis à l'origine puis ce remetre dans le src

Execution :
$	java VslComp fichierACompiler

si antlr n'est pas définit en variable d'environnement :
$	java -cp chemin/antlr.jar: VslComp fichierACompiler

Pour afficher le code 3 adresse produit :
dan VslComp.java, enlever le commentaire ligne 87

Pour produire le code MIPS dans un fichier :
enlever les commentaires ligne 91 (et eventuellement changer le nom de fichier), 92, 93 et 96.

