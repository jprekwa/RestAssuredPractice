import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSpecificPostTest {

    @Test
    public void getPost() {
        given().pathParam("postId", 1)
                .when().get("http://localhost:3000/posts/{postId}")
                .then().log().all().statusCode(200).statusLine(Matchers.containsString("OK"));

//        given().log().all()
//                .when().get("http://localhost:3000/posts/{postId}", 4)
//                .then().log().all();
    }
}