//TODO

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    public void clickonpagebutton() {
        driver.findElement(findPageButton).click();
    }

    public void checkresult() {
        //Meg kéne keresni az oldal első sorát, és aszerint ellenőrizni a hivatkozásokat. Így szét tudnám szedni a click és a checkresult metódust
        if (driver.getPageSource().contains("Math Typesetting")) {
            assertEquals(expectedUrlPageMath, driver.getCurrentUrl());
        } else if (driver.getPageSource().contains("Placeholder Text")) {
            assertEquals(expectedUrlPlaceholder, driver.getCurrentUrl());
        } else if (driver.getPageSource().contains("Rich Content")) {
            assertEquals(expectedUrlRichContent, driver.getCurrentUrl());
        } else if (driver.getPageSource().contains("Markdown")) {
            assertEquals(expectedUrlMarkdown, driver.getCurrentUrl());
        } else if (driver.getPageSource().contains("Image Test")) {
            assertEquals(expectedUrlImage, driver.getCurrentUrl());
        }
    }
}
