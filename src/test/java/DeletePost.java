import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePost {

    //deleting post using path params
    @Test
    public void deletePost() {
//        given().pathParam("postId", 3)
//                .when().delete("http://localhost:3000/posts/{postId}")
//                .then().log().all();

        given().log().all()
                .when().delete("http://localhost:3000/posts/{postId}", 9)
                .then().log().all().statusCode(200).statusLine(Matchers.containsString("OK"));
    }
}
