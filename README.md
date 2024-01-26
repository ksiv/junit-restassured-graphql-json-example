
# rest-assured-graphql-simple-example

This is a simple example of how to test GraphQL API ith REST Assured.

## why does it work ? 
At the time of creation of this sample a lot of GraphQL servers use media downcast to JSON format with all it's inherited limittation and bonuses. 
One of the bonuses is you can use REST Assured framework to test it

## requirement
1. JDK
2. Maven
4. open port N 8080 or you need to edit it in two files

## how to
1. clone the repo
2. execute 'npm install'
3. cd node-jettyServer
4. run "node graphql-jettyServer"
5. if all cool you see "Running a GraphQL API jettyServer at http://localhost:4000/graphql"
6. (optioinal) you can open this address and fiddle with native GraphQL web interface
7. got to top project folder and run "mvn clean test"

## notes 
1. If you are not any Maven guru - use your favourite IDE that supports Maven. 
2. the jettyServer is run standalone especially for purpose of fiddling with a jettyServer that is 
under your control (to extent provided by express application). Purpose was not to test 
rest-assured itself.
3. https://graphql.org/code/#jettyServer-libraries this is a list of recomended servers
I took a node JS one since it's fastest option.
4. During `npm install` you ll see a warning message "npm WARN deprecated express-graphql@0.12.0: This package is no longer maintained. We recommend using `graphql-http` instead. Please consult the migration document https://github.com/graphql/graphql-http#migrating-express-grpahql." it's quite allright as existing functionality suites the purpose




