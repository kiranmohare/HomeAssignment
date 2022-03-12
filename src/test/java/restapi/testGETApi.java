package restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testGETApi {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte";
    }

    @Test
    public void testGetRequestValidInput(){
        int id = 200007;
        Response response = RestAssured.get("/"+id);
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void testGetRequestInvalidInput(){
        String id = "abcd";
        Response response = RestAssured.get("/"+id);
        Assert.assertEquals(404, response.statusCode());
    }

    @Test
    public void testGetRequestNoContentOutput(){
        int id = 5456;
        Response response = RestAssured.get("/"+id);
        Assert.assertEquals(204, response.statusCode());
    }
}
