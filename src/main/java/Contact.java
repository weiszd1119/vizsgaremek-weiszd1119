import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Contact extends StartDriver {
	private final String urlContact = "https://lennertamas.github.io/blondesite/contact/";
	private final String inputContactYourName = "Neville Longbottom";
	private final String inputContactEmailAddress = "nevillelongbottom@roxfort.com";
	private final String inputContactSubject = "I forgot when I take the exam";
	private final String inputContactMessage = "Dear Teacher!\n Please let me know when the herbology exam for first-year students will be.\n Sincerely,\n Neville Longbottom";
	private final By findContactYourName = By.name("name");
	private final By findContactEmailAddress = By.name("mail");
	private final By findContactSubject = By.name("title");
	private final By findContactMessage = By.name("message");
	private final By findContactSubmitButton = By.cssSelector("#content > div > div > div.bg-white.col-span-3.lg\\:col-span-2.p-5.dark\\:bg-warmgray-900.dark\\:text-white > div > div > form > input");
	
	private final By formMessage = By.xpath("/html/body/div/div[1]/h1");
	
	public Contact(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlContact);
	}
	
	public void writeIntoContactYourNameUserField() {
		driver.findElement(findContactYourName).sendKeys(inputContactYourName);
	}
	
	public void writeIntoContactYourNameUserFieldFromTxtFile() throws IOException {
		//Reading from file.
		//Create Object of java FileReader and BufferedReader class.
		String testFileYourName = "contactSourceYourName.txt";
		FileReader fileReader = new FileReader(testFileYourName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOfTestYourName = "";
		
		//Loop to read all lines one by one from file, content saved in a variable, and send keys from this variable.
		String inputContactYourNameFromFile = null;
		while ((contentOfTestYourName = bufferedReader.readLine()) != null) {
			inputContactYourNameFromFile = contentOfTestYourName;
		}
		driver.findElement(findContactYourName).sendKeys(inputContactYourNameFromFile);
	}
	
	public void deleteFromContactYourNameUserField() {
		driver.findElement(findContactYourName).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void writeIntoContactEmailAddress() {
		driver.findElement(findContactEmailAddress).sendKeys(inputContactEmailAddress);
	}
	
	public void writeIntoContactEmailAddressFromTxtFile() throws IOException {
		String testFileEmailAddress = "contactSourceEmailAddress.txt";
		FileReader fileReader = new FileReader(testFileEmailAddress);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOftestFileEmailAddress = "";
		
		String inputContactEmailAddressFromFile = null;
		while ((contentOftestFileEmailAddress = bufferedReader.readLine()) != null) {
			inputContactEmailAddressFromFile = contentOftestFileEmailAddress;
		}
		driver.findElement(findContactEmailAddress).sendKeys(inputContactEmailAddressFromFile);
	}
	
	public void deleteFromContactEmailAddress() {
		driver.findElement(findContactEmailAddress).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void writeIntoContactSubject() {
		driver.findElement(findContactSubject).sendKeys(inputContactSubject);
	}
	
	public void writeIntoContactSubjectFromTxtFile() throws IOException {
		String testFileSubject = "contactSourceSubject.txt";
		FileReader fileReader = new FileReader(testFileSubject);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOfTestFileSubject = "";
		
		String inputContactSubjectFromFile = null;
		while ((contentOfTestFileSubject = bufferedReader.readLine()) != null) {
			inputContactSubjectFromFile = contentOfTestFileSubject;
		}
		driver.findElement(findContactSubject).sendKeys(inputContactSubjectFromFile);
	}
	
	public void deleteFromContactSubject() {
		driver.findElement(findContactSubject).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void writeIntoContactMessage() {
		driver.findElement(findContactMessage).sendKeys(inputContactMessage);
	}
	
	public void writeIntoContactMessageFromTxtFile() throws IOException {
		String testFileMessage = "contactSourceMessage.txt";
		FileReader fileReader = new FileReader(testFileMessage);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOftestFileMessage = "";
		
		String inputContactMessageFromFile = null;
		while ((contentOftestFileMessage = bufferedReader.readLine()) != null) {
			inputContactMessageFromFile = contentOftestFileMessage;
		}
		driver.findElement(findContactMessage).sendKeys(inputContactMessageFromFile);
	}
	
	public void writeIntoAllFieldsFromJSONFile() throws IOException, ParseException {
		// Read JSON file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("contactSource.json");
		Object object = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) object;
		for (int i = 0 ; i < usersList.size() ; i++) {
			JSONObject usersOfJSON = (JSONObject) usersList.get(i);
			JSONObject user = (JSONObject) usersOfJSON.get("users");
			String yourname = (String) user.get("yourname");
			String email = (String) user.get("email");
			String subject = (String) user.get("subject");
			String message = (String) user.get("message");
		}
	}
	
	public void fillAllFieldFromJSONFile (String yourname, String email, String subject, String message) {
		driver.findElement(findContactYourName).sendKeys(yourname);
		driver.findElement(findContactEmailAddress).sendKeys(email);
		driver.findElement(findContactSubject).sendKeys(subject);
		driver.findElement(findContactMessage).sendKeys(message);
	}
	
	public void deleteAllFieldWithJSONFile() {
		driver.findElement(findContactYourName).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		driver.findElement(findContactEmailAddress).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		driver.findElement(findContactSubject).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		driver.findElement(findContactMessage).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	public void deleteFromContactMessage() {
		driver.findElement(findContactMessage).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void pushSubmitButton() {
		driver.findElement(findContactSubmitButton).click();
	}
	
	public String currentContactResult() {
		String currentFormMessage = driver.findElement(formMessage).getText();
		return currentFormMessage;
	}
	
	// Fülle dieses Feld aus keresése
	public String currentWarningMessageResult() {
		String currentWarningMessage = driver.findElement(By.name("name")).getAttribute("validationMessage");
		return currentWarningMessage;
	}
	
	
}