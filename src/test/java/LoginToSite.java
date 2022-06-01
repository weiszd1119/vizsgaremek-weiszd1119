import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToSite extends StartDriver {
    private static final String url = "https://lennertamas.github.io/blondesite/";
    private static final String inputUserName = "beckz";
    private static final String inputPassword = "30y123";
    private static final WebElement findUserName = driver.findElement(By.id("email"));
    private static final WebElement findPassword = driver.findElement(By.id("password"));
    private static final WebElement findLoginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/button")); //Ez az alsó register


    public LoginToSite(WebDriver startdriver)
    {
        super(startdriver);
    }

    public static void navigate()
    {
        driver.navigate().to(url);
    }
    
    public static void writeintouserfield()
    {
        findUserName.sendKeys(inputUserName);
    }
    public static void writeintopasswordfield()
    {
        findPassword.sendKeys(inputPassword);
    }

    public static void pressloginbutton()
    {
        findLoginButton.click();
    }
        /*
        driver.navigate().to("https://lennertamas.github.io/blondesite/");
        String inputUserName = "beckz";
        WebElement findUserName = driver.findElement(By.id("email"));
        findUserName.sendKeys(inputUserName);
        String inputPassword = "30y123";
        WebElement findPassword = driver.findElement(By.id("password"));
        findPassword.sendKeys(inputPassword);
        findPassword.sendKeys(Keys.ENTER);
        assertEquals("https://lennertamas.github.io/blondesite/", driver.getCurrentUrl());
        */
}
