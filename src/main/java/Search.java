//TODO Create Assertions

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Search extends StartDriver {
	private final String urlSearch = "https://lennertamas.github.io/blondesite/about/";
	private final By findSearchBox = By.name("q");
	
	private final By findAcceptButton = By.id("L2AGLb"); //A keresés után felugrik egy Google-s adatkezelő nyilatkozat
	
	public Search(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlSearch);
	}
	
	public void writeIntoSearchField() throws IOException, InterruptedException {
		// A textfile sorainak számának lekérdezése ahhoz, hogy csak addig fusson le a fori (i < linesDataSourceTxt) Path path = Paths.get(fileName);
		int linesDataSource = 0;
		try {
			linesDataSource = (int) Files.lines(Path.of(("searchSource.txt"))).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < linesDataSource; i++) {
			// Sorok beolvasása
			String inputActualLine = Files.readAllLines(Paths.get("searchSource.txt")).get(i);
			// Sorok elküldése
			driver.findElement(findSearchBox).sendKeys(inputActualLine, Keys.ENTER);
			driver.findElement(findAcceptButton);
			Thread.sleep(5000);
			driver.navigate().back();
			driver.findElement(findSearchBox).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		}
	}
	
	// Azt várjuk el, hogy a keresési mező használata után kapjunk egy találati oldalt. A találati oldalon szerepel az a szó, hogy "találat", ha sikeretelen a keresés, a szó nem szerepel az oldalon.
	public boolean currentSearchResult() {
		boolean currentSearchFindAWord = driver.getPageSource().contains("Ergebnisse"); //Az Ergebnisse szó németül találatot jelent
		return currentSearchFindAWord;
	}
}