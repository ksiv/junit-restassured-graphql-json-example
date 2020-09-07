package RESTAssuredGraphQLTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class JUnitTests {
    String endpointURL = "http://localhost:4000/graphql";

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

}