import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillContactOnSite extends StartDriver {
    private final String url = "https://lennertamas.github.io/blondesite/contact/";
    private final String inputContactYourName = "Neville Longbottom";
    private final String inputContactEmailAddress = "nevillelongbottom@roxfort.com";
    private final String inputContactSubject = "I forgot when I take the exam";
    private final String inputContactMessage = "Dear Teacher!\n Please let me know when the herbology exam for first-year students will be.\n Sincerely,\n Neville Longbottom";
    private final By findContactYourName = By.name("name");
    private final By findContactEmailAddress = By.name("mail");
    private final By findContactSubject = By.name("title");
    private final By findContactMessage = By.name("message");
    private final By findContactSubmitButton = By.cssSelector("#content > div > div > div.bg-white.col-span-3.lg\\:col-span-2.p-5.dark\\:bg-warmgray-900.dark\\:text-white > div > div > form > input");

    public FillContactOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    public void writeintocontactyournameuserfield() {
        driver.findElement(findContactYourName).sendKeys(inputContactYourName);
    }

    public void writeintocontactemailaddress() {
        driver.findElement(findContactEmailAddress).sendKeys(inputContactEmailAddress);
    }

    public void writeintocontactsubject() {
        driver.findElement(findContactSubject).sendKeys(inputContactSubject);
    }

    public void writeintocontactmessage() {
        driver.findElement(findContactMessage).sendKeys(inputContactMessage);
    }

    public void pushsubmitbutton() {
        driver.findElement(findContactSubmitButton).click();
    }
}