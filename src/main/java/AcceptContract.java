import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AcceptContract extends StartDriver {
	public AcceptContract(WebDriver startdriver) {
		super(startdriver);
	}
	
	private final String urlAcceptContract = "https://lennertamas.github.io/blondesite/";
	
	private final By findAcceptButton = By.id("terms-and-conditions-button");
	
	private final By findCloseButton = By.className("CloseIcon");
	
	public void navigate() {
		driver.navigate().to(urlAcceptContract);
	}
	
	public void clickOnAcceptButton() {
		WebElement AcceptButton = driver.findElement(findAcceptButton);
		AcceptButton.click();
	}
	
	public void clickOnCloseButton() {
		WebElement CloseButton = driver.findElement(findCloseButton);
		CloseButton.click();
	}
}