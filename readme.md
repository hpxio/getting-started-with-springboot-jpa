# Getting Started with Spring Boot JPA

> Spring Data is a project driven by Spring that aims at providing a consistent data access layer for various data stores.


<details>
    <summary>Synopsis</summary>

* [Objectives](#objectives)
* [Pre-requisites](#pre-requisites)
* [Project Structure](#project-structure)
* [Running the Project](#running-the-project)
* [API Details](#api-details)
* [Topics Covered](#topics-covered)

</details>

## Objectives

Learn how to use Java Persistent APIs with Spring Boot via Spring Data JPA module.  
Explore various development recommendations for working with Data access layer.

## Pre-requisites

### Framework/Language Knowledge

To get a good understanding of the internal working, I recommend you have basic understanding of the following topics:

* Developing Restful API with Spring Boot _(for developing testable rest-api)_
* Basic understanding of RDBMS system for working with H2 in-memory database _(for writing SQL)_

### IDE/Tools Setup

Following are the tools & setup I used for developing this application.

* **Development Kit**, 1.8.0_281 (x86_64) By "Oracle Corporation"
* **Project Management**, Apache Maven 3.6.1
* **IDE**, IntelliJ IDEA 2021.3

## Project Structure

The project consists of a single module which uses user-record management as example.
Once the application is running you will be able to create, remove, update & display user data.

<hr/>

## Running the Project
The application is implemented with H2DB (in-memory database).
It uses properties which you can customize as per your need. The default values are listed as follows.

### Properties
> all the properties are available in `src/main/resources/application.yaml`

To access the H2 database console, set the `h2.console.enabled` to **true**.
To set a custom path to access H2 database, set the `h2.console.path` to a valid path.
```yaml
# Enabling H2 Console
  h2:
    console:
      enabled: true

  # Custom H2 Console URL
      path: /h2
```

### Starting the Application

* Go to the `root directory` of the project and run,
    * ```mvn clean spring-boot:run```
* To open h2-console, with default settings you can access it at,
    * ```http://localhost:8089/h2```

_For details about APIs & classes, see api-info.md file._ 

<hr/>

## Topics Covered
Spring dtaa JPA Dependencies, Basic DB Setup, Properties and Customization, JPARepository

### Important References

* [Spring Data JPA - Official API Docs](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface)
* [JPA Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

<hr/>

### Contributions
For adding your contributions, please see **contributing.md** file.

### Changelogs
For changelog & release information, please see *changelog.md** file.