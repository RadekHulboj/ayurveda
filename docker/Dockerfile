# Dockerfile (Spring Boot WAR)
FROM eclipse-temurin:17-jdk-alpine

# Ustawiamy katalog roboczy
WORKDIR /app

# Instalujemy curl
RUN apk add --no-cache curl

# Kopiujemy plik .war do obrazu
COPY ../build/libs/Ayurveda-0.0.1-SNAPSHOT.war app.war

# Otwieramy port aplikacji
EXPOSE 8080

# Uruchamiamy aplikację
ENTRYPOINT ["java", "-jar", "app.war"]
