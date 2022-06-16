//TODO findAlertMessage
//TODO szétszedni két külön tesztre

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContactOnSite extends StartDriver {
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
	
	public ContactOnSite(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlContact);
	}
	
	public void writeIntoContactYourNameUserField() {
		driver.findElement(findContactYourName).sendKeys(inputContactYourName);
	}
	
	public void writeIntoContactYourNameUserFieldFromFile() throws IOException {
		//Reading from file.
		//Create Object of java FileReader and BufferedReader class.
		String testFile_1 = "C:\\Users\\Felhasználó\\IdeaProjects\\vizsgaremek-weiszd1119\\src\\main\\java\\ContactOnSite_sources\\dataSourceFromFile_1.txt";
		FileReader fileReader = new FileReader(testFile_1);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOfTestFile_1 = "";
		
		//Loop to read all lines one by one from file, content saved in a variable, and send keys from this variable.
		String inputContactYourNameFromFile = null;
		while ((contentOfTestFile_1 = bufferedReader.readLine()) != null) {
			inputContactYourNameFromFile = contentOfTestFile_1;
		}
		driver.findElement(findContactYourName).sendKeys(inputContactYourNameFromFile);
	}
	
	public void deleteFromContactYourNameUserField() {
		driver.findElement(findContactYourName).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void writeIntoContactEmailAddress() {
		driver.findElement(findContactEmailAddress).sendKeys(inputContactEmailAddress);
	}
	
	public void writeIntoContactEmailAddressFromFile() throws IOException {
		String testFile_2 = "C:\\Users\\Felhasználó\\IdeaProjects\\vizsgaremek-weiszd1119\\src\\main\\java\\ContactOnSite_sources\\dataSourceFromFile_2.txt";
		FileReader fileReader = new FileReader(testFile_2);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOfTestFile_2 = "";
		
		String inputContactEmailAddressFromFile = null;
		while ((contentOfTestFile_2 = bufferedReader.readLine()) != null) {
			inputContactEmailAddressFromFile = contentOfTestFile_2;
		}
		driver.findElement(findContactEmailAddress).sendKeys(inputContactEmailAddressFromFile);
	}
	
	public void deleteFromContactEmailAddress() {
		driver.findElement(findContactEmailAddress).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void writeIntoContactSubject() {
		driver.findElement(findContactSubject).sendKeys(inputContactSubject);
	}
	
	public void writeIntoContactSubjectFromFile() throws IOException {
		String testFile_3 = "C:\\Users\\Felhasználó\\IdeaProjects\\vizsgaremek-weiszd1119\\src\\main\\java\\ContactOnSite_sources\\dataSourceFromFile_3.txt";
		FileReader fileReader = new FileReader(testFile_3);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOfTestFile_3 = "";
		
		String inputContactSubjectFromFile = null;
		while ((contentOfTestFile_3 = bufferedReader.readLine()) != null) {
			inputContactSubjectFromFile = contentOfTestFile_3;
		}
		driver.findElement(findContactSubject).sendKeys(inputContactSubjectFromFile);
	}
	
	public void deleteFromContactSubject() {
		driver.findElement(findContactSubject).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void writeIntoContactMessage() {
		driver.findElement(findContactMessage).sendKeys(inputContactMessage);
	}
	
	public void writeIntoContactMessageFromFile() throws IOException {
		String testFile_4 = "C:\\Users\\Felhasználó\\IdeaProjects\\vizsgaremek-weiszd1119\\src\\main\\java\\ContactOnSite_sources\\dataSourceFromFile_4.txt";
		FileReader fileReader = new FileReader(testFile_4);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOfTestFile_4 = "";
		
		String inputContactMessageFromFile = null;
		while ((contentOfTestFile_4 = bufferedReader.readLine()) != null) {
			inputContactMessageFromFile = contentOfTestFile_4;
		}
		driver.findElement(findContactMessage).sendKeys(inputContactMessageFromFile);
	}
	
	public void deleteFromContactMessage() {
		driver.findElement(findContactMessage).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void pushSubmitButton() {
		driver.findElement(findContactSubmitButton).click();
	}
	
	public String currentContactResult() {
		String currentUrlContact = driver.getCurrentUrl();
		return currentUrlContact;
	}
	
	// Fülle dieses Feld aus keresése
	public String currentWarningMessageResult() {
		String currentWarningMessage = driver.findElement(By.name("name")).getAttribute("validationMessage");
		return currentWarningMessage;
	}
	
	
}