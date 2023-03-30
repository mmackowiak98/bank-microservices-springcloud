FROM openjdk:17-jdk-slim as build

#Information around who maintains the image
MAINTAINER mmackowiak.com

# Add the application's jar to the container
COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/eureka-server-0.0.1-SNAPSHOT.jar"]