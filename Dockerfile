FROM gradle:8.9.0-jdk17 as build
COPY . /app
WORKDIR /app
RUN ./gradlew build -x test

FROM openjdk
COPY --from=BUILD /app/build/libs/ishelt-0.0.1-SNAPSHOT.jar ishelt.jar
ENTRYPOINT ["java", "-jar", "ishelt.jar"]