import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLogout extends StartDriver {
	private final String inputLoginUserName = "weiszd1119";
	private final String inputLoginPassword = "TEmp1119";
	private final By findLoginUserName = By.id("email");
	private final By findLoginPassword = By.id("password");
	
	private final By findLoginTab = By.id("login-form-button");
	private final By findLoginButton = By.xpath("//*[@id=\"login\"]/form/div[4]/button");
	
	private final By findLogoutButton = By.xpath("//*[@id=\"mobileMenu\"]/div[2]/a[5]");
	
	//Konstruktor
	public LoginLogout(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void writeIntoUserField() {
		driver.findElement(findLoginUserName).sendKeys(inputLoginUserName);
	}
	
	public void navigate() {
		driver.navigate().to("https://lennertamas.github.io/blondesite/");
	}
	
	public void fillAllFieldsFromJSONFile(String username, String password) {
		driver.findElement(findLoginUserName).sendKeys(username);
		driver.findElement(findLoginPassword).sendKeys(password);
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
	
	public void pressLogoutButton() {
		driver.findElement(findLogoutButton).click();
	}
	
	public String currentLoginResult() {
		String currentLogout = driver.findElement(By.xpath("//*[@id=\"mobileMenu\"]/div[2]/a[5]")).getText();
		return currentLogout;
	}
	
	public String currentLogoutResult() {
		String currentUrlLogout = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/button")).getText();
		return currentUrlLogout;
	}
}