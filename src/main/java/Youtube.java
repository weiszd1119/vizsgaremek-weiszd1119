//TODO Not work yet

import org.openqa.selenium.*;

public class Youtube extends StartDriver {
    private final String urlYoutube = "https://lennertamas.github.io/blondesite/post/rich-content/";

    private final By YoutubeVideo = By.cssSelector("#content > div > div > div.col-span-3.lg\\:col-span-2.dark\\:text-white > div:nth-child(1) > div > div:nth-child(3)");

    public Youtube(WebDriver startdriver) {
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
