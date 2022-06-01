//Main: Driver konfigurálása, tesztek futtatása
//Lokális futtatásnál a headless-t ki kell kapcsolni, viszont a GitHub-os futtatás csak bekapcsolt headless-szel működik

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
        // options.addArguments("--headless");
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
    public void loginBlondeSite() {
        LoginToSite loginToSite = (LoginToSite) SiteFactory.Create("LoginToSite", driver);
        LoginToSite.navigate();
        LoginToSite.writeintouserfield();
        LoginToSite.writeintopasswordfield();
        LoginToSite.pressloginbutton();
        }
    @Test
    @Epic("Blonde Site")
    @Story("Register to Blonde Site")
    @Description("Navigation to the Register page and register to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void registerToBlondeSite() {
        RegisterToSite registerToSite = (RegisterToSite) SiteFactory.Create("RegisterToSite", driver);
        registerToSite.navigate();
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
    public void navigateOnBlondeSite() {
        driver.navigate().to("https://lennertamas.github.io/blondesite/");
        String inputUserName = "beckz";
        WebElement findUserName = driver.findElement(By.id("email"));
        findUserName.sendKeys(inputUserName);
        String inputPassword = "30y123";
        WebElement findPassword = driver.findElement(By.id("password"));
        findPassword.sendKeys(inputPassword);
        findPassword.sendKeys(Keys.ENTER);
        WebElement findSecondPage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/nav/ul/li[2]/a"));
        findSecondPage.click();
        assertEquals("https://lennertamas.github.io/blondesite/page/2/", driver.getCurrentUrl());
        Allure.addAttachment("Screenshot of Landing Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement findNextPage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/nav/ul/li[3]/a"));
        findNextPage.click();
        assertEquals("https://lennertamas.github.io/blondesite/page/2/", driver.getCurrentUrl());
    }

    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page")
    @Severity(SeverityLevel.NORMAL)
    public void fillContactOnBlondeSite() throws InterruptedException {
        driver.navigate().to("https://lennertamas.github.io/blondesite/contact/");
        Thread.sleep(2000);
        WebElement findYourName = driver.findElement(By.name("name"));
        findYourName.sendKeys("Neville Longbottom");
        WebElement findEmailAddress = driver.findElement(By.name("mail"));
        findEmailAddress.sendKeys("nevillelongbottom@roxfort.com");
        WebElement findSubject = driver.findElement(By.name("title"));
        findSubject.sendKeys("I forgot when I take the exam");
        WebElement findMessage = driver.findElement(By.name("message"));
        findMessage.sendKeys(" Dear Teacher!\n Please let me know when the herbology exam for first-year students will be.\n Sincerely,\n Neville Longbottom");
        Allure.addAttachment("Screenshot of Contact Page (text shown)", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement findSubmitButton = driver.findElement(By.cssSelector("#content > div > div > div.bg-white.col-span-3.lg\\:col-span-2.p-5.dark\\:bg-warmgray-900.dark\\:text-white > div > div > form > input"));
        findSubmitButton.click();
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