FROM openjdk:17
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3307/patientdb
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=sql-my-beloved

EXPOSE 8080
COPY target/PatientService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]