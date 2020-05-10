# Projet 3A - Application mobile : Ghibli Repertory 
Ce projet permet de mettre en pratique toutes les notions basiques du développement mobile vues en cours.

À travers l'univers de [Ghibli](https://www.studioghibli.com.au/#films), cette application, nommée **Ghibli Repertory**, propose une description de chaque film produit par le studio d'animation japonais : _Studio Ghibli_.
<p align="center">
 <img src = "https://user-images.githubusercontent.com/63917571/81495887-d810c380-92b3-11ea-981e-bb0caa784abe.png">
 </p>

## Table des matières
* Logiciels utilisés
* Critères de notation
* Fonctionnalités
* Art Design
* Références

## Logiciels utilisés
### <img src = "https://user-images.githubusercontent.com/63917571/81484222-27b7a680-9244-11ea-926d-98b4cbf25aaa.png" width="75" height="75"> Android Studio
Environnement de développement choisi pour développer des apllications mobiles Android.

### <img src = "https://user-images.githubusercontent.com/63917571/81484226-2a1a0080-9244-11ea-91f1-4eb25c4ad807.png"> Paint Tool SAI
Éditeur graphique raster léger et un logiciel de peinture pour Microsoft Windows.

## Critères de notation
### Obligatoires
* Écran avec une liste d’éléments
* Écran avec le détail d’un élément
* Appel WebService à une API Rest
* Stockage de données en cache

### Facultatifs

**Architecture :**
* Singleton
* Design Patterns
* MVC
* Principe SOLID

**Design :**
* Material Design (Android Studio)
* Paint Tool SAI
* Pinterest

## Fonctionnalités
### Écran d'accueil
<p align="center">
<img src="https://user-images.githubusercontent.com/63917571/81483724-93981000-9240-11ea-8079-2fd6139da022.png" width="270" height="480">
</p>
 
* _Press to continue_ : bouton qui permet d'accéder à la page suivante

### Écran répertoire de films
Affiche la liste des films Ghibli.

<img src="https://user-images.githubusercontent.com/63917571/81483725-985cc400-9240-11ea-8a39-ddc0008525dd.png" width="270" height="480"> ![alt-text](https://media.giphy.com/media/U2LpX5f5j4hDqyfjgG/giphy.gif)

* `RecyclerView` : affiche une liste déroulante d'éléments basée sur un/des ensemble(s) de données.

### Écran détails de films
Offre une description complète du film sélectionné.

<img src="https://user-images.githubusercontent.com/63917571/81483501-0607f080-923f-11ea-9502-e5736b4ec5ee.png" width="270" height="480"> ![alt-text](https://media.giphy.com/media/Y3ej0PBjlQ63GtugQm/giphy.gif)

* `ScrollView` : permet de lire toute la description de la page.
* `YouTubePlayerView` : possibilité de regarder une vidéo pour découvrir le monde de Ghibli et ses bandes-annonces.
* _Characters coming soon..._ : bouton qui affiche un Toast "Coming soon..." (pour une future et éventuelle mise à jour de l'application).

## Art Design
Concerne toute la partie graphique utilisée avec Paint Tool SAI pour l'application **Ghibli Repertory**.

### Logo
Logo représentant le personnage emblématique du [Studio Ghibli](http://www.ghibli.jp/).

<p align="center">
<img src="https://user-images.githubusercontent.com/63917571/81483947-0eadf600-9242-11ea-8439-4e153b1209e0.png" width="150" height="150">
</p>

### Boutons
Tous les boutons utilisés dans l'application.

<img src = "https://user-images.githubusercontent.com/63917571/81495936-3d64b480-92b4-11ea-9128-f3206e849b49.png" width="350" hight="100" align="left">
<img src ="https://user-images.githubusercontent.com/63917571/81495939-3f2e7800-92b4-11ea-81a2-1a347dfc7559.png" width="250" hight="50" align="right">
