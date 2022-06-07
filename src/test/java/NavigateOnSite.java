import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigateOnSite extends StartDriver {
    private final String urlNav = "https://lennertamas.github.io/blondesite/";
    private final String expectedUrl = "https://lennertamas.github.io/blondesite/page/2/";
    private final By findSecondPage = By.xpath("//*[@id=\"content\"]/div/div/div[1]/nav/ul/li[2]/a");
    private final By findNextPage = By.xpath("//*[@id=\"content\"]/div/div/div[1]/nav/ul/li[3]/a");

    public NavigateOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void clickonsecondpage() {
        driver.findElement(findSecondPage).click();
    }

    public void clickonnextpage() {
        driver.findElement(findNextPage).click();
    }

    public void checknavigateresult() {
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}