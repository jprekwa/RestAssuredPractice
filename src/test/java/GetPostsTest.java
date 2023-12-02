import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetPostsTest {

    //getting all posts
    @Test
    public void getPosts() {
        when().get("http://localhost:3000/posts")
                .then().log().body().statusCode(200).statusLine(Matchers.containsString("OK"));
    }
}
