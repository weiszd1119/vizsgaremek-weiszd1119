//TODO

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksOnSite extends StartDriver {
    private final String urlLinks = "https://lennertamas.github.io/blondesite/about/";
    private final By findContactYourName = By.name("name");
    public LinksOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlLinks);
    }

    /*
    public void writeintocontactyournameuserfield() {
        driver.findElement(findContactYourName).sendKeys(inputContactYourName);
    }
    */

}