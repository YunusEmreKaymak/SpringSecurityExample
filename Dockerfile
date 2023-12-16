FROM openjdk:17
EXPOSE 8080
ADD target/SpringSecurityExample-0.0.1-SNAPSHOT.jar SpringSecurityExample-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","SpringSecurityExample-0.0.1-SNAPSHOT.jar"]