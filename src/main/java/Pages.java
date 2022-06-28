import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Pages extends StartDriver {
	private final String urlPages = "https://lennertamas.github.io/blondesite/post/emoji-support/";
	private final By findArrowButton = By.className("icon-keyboard_arrow_right");
	
	private ArrayList<String> pagesTitlesArrayList = new ArrayList<String>(); // Lista létrehozása a megjelenő tagek-nek
	
	public Pages(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlPages);
	}
	
	public ArrayList<String> getTitle() {
		String pagesTitleString = driver.findElement(By.xpath("//*[@id=\"date\"]")).getText();
		pagesTitlesArrayList.add(pagesTitleString);
		System.out.println(pagesTitlesArrayList);
		return pagesTitlesArrayList;
	}
	public void clickOnPageButton() {
		driver.findElement(findArrowButton).click();
	}
	
	
}