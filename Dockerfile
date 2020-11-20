FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/product-service.jar product-service.jar
ENTRYPOINT ["java","-jar","product-service.jar"]