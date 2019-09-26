package api;

import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class APITest {
    private static String baseURL = "https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=Nelson%20Mandela&utf8=&format=json";

    @Test
    public void getFirstBookingAndCheckFirstName() {
    //then().body("title", equalTo("Nelson Mandela"));
        String a = (String) given().get(baseURL).then()
                .extract()
                .jsonPath()
                .getList("query.search.title").get(0);
        Assert.assertEquals(a, "Nelson Mandela");
    }
}
