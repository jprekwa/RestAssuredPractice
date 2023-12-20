import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSpecificFieldValue {

    //getting specific field value using Response class
    @Test
    public void checkSpecificField() {
        Response response = RestAssured.get("http://localhost:3000/posts/{postId}", 1);
        String author = response.path("author");

//        String author = RestAssured.get("http://localhost:3000/posts/{postId}", 1).path("author");

        Assert.assertEquals(author, "Jakub The First");
    }

    //getting specific field value using JSonPath class
    @Test
    public void checkSpecificFieldJsonPath() {
//        Response response = RestAssured.get("http://localhost:3000/posts/{postId}", 1);
//        JsonPath jsonPath = new JsonPath(response.asString());
//        String author = jsonPath.get("author");

        String responseBody = RestAssured.get("http://localhost:3000/posts/{postId}", 1).asString();
        String author = JsonPath.from(responseBody).get("author");

        Assert.assertEquals(author, "Jakub The First");
    }
}
