FROM openjdk:8-jdk-alpine
WORKDIR /workspace/app

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x ./mvnw &&./mvnw install -DskipTests

WORKDIR /app
RUN cp /workspace/app/target/employees.jar /app/employees.jar
ENTRYPOINT ["java","-jar", "employees.jar"]
