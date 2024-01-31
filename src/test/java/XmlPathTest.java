import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.util.List;

public class XmlPathTest {

    @Test
    public void testXmlPath() {
        String xml = "<movies>\n" +
                "\t<movie genre=\"comedy\">\n" +
                "\t\t<id>1</id>\n" +
                "\t\t<name>Forrest Gump</name>\n" +
                "\t\t<rate>8</rate>\n" +
                "\t</movie>\n" +
                "\t<movie genre=\"animation\">\n" +
                "\t\t<id>2</id>\n" +
                "\t\t<name>Shrek</name>\n" +
                "\t\t<rate>7</rate>\n" +
                "\t</movie>\n" +
                "\t<movie genre=\"drama\">\n" +
                "\t\t<id>3</id>\n" +
                "\t\t<name>Green Mile</name>\n" +
                "\t\t<rate>9</rate>\n" +
                "\t</movie>\n" +
                "</movies>";

        //getting name of the first movie
        String firstMovieName = XmlPath.from(xml).get("movies.movie.name[0]");

        //getting list of movies names
        List<String> moviesNames = XmlPath.from(xml).getList("movies.movie.name");

        //getting attribute genre from first movie
        String firstMovieGenre = XmlPath.from(xml).get("movies.movie[0].@genre");
    }
}
