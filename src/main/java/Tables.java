import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tables extends StartDriver {
	private final String urlTables = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
	
	private final By FirstTable = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/table[1]/tbody/tr");
	
	private String[] nameList;
	
	private String[] ageList;
	
	
	public Tables(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlTables);
	}
	
	public String[] getNameTable() {
		List<WebElement> tds = driver.findElements(FirstTable);
		String[] nameList;
		nameList = new String[tds.size()];
		for (int i = 0; i < tds.size(); i++) {
			WebElement td = tds.get(i).findElement(By.xpath("./td[1]"));
			nameList[i] = td.getText();
		}
		return nameList;
	}
	
	public String[] getAgeTable() {
		List<WebElement> tds = driver.findElements(FirstTable);
		String[] ageList;
		ageList = new String[tds.size()];
		for (int i = 0; i < tds.size(); i++) {
			WebElement td = tds.get(i).findElement(By.xpath("./td[2]"));
			ageList[i] = td.getText();
		}
		return ageList;
	}
	
	public String[] currentNameResult() {
		String[] currentNameList = nameList;
		return currentNameList;
	}
	
	public String[] currentAgeResult() {
		String[] currentAgeList = ageList;
		return currentAgeList;
	}
}