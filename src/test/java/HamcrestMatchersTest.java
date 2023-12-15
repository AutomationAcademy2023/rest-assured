import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
    @Test
    public void testUserList() {
        given() // Request specification start.
                .baseUri("https://jsonplaceholder.typicode.com") // Base URI for the API.
        .when() // Signifies the beginning of the request.
                .get("/users") // GET request to the "/users" endpoint.
        .then() // Start of the response assertion phase.
                .body("size()", greaterThan(5)) // Checks if the size of the returned list is greater than 5.
                .body("email", everyItem(containsString("@"))) // Ensures every "email" in the response contains "@".
                .body("name", hasItem("Leanne Graham")); // Checks if "Leanne Graham" is in the "name" list of the response.
    }
}

