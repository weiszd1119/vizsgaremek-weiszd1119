//TODO switch?

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Links extends StartDriver {
	private final String urlLinks = "https://lennertamas.github.io/blondesite/about/";
	private final By findLinkFirst = By.linkText("Apache Licence 2.0.");
	private final By findLinkSecond = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[1]/a");
	private final By findLinkThird = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[2]/a");
	private final By findLinkFourth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[3]/a");
	private final By findLinkFifth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[4]/a");
	private final By findLinkSixth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[5]/a");
	private final By findLinkSeventh = By.linkText("GitHub");
	
	public Links(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlLinks);
	}
	
	public void navigateback() {
		driver.navigate().back();
	}
	
	public void clickOnLinkFirst() {
		driver.findElement(findLinkFirst).click();
	}
	
	public void clickOnLinkSecond() {
		driver.findElement(findLinkSecond).click();
	}
	
	public void clickOnLinkThird() {
		driver.findElement(findLinkThird).click();
	}
	
	public void clickOnLinkFourth() {
		driver.findElement(findLinkFourth).click();
	}
	
	public void clickOnLinkFifth() {
		driver.findElement(findLinkFifth).click();
	}
	
	public void clickOnLinkSixth() {
		driver.findElement(findLinkSixth).click();
	}
	
	public void clickOnLinkSeventh() {
		driver.findElement(findLinkSeventh).click();
	}
	
	public String checkLinkResultFirst() {
		String currentUrlLinksFirst = driver.getCurrentUrl();
		return currentUrlLinksFirst;
	}
	
	public String checkLinkResultSecond() {
		String currentUrlLinksSecond = driver.getCurrentUrl();
		return currentUrlLinksSecond;
	}
	
	public String checkLinkResultThird() {
		String currentUrlLinksThird = driver.getCurrentUrl();
		return currentUrlLinksThird;
	}
	
	public String checkLinkResultFourth() {
		String currentUrlLinksFourth = driver.getCurrentUrl();
		return currentUrlLinksFourth;
	}
	
	public String checkLinkResultFifth() {
		String currentUrlLinksFifth = driver.getCurrentUrl();
		return currentUrlLinksFifth;
	}
	
	public String checkLinkResultSixth() {
		String currentUrlLinksSixth = driver.getCurrentUrl();
		return currentUrlLinksSixth;
	}
	
	public String checkLinkResultSeventh() {
		String currentUrlLinksSeventh = driver.getCurrentUrl();
		return currentUrlLinksSeventh;
	}
}