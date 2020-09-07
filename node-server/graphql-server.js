var express = require('express');
var { graphqlHTTP } = require('express-graphql');
var { buildSchema } = require('graphql');

// Construct a schema, using GraphQL schema language
var schema = buildSchema(`
  type Query {
    quoteOfTheDay: String
    random: Float!
    sumInt(firstInt: Int!, secondInt: Int!): Int
  }
`);

// The root provides a resolver function for each API endpoint
var root = {
random: () => {
    return Math.random();
},
sumInt: (args) => {
    return args.firstInt + args.secondInt;
}
};

var app = express();
app.use('/graphql', graphqlHTTP({
  schema: schema,
  rootValue: root,
  graphiql: true,
}));

app.listen(4000);
console.log('Running a GraphQL API server at http://localhost:4000/graphql');