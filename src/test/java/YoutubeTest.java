import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Collections;

public class YoutubeTest extends StartDriver {
    private final String urlYoutube = "https://lennertamas.github.io/blondesite/post/rich-content/";

    private final By YoutubeVideo = By.cssSelector("#content > div > div > div.col-span-3.lg\\:col-span-2.dark\\:text-white > div:nth-child(1) > div > div:nth-child(3)");

    public YoutubeTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlYoutube);
    }

    public void pressfirstvideoplaybutton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        driver.findElement(YoutubeVideo).sendKeys(Keys.SPACE);
    }

}
