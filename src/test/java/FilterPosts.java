import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class FilterPosts {

    //filtering posts using query param
    @Test
    public void filterPostsByAuthor() {
        given().
                queryParam("author", "Jakub The Third").
        when().
                get("http://localhost:3000/posts/").
        then().
                statusCode(200).statusLine(containsString("OK"));
    }

    @Test
    public void filterPostsById() {
        given().
                queryParam("id", "1", "2").
        when().
                get("http://localhost:3000/posts/").
        then().
                statusCode(200).statusLine(containsString("OK"));
    }

    //filtering posts using map
    @Test
    public void filterPostsByAuthorAndTitle() {
        Map<String, Object> params = new HashMap<>();
        params.put("author", "Jakub The Third");
        params.put("title", "The Second Title");

        given().
                queryParams(params).
        when().
                get("http://localhost:3000/posts/").
        then().
                statusCode(200).statusLine(containsString("OK"));
    }
}
