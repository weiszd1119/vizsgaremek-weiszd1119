//TODO switch?

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Links extends StartDriver {
	private final String urlLinks = "https://lennertamas.github.io/blondesite/about/";
	private final By findLinkFirst = By.linkText("Apache Licence 2.0.");
	private final By findLinkSecond = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[1]/a");
	private final By findLinkThird = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[2]/a");
	private final By findLinkFourth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[3]/a");
	private final By findLinkFifth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[4]/a");
	private final By findLinkSixth = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[5]/a");
	private final By findLinkSeventh = By.linkText("GitHub");
	
	private final ArrayList<String> linksTitlesArrayList = new ArrayList<String>(); // Lista létrehozása a megjelenő linkek-nek
	
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
	
	public ArrayList<String> getLinksTitle() {
		String linksTitleString = driver.findElement(By.xpath("//*[@id=\"repository-container-header\"]/div[1]/div/div/strong/a")).getText();
		linksTitlesArrayList.add(linksTitleString);
		return linksTitlesArrayList;
	}
	
	public String[] currentLinksResult() {
		ArrayList<String> currentLinksArrayList = linksTitlesArrayList;
		String[] currentLinksArrayListToArray = currentLinksArrayList.toArray(new String[0]);
		return currentLinksArrayListToArray;
	}
}