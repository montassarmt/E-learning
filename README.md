# E-learning Platform - Event Management Module

## 📆 Branch Overview: gestion-des-événements
This branch implements the event management functionality for the E-learning platform, allowing educational institutions to create, manage, and promote events such as hackathons, conferences, and other learning activities.

## 🚀 Features
- Event Creation and Management*: Create, update, and delete educational events
- Registration of users
- *Calendar Integration*: View events in calendar format 
- Affichage dynamique des événements à venir (slider Angular)
- Create, update and delete hackathons
- Create, update and delete conference sessions

## 🔧 Technologies
Backend: Spring Boot + Microservices (backend2)
Frontend: Angular 15+
Database: MySQL
Cloud Integration:
Eureka (Service Discovery)
Spring Cloud Gateway
Google Calendar API
ZEGOCLOUD (video sessions, optional)

## 🛠️ Prerequisites
Java 17+
Maven 3.x
Node.js 16+ / Angular CLI
MySQL Database
Google Calendar API Key (OAuth2 enabled)


### Installation Steps
Clone the repository and switch to this branch:

   
   git clone https://github.com/montassarmt/E-learning.git
   cd E-learning
   git checkout gestion-des-événements
   
   Configure application.properties for backend2 and gateway
   Start Eureka (http://localhost:8761)
   Launch the API Gateway (http://localhost:8085)
   Start the Angular frontend: ng serve (http://localhost:4200)




## 🔄 Integration
✅ User authentication (for event participation)
✅ Angular toast-based notification system
✅ Gateway routing (http://localhost:8085) to all microservices
✅ Full Google Calendar synchronization (add/update/delete)
✅ visio-conference




## 👥 Contributors
Zeineb jmal (@Zeinebjmal)


## 📅 Last Updated
2025-04-08


