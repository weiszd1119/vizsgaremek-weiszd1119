import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Tag("usermanagement")
public class MainUserManagementTest {
	
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
	
	@Test
	@Epic("Blonde Site")
	@Story("Accept Contract on Blonde Site")
	@Description("Accept the 'Terms and Conditions' popup window")
	@Severity(SeverityLevel.CRITICAL)
	public void acceptContractOnBlondeSite() throws InterruptedException {
		AcceptContract acceptContract = (AcceptContract) SiteFactory.Create("AcceptContract", driver);
		acceptContract.navigate();
		Thread.sleep(5000);
		acceptContract.clickOnAcceptButton();
		// Assertion: Azt vizsgáljuk, hogy az adatkezelési nyilatkozat eltűnt-e
		boolean actualUrlRegister = acceptContract.currentContractResult(); // True-t adna vissza, ha nem tűnne el, tehát nekünk a false érték a jó
		Assertions.assertFalse(actualUrlRegister);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Register to Blonde Site")
	@Description("Close the Terms and Conditions popup window")
	@Severity(SeverityLevel.CRITICAL)
	public void closeContractOnBlondeSite() throws InterruptedException {
		AcceptContract acceptContract = (AcceptContract) SiteFactory.Create("AcceptContract", driver);
		acceptContract.navigate();
		Thread.sleep(5000);
		acceptContract.clickOnCloseButton();
		// Assertion: Azt vizsgáljuk, hogy az adatkezelési nyilatkozat eltűnt-e
		boolean actualUrlRegister = acceptContract.currentContractResult(); // True-t adna vissza, ha nem tűnne el, tehát nekünk a false érték a jó
		Assertions.assertFalse(actualUrlRegister);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Register to Blonde Site")
	@Description("Register one user and check appearing message after register")
	@Severity(SeverityLevel.CRITICAL)
	public void registerToBlondeSite() throws InterruptedException {
		acceptContractOnBlondeSite();
		Register register = (Register) SiteFactory.Create("Register", driver);
		Thread.sleep(5000);
		register.pushRegTab();
		register.writeIntoRegUserField();
		register.writeIntoRegPasswordField();
		register.writeIntoRegEmailField();
		register.writeIntoRegDescriptionField();
		register.pushRegButton();
		// Assertions
		String expectedRegisterMessage = "User registered!";
		String actualUrlRegister = register.currentRegisterMessageResult();
		Assertions.assertEquals(expectedRegisterMessage, actualUrlRegister);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Register to Blonde Site")
	@Description("Register five users and check appearing message after every register")
	@Severity(SeverityLevel.CRITICAL)
	public void registerFromJSONFileToBlondeSite() throws InterruptedException, IOException, ParseException {
		acceptContractOnBlondeSite();
		Register register = (Register) SiteFactory.Create("Register", driver);
		Thread.sleep(5000);
		register.pushRegTab();
		// Read JSON file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("registerSource.json");
		Object object = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) object;
		for (int i = 0; i < usersList.size(); i++) {
			JSONObject usersOfJSON = (JSONObject) usersList.get(i);
			JSONObject user = (JSONObject) usersOfJSON.get("users");
			String username = (String) user.get("username");
			String password = (String) user.get("password");
			String email = (String) user.get("email");
			String description = (String) user.get("description");
			register.fillAllFieldFromJSONFile(username, password, email, description);
			register.clickRegisterButton();
			Thread.sleep(5000);
			//Assertions
			String expectedRegisterMessage = "User registered!";
			String actualRegisterMessage = register.currentRegisterMessageResult();
			Assertions.assertEquals(expectedRegisterMessage, actualRegisterMessage);
			//
			register.deleteAllFieldWithJSONFile();
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Login to Blonde Site")
	@Description("Login with one user and check result")
	@Severity(SeverityLevel.CRITICAL)
	public void loginToBlondeSite() throws InterruptedException {
		registerToBlondeSite();
		LoginLogout loginLogout = (LoginLogout) SiteFactory.Create("LoginLogout", driver);
		Thread.sleep(5000);
		loginLogout.pushLoginTab();
		loginLogout.writeIntoUserField();
		loginLogout.writeIntoPasswordField();
		loginLogout.pressLoginButton();
		// Assertions
		// Assertions: A login-t azzal ellenőrizzük, hogy megjelenik-e a Logout lehetőség
		String expectedMenuText = "Logout";
		String actualMenuText = loginLogout.currentLoginResult();
		Assertions.assertEquals(expectedMenuText, actualMenuText);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Login to Blonde Site")
	@Description("Login with five users and check result")
	@Severity(SeverityLevel.CRITICAL)
	public void loginFromJSONFileToBlondeSite() throws InterruptedException, IOException, ParseException {
		registerFromJSONFileToBlondeSite();
		LoginLogout loginLogout = (LoginLogout) SiteFactory.Create("LoginLogout", driver);
		Thread.sleep(5000);
		loginLogout.navigate();
		// Read JSON file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("loginSource.json");
		Object object = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) object;
		for (int i = 0; i < usersList.size(); i++) {
			JSONObject usersOfJSON = (JSONObject) usersList.get(i);
			JSONObject user = (JSONObject) usersOfJSON.get("users");
			String username = (String) user.get("username");
			String password = (String) user.get("password");
			loginLogout.fillAllFieldsFromJSONFile(username, password);
			loginLogout.pressLoginButton();
			Thread.sleep(5000);
			// Assertions: A login-t azzal ellenőrizzük, hogy megjelenik-e a Logout lehetőség
			String expectedMenuText = "Logout";
			String actualMenuText = loginLogout.currentLoginResult();
			Assertions.assertEquals(expectedMenuText, actualMenuText);
			//
			loginLogout.pressLogoutButton();
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("LoginLogout to Blonde Site")
	@Description("Logout from site and check result")
	@Severity(SeverityLevel.CRITICAL)
	public void logoutFromBlondeSite() throws InterruptedException {
		loginToBlondeSite();
		LoginLogout loginLogout = (LoginLogout) SiteFactory.Create("LoginLogout", driver);
		Thread.sleep(5000);
		loginLogout.pressLogoutButton();
		//Assertions: Azt nézzük meg, hogy megjelenik-e a login szöveg
		String expectedButtonText = "Login";
		String actualButtonText = loginLogout.currentLogoutResult();
		Assertions.assertEquals(expectedButtonText, actualButtonText);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Modify data on Blonde Site")
	@Description("Modiiy profile data and check result")
	@Severity(SeverityLevel.NORMAL)
	public void modifyDataOnBlondeSite() throws InterruptedException {
		loginToBlondeSite();
		ModifyData modifyData = (ModifyData) SiteFactory.Create("ModifyData", driver);
		Thread.sleep(5000);
		modifyData.clickOnProfileLink();
		modifyData.writeIntoNameField();
		modifyData.writeIntoBioField();
		modifyData.writeIntoPhoneField();
		modifyData.clickOnSaveProfileButton();
		// Assertions
		String expectedModifyMessage = "Profile Edited!";
		String actualModifyMessage = modifyData.currentModifyMessageResult();
		Assertions.assertEquals(expectedModifyMessage, actualModifyMessage);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Delete account from Blonde Site")
	@Description("Delete account data and check result")
	@Severity(SeverityLevel.NORMAL)
	public void deleteAccountFromBlondeSite() throws InterruptedException {
		loginToBlondeSite();
		ModifyData modifyData = (ModifyData) SiteFactory.Create("ModifyData", driver);
		Thread.sleep(5000);
		modifyData.clickOnProfileLink();
		modifyData.clickOnDeleteAccountButton();
		modifyData.clickOnDeleteAccountSureButton();
		// Assertions
		String expectedDeleteMessage = "Profile Deleted!";
		String actualDeleteMessage = modifyData.currentModifyMessageResult();
		Assertions.assertEquals(expectedDeleteMessage, actualDeleteMessage);
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