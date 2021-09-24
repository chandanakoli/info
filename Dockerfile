FROM openjdk:11
COPY target/*.jar info.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/info-1.0.jar"]
