FROM openjdk:11
COPY target/*.jar info.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/info-1.0.jar"]
