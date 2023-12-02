import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VerifyResponse {

    //verifying whole response body
    @Test
    public void getPost() {
        String expected = "{\n" +
                "  \"author\": \"Jakub The First\",\n" +
                "  \"title\": \"updatePost\",\n" +
                "  \"id\": 1\n" +
                "}";

        given().log().all()
                .when().get("http://localhost:3000/posts/{postId}", 1).
                then().log().all().body(Matchers.equalTo(expected));
    }

    //verifying part of response body
    @Test
    public void getPostContains() {
        given().log().all()
                .when().get("http://localhost:3000/posts/{postId}", 1).
                then().log().all().body(Matchers.containsStringIgnoringCase("jakub"));
    }

    //verifying two field in response body
    @Test
    public void checkSpecificField() {
        given().log().all()
                .when().get("http://localhost:3000/posts/{postId}", 1).
                then().log().all().body("title", Matchers.equalTo("updatePost"))
                .and().body("author", Matchers.equalTo("Jakub The First"));
    }
}
