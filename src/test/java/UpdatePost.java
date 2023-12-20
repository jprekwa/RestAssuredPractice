import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class UpdatePost {

    //replacing post using map
    @Test
    public void replacePostMap() {
        Map<String, Object> post = new HashMap<>();
        post.put("title", "updatePost");
        post.put("author", "Jakub The First");

        given().
                contentType(ContentType.JSON).body(post).
        when().
                put("http://localhost:3000/posts/1").
        then().
                statusCode(200).statusLine(containsString("OK"));

//        given().
//                pathParam("postId", 1).contentType(ContentType.JSON).body(post).
//        when().
//                put("http://localhost:3000/posts/{postId}").
//        then().
//                statusCode(200).statusLine(containsString("OK"));

//        given().
//                contentType(ContentType.JSON).body(post).
//        when().
//                put("http://localhost:3000/posts/{postId}", 1).
//        then().
//                statusCode(200).statusLine(containsString("OK"));

    }

    //replacing post using object
    @Test
    public void replacePostObject() {
        Post newPost = new Post();
        newPost.setAuthor("Jakub The Second");
        newPost.setTitle("The Second Title");

//        given().
//                contentType(ContentType.JSON).body(newPost).
//        when().
//                put("http://localhost:3000/posts/2").
//        then().
//                statusCode(200).statusLine(containsString("OK"));

        given().
                pathParam("postId", 2).contentType(ContentType.JSON).body(newPost).
        when().
                put("http://localhost:3000/posts/{postId}").
        then().
                statusCode(200).statusLine(containsString("OK"));

//        given().
//                contentType(ContentType.JSON).body(newPost).
//        when().
//                put("http://localhost:3000/posts/{postId}", 2).
//        then().
//                statusCode(200).statusLine(containsString("OK"));
    }

    //updating post
    @Test
    public void updatePost() {
        Post newPost = new Post();
        newPost.setAuthor("Jakub The First");

//        given().
//                contentType(ContentType.JSON).body(newPost).
//        when().
//                patch("http://localhost:3000/posts/1").
//        then().
//                statusCode(200).statusLine(containsString("OK"));

//        given().
//                pathParam("postId", 1).contentType(ContentType.JSON).body(newPost).
//        when().
//                patch("http://localhost:3000/posts/{postId}").
//        then().
//                statusCode(200).statusLine(containsString("OK"));

        given().
                contentType(ContentType.JSON).body(newPost).
        when().
                patch("http://localhost:3000/posts/{postId}", 1).
        then().
                statusCode(200).statusLine(containsString("OK"));
    }

}
