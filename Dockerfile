FROM openjdk:8
EXPOSE 8085
COPY target/springboot-postgres-2024-*.jar springboot-postgres.jar
CMD ["java", "-jar", "springboot-postgres.jar"]