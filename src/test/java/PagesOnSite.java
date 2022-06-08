//TODO

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagesOnSite extends StartDriver {
    private final String urlPages = "https://lennertamas.github.io/blondesite/post/emoji-support/";
    private final String expectedUrlPageMath = "https://lennertamas.github.io/blondesite/post/math-typesetting/";
    private final String expectedUrlPlaceholder = "https://lennertamas.github.io/blondesite/post/placeholder-text/";
    private final String expectedUrlRichContent = "https://lennertamas.github.io/blondesite/post/rich-content/";
    private final String expectedUrlMarkdown = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
    private final String expectedUrlImage = "https://lennertamas.github.io/blondesite/post/image-test/";
    private final By findPageButton = By.className("icon-keyboard_arrow_right");

    public PagesOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlPages);
    }

    public void clickonpagesbuttonandcheckresult() {
        driver.findElement(findPageButton).click();
        assertEquals(expectedUrlPageMath, driver.getCurrentUrl());
        driver.findElement(findPageButton).click();
        assertEquals(expectedUrlPlaceholder, driver.getCurrentUrl());
        driver.findElement(findPageButton).click();
        assertEquals(expectedUrlRichContent, driver.getCurrentUrl());
        driver.findElement(findPageButton).click();
        assertEquals(expectedUrlMarkdown, driver.getCurrentUrl());
        driver.findElement(findPageButton).click();
        assertEquals(expectedUrlImage, driver.getCurrentUrl());
    }
}
