FROM openjdk:8-jdk-alpine
ADD target/*.jar app.jar
RUN mkdir -p /apps/car/logs/
ENV TZ=Asia/Bangkok
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java", "-jar", "/app.jar"]