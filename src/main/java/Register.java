import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;


public class Register extends StartDriver {
	private final String inputRegUserName = "weiszd1119";
	private final String inputRegPassword = "TEmp1119";
	private final String inputRegEmail = "yaraclen@gmail.com";
	private final String inputRegDescription = "Test User in CC-TA";
	private final By findRegisterTab = By.id("register-form-button"); //Ez a felső register
	private final By findRegUserName = By.id("register-username");
	private final By findRegPassword = By.id("register-password");
	private final By findRegEmail = By.id("register-email");
	private final By findRegDescription = By.id("register-description");
	private final By findRegisterButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
	
	//Konstruktor
	public Register(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void writeIntoRegUserField() {
		driver.findElement(findRegUserName).sendKeys(inputRegUserName);
	}
	
	public void writeIntoRegPasswordField() {
		driver.findElement(findRegPassword).sendKeys(inputRegPassword);
	}
	
	public void writeIntoRegEmailField() {
		driver.findElement(findRegEmail).sendKeys(inputRegEmail);
	}
	
	public void writeIntoRegDescriptionField() {
		driver.findElement(findRegDescription).sendKeys(inputRegDescription);
	}
	
	public void pushRegTab() {
		driver.findElement(findRegisterTab).click();
	}
	
	public void pushRegButton() {
		driver.findElement(findRegisterButton).click();
	}
	
	public void writeIntoAllFieldsFromFile() throws IOException, ParseException {
		// Read JSON file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("registerSource.json");
		Object object = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) object;
		for (int i = 0 ; i < usersList.size() ; i++) {
			JSONObject usersOfJSON = (JSONObject) usersList.get(i);
			JSONObject user = (JSONObject) usersOfJSON.get("users");
			String username = (String) user.get("username");
			String password = (String) user.get("password");
			String email = (String) user.get("email");
			String description = (String) user.get("description");
			driver.findElement(findRegUserName).sendKeys(username);
			//Először ezeket be kell regisztrálni
			driver.findElement(findRegPassword).sendKeys(password);
			// push login, navigate back
			driver.findElement(findRegEmail).sendKeys(email);
			driver.findElement(findRegDescription).sendKeys(description);
			driver.findElement(findRegisterButton).click();
			driver.findElement(findRegUserName).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			driver.findElement(findRegPassword).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			driver.findElement(findRegEmail).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			driver.findElement(findRegDescription).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		}
	}
	
	public String currentRegisterMessageResult() {
		String currentRegisterMessage = driver.findElement(By.id("register-alert")).getText();
		return currentRegisterMessage;
	}
}