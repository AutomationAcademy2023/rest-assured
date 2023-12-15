import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import Models.Post;
import Models.UserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SerializationTest {

    @Test
    public void testCreatePost() {
        Post newPost = new Post(1, "Demo Title", "This is the body."); // Creates a new Post object with given values.
        UserResponse userResponse;

        Response response =
                given() // Starts defining a request.
                        .baseUri("https://jsonplaceholder.typicode.com") // Sets the API's base URI.
                        .contentType(ContentType.JSON) // Sets the content type of the request to JSON.
                        .body(newPost) // Serializes the newPost object to JSON for the request body.
                .when() // Marks the beginning of the request definition.
                        .post("/posts"); // Sends a POST request to the "/posts" endpoint

        // print response and deserialize it as UserResponse Object
        response.prettyPrint();
        userResponse = response.body().as(UserResponse.class);

        // Assertions to check if the response data matches the request data.
        assertEquals(newPost.title, userResponse.title);
        assertEquals(newPost.body, userResponse.body);
        assertEquals(newPost.userId, userResponse.userId);
        assertTrue(userResponse.id > 100);

    }
}

