import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Tag("workwithdata")
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
        contactOnSite.writeintocontactyournameuserfield();
        contactOnSite.writeintocontactemailaddress();
        contactOnSite.writeintocontactsubject();
        contactOnSite.writeintocontactmessage();
        contactOnSite.pushsubmitbutton();
        // Assertions
        String expectedUrlContact = "https://getform.io/f/4bc32c7d-2c91-4c4d-bacf-a8c1bccf1de9";
        String actualUrlContact = contactOnSite.currentcontactresult();
        Assertions.assertEquals(expectedUrlContact, actualUrlContact);
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
        contactOnSite.writeintocontactyournameuserfield();
        contactOnSite.writeintocontactemailaddress();
        contactOnSite.writeintocontactsubject();
        contactOnSite.writeintocontactmessage();
        // Mezők törlése
        contactOnSite.deletefromcontactyournameuserfield();
        contactOnSite.deletefromcontactemailaddress();
        contactOnSite.deletefromcontactsubject();
        contactOnSite.deletefromcontactmessage();
        contactOnSite.pushsubmitbutton();
        // Figyelmeztető szöveg keresése
        contactOnSite.currentwarningmessageresult();
        // Assertions
        String expectedWarningMessage = "Fülle dieses Feld aus.";
        String actualWarningMessage = contactOnSite.currentwarningmessageresult();
        Assertions.assertEquals(expectedWarningMessage, actualWarningMessage);

    }
    @Test
    @Epic("Blonde Site")
    @Story("Search on Blonde Site")
    @Description("Search some expressions the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void searchOnBlondeSite () throws InterruptedException {
        SearchOnSite searchOnSite = (SearchOnSite) SiteFactory.Create("SearchOnSite", driver);
        searchOnSite.navigate();
        Thread.sleep(5000);
        searchOnSite.writeintosearchfield();
    }
    @Test
    @Epic("Blonde Site")
    @Story("Search on Blonde Site")
    @Description("Search some expressions the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void tablesTestOnBlondeSite() throws InterruptedException {
        Tables tablesTest = (Tables) SiteFactory.Create("TablesTest", driver);
        tablesTest.navigate();
        Thread.sleep(5000);
        tablesTest.getNameTable();
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
        // listTest.checklistresult();
    }
    @Test
    @Epic("Blonde Site")
    @Story("Save Image fron Blonde Site")
    @Description("Saving Image from the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void savingImageFromBlondeSite() throws InterruptedException, IOException {
        SaveImage saveImageTest = (SaveImage) SiteFactory.Create("SaveImageTest", driver);
        saveImageTest.navigate();
        Thread.sleep(5000);
        saveImageTest.saveimage();
        boolean actualResultImageTest = saveImageTest.checksaveimageresult(); //Assertion résznek a tesztben kell lennie
        Assertions.assertTrue(actualResultImageTest);
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
