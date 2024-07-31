FROM amazoncorretto:11
WORKDIR /app
COPY . /app
RUN ./gradlew clean build
RUN cp build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]