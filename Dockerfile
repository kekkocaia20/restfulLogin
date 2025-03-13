# Usa un'immagine base con OpenJDK
FROM openjdk:17-jdk-slim

# Imposta il working directory all'interno del container
WORKDIR /app

# Copia il file JAR nel container
COPY target/restfulLogin-0.0.1-SNAPSHOT.jar restfulLogin.jar

# Espone la porta che l'applicazione usa (porta 8099 nel tuo caso)
EXPOSE 8099

# Comando per eseguire il file JAR
ENTRYPOINT ["java", "-jar", "restfulLogin.jar"]
