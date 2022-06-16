import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SaveImage extends StartDriver {
	private final String urlImageTest = "https://lennertamas.github.io/blondesite/post/image-test/";
	
	private final String saveFileName = "prism.jpg";
	
	public SaveImage(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlImageTest);
	}
	
	public void saveImage() throws IOException {
		final WebElement findPrismImage = driver.findElement(By.className("py-4"));
		final String srcPrismImage = findPrismImage.getAttribute("src");
		URL prismImageURL = new URL(srcPrismImage);
		BufferedImage saveImage = ImageIO.read(prismImageURL);
		ImageIO.write(saveImage, "jpg", new File(saveFileName)); // A képet beteszi a projekt könyvtárába
	}
	
	public boolean checkSaveImageResult() {
		File savedImageFile = new File(saveFileName);
		return savedImageFile.exists();
	}
	
	
}