import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToSite extends StartDriver {
    private final String urlLogin = "https://lennertamas.github.io/blondesite/";
    private final String inputLoginUserName = "weiszd1119";
    private final String inputLoginPassword = "TEmp1119";
    private final By findLoginUserName = By.id("email");
    private final By findLoginPassword = By.id("password");
    private final By findLoginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");

    //Konstruktor
    public LoginToSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlLogin);
    }

    public void writeintouserfield() {
        driver.findElement(findLoginUserName).sendKeys(inputLoginUserName);
    }

    public void writeintopasswordfield() {
        driver.findElement(findLoginPassword).sendKeys(inputLoginPassword);
    }

    public void pressloginbutton() {
        driver.findElement(findLoginButton).click();
    }

    public String checkloginresult() {
        String currentUrlLogin = driver.getCurrentUrl();
        return currentUrlLogin;
    }
}