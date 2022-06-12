// Main: Driver konfigurálása, tesztek futtatása
// Lokális futtatásnál a headless-t ki kell kapcsolni, viszont a GitHub-os futtatás csak bekapcsolt headless-szel működik

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import jdk.jfr.ContentType;
import okhttp3.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.annotation.CheckReturnValue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ExamTestMain {

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
    @Description("Web Service Test at Blonde Site")
    @Severity(SeverityLevel.CRITICAL)
    public void webServiceTestAtBlondeSite() throws InterruptedException {
        WebServiceTest webServiceTest = (WebServiceTest) SiteFactory.Create("WebServiceTest", driver);
        webServiceTest.sendingresponsecodeoktest();
        }
    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page and login to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void loginToBlondeSite() throws InterruptedException {
        LoginToSite loginToSite = (LoginToSite) SiteFactory.Create("LoginToSite", driver);
        loginToSite.navigate();
        Thread.sleep(5000);
        loginToSite.writeintouserfield();
        loginToSite.writeintopasswordfield();
        loginToSite.pressloginbutton();
        loginToSite.checkloginresult();
        }
    @Test
    @Epic("Blonde Site")
    @Story("Register to Blonde Site")
    @Description("Navigation to the Register page and register to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void registerToBlondeSite() throws InterruptedException {
        RegisterToSite registerToSite = (RegisterToSite) SiteFactory.Create("RegisterToSite", driver);
        registerToSite.navigate();
        Thread.sleep(5000);
        registerToSite.pushregtab();
        registerToSite.writeintoreguserfield();
        registerToSite.writeintoregpasswordfield();
        registerToSite.writeintoregemailfield();
        registerToSite.writeintoregdescriptionfield();
        registerToSite.pushregbutton();
        registerToSite.writeintoreguserfieldinvalid();
        registerToSite.writeintoregpasswordfieldinvalid();
        registerToSite.writeintoregemailfieldinvalid();
        registerToSite.writeintoregdescriptionfieldinvalid();
        registerToSite.pushregbutton();
    }

    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page")
    @Severity(SeverityLevel.NORMAL)
    public void navigateOnBlondeSite() throws InterruptedException {
        NavigateOnSite navigateOnSite = (NavigateOnSite) SiteFactory.Create("NavigateOnSite", driver);
        Thread.sleep(5000);
        loginToBlondeSite();
        navigateOnSite.clickonsecondpage();
        navigateOnSite.clickonnextpage();
        navigateOnSite.checknavigateresult();
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
    public void searchOnBlondeSite() throws InterruptedException {
        SearchOnSite searchOnSite = (SearchOnSite) SiteFactory.Create("SearchOnSite", driver);
        searchOnSite.navigate();
        Thread.sleep(5000);
        searchOnSite.writeintosearchfield();
    }

    @Test
    @Epic("Tags")
    @Story("Tags on Blonde Site")
    @Description("Tags some expressions the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void tagsOnBlondeSite() throws InterruptedException {
        TagsOnSite tagsOnSite = (TagsOnSite) SiteFactory.Create("TagsOnSite", driver);
        tagsOnSite.navigate();
        Thread.sleep(5000);
        tagsOnSite.clickonfindcsstagandcheckresult();
    }

    @Test
    @Epic("Math Typesetting")
    @Story("Test all external links")
    @Description("Test all external links")
    @Severity(SeverityLevel.NORMAL)
    public void linksOnBlondeSite() throws InterruptedException {
        LinksOnSite linksOnSite = (LinksOnSite) SiteFactory.Create("LinksOnSite", driver);
        linksOnSite.navigate();
        Thread.sleep(5000);
        linksOnSite.clickonlinksandcheckresult();
    }

    @Test
    @Epic("Blonde Site")
    @Story("Search on Blonde Site")
    @Description("Search some expressions the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void pagesOnBlondeSite() throws InterruptedException {
        PagesOnSite pagesOnSite = (PagesOnSite) SiteFactory.Create("PagesOnSite", driver);
        pagesOnSite.navigate();
        Thread.sleep(5000);
        pagesOnSite.clickonpagebutton();
        pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        pagesOnSite.checkresult();
    }
    @Test
    @Epic("Blonde Site")
    @Story("Search on Blonde Site")
    @Description("Search some expressions the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void cssStyleOnBlondeSite() throws InterruptedException {
        CssStyleTest cssStyleTest = (CssStyleTest) SiteFactory.Create("CssStyleTest", driver);
        cssStyleTest.navigate();
        Thread.sleep(5000);
        cssStyleTest.clickonsetbutton();
        // cssStyleTest.checkiconchange();
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
    @Story("Embedded Youtube Videos on Blonde Site")
    @Description("Testing embedded Youtube videos and video control functions on the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void youtubeTestOnBlondeSite() throws InterruptedException {
        YoutubeTest youtubeTest = (YoutubeTest) SiteFactory.Create("YoutubeTest", driver);
        youtubeTest.navigate();
        Thread.sleep(10000);
        youtubeTest.pressfirstvideoplaybutton();
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