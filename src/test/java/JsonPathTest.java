import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JsonPathTest {

    //getting specific fields within body using JSONPath class
    @Test
    public void checkSpecificFieldJsonPath() {
        Response response = RestAssured.get("http://localhost:3000/posts/{postId}", 1);

        System.out.println(response.asString());

        String secretString = response.path("secretString");
        List<Integer> winningNumbers = response.path("winning-numbers");
//      String firstWinnerName = response.path("winners.name[0]");
        String firstWinnerName = response.path("winners[0].name");
        String secondWinnerName = response.path("winners[1].name");
        String lastWinnerName = response.path("winners[-1].name");

        //get List with all names of winners
        List<String> winnerNames = response.path("winners.name");

        //get all information about the first winner
        Map<String,?> winner = response.path("winners[0]");

        //get all information about all the winners
        List<Map<String, ?>> winners = response.path("winners");
    }
}