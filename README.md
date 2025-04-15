🧠 E-learning Platform - Test & Exam Management Module
🎯 Branch Overview: gestion-des-tests
Ce module permet aux enseignants de créer, gérer et évaluer des tests et des examens, avec prise en charge des quiz à choix multiple et des examens à réponse libre. Il prend également en charge la génération de certificats et l’évaluation automatique.

🚀 Features
Création et gestion de tests et examens

Type de test : QUIZ, TEST_WITH_CERTIFICATE, TEST_WITHOUT_CERTIFICATE

Questions liées à chaque test avec validation automatique

Support des types de questions

Quiz : 4 réponses à choix multiple, 1 seule correcte

Examen : réponse libre texte

Soumission et correction automatique des quiz

Aperçu des questions avant soumission

Timer pour les quiz

Évaluation avec score en %

Génération de certificats pour les tests valides

Notifications via ngx-toastr

🔧 Technologies
Backend: Spring Boot + Microservices

Frontend: Angular 18 (standalone components)

Base de données: MySQL / H2

Cloud Integration:

Eureka (Service Discovery)

Spring Cloud Gateway

Notifications: ngx-toastr

Timer: Intégré côté Angular

🛠️ Prerequisites
Java 17+

Maven 3.x

Node.js 18+

Angular CLI 18

MySQL

⚙️ Installation
bash
Copier
Modifier
# Clone du projet
git clone https://github.com/tonuser/E-learning.git
cd E-learning
git checkout gestion-des-tests
📦 Backend
Configurer application.properties du microservice backend2 (test-service)

Lancer Eureka Server → http://localhost:8761

Lancer API Gateway → http://localhost:8085

💻 Frontend
bash
Copier
Modifier
cd frontend
npm install
ng serve
Accès via : http://localhost:4200

🔄 Integration
✅ Authentification utilisateur pour passer les tests
✅ Enregistrement et correction des résultats de quiz
✅ Soumission avec timer intégré
✅ Communication via Spring Gateway
✅ Intégration avec la logique de certificat
✅ Notifications toast dynamiques

👥 Contributors
Iyed Tlili (@IyedTlili)

[Les membres de l'équipe ÉcoTechno]

📅 Last Updated
2025-04-14
