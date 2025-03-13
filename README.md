📌 Descrizione del Progetto

RestfulLogin è un'API REST costruita con Spring Boot, PostgreSQL e Hibernate per gestire un sistema di autenticazione utente. 
Questo progetto fornisce un'implementazione robusta del login e della registrazione, consentendo agli utenti di accedere e gestire le proprie credenziali in modo sicuro.

🏗️ Tecnologie Utilizzate

-Spring Boot 3.4.3 - Framework per la creazione di applicazioni Java

-PostgreSQL - Database relazionale per la gestione degli utenti

-Hibernate - ORM per la persistenza dei dati

-Docker - Contenitore per il deploy dell'applicazione

-Render + NeonDB - Hosting e database cloud per il deployment

🔥 Funzionalità Principali

✅ Registrazione di un nuovo utente
✅ Login con autenticazione
✅ Gestione degli utenti
✅ Connessione sicura al database PostgreSQL
✅ Deploy automatizzato con Docker su Render

⚙️ Installazione e Setup

1️⃣ Clonare il Repository

git clone https://github.com/kekkocaia20/RestfulLogin.git
cd RestfulLogin

2️⃣ Configurare il Database

Modificare il file application.properties con le credenziali corrette di PostgreSQL.

spring.datasource.url=jdbc:postgresql://host_neon/database
spring.datasource.username=username
spring.datasource.password=password

3️⃣ Creare il JAR

mvn clean package

4️⃣ Avviare l'Applicazione

java -jar target/restfullogin-0.0.1-SNAPSHOT.jar

5️⃣ Usare Docker

docker build -t restful-login .
docker run -p 8099:8099 restful-login

🚀 Deployment su Render

L'applicazione è stata containerizzata con Docker e distribuita su Render con database gestito su NeonDB.

Autore: [Francesco Caianiello]
📧 Contatto: frank.caianiello@gmail.com🔗 LinkedIn: Francesco Caianiello

