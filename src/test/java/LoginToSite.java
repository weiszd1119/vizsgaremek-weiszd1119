import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToSite extends StartDriver {
    private final String url = "https://lennertamas.github.io/blondesite/";
    private final String inputUserName = "Remus Lupin";
    private final String inputPassword = "Moon1119";
    private final WebElement findUserName = driver.findElement(By.id("email"));
    private final WebElement findPassword = driver.findElement(By.id("password"));
    private final WebElement findLoginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/button"));

    //Konstruktor
    public LoginToSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    public void writeintouserfield() {
        findUserName.sendKeys(inputUserName);
    }

    public void writeintopasswordfield() {
        findPassword.sendKeys(inputPassword);
    }

    public void pressloginbutton() {
        findLoginButton.click();
    }
}