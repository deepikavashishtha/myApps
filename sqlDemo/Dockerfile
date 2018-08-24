FROM maven:3.5.0-jdk-8 
WORKDIR ./
ADD . ./
COPY ./target/sqlDemo-0.0.1-SNAPSHOT.jar ./

EXPOSE 8050
ENV NAME spring-microservice
CMD ["java","-jar","sqlDemo-0.0.1-SNAPSHOT.jar"]