import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddPostTest {

    @Test
    public void addPost(){
        String newPostBody = "{\n" +
                "    \"title\": \"addPostRestAssuredTest\",\n" +
                "    \"author\": \"Jakub\"\n" +
                "}";

        given().log().all().contentType(ContentType.JSON).body(newPostBody)
                .when().post("http://localhost:3000/posts")
                .then().log().all();
    }

    @Test
    public void addPostFromFile(){
        File newPost = new File("src/test/resources/post.json");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3000/posts")
                .then().log().all();
    }

    @Test
    public void addPostMap(){
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("title", "TitleFromMap");
        newPost.put("author", "Jakub The Third");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3000/posts")
                .then().log().all();
    }
}
