// TODO full xpath töröl
// TODO for i-vel végigjárni a findTag-eken (?)


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Tags extends StartDriver {
	private final String urlTags = "https://lennertamas.github.io/blondesite/about/";
	
	private final By findCssTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[1]");
	private final By findEmojiTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[2]");
	private final By findHtmlTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[3]");
	private final By findMarkdownTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[4]");
	private final By findPrivacyTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[5]");
	private final By findShortcodesTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[6]");
	private final By findTextTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[7]");
	private final By findThemesTag = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div/a[8]");
	
	private final ArrayList<String> tagsTitlesArrayList = new ArrayList<String>(); // Lista létrehozása a megjelenő tagek-nek
	
	public Tags(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlTags);
	}
	
	public void clickOnTagCss() {
		driver.findElement(findCssTag).click();
	}
	
	public void clickOnTagEmoji() {
		driver.findElement(findEmojiTag).click();
	}
	
	public void clickOnTagHtml() {
		driver.findElement(findHtmlTag).click();
	}
	
	public void clickOnTagMarkdown() {
		driver.findElement(findMarkdownTag).click();
	}
	
	public void clickOnTagPrivacy() {
		driver.findElement(findPrivacyTag).click();
	}
	
	public void clickOnTagShortcodes() {
		driver.findElement(findShortcodesTag).click();
	}
	
	public void clickOnTagText() {
		driver.findElement(findTextTag).click();
	}
	
	public void clickOnTagThemes() {
		driver.findElement(findThemesTag).click();
	}
	
	public ArrayList<String> getTagsTitle() {
		String tagsTitleString = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/h2")).getText();
		tagsTitlesArrayList.add(tagsTitleString);
		return tagsTitlesArrayList;
	}
	
	public String[] currentTagsResult() {
		ArrayList<String> currentTagsArrayList = tagsTitlesArrayList;
		String[] currentTagsArrayListToArray = currentTagsArrayList.toArray(new String[0]);
		return currentTagsArrayListToArray;
	}
	
	
}