import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePost {

    @Test
    public void updatePostMap(){
        Map<String, Object> post = new HashMap<>();
        post.put("title", "updatePostTitle");
        post.put("author", "updateJakub");

        given().log().all().contentType(ContentType.JSON).body(post)
                .when().put("http://localhost:3000/posts/1")
                .then().log().all();
    }

    @Test
    public void updatePostObject(){
        Post newPost = new Post();
        newPost.setAuthor("updateJakubObject");
//        newPost.setTitle("updatePostObjectTitle");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().put("http://localhost:3000/posts/1")
                .then().log().all();
    }

}
