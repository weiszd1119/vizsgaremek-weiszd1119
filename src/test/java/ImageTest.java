//TODO

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageTest extends StartDriver {
    private final String urlLinks = "https://lennertamas.github.io/blondesite/post/image-test/";
    private final By findImage = By.xpath("/html/body/div/div[2]/div/div/div[1]/div[1]/img");


    public ImageTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlLinks);
    }

    /*
    public void checkimageexist() {
        assertEquals(expectedUrlCss, findImage.get);
    }
    */


    /*
  public void CheckImage() throws Exception {
	driver.get(baseUrl);
	WebElement ImageFile = driver.findElement(By.xpath("//img[contains(@id,'Test Image')]"));

        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
             System.out.println("Image not displayed.");
        }
        else
        {
            System.out.println("Image displayed.");
        }
	}
	*/

}