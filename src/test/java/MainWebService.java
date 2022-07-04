import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

@Tag("webservice")
public class MainWebService {
	WebDriver driver;
	
	@BeforeEach
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@RepeatedTest(5)
	@Epic("Blonde Site")
	@Story("Web Service Test at Blonde Site")
	@Description("Running a REST test to check the connection with correct URL, if response code is 200, the connection was established")
	@Severity(SeverityLevel.CRITICAL)
	public void webServiceTestOkAtBlondeSite() throws InterruptedException {
		WebService webService = (WebService) SiteFactory.Create("WebService", driver);
		Response response = RestAssured.when().get(webService.getUrlOkString()).then().contentType(ContentType.HTML).extract().response();
		int code = response.statusCode();
		//Status Code 200 = HTTP OK
		Assertions.assertEquals(200, code);
	}
	
	@RepeatedTest(5)
	@Epic("Blonde Site")
	@Story("Web Service Test at Blonde Site")
	@Description("Running a REST test to check the connection with bad URL, if response code is 404, the page not found")
	@Severity(SeverityLevel.CRITICAL)
	public void webServiceTestNotFountAtBlondeSite() throws InterruptedException {
		WebService webService = (WebService) SiteFactory.Create("WebService", driver);
		Response response = RestAssured.when().get(webService.getUrlNotFoundString()).then().contentType(ContentType.HTML).extract().response();
		int code = response.statusCode();
		//Status Code 404 = HTTP Not Found
		Assertions.assertEquals(404, code);
	}
	
	@AfterEach
	@Epic("Blonde Site")
	@Story("Make Screenshot")
	@Description("Make Screenshot After Each Test")
	@Severity(SeverityLevel.CRITICAL)
	public void makeScreenshot() {
		Allure.addAttachment("Screenshot of Tested Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
}