FROM openjdk:17
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3307/patientdb
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=sql-my-beloved
EXPOSE 8080

COPY keycloak.crt /tmp/keycloak.crt
RUN \
    cd $JAVA_HOME/lib/security \
    && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias keycloakcert -file /tmp/keycloak.crt

COPY target/PatientService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]