import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SaveImageTest extends StartDriver {
    private final String urlImageTest = "https://lennertamas.github.io/blondesite/post/image-test/";

    public SaveImageTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlImageTest);
    }

    public void saveimage() throws IOException {
        final WebElement findPrismImage = driver.findElement(By.className("py-4"));
        final String srcPrismImage = findPrismImage.getAttribute("src");
        URL prismImageURL = new URL(srcPrismImage);
        BufferedImage saveImage = ImageIO.read(prismImageURL);
        ImageIO.write(saveImage, "jpg", new File("prism.jpg")); // A képet beteszi a projekt könyvtárába
    }
    public void checksaveimageresult() {
        File savedImageFile = new File("C:\\Users\\Felhasználó\\IdeaProjects\\vizsgaremek-weiszd1119\\prism.jpg");
        Assertions.assertTrue(savedImageFile.exists());
    }

}
