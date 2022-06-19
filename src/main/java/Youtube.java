//TODO Not work yet

import org.openqa.selenium.*;

public class Youtube extends StartDriver {
	private final String urlYoutube = "https://lennertamas.github.io/blondesite/post/rich-content/";
	
	private final By findYoutubePlayButton = By.xpath("//*[@id=\"movie_player\"]/div[4]/button");
	
	public Youtube(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlYoutube);
	}
	
	public void pressFirstVideoPlayButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		WebElement waitForVisible = driver.findElement(findYoutubePlayButton);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", waitForVisible);
	}
	
}