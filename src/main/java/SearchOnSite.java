//TODO Create Assertions

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchOnSite extends StartDriver {
	private final String url = "https://lennertamas.github.io/blondesite/about/";
	private final String inputSearchBox = "syntax\n";
	private final By findSearchBox = By.name("q");
	
	public SearchOnSite(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(url);
	}
	
	public void writeIntoSearchField() {
		driver.findElement(findSearchBox).sendKeys(inputSearchBox);
	}
	
	public String currentSearchResult() {
		// Azt kéne megnézni, hogy az url-be beírja-e a beírt keresőszót, a "q" paramétert kéne kiszedni
		String currentUrlSearch = driver.getCurrentUrl();
		System.out.println(currentUrlSearch);
		return currentUrlSearch;
	}
	
}