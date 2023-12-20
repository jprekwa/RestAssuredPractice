import io.restassured.http.ContentType;
import model.Post;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class VerifyResponse {

    //verifying whole response body
    @Test
    public void getPost() {
        String expected = "{\n" +
                "  \"author\": \"Jakub The First\",\n" +
                "  \"title\": \"updatePost\",\n" +
                "  \"id\": 1\n" +
                "}";

                when().
                        get("http://localhost:3000/posts/{postId}", 1).
                then().
                        assertThat().body(equalTo(expected));
    }

    //verifying part of response body
    @Test
    public void getPostContains() {
                when().
                        get("http://localhost:3000/posts/{postId}", 1).
                then().
                        assertThat().body(Matchers.containsStringIgnoringCase("jakub"));
    }

    //verifying two field in response body
    @Test
    public void checkSpecificField() {
                when().
                        get("http://localhost:3000/posts/{postId}", 1).
                then().
                        assertThat().body("title", equalTo("updatePost")).
                and().
                        assertThat().body("author", equalTo("Jakub The First"));
    }

    //verifying response body using response body as an object
    @Test
    public void getPostObject() {
        Integer id = 1;

        Post newPost =
                when().
                        get("http://localhost:3000/posts/{postId}", id).
                then().
                        body("title", equalTo("updatePost")).
                and().
                        body("author", equalTo("Jakub The First")).
                extract()
                        .as(Post.class);

        Assert.assertEquals(newPost.getAuthor(), "Jakub The First");
        Assert.assertEquals(newPost.getTitle(), "updatePost");
        Assert.assertEquals(newPost.getId(), id);
    }

    //verifying response body using objects after creating post
    @Test
    public void addPostObject() {
        Post newPost = new Post();
        newPost.setAuthor("Jakub The Object");
        newPost.setTitle("Object Title");

        Post createdPost =
                given().
                        contentType(ContentType.JSON).body(newPost).
                when().
                        post("http://localhost:3000/posts").
                then().
                        extract().body().as(Post.class);

        Assert.assertEquals(newPost, createdPost);
    }
}