# 📦 User Backend Microservice

Microservice Spring Boot pour la gestion des utilisateurs dans une architecture **microservices**.  
Il offre l'authentification (JWT), l'inscription, la gestion des rôles, et la réinitialisation du mot de passe via email.  
Connecté à un **frontend Angular** et intégré dans une architecture globale avec **API Gateway** et **Eureka Server**.

---

## 🛠️ Technologies

- Java 17 / Spring Boot
- Spring Security / JWT
- MySQL
- Maven
- Email (SMTP)
- Angular (Frontend)
- Microservices (Eureka, Spring Cloud Gateway)

---

## 🚀 Fonctionnalités principales

- ✅ Authentification avec JWT (`/signin`)
- ✅ Inscription avec rôles dynamiques (`/signup`)
  - Rôles supportés : STUDENT (par défaut), TUTOR, PARTNER
- ✅ Envoi d’un **code de vérification par email** pour réinitialisation
- ✅ Vérification du code (`/verify-code`)
- ✅ Réinitialisation du mot de passe (`/reset-password`)
- ✅ Système sécurisé avec Spring Security + Encoder (BCrypt)

---

## 📁 Structure des endpoints

| Méthode | Endpoint                | Description                                      |
|---------|-------------------------|--------------------------------------------------|
| POST    | `/api/auth/signin`      | Connexion (JWT)                                  |
| POST    | `/api/auth/signup`      | Inscription avec rôles                           |
| POST    | `/api/auth/forgot-password` | Envoi d’un code par email                    |
| POST    | `/api/auth/verify-code` | Vérifie le code envoyé par email                 |
| POST    | `/api/auth/reset-password` | Réinitialise le mot de passe                  |

---

## ⚙️ Configuration nécessaire

### `application.properties` (extrait)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=your_password

jwt.secret=your_secret_key
jwt.expirationMs=86400000

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
