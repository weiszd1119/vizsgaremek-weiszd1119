import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExamTest {
    public WebDriver driver;

    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page")
    @Severity(SeverityLevel.CRITICAL)
    public void loginBlondeSite() {
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
        driver.navigate().to("https://lennertamas.github.io/blondesite/");
        String inputUserName = "beckz";
        WebElement findUserName = driver.findElement(By.id("email"));
        findUserName.sendKeys(inputUserName);
        String inputPassword = "30y123";
        WebElement findPassword = driver.findElement(By.id("password"));
        findPassword.sendKeys(inputPassword);
        findPassword.sendKeys(Keys.ENTER);
        assertEquals("https://lennertamas.github.io/blondesite/", driver.getCurrentUrl());
        Allure.addAttachment("Screenshot of Landing Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page")
    @Severity(SeverityLevel.CRITICAL)
    public void navigateOnBlondeSite() {
        loginBlondeSite();
        WebElement findSecondPage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/nav/ul/li[2]/a"));
        findSecondPage.click();
        assertEquals("https://lennertamas.github.io/blondesite/page/2/", driver.getCurrentUrl());
        Allure.addAttachment("Screenshot of Landing Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement findNextPage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/nav/ul/li[3]/a"));
        findNextPage.click();
        assertEquals("https://lennertamas.github.io/blondesite/page/2/", driver.getCurrentUrl());
        Allure.addAttachment("Screenshot of Landing Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test
    @Epic("Blonde Site")
    @Story("Login to Blonde Site")
    @Description("Navigation to the login page")
    @Severity(SeverityLevel.CRITICAL)
    public void fillContactOnBlondeSite() throws InterruptedException {
        loginBlondeSite();
        Thread.sleep(2000);
        WebElement findYourName = driver.findElement(By.xpath(".//*[text()[contains(.,\"Your Name\")]]"));
        findYourName.sendKeys("Neville Longbottom");
        WebElement findEmailAddress = driver.findElement(By.xpath(".//*[text()[contains(.,\"Email Address\")]]"));
        findEmailAddress.sendKeys("nevillelongbottom@roxfort.com");
        WebElement findSubject = driver.findElement(By.xpath(".//*[text()[contains(.,\"Subject\")]]"));
        findSubject.sendKeys("I forgot when I take the exam");
        WebElement findMessage = driver.findElement(By.xpath(".//*[text()[contains(.,\"Message\")]]"));
        findMessage.sendKeys(" Dear Teacher!\n Please let me know when the herbology exam for first-year students will be.\n Sincerely,\n Neville Longbottom");
        WebElement findSubmitButton = driver.findElement(By.xpath(".//*[text()[contains(.,\"Submit\")]]"));
        findSubmitButton.click();
        Allure.addAttachment("Screenshot of Contact Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}