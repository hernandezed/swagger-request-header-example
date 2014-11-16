Spring boot application demonstrating a bug in swagger-springmvc
================================================================

This small Spring Boot application consists of following components

* A small demo REST controller which takes 2 arguments as request parameters and sends the response back as an JSON or XML response
* Spring security configuration for basic authentication
* Swagger SpringMVC configuration
* An index.html file using swagger-ui

Initial setup
-------------

1. `mvn verify`
2. `java -jar target/swagger-springmvc-bug.1.1.8.RELEASE.jar`
   (`mvn spring-boot:run` works but resource filtering used in index.html does not work)
