# ⚡ FreeMatch

> Programme un évènement sportif facilement et rassemble ta communauté !

## 🎯 Principe de l'application

**FreeMatch** est une plateforme qui permet de **créer et organiser des évènements sportifs** en toute simplicité. L'objectif est de faciliter la mise en place de matchs et d'activités sportives en permettant à tout le monde de :

- 📅 **Créer des évènements sportifs** sur des créneaux horaires spécifiques
- 🏟️ **Réserver des terrains** disponibles dans votre ville
- 👥 **Inviter des participants** à rejoindre vos matchs
- ⚽ **Participer à des évènements** organisés par d'autres joueurs
- 🤝 **Rassembler une communauté** de sportifs autour de votre passion

Que vous soyez amateur de football, basketball, tennis ou tout autre sport, FreeMatch vous aide à organiser vos sessions sportives et à trouver des partenaires de jeu !

---

## 🚀 Démarrage rapide (Local)

### Prérequis
- **Node.js** (v18+)
- **Java JDK 25** (avec `JAVA_HOME` pointant vers cette installation)
- **Gradle** (inclus via wrapper)

### 🛠️ Lancer l'application

#### Avec IntelliJ IDEA

Ouvrir la racine du projet et laisser IntelliJ synchroniser le projet Gradle `server`.
Les configurations partagées du dossier `.run` permettent de lancer **Backend**
(`bootRun`), **Frontend** (`npm run dev`) ou **FreeMatch** (les deux ensemble).
Gradle utilise le JDK indiqué par `JAVA_HOME`, qui doit être Java 25.
Installer les dépendances du frontend avec `npm install` dans `client` avant le premier lancement.

#### 1️⃣ **Backend** (Kotlin/Spring Boot)

```bash
# Se placer dans le dossier server
cd server

# Lancer le serveur Spring Boot
./gradlew bootRun

# Ou sur Windows
gradlew.bat bootRun
```

✅ Le serveur démarre sur **http://localhost:8080**

> 💡 La base de données H2 est automatiquement créée en mémoire au démarrage

#### 2️⃣ **Frontend** (React)

Dans un nouveau terminal :

```bash
# Se placer dans le dossier client
cd client

# Installer les dépendances (première fois uniquement)
npm install

# Lancer le serveur de développement
npm run dev
```

✅ L'application est accessible sur **http://localhost:3000**

### 🎯 Accès rapide

| Service | URL |
|---------|-----|
| **Frontend** | http://localhost:3000 |
| **Backend API** | http://localhost:8080 |
| **Console H2** | http://localhost:8080/h2-console |

---

## ✨ Fonctionnalités principales

- 🔐 **Authentification sécurisée** : Inscription et connexion pour gérer vos évènements
- 🗺️ **Carte des terrains** : Visualisez tous les terrains disponibles près de chez vous
- 📆 **Gestion d'évènements** : Créez, modifiez et supprimez vos évènements sportifs
- 🏅 **Multi-sports** : Support de différents types de sports (football, basketball, tennis, etc.)
- 📱 **Progressive Web App (PWA)** : Installez l'application sur votre téléphone
- 🎨 **Interface moderne** : Design épuré et intuitif avec animations fluides

## 💻 Technologies utilisées

### Frontend
- **React** + **TypeScript** : Interface utilisateur moderne et typée
- **React Router** : Navigation entre les pages
- **Vite** : Build tool ultra-rapide
- **Tailwind CSS** : Styling moderne et responsive
- **PWA** : Application installable sur mobile

### Backend
- **Kotlin** + **Spring Boot** : Serveur performant et scalable
- **H2 Database** : Base de données en mémoire (développement)
- **Spring Data JPA** : Gestion de la persistance
- **Spring Security** + **JWT** : Authentification sécurisée
- **Gradle** : Gestion des dépendances

---

## 📦 Installation complète

### 1. Cloner le repository
```bash
git clone https://github.com/votre-username/free-match.git
cd free-match
```

### 2. Configuration du Backend

Le backend utilise une base de données H2 en mémoire, aucune configuration supplémentaire n'est nécessaire.

```bash
cd server

# Build le projet
./gradlew build

# Lancer l'application
./gradlew bootRun
```

### 3. Configuration du Frontend

```bash
cd client

# Installer les dépendances
npm install

# Lancer en mode développement
npm run dev

# Build pour la production
npm run build
```

---

## 🎮 Utilisation

1. **Créer un compte** : Inscrivez-vous avec votre email et un pseudo
2. **Explorer les terrains** : Parcourez la carte des terrains disponibles
3. **Créer un évènement** : Sélectionnez un terrain, un créneau et le type de sport
4. **Inviter des joueurs** : Partagez votre évènement avec vos amis
5. **Participer** : Rejoignez les évènements créés par d'autres joueurs

---

## 🛠️ Commandes utiles

### Backend
```bash
# Lancer les tests
./gradlew test

# Build le projet
./gradlew build

# Nettoyer le build
./gradlew clean
```

### Frontend
```bash
# Lancer en mode dev
npm run dev

# Build pour production
npm run build

# Preview du build
npm run preview

# Linter
npm run lint
```

---

## 🤝 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :
- 🐛 Signaler des bugs
- 💡 Proposer de nouvelles fonctionnalités
- 🔧 Soumettre des pull requests

## 📄 Licence

Ce projet est sous licence MIT.

## 👨‍💻 Auteur

Développé avec ❤️ pour faciliter l'organisation d'évènements sportifs.

---

**FreeMatch** - *Jouez ensemble, simplement !* ⚡