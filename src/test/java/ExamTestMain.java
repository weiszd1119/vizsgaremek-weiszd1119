// Main: Driver konfigurálása, tesztek futtatása
// Lokális futtatásnál a headless-t ki kell kapcsolni, viszont a GitHub-os futtatás csak bekapcsolt headless-szel működik

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page and login to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void loginBlondeSite() throws InterruptedException {
        LoginToSite loginToSite = (LoginToSite) SiteFactory.Create("LoginToSite", driver);
        loginToSite.navigate();
        Thread.sleep(5000);
        loginToSite.writeintouserfield();
        loginToSite.writeintopasswordfield();
        loginToSite.pressloginbutton();
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
    }

    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page")
    @Severity(SeverityLevel.NORMAL)
    public void navigateOnBlondeSite() throws InterruptedException {
        NavigateOnSite navigateOnSite = (NavigateOnSite) SiteFactory.Create("NavigateOnSite", driver);
        Thread.sleep(5000);
        loginBlondeSite();
        navigateOnSite.clickonsecondpage();
        navigateOnSite.clickonnextpage();
        navigateOnSite.checkresult();
    }

    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page")
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