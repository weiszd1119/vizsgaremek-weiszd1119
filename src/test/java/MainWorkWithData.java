import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
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
		ContactOnSite contactOnSite = (ContactOnSite) SiteFactory.Create("ContactOnSite", driver);
		contactOnSite.navigate();
		Thread.sleep(5000);
		// Mezők kitöltése
		contactOnSite.writeIntoContactYourNameUserField();
		contactOnSite.writeIntoContactEmailAddress();
		contactOnSite.writeIntoContactSubject();
		contactOnSite.writeIntoContactMessage();
		contactOnSite.pushSubmitButton();
		// Assertions
		String expectedUrlContact = "https://getform.io/f/4bc32c7d-2c91-4c4d-bacf-a8c1bccf1de9";
		String actualUrlContact = contactOnSite.currentContactResult();
		Assertions.assertEquals(expectedUrlContact, actualUrlContact);
		// Print results
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedUrlContact);
		System.out.println("Actual result is: " + actualUrlContact);
		if (expectedUrlContact.equals(actualUrlContact)) {
			System.out.println("Test passed!");
		}
		else {
			System.out.println("Test failed!");
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Fill Contact on Blonde Site")
	@Description("Fill Contact the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void fillContactFromFileOnBlondeSite() throws InterruptedException, IOException {
		ContactOnSite contactOnSite = (ContactOnSite) SiteFactory.Create("ContactOnSite", driver);
		contactOnSite.navigate();
		Thread.sleep(5000);
		// Mezők kitöltése file-ból
		contactOnSite.writeIntoContactYourNameUserFieldFromFile();
		contactOnSite.writeIntoContactEmailAddressFromFile();
		contactOnSite.writeIntoContactSubjectFromFile();
		contactOnSite.writeIntoContactMessageFromFile(); //A filebeolvasás üres sor esetén leáll
		contactOnSite.pushSubmitButton();
		// Assertions
		String expectedUrlContact = "https://getform.io/f/4bc32c7d-2c91-4c4d-bacf-a8c1bccf1de9";
		String actualUrlContact = contactOnSite.currentContactResult();
		Assertions.assertEquals(expectedUrlContact, actualUrlContact);
		// Print results
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedUrlContact);
		System.out.println("Actual result is: " + actualUrlContact);
		if (expectedUrlContact.equals(actualUrlContact)) {
			System.out.println("Test passed!");
		}
		else {
			System.out.println("Test failed!");
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Delete inputs from Contact on Blonde Site")
	@Description("Delete inputs from Fill Contact the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void deleteInputFromContactOnBlondeSite() throws InterruptedException {
		ContactOnSite contactOnSite = (ContactOnSite) SiteFactory.Create("ContactOnSite", driver);
		contactOnSite.navigate();
		Thread.sleep(5000);
		// Mezők kitöltése
		contactOnSite.writeIntoContactYourNameUserField();
		contactOnSite.writeIntoContactEmailAddress();
		contactOnSite.writeIntoContactSubject();
		contactOnSite.writeIntoContactMessage();
		// Mezők törlése
		contactOnSite.deleteFromContactYourNameUserField();
		contactOnSite.deleteFromContactEmailAddress();
		contactOnSite.deleteFromContactSubject();
		contactOnSite.deleteFromContactMessage();
		contactOnSite.pushSubmitButton();
		// Figyelmeztető szöveg keresése
		contactOnSite.currentWarningMessageResult();
		// Assertions
		String expectedWarningMessage = "Fülle dieses Feld aus.";
		String actualWarningMessage = contactOnSite.currentWarningMessageResult();
		Assertions.assertEquals(expectedWarningMessage, actualWarningMessage);
		// Print results
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedWarningMessage);
		System.out.println("Actual result is: " + actualWarningMessage);
		if (expectedWarningMessage.equals(actualWarningMessage)) {
			System.out.println("Test passed!");
		}
		else {
			System.out.println("Test failed!");
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void searchOnBlondeSite() throws InterruptedException {
		SearchOnSite searchOnSite = (SearchOnSite) SiteFactory.Create("SearchOnSite", driver);
		searchOnSite.navigate();
		Thread.sleep(5000);
		searchOnSite.writeIntoSearchField();
		// Azt kéne megnézni, hogy az url-be beírja-e a beírt keresőszót, a "q" paramétert kéne kiszedni
		String expectedUrlSearch = "https://www.google.com/search?q=syntax&sitesearch=https%3A%2F%2Flennertamas.github.io%2Fblondesite%2F";
		String actualUrlSearch = searchOnSite.currentSearchResult();
		Assertions.assertEquals(expectedUrlSearch, actualUrlSearch);
		// Print results
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedUrlSearch);
		System.out.println("Actual result is: " + actualUrlSearch);
		if (expectedUrlSearch.equals(actualUrlSearch)) {
			System.out.println("Test passed!");
		}
		else {
			System.out.println("Test failed!");
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void tablesNameTestOnBlondeSite() throws InterruptedException {
		Tables tables = (Tables) SiteFactory.Create("TablesTest", driver);
		tables.navigate();
		Thread.sleep(5000);
		// Assertion
		tables.currentNameResult();
		String[] expectedTableColumnNames = {"Bob", "Alice"};
		String[] actualTableColumnNames = tables.getNameTable();
		Assertions.assertArrayEquals(expectedTableColumnNames, actualTableColumnNames);
		// Print results
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedTableColumnNames);
		System.out.println("Actual result is: " + actualTableColumnNames);
		if (expectedTableColumnNames.equals(actualTableColumnNames)) {
			System.out.println("Test passed!");
		}
		else {
			System.out.println("Test failed!");
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void tablesAgeTestOnBlondeSite() throws InterruptedException {
		Tables tables = (Tables) SiteFactory.Create("TablesTest", driver);
		tables.navigate();
		Thread.sleep(5000);
		// Assertion
		tables.currentAgeResult();
		String[] expectedTableColumnAges = {"27", "23"};
		String[] actualTableColumnAges = tables.getAgeTable();
		Assertions.assertArrayEquals(expectedTableColumnAges, actualTableColumnAges);
		// Print results
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedTableColumnAges);
		System.out.println("Actual result is: " + actualTableColumnAges);
		if (expectedTableColumnAges.equals(actualTableColumnAges)) {
			System.out.println("Test passed!");
		}
		else {
			System.out.println("Test failed!");
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("List on Blonde Site")
	@Description("List on the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void listTestOnBlondeSite() throws InterruptedException {
		List listTest = (List) SiteFactory.Create("ListTest", driver);
		listTest.navigate();
		Thread.sleep(5000);
		listTest.getOrderedList();
		// TODO not work yet, Assertions
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
		boolean expectedResultImageTest = true; // Azt vizsgáljuk, hogy a mentés után létezik-e a fájl
		boolean actualResultImageTest = saveImageTest.checkSaveImageResult();
		Assertions.assertTrue(actualResultImageTest);
		// Print results
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedResultImageTest);
		System.out.println("Actual result is: " + actualResultImageTest);
		if (expectedResultImageTest == actualResultImageTest) {
			System.out.println("Test passed!");
		}
		else {
			System.out.println("Test failed!");
		}
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