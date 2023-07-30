
# rest-assured-graphql-simple-example

This is a simple example of how to test GraphQL API ith rest-assured.
Since it's simple the code is ugly. Components version is not the best ones
so do not use it as production basement rather like a concept show-case.

## why does it work ? 
At the time of creation of this sample a lot of servers (including node express-graphql) provide GraphQL servives in a form downcast to JSON format with all it's inherited limittation and bonuses. 

## requirement
1. JDK
2. Maven
3. Node.js
4. open port N 4000 or you need to edit it in two files

## how to
1. go into node folder read "graphql-server" file :-)
2. run "node graphql-server"
3. if all cool you see "Running a GraphQL API server at http://localhost:4000/graphql"
4. you can open this address and fiddle with native GraphQL web interface
5. got to top project folder and run "mvn clean test"

## notes 
1. If you are not any Maven guru - use your favourite IDE that supports Maven. 
2. the server is run standalone especially for purpose of fiddling with a server that is 
under your control (to extent provided by express application). Purpose was not to test 
rest-assured itself.
3. https://graphql.org/code/#server-libraries this is a list of recomended servers
I took a node JS one since it's fastest option.



