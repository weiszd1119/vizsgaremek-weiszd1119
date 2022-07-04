import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Tag("controls")
public class MainControlSite {
	
	WebDriver driver;
	
	@BeforeEach
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	@Epic("Tags")
	@Story("Tags on Blonde Site")
	@Description("Click on all tags  at subpage and check titles")
	@Severity(SeverityLevel.NORMAL)
	public void tagsOnBlondeSite() throws InterruptedException {
		Tags tags = (Tags) SiteFactory.Create("Tags", driver);
		tags.navigate();
		Thread.sleep(5000);
		tags.clickOnTagCss();
		tags.getTagsTitle();
		tags.clickOnTagEmoji();
		tags.getTagsTitle();
		tags.clickOnTagHtml();
		tags.getTagsTitle();
		tags.clickOnTagMarkdown();
		tags.getTagsTitle();
		tags.clickOnTagPrivacy();
		tags.getTagsTitle();
		tags.clickOnTagShortcodes();
		tags.getTagsTitle();
		tags.clickOnTagText();
		tags.getTagsTitle();
		tags.clickOnTagThemes();
		tags.getTagsTitle();
		//Assertion: azt ellenőrizzük, hogy az utolsó lépés után a lista megegyezik-e az elvárt listával
		List<String> expectedTagsTitlesArrayList = new ArrayList<>();
		expectedTagsTitlesArrayList.add("Css");
		expectedTagsTitlesArrayList.add("Emoji");
		expectedTagsTitlesArrayList.add("HTML");
		expectedTagsTitlesArrayList.add("Markdown");
		expectedTagsTitlesArrayList.add("Privacy");
		expectedTagsTitlesArrayList.add("Shortcodes");
		expectedTagsTitlesArrayList.add("Text");
		expectedTagsTitlesArrayList.add("Themes");
		String[] expectedTagsTitlesArrayListToArray = expectedTagsTitlesArrayList.toArray(new String[0]); // Az Assertion nem tud listákat összehasonlítani, csak tömböket
		String[] actualTagsTitlesArrayList = tags.currentTagsResult();
		Assertions.assertArrayEquals(expectedTagsTitlesArrayListToArray, actualTagsTitlesArrayList);
	}
	
	@Test
	@Epic("Math Typesetting")
	@Story("Test all external links")
	@Description("Click on all links at subpage and check titles")
	@Severity(SeverityLevel.NORMAL)
	public void linksOnBlondeSite() throws InterruptedException {
		Links links = (Links) SiteFactory.Create("Links", driver);
		links.navigate();
		Thread.sleep(5000);
		// Assertions
		links.clickOnLinkFirst();
		links.getLinksTitle();
		links.navigateback();
		links.clickOnLinkSecond();
		links.getLinksTitle();
		links.navigateback();
		links.clickOnLinkThird();
		links.getLinksTitle();
		links.navigateback();
		links.clickOnLinkFourth();
		links.getLinksTitle();
		links.navigateback();
		links.clickOnLinkFifth();
		links.getLinksTitle();
		links.navigateback();
		links.clickOnLinkSixth();
		links.getLinksTitle();
		//Assertion: azt ellenőrizzük, hogy az utolsó lépés után a lista megegyezik-e az elvárt listával
		List<String> expectedLinksTitlesArrayList = new ArrayList<>();
		expectedLinksTitlesArrayList.add("hugo");
		expectedLinksTitlesArrayList.add("goldmark");
		expectedLinksTitlesArrayList.add("chroma");
		expectedLinksTitlesArrayList.add("smartcrop");
		expectedLinksTitlesArrayList.add("cobra");
		expectedLinksTitlesArrayList.add("viper");
		String[] expectedLinksTitlesArrayListToArray = expectedLinksTitlesArrayList.toArray(new String[0]); // Az Assertion nem tud listákat összehasonlítani, csak tömböket
		String[] actualLinksTitlesArrayList = links.currentLinksResult();
		Assertions.assertArrayEquals(expectedLinksTitlesArrayListToArray, actualLinksTitlesArrayList);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Pages on Blonde Site")
	@Description("Click on next page buttons  at subpage and check titles")
	@Severity(SeverityLevel.NORMAL)
	public void pagesOnBlondeSite() throws InterruptedException {
		Pages pages = (Pages) SiteFactory.Create("Pages", driver);
		pages.navigate();
		boolean arrowButtonExist = driver.findElement(By.className("icon-keyboard_arrow_right")).isEnabled();
		while (arrowButtonExist == true) // Addig fut le, ameddig létezik a gomb
		{
			Thread.sleep(5000);
			try {
				pages.getPagesTitle();
				pages.clickOnPageButton();
			} catch (Exception e) {
				arrowButtonExist = false;
			}
		}
		//Assertion: azt ellenőrizzük, hogy az utolsó lépés után a lista megegyezik-e az elvárt listával
		List<String> expectedPagesArrayList = new ArrayList<>();
		expectedPagesArrayList.add("2019/03/05");
		expectedPagesArrayList.add("2019/03/08");
		expectedPagesArrayList.add("2019/03/09");
		expectedPagesArrayList.add("2019/03/10");
		expectedPagesArrayList.add("2019/03/11");
		expectedPagesArrayList.add("2020/08/14");
		String[] expectedPagesArrayListToArray = expectedPagesArrayList.toArray(new String[0]); // Az Assertion nem tud listákat összehasonlítani, csak tömböket
		String[] actualPagesArrayList = pages.currentPagesResult();
		Assertions.assertArrayEquals(expectedPagesArrayListToArray, actualPagesArrayList);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Css on Blonde Site")
	@Description("Click on 'moon' button and check the result (button and class name changing)")
	@Severity(SeverityLevel.NORMAL)
	public void cssStyleOnBlondeSite() throws InterruptedException {
		CssStyle cssStyle = (CssStyle) SiteFactory.Create("CssStyle", driver);
		cssStyle.navigate();
		Thread.sleep(5000);
		cssStyle.clickOnSetButton();
		cssStyle.currentCssStyle();
		//Assertion: azt ellenőrizzük, hogy a gomb megváltozott-e
		String expectedCssStyleClass = "inline-flex align-middle leading-normal text-lg text-white icon-sun";
		String actualCssStyleClass = cssStyle.currentCssStyle();
		Assertions.assertEquals(expectedCssStyleClass, actualCssStyleClass);
	}
	
	@AfterEach
	@Epic("Blonde Site")
	@Story("Make Screenshot")
	@Description("Make a screenshot after each test at an important moment and attach it to Allure Report (generated Allure Report on GitHub is empty")
	@Severity(SeverityLevel.CRITICAL)
	public void makeScreenshot() {
		Allure.addAttachment("Screenshot of Tested Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
}