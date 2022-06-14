import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

@Tag("usermanagement")
public class MainUserManagement {

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
    public void loginToBlondeSite() throws InterruptedException {
        LoginToSite loginToSite = (LoginToSite) SiteFactory.Create("LoginToSite", driver);
        loginToSite.navigate();
        Thread.sleep(5000);
        loginToSite.writeintouserfield();
        loginToSite.writeintopasswordfield();
        loginToSite.pressloginbutton();
        // Assertions
        String expectedUrlLogin = "https://lennertamas.github.io/blondesite/landing/";
        String actualUrlLogin = loginToSite.checkloginresult();
        Assertions.assertEquals(expectedUrlLogin, actualUrlLogin);
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
        // Assertions (nem ez fog kelleni, hanem ki kell szedni a regisztráció után a megjelenő szöveget
        String expectedUrlRegister = "https://lennertamas.github.io/blondesite/landing/";
        String actualUrlRegister = registerToSite.checkregisterresult();
        Assertions.assertEquals(expectedUrlRegister, actualUrlRegister);
        // Második tesztbe kiszervezni
        registerToSite.writeintoreguserfieldinvalid();
        registerToSite.writeintoregpasswordfieldinvalid();
        registerToSite.writeintoregemailfieldinvalid();
        registerToSite.writeintoregdescriptionfieldinvalid();
        registerToSite.pushregbutton();
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
