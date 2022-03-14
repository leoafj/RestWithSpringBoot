FROM openjdk:11-jdk
VOLUMA /tpm
ADD target/rest-with-springboot-udemy-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev./urandom", "-jar", "/app.jar"]