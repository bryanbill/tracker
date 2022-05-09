# Tracker

### (Tracker - Moringa School Project)

- [Description](#overall-project-description)
- [Setup instructions](#setup-instructions)
- [Technology Used](#languages-and-frameworks)
- [Licence](#Licence)
- [Authors Info](#Author)

## Overall Project Description

- Tracker is an application that helps Rangers track animals in the wild.

## Setup Instructions

### Clone the repository

HTTPS: `git clone https://github.com/bryanbill/tracker.git`

SSH: `git clone git@github.com:bryanbill/tracker.git`

### Install dependencies
```bash
mvn clean install
```

### Create Tables (if they don't exist) - This is taken care of by default (Seeding)
```sql
CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, " +
                            "username VARCHAR(255) UNIQUE,fullName VARCHAR(255), " +
                            "company VARCHAR(255), password VARCHAR(255));

CREATE TABLE IF NOT EXISTS animals (id SERIAL PRIMARY KEY, " +
                    "animalname VARCHAR(255) UNIQUE, " +
                    "animaltype TEXT, " +
                    "age TEXT, health VARCHAR(255));

CREATE TABLE IF NOT EXISTS sightings " +
                            "(id SERIAL PRIMARY KEY, loc VARCHAR(255), animalid VARCHAR(255), rangerid VARCHAR(255))
```
### Run the application
```bash
mvn exec:java
```

## Languages and Frameworks

- Java
- Gradle
- Spark
- PostgreSQL
- Handlebars


## Known Bugs

- Currently not aware of any. Open to project improvement suggestions.

## Contributing

Contributions to the project are welcome. Fork this repo to contribute.u

## Live Site

#### Available Here: (http://tracker.soloo.me/)


## Licence

[MIT LICENCE](LICENSE)

## Author

- [Brian Omondi](https://github.com/bryanbill)
