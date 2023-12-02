import io.restassured.http.ContentType;
import model.Post;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VerifyResponse {

    //verifying whole response body
    @Test
    public void getPost() {
        String expected = "{\n" +
                "  \"author\": \"Jakub The First\",\n" +
                "  \"title\": \"updatePost\",\n" +
                "  \"id\": 1\n" +
                "}";

        given().log().all()
                .when().get("http://localhost:3000/posts/{postId}", 1)
                .then().log().all().body(Matchers.equalTo(expected));
    }

    //verifying part of response body
    @Test
    public void getPostContains() {
        given().log().all()
                .when().get("http://localhost:3000/posts/{postId}", 1)
                .then().log().all().body(Matchers.containsStringIgnoringCase("jakub"));
    }

    //verifying two field in response body
    @Test
    public void checkSpecificField() {
        given().log().all()
                .when().get("http://localhost:3000/posts/{postId}", 1)
                .then().log().all().body("title", Matchers.equalTo("updatePost"))
                .and().body("author", Matchers.equalTo("Jakub The First"));
    }

    //verifying response body using response body as an object
    @Test
    public void getPostObject() {
        Integer id = 1;

        Post newPost = given().log().all()
                .when().get("http://localhost:3000/posts/{postId}", id)
                .then().log().all().body("title", Matchers.equalTo("updatePost"))
                .and().body("author", Matchers.equalTo("Jakub The First"))
                .extract().as(Post.class);

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

        Post createdPost = given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3000/posts")
                .then().log().all().extract().body().as(Post.class);

        Assert.assertEquals(newPost, createdPost);
    }
}