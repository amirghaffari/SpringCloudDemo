Developing Microservices using Spring Cloud
-----------

This example provides a basic demonstration of how a microservices-based system can be implemented using [Spring Boot](https://spring.io/projects/spring-boot) and [Spring Cloud](https://spring.io/projects/spring-cloud). The system implements a simple enrollment query from the below entities:

* Student
* Course
* Enrollment

There is one microservice per each entity, i.e. *student microservice*, *course microservice*, and the *enrollment microservice*. The *enrollment microservice* communicates with the two other microservices to provide the following queries:

* A query that gets a student id and returns all the courses that the student has taken: http://localhost:8003/enrollments/student/1 
* A query that gets a year and shows all the enrollments in that year: http://localhost:8003/enrollments/year/2020

The *enrollment microservice* uses [`RestTemplate`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) and [`Feign`](https://github.com/OpenFeign/feign) to communicate with the *Student* and *Course* microservices via the REST API. This is just to demonstrate the both ways of consuming RESTful Web Services in a Spring Cloud microservice.

To centralized configuration, there is a [Spring Cloud Config Server](https://cloud.spring.io/spring-cloud-config/reference/html/) that manages external properties for the microservices. The configuration files are located in the `config-repo` folder. There is one property file in this folder for each microservice.

To run the config server
---
```
    $ git clone https://github.com/amirghaffari/SpringCloudDemo.git
    $ cd SpringCloudDemo/config-server
    $ mvn spring-boot:run
```

To verify if the config server is up and running, you can check the *student microservice* configuration at http://localhost:8888/student-service/default.

This example uses [Netflix Eureka service registry](https://github.com/spring-cloud/spring-cloud-netflix) where all microservices can register themselves and discover other registered microservices.

To run the service registry
---
```
    $ cd SpringCloudDemo/discovery-service
    $ mvn spring-boot:run
```

To verify if the service registry is up and running, you can check the Eureka console at http://localhost:9000/.

Now that the Config and Registry Services are up and running, you can run the *Student*, *Course*, and *Enrollment* microservices:
```
    $ cd SpringCloudDemo/student-service
    $ mvn install spring-boot:run
```
```
    $ cd SpringCloudDemo/course-service
    $ mvn install spring-boot:run
```
```
    $ cd SpringCloudDemo/enrollment-service
    $ mvn spring-boot:run
```

**Note**) The *install* command is used in the above commands for the *student* and *course* microservices to package and deploy them to local repository because the *enrollment* microservice has dependency on them.

 Services can be verified using the below URLs:
 - http://localhost:8001/students
 - http://localhost:8002/courses
 - http://localhost:8003/enrollments/student/1
 - http://localhost:8003/enrollments/year/2020

 
 