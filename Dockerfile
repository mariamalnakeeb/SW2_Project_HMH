FROM openjdk:8
ADD target/users-sql.jar users-sql.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "user-sql.jar"]