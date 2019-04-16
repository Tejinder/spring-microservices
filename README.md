# Spring Boot Microservices: 

Building a Top Sports Brands Architecture with Spring Boot. In this spring boot microservices example, we will be creating Top Sports Brands application which will be having 3 services:-

1. Eureka Service –  This Service will register every microservice and then the client microservice will look up the Eureka server to get a dependent microservice to get the job done.This Eureka Server is owned by Netflix and in this, Spring Cloud offers a declarative way to register and invoke services by Java annotation.
2. Item Catalog Service – This service will generate the list of Sports brands which are popular in the market. 
3. Edge Service – It is similar to the standalone Item service created in Bootiful Development with Spring Boot and Angular. However, it will have fallback capabilities which prevent the client from receiving an HTTP error when the service is not available
