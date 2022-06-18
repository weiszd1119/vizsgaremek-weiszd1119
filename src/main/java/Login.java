import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends StartDriver {
	private final String inputLoginUserName = "weiszd1119";
	private final String inputLoginPassword = "TEmp1119";
	private final By findLoginUserName = By.id("email");
	private final By findLoginPassword = By.id("password");
	
	private final By findLoginTab = By.id("login-form-button");
	private final By findLoginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");
	
	//Konstruktor
	public Login(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void writeIntoUserField() {
		driver.findElement(findLoginUserName).sendKeys(inputLoginUserName);
	}
	
	public void writeIntoPasswordField() {
		driver.findElement(findLoginPassword).sendKeys(inputLoginPassword);
	}
	
	public void pushLoginTab() {
		WebElement waitForVisible = driver.findElement(findLoginTab);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", waitForVisible);
	}
	
	public void pressLoginButton() {
		driver.findElement(findLoginButton).click();
	}
	
	public String checkLoginResult() {
		String currentUrlLogin = driver.getCurrentUrl();
		return currentUrlLogin;
	}
}