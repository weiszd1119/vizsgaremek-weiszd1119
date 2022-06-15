import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterToSite extends StartDriver {
    private final String urlRegister = "https://lennertamas.github.io/blondesite/";
    private final String inputRegUserName = "weiszd1119";
    private final String inputRegPassword = "TEmp1119";
    private final String inputRegEmail = "yaraclen@gmail.com";
    private final String inputRegDescription = "Test User in CC-TA";
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

    public void writeintoregpasswordfield() {
        driver.findElement(findRegPassword).sendKeys(inputRegPassword);
    }

    public void writeintoregemailfield() {
        driver.findElement(findRegEmail).sendKeys(inputRegEmail);
    }

    public void writeintoregdescriptionfield() {
        driver.findElement(findRegDescription).sendKeys(inputRegDescription);
    }

    public void pushregtab() {
        driver.findElement(findRegisterTab).click();
    }

    public void pushregbutton() {
        driver.findElement(findRegisterButton).click();
    }

    public String currentregistermessageresult() {
        String currentRegisterMessage = driver.findElement(By.id("register-alert")).getText();
        System.out.println(currentRegisterMessage);
        return currentRegisterMessage;
    }
}