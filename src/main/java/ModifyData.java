import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModifyData extends StartDriver {
	
	private final String modifyUrl = "https://lennertamas.github.io/blondesite/";
	
	private final String inputModifyName = "Fred Weasley";
	
	private final String inputModifyBio = "1997";
	
	private final String inputModifyPhone = "717-2201-15";
	
	public ModifyData(WebDriver startdriver) {
		super(startdriver);
	}
	
	private final By findProfileLink = By.linkText("Profile");
	
	private final By findModifyName = By.id("name");
	
	private final By findModifyBio = By.id("bio");
	
	private final By findModifyPhone = By.id("phone-number");
	
	private final By findSaveProfileButton = By.xpath("//*[@id=\"edit-profile\"]/form/div[5]/button");
	
	private final By findDeleteAccountButton = By.xpath("//*[@id=\"edit-profile\"]/form/div[6]/button");
	
	private final By findDeleteAccountSureButton = By.id("delete-account-btn");
	
	public void navigate() {
		driver.navigate().to(modifyUrl);
	}
	
	public void clickOnProfileLink() {
		driver.findElement(findProfileLink).click();
	}
	
	public void clickOnSaveProfileButton() {
		driver.findElement(findSaveProfileButton).click();
	}
	
	public void clickOnDeleteAccountButton() {
		driver.findElement(findDeleteAccountButton).click();
	}
	
	public void clickOnDeleteAccountSureButton() {
		driver.findElement(findDeleteAccountSureButton);
	}
	
	public void writeIntoNameField() {
		driver.findElement(findModifyName).sendKeys(inputModifyName);
	}
	
	public void writeIntoBioField() {
		driver.findElement(findModifyBio).sendKeys(inputModifyBio);
	}
	
	public void writeIntoPhoneField() {
		driver.findElement(findModifyPhone).sendKeys(inputModifyPhone);
	}
	
	public String currentModifyMessageResult() {
		String currentModifyMessage = driver.findElement(By.id("edit-alert")).getText();
		return currentModifyMessage;
	}
	
}