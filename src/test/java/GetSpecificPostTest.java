import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;

public class GetSpecificPostTest {

    //getting specific post using path param
    @Test
    public void getPost() {
        given().
                pathParam("postId", 1).
        when().
                get("http://localhost:3000/posts/{postId}").
        then().
                statusCode(200).statusLine(containsString("OK"));

//        when().
//                get("http://localhost:3000/posts/{postId}", 4).
//        then().
//                statusCode(200).statusLine(containsString("OK"));
    }
}