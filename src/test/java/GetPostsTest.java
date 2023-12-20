import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;

public class GetPostsTest {

    //getting all posts
    @Test
    public void getPosts() {
        when().
                get("http://localhost:3000/posts").
        then().
                statusCode(200).statusLine(containsString("OK"));
    }
}
