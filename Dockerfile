FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /opt/app

# Kopiera konfigurationsfiler
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# FIX: Ge kör-rättigheter till Maven Wrapper innan den anropas
RUN chmod +x mvnw

# Ladda ner beroenden (cache-vänligt steg)
RUN ./mvnw dependency:go-offline

# Kopiera källkod och bygg applikationen
COPY ./src ./src
RUN ./mvnw clean install -DskipTests

# Slutgiltig image (Runtime)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /opt/app

# Berätta för omvärlden att appen körs på port 8080
EXPOSE 8080

# Kopiera den färdiga JAR-filen från builder-stadiet
COPY --from=builder /opt/app/target/*.jar /opt/app/app.jar

# Starta appen med prod-profilen
ENTRYPOINT ["java","-Dspring.profiles.active=prod", "-jar", "/opt/app/app.jar" ]