
![IronHack Logo](https://s3-eu-west-1.amazonaws.com/ih-materials/uploads/upload_d5c5793015fec3be28a63c4fa3dd4d55.png)

# Santander-Final-Project

## Index
* [1. Introduction](#introduction)
  * [1.1. Credentials](#credentials)
* [2. Tools](#tools)
* [3. Methodology](#methodology)

## Introduction
The goal of this project was fully deploy a application with the back-end developed in Spring Framework and the front-end using Angular.

Once in the application, the first thing users will come accross is the #login page, where they could login if they had an account or go to #sign-in page
where they can register.

The first approach was to configure a Zuul Proxy that would connect to the Auth-Service in order to get the users authenticated and then serve as a Gateway to the rest of services:


Due to being unable to get the Authorizations back from Zuul Proxy to the Client the app was unable to work. So in the last days I had to make the decision and forget about the Zuul Proxy and stay with an Edge-Service that would be the same that authenticated the users and then access the rest of services:


Anyway the **Zuul version of the project** can be found in the branch with the same name.

### Credentials
The credentials to log into the application are:

| Username | Password |
| ------ | --------------- |
| admin   | admin | 

Also note that the user **must create an account** in order to use the app as user.

The **front-end** application is **deployed in Cloud, using Heroku**.

You can access in here: https://xabi-iron-bank.herokuapp.com.

## Tools
- Angular (including HTML, CSS and TypeScript) to create the front-end to the previous project deployed on heroku.
- Heroku to deploy the updated app in Cloud.
- IntelliJ to develop the back-end with Spring Framework

## Methodology
The aplication is a single-page app where the users can:
* **Login**: Allow users to login by passing the correct credentials.
* **Create an Account**: If user doesn't have an account they can create it here.
* **Account page**: Were users can preview all the banking accounts they have and access to a "more info. page".
* **Account information**: The users can make Transactions to other accounts and check the transactions made with that account.
* **Admins**: They can update the amount of Money in the accounts.

## Requisites
* Include a Java/Spring Boot back-end and an Angular front-end
* Include at least 3 SQL database tables
* Include at least 1 MongoDB
* Include at least 4 services plus at least 1 edge service
* Include a user and an admin view
* Include at least 1 GET, POST, PUT/PATCH, and DELETE route
* Include adequate and complete documentation
* Include at least 1 technology, tool, framework, or library that has not been covered in class



