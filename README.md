# README Bibal

Bibal est une application de gestion de bibliothèque architecturée en deux parties.


## Partie Backend (API)

### Prérequis

* Java 8
* Maven 3.5
* Mysql
* Connexion internet

### Lancement

Au préalable il faut qu'il existe une base de données existante sur le serveur mysql
Les paramètres de la base de données doivent être réglés dans le fichier au chemin :
`bibal-api/src/resources/applications.properties`

Les lignes concernant la base de données

```properties
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/bibal
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
```

Dans le terminal, vérifiez que le dossier courant est bien celui du projet :

```bash
# Compiler le jar et installe les dépendances
mvn clean install -DskipTests

# Lancer l'API (serveur tomcat)
java -jar target/bibal-0.0.1-SNAPSHOT.jar
```

Le serveur Tomcat servant l'API est désormais actif sur localhost:8083

## Partie Frontend

### Prérequis

* Node v8.*
* Npm v5.*
* Connexion internet


### Lancement

Dans le terminal, vérifiez que le dossier courant est bien celui du projet :

```bash
# Installer les dépendances
npm install

# Lancer le serveur de dev avec hot reloading
npm run watch
```

Le navigateur internet par défaut s'ouvrira automatiquement sur la page du site.