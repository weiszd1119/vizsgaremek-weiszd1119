import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Tag("workwithdata")
public class MainWorkWithData extends ExamTestMain {

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
    @Story("Fill Contact on Blonde Site")
    @Description("Fill Contact the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void fillContactOnBlondeSite() throws InterruptedException {
        FillContactOnSite fillContactOnSite = (FillContactOnSite) SiteFactory.Create("FillContactOnSite", driver);
        fillContactOnSite.navigate();
        Thread.sleep(5000);
        fillContactOnSite.writeintocontactyournameuserfield();
        fillContactOnSite.writeintocontactemailaddress();
        fillContactOnSite.writeintocontactsubject();
        fillContactOnSite.writeintocontactmessage();
        fillContactOnSite.pushsubmitbutton();
        fillContactOnSite.checkcontactresult();
        fillContactOnSite.navigateback();
        fillContactOnSite.deletefromcontactyournameuserfield();
        fillContactOnSite.deletefromcontactemailaddress();
        fillContactOnSite.deletefromcontactsubject();
        fillContactOnSite.deletefromcontactmessage();
        fillContactOnSite.pushsubmitbutton();
        // fillContactOnSite.checkalertmessage();
        // fillContactOnSite.deletecontactresult();
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
        TablesTest tablesTest = (TablesTest) SiteFactory.Create("TablesTest", driver);
        tablesTest.navigate();
        Thread.sleep(5000);
        tablesTest.getNameTable();
        tablesTest.checktableresult();
    }
    @Test
    @Epic("Blonde Site")
    @Story("List on Blonde Site")
    @Description("List on the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void listTestOnBlondeSite() throws InterruptedException {
        ListTest listTest = (ListTest) SiteFactory.Create("ListTest", driver);
        listTest.navigate();
        Thread.sleep(5000);
        listTest.getOrderedList();
        listTest.checklistresult();
    }
    @Test
    @Epic("Blonde Site")
    @Story("Save Image fron Blonde Site")
    @Description("Saving Image from the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void savingImageFromBlondeSite() throws InterruptedException, IOException {
        SaveImageTest saveImageTest = (SaveImageTest) SiteFactory.Create("SaveImageTest", driver);
        saveImageTest.navigate();
        Thread.sleep(5000);
        saveImageTest.saveimage();
        saveImageTest.checksaveimageresult();
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
