import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class List<S> extends StartDriver {
	private final String urlList = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
	
	private final ArrayList<String> lisArrayList = new ArrayList<String>(); // Lista létrehozása a megjelenő li-knek
	
	
	public List(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlList);
	}
	
	public ArrayList<String> getOrderedList() {
		String orderedListListLi1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/ol/li[1]")).getText();
		String orderedListListLi2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/ol/li[2]")).getText();
		String orderedListListLi3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/ol/li[3]")).getText();
		lisArrayList.add(orderedListListLi1);
		lisArrayList.add(orderedListListLi2);
		lisArrayList.add(orderedListListLi3);
		return lisArrayList;
	}
	
	public String[] currentLisResult() {
		ArrayList<String> currentLisArrayList = lisArrayList;
		String[] currentLisArrayListToArray = currentLisArrayList.toArray(new String[0]);
		return currentLisArrayListToArray;
	}
}