import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;





@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnitTests {
    Server server = new Server(8080);
    String endpointURL = "http://localhost:8080/graphql";

    @Test
    public void graphQLtoJSONusingJSONObject() {
        String textFromGrathQLEditorQuery = "{sumInt(secondInt:1,firstInt:4)}";
        String textFromGrathQLEditorVariable = "";
        String textOperationName="";
        graphQLrequestBuilder myGraphQLBuilder = new graphQLrequestBuilder();
        myGraphQLBuilder.setQuery(textFromGrathQLEditorQuery);
        String jsonString = myGraphQLBuilder.getJSONString();
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(jsonString);
        System.out.println("sending >>>");
        request.given().log().body();
        Response response = request.post(endpointURL);
        System.out.println("receiving <<<");
        System.out.println(response.getBody().asString());
        response.then().body("data.sumInt", equalTo(5));
        response.then().body("data.sumInt", lessThanOrEqualTo(5));

    }

    @Test
    public void simpleQueryWithParameterVariablesSentSeparately() {
        String textFromGrathQLEditorQuery = "query mySum($firstInt: Int!,$secondInt: Int!)\n" +
                "{sumInt(secondInt: $secondInt,firstInt:$firstInt)}";
        String textFromGrathQLEditorVariable = "{" +
                "  \"firstInt\":  2,\n" +
                "  \"secondInt\": 3\n" +
                "}";
        String textOperationName="";
        graphQLrequestBuilder myGraphQLBuilder = new graphQLrequestBuilder();
        myGraphQLBuilder.setQuery(textFromGrathQLEditorQuery);
        myGraphQLBuilder.setVariables(textFromGrathQLEditorVariable);
        String jsonString = myGraphQLBuilder.getJSONString();
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(jsonString);
        System.out.println("sending >>>");
        request.given().log().body();
        Response response = request.post(endpointURL);
        System.out.println("receiving <<<");
        System.out.println(response.getBody().asString());
        response.then().body("data.sumInt", equalTo(5));
        response.then().body("data.sumInt", lessThanOrEqualTo(5));
    }
    @BeforeAll

    public void startJetty() throws Exception {
        // Create Server
        System.out.println("Starting server");

        // Create Context
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Add Servlet
        context.addServlet(new ServletHolder(new GraphQLServlet()), "/graphql");

        // Set Handler
        server.setHandler(context);

        // Start Server
        server.start();
    }

    @AfterAll
    public void stopServer() throws Exception {
        server.stop();
        System.out.println("Stopping server");

    }
}