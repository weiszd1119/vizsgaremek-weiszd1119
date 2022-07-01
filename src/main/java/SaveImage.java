import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SaveImage extends StartDriver {
	private final String urlImageTest = "https://lennertamas.github.io/blondesite/post/image-test/";
	
	private final String saveFileName = "prism.jpg";
	
	private final String saveFileNameSecond = "prismSecond.jpg";
	
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
	
	public void saveImageSecond() throws IOException {
		final WebElement findPrismImage = driver.findElement(By.className("py-4"));
		final String srcPrismImage = findPrismImage.getAttribute("src");
		URL prismImageURL = new URL(srcPrismImage);
		BufferedImage saveImage = ImageIO.read(prismImageURL);
		ImageIO.write(saveImage, "jpg", new File(saveFileNameSecond)); // A képet beteszi a projekt könyvtárába
	}
	
	public boolean checkSaveImageResult() {
		File savedImageFile = new File(saveFileName);
		return savedImageFile.exists();
	}
	
	public boolean checkSaveImageSecondResult() {
		File savedImageFile = new File(saveFileNameSecond);
		return savedImageFile.exists();
	}
	
	public boolean checkSavedTwoImageIsEqual() throws IOException {
		boolean twoImageIsEqual = false;
		BufferedImage savedImageFirst = ImageIO.read(new File("prism.jpg"));
		BufferedImage savedImageSecond = ImageIO.read(new File("prismSecond.jpg"));
		int widthOfImageFirst = savedImageFirst.getWidth();
		int widthOfImageSecond = savedImageSecond.getWidth();
		int heightOfImageFirst = savedImageFirst.getHeight();
		int heightOfImageSecond = savedImageSecond.getHeight();
		if ((widthOfImageFirst != widthOfImageSecond) || (heightOfImageFirst != heightOfImageSecond)) {
			twoImageIsEqual = false;
		} else {
			long difference = 0;
			for (int j = 0; j < heightOfImageFirst; j++) {
				for (int i = 0; i < widthOfImageFirst; i++) {
					//Getting the RGB values of a pixel
					int pixel1 = savedImageFirst.getRGB(i, j);
					Color color1 = new Color(pixel1, true);
					int r1 = color1.getRed();
					int g1 = color1.getGreen();
					int b1 = color1.getBlue();
					int pixel2 = savedImageSecond.getRGB(i, j);
					Color color2 = new Color(pixel2, true);
					int r2 = color2.getRed();
					int g2 = color2.getGreen();
					int b2 = color2.getBlue();
					//sum of differences of RGB values of the two images
					long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
					difference = difference + data;
				}
			}
			double avg = difference / (widthOfImageFirst * heightOfImageFirst * 3);
			double percentage = 100 - ((avg / 255) * 100); // A 100-ból vonom ki a különbséget. Ha nincs különbség, azaz a különbség 0, akkor a két kép egyezősége 100%
			if (percentage == 100) {
				twoImageIsEqual = true;
			}
		}
		return twoImageIsEqual;
		
	}
}