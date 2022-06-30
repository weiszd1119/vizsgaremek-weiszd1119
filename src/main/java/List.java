import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class List extends StartDriver {
	private final String urlList = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
	
	private final By orderedList = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/ol");
	
	private String[] itemList;
	
	
	public List(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlList);
	}
	
	public String[] getOrderedList() {
		java.util.List<WebElement> lis = driver.findElements(orderedList);
		String[] orderedList;
		orderedList = new String[lis.size()];
		for (int i = 0; i < lis.size(); i++) {
			WebElement li = lis.get(i).findElement(By.xpath("./*"));
			orderedList[i] = li.getText();
		}
		return orderedList;
	}
	
	public String[] currentOrderedResult() {
		String[] currentOrderedList = itemList;
		return currentOrderedList;
	}
	
}