

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;



public class GraphQLServlet extends SimpleGraphQLServlet {

        public GraphQLServlet() {
                super(buildSchema());
        }

        private static GraphQLSchema buildSchema() {

                return SchemaParser.newParser()
                        .file("schema.graphqls")
                        .resolvers(new Query())
                        .build()
                        .makeExecutableSchema();
        }
}

