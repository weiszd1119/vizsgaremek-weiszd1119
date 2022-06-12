import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class WebServiceTest extends StartDriver {

    public WebServiceTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void sendingresponsecodeoktest()
    {
        Response response = RestAssured
                .when()
                .get("http://lennertamas.github.io/blondesite/")
                .then()
                .contentType(ContentType.HTML)
                .extract()
                .response();

        int code = response.statusCode();

        Assertions.assertEquals(200, code); //Status Code 200 = HTTP OK
    }
}
