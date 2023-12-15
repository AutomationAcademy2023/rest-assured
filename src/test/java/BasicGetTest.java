import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicGetTest {
    @Test
    public void testUserEndpoint() {
        int index = 1;

        given() // Begins a Rest Assured chain, defining a request specification.
                .baseUri("https://jsonplaceholder.typicode.com") // Sets the base URI for the request.
        .when() // Signifies the start of defining the actual request to send.
                .get("/users/" + index) // Specifies the type (GET) and the endpoint ("/users/1").
        .then() // Signifies the assertion phase of the chain, where the response is validated.
                .statusCode(200) // Asserts that the status code of the response is 200 (OK).
                .body("username", equalTo("Bret")); // Asserts that the "username" field in the response body is "Bret".
    }
}
