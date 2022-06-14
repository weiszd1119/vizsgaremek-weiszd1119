//TODO findAlertMessage
//TODO szétszedni két külön tesztre

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class FillContactOnSite extends StartDriver {
    private final String urlContact = "https://lennertamas.github.io/blondesite/contact/";
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
        driver.navigate().to(urlContact);
    }

    public void navigateback() {driver.navigate().back();}

    public void writeintocontactyournameuserfield() {
        driver.findElement(findContactYourName).sendKeys(inputContactYourName);
    }
    public void deletefromcontactyournameuserfield() {
        driver.findElement(findContactYourName).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
    }

    public void writeintocontactemailaddress() {
        driver.findElement(findContactEmailAddress).sendKeys(inputContactEmailAddress);
    }
    public void deletefromcontactemailaddress() {
        driver.findElement(findContactEmailAddress).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
    }

    public void writeintocontactsubject() {
        driver.findElement(findContactSubject).sendKeys(inputContactSubject);
    }
    public void deletefromcontactsubject() {
        driver.findElement(findContactSubject).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
    }

    public void writeintocontactmessage() {
        driver.findElement(findContactMessage).sendKeys(inputContactMessage);
    }
    public void deletefromcontactmessage() {
        driver.findElement(findContactMessage).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
    }

    public void pushsubmitbutton() {
        driver.findElement(findContactSubmitButton).click();
    }
    public String checkcontactresult() {
        String currentUrlContact = driver.getCurrentUrl();
        return currentUrlContact;
        }

        // Fülle dieses Feld aus keresése
    public void warningmessage () {
        String actualTooltip = driver.findElement(By.name("name")).getAttribute("validationMessage");
        System.out.println(actualTooltip);
    }

    /*
    public void checkalertmessage() {
        driver.findElement(findAlertMessageButton);
        assertEquals(inputAlertMessage, new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='submitNext' and @value='Next']"))));
    }
    */

    /*
    public void deletecontactresult() {
    */

    }
