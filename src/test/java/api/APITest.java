package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {
    private static String baseURL = "https://en.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json";

    public String getSearchResult(String query) {
        return (String) given().get(baseURL+"&srsearch="+query).then()
                .extract()
                .jsonPath()
                .getList("query.search.title").get(0);
    }

    @Test
    public void testURL(){
        Assert.assertEquals(getSearchResult("Nelson Mandela"), "Nelson Mandela");
    }
}
