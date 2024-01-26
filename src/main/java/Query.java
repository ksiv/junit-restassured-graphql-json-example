

import com.coxautodev.graphql.tools.GraphQLRootResolver;


public class Query implements GraphQLRootResolver {

    // Example call which simply returns a sum of two integers
    public Integer sumInt(Integer a, Integer b) {
        return new sumTwoIntegers(a, b).calculate();
    }
}