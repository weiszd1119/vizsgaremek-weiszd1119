//TODO switch?

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksOnSite extends StartDriver {
    private final String urlLinks = "https://lennertamas.github.io/blondesite/about/";
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

    public void navigateback() {
        driver.navigate().back();
    }

    public void clickonlinkfirst() {
        driver.findElement(findLinkFirst).click();
    }

    public void clickonlinksecond() {
        driver.findElement(findLinkSecond).click();
    }

    public void clickonlinkthird() {
        driver.findElement(findLinkThird).click();
    }

    public void clickonlinkfourth() {
        driver.findElement(findLinkFourth).click();
    }

    public void clickonlinkfifth() {
        driver.findElement(findLinkFifth).click();
    }

    public void clickonlinksixth() {
        driver.findElement(findLinkSixth).click();
    }

    public void clickonlinkseventh() {
        driver.findElement(findLinkSeventh).click();
    }

    public String checklinkresultfirst() {
        String currentUrlLinksFirst = driver.getCurrentUrl();
        return currentUrlLinksFirst;
    }

    public String checklinkresultsecond() {
        String currentUrlLinksSecond = driver.getCurrentUrl();
        return currentUrlLinksSecond;
    }

    public String checklinkresultthird() {
        String currentUrlLinksThird = driver.getCurrentUrl();
        return currentUrlLinksThird;
    }

    public String checklinkresultfourth() {
        String currentUrlLinksFourth = driver.getCurrentUrl();
        return currentUrlLinksFourth;
    }

    public String checklinkresultfifth() {
        String currentUrlLinksFifth = driver.getCurrentUrl();
        return currentUrlLinksFifth;
    }

    public String checklinkresultsixth() {
        String currentUrlLinksSixth = driver.getCurrentUrl();
        return currentUrlLinksSixth;
    }

    public String checklinkresultseventh() {
        String currentUrlLinksSeventh = driver.getCurrentUrl();
        return currentUrlLinksSeventh;
    }
}