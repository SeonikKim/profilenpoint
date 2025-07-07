# 1) Build Stage
FROM gradle:7.6-jdk17 AS builder
WORKDIR /home/gradle/project

# 복사할 항목들
COPY gradlew gradlew
COPY gradle gradle
COPY settings.gradle settings.gradle
COPY build.gradle build.gradle
COPY src src

RUN chmod +x gradlew
RUN ./gradlew clean bootJar -x test --no-daemon

# 2) Runtime Stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]