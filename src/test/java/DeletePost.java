import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;

public class DeletePost {

    //deleting post using path params
    @Test
    public void deletePost() {
//        given().pathParam("postId", 3)
//                .when().delete("http://localhost:3000/posts/{postId}")
//                .then().log().all();

        when().
                delete("http://localhost:3000/posts/{postId}", 12).
        then().
                statusCode(200).statusLine(containsString("OK"));
    }
}
