import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterToSite extends StartDriver {
    private static final String url = "https://lennertamas.github.io/blondesite/";
    private static final String inputRegUserName = "Remus Lupin";
    private static final String inputRegPassword = "Moon1119";
    private static final String inputRegEmail = "remuslupin@roxfort.com";
    private static final String inputRegDescription = "Teacher at Roxfort";
    private static final WebElement findRegisterTab = driver.findElement(By.id("register-form-button")); //Ez a felső register
    private static final WebElement findRegUserName = driver.findElement(By.id("register-username"));
    private static final WebElement findRegPassword = driver.findElement(By.id("register-password"));
    private static final WebElement findRegEmail = driver.findElement(By.id("register-email"));
    private static final WebElement findRegDescription = driver.findElement(By.id("register-description"));
    private static final WebElement findRegisterButton = driver.findElement(By.xpath("//*[@id=\"register\"]/form/div[6]/button"));

    //Konstruktor
    public RegisterToSite(WebDriver startdriver) {
        super(startdriver);
    }

    public static void navigate() {
        driver.navigate().to(url);
    }

    public static void writeintoreguserfield() {
        findRegUserName.sendKeys(inputRegUserName);
    }

    public static void writeintoregpasswordfield() {
        findRegPassword.sendKeys(inputRegPassword);
    }

    public static void writeintoregemailfield() {
        findRegEmail.sendKeys(inputRegEmail);
    }

    public static void writeintoregdescriptionfield() {
        findRegDescription.sendKeys(inputRegDescription);
    }

    public static void pushregtab() {
        findRegisterTab.click();
    }

    public static void pushregbutton() {
        findRegisterButton.click();
    }
}




    /*
    driver.navigate().to("https://lennertamas.github.io/blondesite/");
        WebElement findRegisterTab = driver.findElement(By.id("register-form-button")); //Ez a felső register
        findRegisterTab.click();
        WebElement findRegUserName = driver.findElement(By.id("register-username"));
        String inputRegUserName = "Neville Longbottom";
        findRegUserName.sendKeys(inputRegUserName);
        WebElement findRegPassword = driver.findElement(By.id("register-password"));
        String inputRegPassword = "LUnaLOvegood1119";
        findRegPassword.sendKeys(inputRegPassword);
        WebElement findRegEmail = driver.findElement(By.id("register-email"));
        String inputRegEmail = "nevillelongbottom@roxfort.com";
        findRegEmail.sendKeys(inputRegEmail);
        WebElement findRegDescription = driver.findElement(By.id("register-description"));
        String inputRegDescription = "Student at Roxfort";
        findRegDescription.sendKeys(inputRegDescription);
        Allure.addAttachment("Screenshot of Register Page (text shown)", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement findRegisterButton = driver.findElement(By.xpath("//*[@id=\"register\"]/form/div[6]/button")); //Ez az alsó register
        findRegisterButton.click();
     */