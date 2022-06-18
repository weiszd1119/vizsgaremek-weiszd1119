//TODO Create Assertions

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Search extends StartDriver {
	private final String urlSearch = "https://lennertamas.github.io/blondesite/about/";
	private final By findSearchBox = By.name("q");
	
	public Search(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlSearch);
	}
	
	public void writeIntoSearchField() throws IOException {
		// A textfile sorainak számának lekérdezése ahhoz, hogy csak addig fusson le a fori (i < linesDataSourceTxt) Path path = Paths.get(fileName);
		int linesDataSource = 0;
		try {
			linesDataSource = (int) Files.lines(Path.of(("C:\\Users\\Felhasználó\\IdeaProjects\\vizsgaremek-weiszd1119\\src\\main\\java\\Search_sources\\dataSource.txt"))).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Text file long was: " + linesDataSource + " line");
		for (int i = 0; i < linesDataSource; i++) {
			// Sorok beolvasása
			String inputActualLine = Files.readAllLines(Paths.get("C:\\Users\\Felhasználó\\IdeaProjects\\vizsgaremek-weiszd1119\\src\\main\\java\\Search_sources\\dataSource.txt")).get(i);
			// Sorok elküldése
			driver.findElement(findSearchBox).sendKeys(inputActualLine, Keys.ENTER);
			// "q" paraméter kiolvasása az URL-ből
			String currentUrlSearch = driver.getCurrentUrl();
			URL urlSearchResultGetQParameter;
			urlSearchResultGetQParameter = new URL(currentUrlSearch);
			String parameters = urlSearchResultGetQParameter.getQuery();
			System.out.println("Parameters were: " + parameters);
			driver.navigate().back();
			driver.findElement(findSearchBox).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		}
	}
	
	public String currentSearchResult() throws MalformedURLException {
		String currentUrlSearch = driver.getCurrentUrl();
		URL urlSearchResultGetQParameter;
		urlSearchResultGetQParameter = new URL(currentUrlSearch);
		String q = urlSearchResultGetQParameter.getQuery();
		System.out.println(q);
		return q;
	}
}