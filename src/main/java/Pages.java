import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Pages extends StartDriver {
	private final String urlPages = "https://lennertamas.github.io/blondesite/post/emoji-support/";
	private final By findArrowButton = By.className("icon-keyboard_arrow_right");
	
	private final ArrayList<String> pagesTitlesArrayList = new ArrayList<String>(); // Lista létrehozása a megjelenő tagek-nek
	
	public Pages(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlPages);
	}
	
	public ArrayList<String> getPagesTitle() {
		String pagesTitleString = driver.findElement(By.xpath("//*[@id=\"date\"]")).getText();
		pagesTitlesArrayList.add(pagesTitleString);
		return pagesTitlesArrayList;
	}
	
	public void clickOnPageButton() {
		driver.findElement(findArrowButton).click();
	}
	
	public String[] currentPagesResult() {
		ArrayList<String> currentPagesArrayList = pagesTitlesArrayList;
		String[] currentPagesArrayListToArray = currentPagesArrayList.toArray(new String[0]);
		return currentPagesArrayListToArray;
	}
	
	
}