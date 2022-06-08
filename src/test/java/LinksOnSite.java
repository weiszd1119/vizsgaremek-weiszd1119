//TODO switch?

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinksOnSite extends StartDriver {
    private final String urlLinks = "https://lennertamas.github.io/blondesite/about/";
    private final String expectedUrlLinkFirst = "https://github.com/gohugoio/hugo/blob/master/LICENSE";
    private final String expectedUrlLinkSecond = "https://github.com/yuin/goldmark";
    private final String expectedUrlLinkThird = "https://github.com/alecthomas/chroma";
    private final String expectedUrlLinkFourth = "https://github.com/muesli/smartcrop";
    private final String expectedUrlLinkFifth = "https://github.com/spf13/cobra";
    private final String expectedUrlLinkSixth = "https://github.com/spf13/viper";
    private final String expectedUrlLinkSeventh = "https://github.com/gohugoio";
    private final By findLinkFirst = By.linkText("Apache Licence 2.0.");
    private final By findLinkSecond = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[1]/a");
    private final By findLinkThird = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[2]/a");
    private final By findLinkFourth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[3]/a");
    private final By findLinkFifth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[4]/a");
    private final By findLinkSixth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[5]/a");
    private final By findLinkSeventh = By.linkText("GitHub");
    public LinksOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlLinks);
    }

    public void clickonlinksandcheckresult() {
        driver.findElement(findLinkFirst).click();
        assertEquals(expectedUrlLinkFirst, driver.getCurrentUrl());
        driver.navigate().back();
        driver.findElement(findLinkSecond).click();
        assertEquals(expectedUrlLinkSecond, driver.getCurrentUrl());
        driver.navigate().back();
        driver.findElement(findLinkThird).click();
        assertEquals(expectedUrlLinkThird, driver.getCurrentUrl());
        driver.navigate().back();
        driver.findElement(findLinkFourth).click();
        assertEquals(expectedUrlLinkFourth, driver.getCurrentUrl());
        driver.navigate().back();
        driver.findElement(findLinkFifth).click();
        assertEquals(expectedUrlLinkFifth, driver.getCurrentUrl());
        driver.navigate().back();
        driver.findElement(findLinkSixth).click();
        assertEquals(expectedUrlLinkSixth, driver.getCurrentUrl());
        driver.navigate().back();
        driver.findElement(findLinkSeventh).click();
        assertEquals(expectedUrlLinkSeventh, driver.getCurrentUrl());
    }
}