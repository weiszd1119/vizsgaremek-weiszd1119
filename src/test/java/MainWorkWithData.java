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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Tag("workWithData")
public class MainWorkWithData {
	
	WebDriver driver;
	
	@BeforeEach
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		// options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Fill Contact on Blonde Site")
	@Description("Fill Contact the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void fillContactOnBlondeSite() throws InterruptedException {
		Contact contact = (Contact) SiteFactory.Create("Contact", driver);
		contact.navigate();
		Thread.sleep(5000);
		// Mezők kitöltése
		contact.writeIntoContactYourNameUserField();
		contact.writeIntoContactEmailAddress();
		contact.writeIntoContactSubject();
		contact.writeIntoContactMessage();
		contact.pushSubmitButton();
		//Assertions
		String expectedFormMessage = "Send successful!";
		String actualFormMessage = contact.currentContactResult();
		Assertions.assertEquals(expectedFormMessage, actualFormMessage);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Fill Contact on Blonde Site")
	@Description("Fill Contact the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void fillContactFromTxtFileOnBlondeSite() throws InterruptedException, IOException {
		Contact contact = (Contact) SiteFactory.Create("Contact", driver);
		contact.navigate();
		Thread.sleep(5000);
		// Mezők kitöltése file-ból
		contact.writeIntoContactYourNameUserFieldFromTxtFile();
		contact.writeIntoContactEmailAddressFromTxtFile();
		contact.writeIntoContactSubjectFromTxtFile();
		contact.writeIntoContactMessageFromTxtFile(); //A filebeolvasás üres sor esetén leáll
		contact.pushSubmitButton();
		//Assertions
		String expectedFormMessage = "Send successful!";
		String actualFormMessage = contact.currentContactResult();
		Assertions.assertEquals(expectedFormMessage, actualFormMessage);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Fill Contact on Blonde Site")
	@Description("Fill Contact the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void fillContactFromJSONFileOnBlondeSite() throws InterruptedException, IOException, ParseException {
		Contact contact = (Contact) SiteFactory.Create("Contact", driver);
		contact.navigate();
		Thread.sleep(5000);
		// Mezők kitöltése file-ból
		// Read JSON file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("contactSource.json");
		Object object = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) object;
		for (int i = 0; i < usersList.size(); i++) {
			JSONObject usersOfJSON = (JSONObject) usersList.get(i);
			JSONObject user = (JSONObject) usersOfJSON.get("users");
			String yourname = (String) user.get("yourname");
			String email = (String) user.get("email");
			String subject = (String) user.get("subject");
			String message = (String) user.get("message");
			contact.fillAllFieldFromJSONFile(yourname, email, subject, message);
			contact.pushSubmitButton();
			Thread.sleep(5000);
			//Assertions
			String expectedFormMessage = "Send successful!";
			String actualFormMessage = contact.currentContactResult();
			Assertions.assertEquals(expectedFormMessage, actualFormMessage);
			//
			contact.navigateBack();
			contact.deleteAllFieldWithJSONFile();
		}
	}
	
	
	@Test
	@Epic("Blonde Site")
	@Story("Delete inputs from Contact on Blonde Site")
	@Description("Delete inputs from Fill Contact the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void deleteInputFromContactOnBlondeSite() throws InterruptedException {
		Contact contact = (Contact) SiteFactory.Create("Contact", driver);
		contact.navigate();
		Thread.sleep(5000);
		// Mezők kitöltése
		contact.writeIntoContactYourNameUserField();
		contact.writeIntoContactEmailAddress();
		contact.writeIntoContactSubject();
		contact.writeIntoContactMessage();
		// Mezők törlése
		contact.deleteFromContactYourNameUserField();
		contact.deleteFromContactEmailAddress();
		contact.deleteFromContactSubject();
		contact.deleteFromContactMessage();
		contact.pushSubmitButton();
		// Figyelmeztető szöveg keresése
		contact.currentWarningMessageResult();
		// Assertions
		String expectedWarningMessage = "Fülle dieses Feld aus.";
		String actualWarningMessage = contact.currentWarningMessageResult();
		Assertions.assertEquals(expectedWarningMessage, actualWarningMessage);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void searchOnBlondeSite() throws InterruptedException, IOException {
		Search search = (Search) SiteFactory.Create("Search", driver);
		search.navigate();
		Thread.sleep(5000);
		search.writeIntoSearchField();
		// Assertions
		// Azt várjuk el, hogy a keresési mező használata után kapjunk egy találati oldalt. A találati oldalon szerepel az a szó, hogy "találat", ha sikeretelen a keresés, a szó nem szerepel az oldalon.
		boolean expectedSearchValue = true;
		boolean actualSearchValue = search.currentSearchResult();
		Assertions.assertEquals(expectedSearchValue, actualSearchValue);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void tablesNameTestOnBlondeSite() throws InterruptedException {
		Tables tables = (Tables) SiteFactory.Create("Tables", driver);
		tables.navigate();
		Thread.sleep(5000);
		// Assertion
		tables.currentNameResult();
		String[] expectedTableColumnNames = {"Bob", "Alice"};
		String[] actualTableColumnNames = tables.getNameTable();
		Assertions.assertArrayEquals(expectedTableColumnNames, actualTableColumnNames);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void tablesAgeTestOnBlondeSite() throws InterruptedException {
		Tables tables = (Tables) SiteFactory.Create("Tables", driver);
		tables.navigate();
		Thread.sleep(5000);
		// Assertion
		tables.currentAgeResult();
		String[] expectedTableColumnAges = {"27", "23"};
		String[] actualTableColumnAges = tables.getAgeTable();
		Assertions.assertArrayEquals(expectedTableColumnAges, actualTableColumnAges);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("List on Blonde Site")
	@Description("List on the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void orderedListTestOnBlondeSite() throws InterruptedException {
		List list = (List) SiteFactory.Create("List", driver);
		list.navigate();
		Thread.sleep(5000);
		//Assertions
		String[] expectedOrderedListElements = {"First item", "Second item", "Third item"};
		String[] actualOrderedListElements = list.getOrderedList();
		Assertions.assertArrayEquals(expectedOrderedListElements, actualOrderedListElements);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Save Image from Blonde Site")
	@Description("Saving Image from the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void savingImageFromBlondeSite() throws InterruptedException, IOException {
		SaveImage saveImageTest = (SaveImage) SiteFactory.Create("SaveImageTest", driver);
		saveImageTest.navigate();
		Thread.sleep(5000);
		saveImageTest.saveImage();
		saveImageTest.saveImageSecond();
		//Assertions
		boolean actualResultImageTest = saveImageTest.checkSaveImageResult(); // Azt vizsgáljuk, hogy a mentés után létezik-e a fájl
		Assertions.assertTrue(actualResultImageTest);
		boolean actualResultImageTestSecond = saveImageTest.checkSaveImageSecondResult(); // Második mentés ellenőrzése
		Assertions.assertTrue(actualResultImageTestSecond);
		boolean actualResultImageTestEqual = saveImageTest.checkSavedTwoImageIsEqual(); // A két lementett kép egyezőségének ellenőrzése pixel szinten
		Assertions.assertTrue(actualResultImageTestEqual);
	}
	
	
	@Test
	@Epic("Blonde Site")
	@Story("Save Image from Blonde Site")
	@Description("Saving Text from the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void saveTextFromBlondeSite() throws InterruptedException, IOException {
		SaveText saveText = (SaveText) SiteFactory.Create("SaveText", driver);
		saveText.navigate();
		Thread.sleep(5000);
		saveText.saveTextToTXTFile();
		//Reading from file.
		//Create Object of java FileReader and BufferedReader class.
		String savedText = "saveTextFile.txt";
		FileReader fileReader = new FileReader(savedText);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String contentOfTextFile = "";
		//Loop to read all lines one by one from file, content saved in a variable, and send keys from this variable.
		String readFromTextFile = null;
		while ((contentOfTextFile = bufferedReader.readLine()) != null) {
			readFromTextFile = contentOfTextFile;
		}
		// Assertions
		String expectedTextFromFile = "Mathematical notation in a Hugo project can be enabled by using third party JavaScript libraries.";
		String actualTextFromFile = readFromTextFile;
		Assertions.assertEquals(expectedTextFromFile, actualTextFromFile);
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