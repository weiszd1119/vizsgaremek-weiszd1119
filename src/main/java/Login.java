import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;

public class Login extends StartDriver {
	private final String inputLoginUserName = "weiszd1119";
	private final String inputLoginPassword = "TEmp1119";
	private final By findLoginUserName = By.id("email");
	private final By findLoginPassword = By.id("password");
	
	private final By findLoginTab = By.id("login-form-button");
	private final By findLoginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");
	
	private final By findLogoutButton = By.xpath("//*[@id=\"mobileMenu\"]/div[2]/a[5]");
	
	//Konstruktor
	public Login(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void writeIntoUserField() {
		driver.findElement(findLoginUserName).sendKeys(inputLoginUserName);
	}
	
	public void navigate() {driver.navigate().to("https://lennertamas.github.io/blondesite/");}
	
	public void writeIntoAllFieldsFromFile() throws IOException, ParseException {
		// Read JSON file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("loginSource.json");
		Object object = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) object;
		for (int i = 0 ; i < usersList.size() ; i++) {
			JSONObject usersOfJSON = (JSONObject) usersList.get(i);
			JSONObject user = (JSONObject) usersOfJSON.get("users");
			String username = (String) user.get("username");
			String password = (String) user.get("password");
			driver.findElement(findLoginUserName).sendKeys(username);
			driver.findElement(findLoginPassword).sendKeys(password);
			driver.findElement(findLoginButton).click();
			driver.findElement(findLogoutButton).click();
		}
	}
	
	
	public void writeIntoPasswordField() {
		driver.findElement(findLoginPassword).sendKeys(inputLoginPassword);
	}
	
	public void pushLoginTab() {
		WebElement waitForVisible = driver.findElement(findLoginTab);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", waitForVisible);
	}
	
	public void pressLoginButton() {
		driver.findElement(findLoginButton).click();
	}
	
	public String checkLoginResult() {
		String currentUrlLogin = driver.getCurrentUrl();
		return currentUrlLogin;
	}
	public String checkLogoutResult() {
		String currentUrlLogout = driver.getCurrentUrl();
		return currentUrlLogout;
	}
}