import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FilterPosts {

    @Test
    public void filterPostsByAuthor() {
        given().log().all().queryParam("author", "Jakub The Third")
                .when().get("http://localhost:3000/posts/")
                .then().log().all();
    }

    @Test
    public void filterPostsById() {
        given().log().all().queryParam("id", "1", "2")
                .when().get("http://localhost:3000/posts/")
                .then().log().all();
    }

    @Test
    public void filterPostsByAuthorAndTitle() {
        Map<String, Object> params = new HashMap<>();
        params.put("author", "Jakub The Third");
        params.put("title", "The Second Title");

        given().log().all().queryParams(params)
                .when().get("http://localhost:3000/posts/")
                .then().log().all();

    }
}
