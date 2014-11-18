Spring boot microservice application
====================================

This small Spring Boot application acting as a kind of blueprint for a typical microservice.
It contains following components:

* A small demo REST controller which takes 2 arguments as request parameters and sends the response back as an JSON or XML response
* API versioning via content type negotiation and vendor specific MIME types
* Spring security configuration for basic authentication
* Swagger SpringMVC integration for generated API documentation
* An index.html file using swagger-ui for browsing the API documentaion including Javascript test client

Initial setup
-------------

1. `mvn verify`
2. `java -jar target/swagger-springmvc-bug.1.1.8.RELEASE.jar`
   (`mvn spring-boot:run` works but resource filtering used in index.html does not work)
3. `http://localhost:9000` shows the API documentation provided by swagger-ui
4. Test user via basic authentication is `user` with password `password`
