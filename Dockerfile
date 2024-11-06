# Dockerfile
# 베이스 이미지 선택
FROM openjdk:17-slim

# 애플리케이션 JAR 파일 복사
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# 포트 설정
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]
