# ────────────────
# 1) Build Stage: Gradle 빌드
# ────────────────
FROM gradle:7.6-jdk17 AS builder
WORKDIR /home/gradle/project

# Gradle Wrapper, 설정, 소스 복사
COPY gradlew gradlew
COPY gradle gradle
COPY settings.gradle settings.gradle
COPY build.gradle build.gradle
COPY src src

# 권한 부여
RUN chmod +x gradlew

# 테스트 스킵(-x test) 하고 bootJar 빌드
RUN ./gradlew clean bootJar -x test --no-daemon

# ────────────────
# 2) Runtime Stage: 실행용 이미지
# ────────────────
FROM openjdk:17-jdk-slim
WORKDIR /app

# MySQL 준비 될 때까지 healthcheck 로 대기 필요 → Compose healthcheck 사용
# (builder 단계에서는 DB 연결 안 함)

# 빌드 스테이지에서 생성된 JAR 복사
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

# 포트 노출
EXPOSE 8081

# 앱 기동
ENTRYPOINT ["java","-jar","app.jar"]
