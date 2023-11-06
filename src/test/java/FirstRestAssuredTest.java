import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class FirstRestAssuredTest {

    public static void main(String[] args) {
        when().get("http://localhost:3000/posts").then().log().body();
    }

    @Test
    public void getPosts(){

    }
}
