FROM java:8
WORKDIR ./
COPY ./target/beerapp-0.0.1-SNAPSHOT.jar ./

EXPOSE 8080
ENV NAME beer-app
CMD ["java","-jar","beerapp-0.0.1-SNAPSHOT.jar"]