import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterToSite extends StartDriver {
    private final String urlRegister = "https://lennertamas.github.io/blondesite/";
    private final String inputRegUserName = "weiszd1119";
    private final String inputRegPassword = "TEmp1119";
    private final String inputRegEmail = "yaraclen@gmail.com";
    private final String inputRegDescription = "Test User in CC-TA";
    private final String inputRegUserNameInvalid = "we1";
    private final String inputRegPasswordInvalid = "a";
    private final String inputRegEmailInvalid = "tz@@tz.com";
    private final String inputRegDescriptionInvalid = "";
    private final By findRegisterTab = By.id("register-form-button"); //Ez a felső register
    private final By findRegUserName = By.id("register-username");
    private final By findRegPassword = By.id("register-password");
    private final By findRegEmail = By.id("register-email");
    private final By findRegDescription = By.id("register-description");
    private final By findRegisterButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");

    //Konstruktor
    public RegisterToSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlRegister);
    }

    public void writeintoreguserfield() {
        driver.findElement(findRegUserName).sendKeys(inputRegUserName);
    }
    public void writeintoreguserfieldinvalid() {
        driver.findElement(findRegUserName).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        driver.findElement(findRegUserName).sendKeys(inputRegUserNameInvalid);
    }

    public void writeintoregpasswordfield() {
        driver.findElement(findRegPassword).sendKeys(inputRegPassword);
    }
    public void writeintoregpasswordfieldinvalid() {
        driver.findElement(findRegPassword).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        driver.findElement(findRegPassword).sendKeys(inputRegPasswordInvalid);

    }
    public void writeintoregemailfield() {
        driver.findElement(findRegEmail).sendKeys(inputRegEmail);
    }
    public void writeintoregemailfieldinvalid() {
        driver.findElement(findRegEmail).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        driver.findElement(findRegEmail).sendKeys(inputRegEmailInvalid);
    }
    public void writeintoregdescriptionfield() {
        driver.findElement(findRegDescription).sendKeys(inputRegDescription);
    }
    public void writeintoregdescriptionfieldinvalid() {
        driver.findElement(findRegDescription).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        driver.findElement(findRegDescription).sendKeys(inputRegDescriptionInvalid);
    }
    public void pushregtab() {
        driver.findElement(findRegisterTab).click();
    }

    public void pushregbutton() {
        driver.findElement(findRegisterButton).click();
    }

    public String checkregisterresult() {
        String currentUrlRegister = driver.getCurrentUrl();
        return currentUrlRegister;
    }
}