# stock-viewer-app
This repository demonstrates the microservice architecture and uses YahooFinanceAPI to get the various stock details a user has subscribed to.

As per the architecture
- `stock-eureka-service`: Eureka-Server + Zuul Proxy + spring-webflux
- `stock-service`: spring-webflux + WebClient + Eureka-Client
- `stock-db-service`: spring-webflux + Reactive-MongoDb + Eureka-Client

### stock-eureka-service 
This microservice acts like the API gateway for all the requests incoming requests. The API gateway is created using Zuul proxy.
And the service is registered as a server with Eureka-Server.
This hides the underlying services and acts as the only entry point of the application

### stock-service
This microservice is responsible for communicating with `stock-db-service` and `YahooFinaceAPI` service and is registered as `Eureka-Client` with Eureka-Server
When the request comes from Web client, this service communicates with _stock-db-service_, gets the list of stocks a user is subscribed to, passes the list to YahooFinanceAPI to get the stock price and other details

### stock-db-service
This microservice communicates with MongoDb to get the stock detail of a user

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
