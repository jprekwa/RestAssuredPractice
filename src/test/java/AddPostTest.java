import io.restassured.http.ContentType;
import model.Post;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddPostTest {

    //adding new posts
    @Test
    public void addPost() {
        String newPostBody = "{\n" +
                "    \"title\": \"addPostRestAssuredTest\",\n" +
                "    \"author\": \"Jakub\"\n" +
                "}";

        given().log().all().contentType(ContentType.JSON).body(newPostBody)
                .when().post("http://localhost:3000/posts")
                .then().log().all().statusCode(201).statusLine(Matchers.containsString("Created"));
    }

    //adding post from file in resources directory
    @Test
    public void addPostFromFile() {
        File newPost = new File("src/test/resources/post.json");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3000/posts")
                .then().log().all().statusCode(201).statusLine(Matchers.containsString("Created"));
    }

    //adding post using map
    @Test
    public void addPostMap() {
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("title", "Title From Map");
        newPost.put("author", "Jakub The Third");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3000/posts")
                .then().log().all().statusCode(201).statusLine(Matchers.containsString("Created"));
    }

    //adding post from Post class object in model directory
    @Test
    public void addPostObject() {
        Post newPost = new Post();
        newPost.setAuthor("Jakub The Fourth");
        newPost.setTitle("Title From Object");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3000/posts")
                .then().log().all().statusCode(201).statusLine(Matchers.containsString("Created"));
    }
}
