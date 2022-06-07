import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchOnSite extends StartDriver {
    private final String url = "https://lennertamas.github.io/blondesite/about/";
    private final String inputSearchBox = "syntax\n";
    private final By findSearchBox = By.name("q");
    public SearchOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    public void writeintosearchfield() {
        driver.findElement(findSearchBox).sendKeys(inputSearchBox);
    }
}