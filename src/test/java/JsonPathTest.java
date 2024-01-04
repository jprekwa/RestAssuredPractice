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

        //getting specific fields
        String secretString = response.path("secretString");
        List<Integer> winningNumbers = response.path("winning-numbers");
//        String firstWinnerName = response.path("winners.name[0]");
        String firstWinnerName = response.path("winners[0].name");
        String secondWinnerName = response.path("winners[1].name");
        String lastWinnerName = response.path("winners[-1].name");

        //getting List with all names of winners
        List<String> winnerNames = response.path("winners.name");

        //getting all information about the first winner
        Map<String, ?> winner = response.path("winners[0]");

        //getting all information about all the winners
        List<Map<String, ?>> winners = response.path("winners");

        //getting all information about the winner with specific name
        Map<String, ?> winnerInfo = response.path("winners.find{it.name=='Andrew'}");
        Integer winnerInfoId = response.path("winners.find{it.name=='Andrew'}.winnerId");

        //getting the highest and lowest values from the table
        Integer maxNumber = response.path("winning-numbers.max()");
        Integer minNumber = response.path("winning-numbers.min()");

        //getting winner with the highest ID
        Map<String, ?> winnerMaxId = response.path("winners.max{it.winnerId}");

        //getting sum of two numbers
        Integer moneySum = response.path("winners.collect{it.money}.sum()");

        //getting id of winner with specific name
        Integer winnerId = response.path("winners.find{it.name=='John'}.winnerId");

        //getting list ids of winners with specific name
        List<Integer> winnersId = response.path("winners.findAll{it.name=='John'}.winnerId");
    }
}