import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PagesOnSite extends StartDriver {
    private final String urlPages = "https://lennertamas.github.io/blondesite/post/emoji-support/";
    private final By findArrowButton = By.className("icon-keyboard_arrow_right");

    public PagesOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlPages);
    }

    public void clickonpagebutton() {
        driver.findElement(findArrowButton).click();
    }
}

