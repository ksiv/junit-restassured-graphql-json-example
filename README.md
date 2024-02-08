
# junit-restassured-graphql-json-example

This is a simple example of how to test GraphQL API with REST Assured where GraphQL server is set to work with JSON messages.

## why does it work ? 
A lot of GraphQL servers still use JSON wrapping to send and receive messages. 
That is why one can use REST Assured framework to test it

## requirement
1. JDK
2. Maven
4. an available IP port (by default 8080) 

## how to execute 
1. clone the repo
2. got to top project folder and run "mvn clean test"

## using docker
1. pull latest maven image `docker pull maven`
2. interactively run container based on this image and execute a command shell inside `docker run -it --name my-maven-container maven bash`
3. changes the active directory to one of the current user `cd`
4. Download this repo: git clone https://github.com/ksiv/junit-restassured-graphql-json-example.git
5. go to junit-restassured-graphql-json-example folder `cd junit-restassured-graphql-json-example`
6. run the tests  `mvn test`


