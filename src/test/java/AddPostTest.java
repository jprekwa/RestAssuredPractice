import io.restassured.http.ContentType;
import org.testng.annotations.Test;

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
}
