# Dockerfile.app
FROM openjdk:17-jdk-slim
WORKDIR /app

# build/libs 안의 JAR 파일을 app.jar 로 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]