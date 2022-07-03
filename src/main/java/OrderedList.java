import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OrderedList extends StartDriver {
	private final String urlList = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
	
	private final ArrayList<String> lisArrayList = new ArrayList<String>(); // Lista létrehozása a megjelenő li-knek
	
	private final By orderedList = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/ol/li");
	public OrderedList(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlList);
	}
	
	public String[] getOrderedList() {
		List<WebElement> lis = driver.findElements(orderedList);
		String[] itemList;
		itemList = new String[lis.size()];
		for (int i = 0; i < lis.size(); i++) {
			WebElement li = lis.get(i);
			itemList[i] = li.getText();
		}
		return itemList;
	}
}