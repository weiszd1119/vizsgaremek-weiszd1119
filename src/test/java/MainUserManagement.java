import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
    @Story("Register to Blonde Site")
    @Description("Navigation to the Register page and register to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void acceptContractOnBlondeSite() throws InterruptedException {
        AcceptContract acceptContract = (AcceptContract) SiteFactory.Create("AcceptContract", driver);
        acceptContract.navigate();
        Thread.sleep(5000);
        acceptContract.clickOnAcceptButton();
        // Assertions
        }
    
    @Test
    @Epic("Blonde Site")
    @Story("Register to Blonde Site")
    @Description("Navigation to the Register page and register to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void closeContractOnBlondeSite() throws InterruptedException {
	    AcceptContract acceptContract = (AcceptContract) SiteFactory.Create("AcceptContract", driver);
	    acceptContract.navigate();
	    Thread.sleep(5000);
	    acceptContract.clickOnCloseButton();
	    // Assertions
    }
    
    @Test
    @Epic("Blonde Site")
    @Story("Register to Blonde Site")
    @Description("Navigation to the Register page and register to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void registerToBlondeSite() throws InterruptedException {
        acceptContractOnBlondeSite();
        Register register = (Register) SiteFactory.Create("Register", driver);
        Thread.sleep(5000);
        register.pushRegTab();
        register.writeIntoRegUserField();
        register.writeIntoRegPasswordField();
        register.writeIntoRegEmailField();
        register.writeIntoRegDescriptionField();
        register.pushRegButton();
        // Assertions
        String expectedRegisterMessage = "User registered!";
        String actualUrlRegister = register.currentRegisterMessageResult();
        Assertions.assertEquals(expectedRegisterMessage, actualUrlRegister);
        // Invalid register?
        System.out.println("Test results are:");
        System.out.println("Expected result was: " + expectedRegisterMessage);
        System.out.println("Actual result is: " + actualUrlRegister);
        if (expectedRegisterMessage.equals(actualUrlRegister)) {
            System.out.println("Test passed!");
        }
            else {
                System.out.println("Test failed!");
            }
    }
    @Test
    @Epic("Blonde Site")
    @Story("LoginLogout to Blonde Site")
    @Description("Navigation to the login page and login to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void registerFromJSONFileToBlondeSite() throws InterruptedException, IOException, ParseException {
        acceptContractOnBlondeSite();
        Register register = (Register) SiteFactory.Create("Register", driver);
        Thread.sleep(5000);
        register.pushRegTab();
        register.writeIntoAllFieldsFromFile();
        // Assertions
        String expectedRegisterMessage = "User registered!";
        String actualUrlRegister = register.currentRegisterMessageResult();
        Assertions.assertEquals(expectedRegisterMessage, actualUrlRegister);
        // Invalid register?
        System.out.println("Test results are:");
        System.out.println("Expected result was: " + expectedRegisterMessage);
        System.out.println("Actual result is: " + actualUrlRegister);
        if (expectedRegisterMessage.equals(actualUrlRegister)) {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
    }
    
    @Test
    @Epic("Blonde Site")
    @Story("LoginLogout to Blonde Site")
    @Description("Navigation to the login page and login to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void loginToBlondeSite() throws InterruptedException {
        registerToBlondeSite();
        LoginLogout loginLogout = (LoginLogout) SiteFactory.Create("LoginLogout", driver);
        Thread.sleep(5000);
        loginLogout.pushLoginTab();
        loginLogout.writeIntoUserField();
        loginLogout.writeIntoPasswordField();
        loginLogout.pressLoginButton();
        // Assertions
        String expectedUrlLogin = "https://lennertamas.github.io/blondesite/landing.html";
        String actualUrlLogin = loginLogout.checkLoginResult();
        Assertions.assertEquals(expectedUrlLogin, actualUrlLogin);
        // Print results
		System.out.println("Test results are:");
        System.out.println("Expected result was: " + expectedUrlLogin);
        System.out.println("Actual result is: " + actualUrlLogin);
        if (expectedUrlLogin.equals(actualUrlLogin)) {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
    }
    
    @Test
    @Epic("Blonde Site")
    @Story("LoginLogout to Blonde Site")
    @Description("Navigation to the login page and login to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void loginFromJSONFileToBlondeSite() throws InterruptedException, IOException, ParseException {
        registerFromJSONFileToBlondeSite();
        LoginLogout loginLogout = (LoginLogout) SiteFactory.Create("LoginLogout", driver);
        Thread.sleep(5000);
        loginLogout.navigate();
        loginLogout.writeIntoAllFieldsFromFile();
        // Assertions
        String expectedUrlLogin = "https://lennertamas.github.io/blondesite/landing/";
        String actualUrlLogin = loginLogout.checkLoginResult();
        Assertions.assertEquals(expectedUrlLogin, actualUrlLogin);
        // Print results
        System.out.println("Test results are:");
        System.out.println("Expected result was: " + expectedUrlLogin);
        System.out.println("Actual result is: " + actualUrlLogin);
        if (expectedUrlLogin.equals(actualUrlLogin)) {
            System.out.println("Test passed!");
        }
        else {
            System.out.println("Test failed!");
        }
    }
    
    @Test
    @Epic("Blonde Site")
    @Story("LoginLogout to Blonde Site")
    @Description("Navigation to the login page and login to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void logoutFromBlondeSite() throws InterruptedException {
        loginToBlondeSite();
        LoginLogout loginLogout = (LoginLogout) SiteFactory.Create("LoginLogout", driver);
        Thread.sleep(5000);
        loginLogout.pressLogoutButton();
        //Assertions
        //A login oldalra lép vissza
    }
    
    @Test
    @Epic("Blonde Site")
    @Story("Save Image from Blonde Site")
    @Description("Saving Image from the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void modifyDataOnBlondeSite() throws InterruptedException {
        loginToBlondeSite();
        ModifyData modifyData = (ModifyData) SiteFactory.Create("ModifyData", driver);
        Thread.sleep(5000);
        modifyData.clickOnProfileLink();
        modifyData.writeIntoNameField();
        modifyData.writeIntoBioField();
        modifyData.writeIntoPhoneField();
        modifyData.clickOnSaveProfileButton();
        // Assertions
        String expectedModifyrMessage = "Profile Edited!";
        String actualModifyMessage = modifyData.currentModifyMessageResult();
        Assertions.assertEquals(expectedModifyrMessage, actualModifyMessage);
        }
    
    @Test
    @Epic("Blonde Site")
    @Story("Save Image from Blonde Site")
    @Description("Saving Image from the Blonde Site")
    @Severity(SeverityLevel.NORMAL)
    public void deleteAccountFromBlondeSite() throws InterruptedException {
        loginToBlondeSite();
        ModifyData modifyData = (ModifyData) SiteFactory.Create("ModifyData", driver);
        Thread.sleep(5000);
        modifyData.clickOnProfileLink();
        modifyData.clickOnDeleteAccountButton();
        modifyData.clickOnDeleteAccountSureButton();
        
        // Assertions
        // Visszatért a login oldalra, üzenet nincs
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