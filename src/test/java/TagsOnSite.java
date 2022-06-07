import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagsOnSite extends StartDriver {
    private final String urlTags = "https://lennertamas.github.io/blondesite/about/";
    private final String expectedUrlCss = "https://lennertamas.github.io/blondesite/tags/css/";
    private final String expectedUrlEmoji = "https://lennertamas.github.io/blondesite/tags/emoji/";
    private final String expectedUrlHtml = "https://lennertamas.github.io/blondesite/tags/html/";
    private final String expectedUrlMarkdown = "https://lennertamas.github.io/blondesite/tags/markdown/";
    private final String expectedUrlPrivacy = "https://lennertamas.github.io/blondesite/tags/privacy/";
    private final String expectedUrlShortcodes = "https://lennertamas.github.io/blondesite/tags/shortcodes/";
    private final String expectedUrlText = "https://lennertamas.github.io/blondesite/tags/text/";
    private final String expectedUrlThemes = "https://lennertamas.github.io/blondesite/tags/themes/";
    private final By findCssTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[1]/span");
    private final By findEmojiTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[2]/span");
    private final By findHtmlTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[3]/span");
    private final By findMarkdownTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[4]/span");
    private final By findPrivacyTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[5]/span");
    private final By findShortcodesTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[6]/span");
    private final By findTextTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[7]/span");
    private final By findThemesTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[8]/span");

    public TagsOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlTags);
    }

    public void clickonfindcsstagandcheckresult() {
        driver.findElement(findCssTag).click();
        assertEquals(expectedUrlCss, driver.getCurrentUrl());
        driver.findElement(findEmojiTag).click();
        assertEquals(expectedUrlEmoji, driver.getCurrentUrl());
        driver.findElement(findHtmlTag).click();
        assertEquals(expectedUrlHtml, driver.getCurrentUrl());
        driver.findElement(findMarkdownTag).click();
        assertEquals(expectedUrlMarkdown, driver.getCurrentUrl());
        driver.findElement(findPrivacyTag).click();
        assertEquals(expectedUrlPrivacy, driver.getCurrentUrl());
        driver.findElement(findShortcodesTag).click();
        assertEquals(expectedUrlShortcodes, driver.getCurrentUrl());
        driver.findElement(findTextTag).click();
        assertEquals(expectedUrlText, driver.getCurrentUrl());
        driver.findElement(findThemesTag).click();
        assertEquals(expectedUrlThemes, driver.getCurrentUrl());
    }
}