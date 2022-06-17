import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
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
		// options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	@Epic("Tags")
	@Story("Tags on Blonde Site")
	@Description("Tags some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void tagsOnBlondeSite() throws InterruptedException {
		TagsOnSite tagsOnSite = (TagsOnSite) SiteFactory.Create("TagsOnSite", driver);
		tagsOnSite.navigate();
		Thread.sleep(5000);
		// Assertions
		// css
		tagsOnSite.clickOnTagCss();
		String expectedUrlTagCss = "https://lennertamas.github.io/blondesite/tags/css/";
		String actualUrlTagCss = tagsOnSite.checkLinkTagCss();
		Assertions.assertEquals(expectedUrlTagCss, actualUrlTagCss);
		// emoji
		tagsOnSite.clickOnTagEmoji();
		String expectedUrlTagEmoji = "https://lennertamas.github.io/blondesite/tags/emoji/";
		String actualUrlTagEmoji = tagsOnSite.checkLinkTagEmoji();
		Assertions.assertEquals(expectedUrlTagEmoji, actualUrlTagEmoji);
		// html
		tagsOnSite.clickOnTagHtml();
		String expectedUrlTagHtml = "https://lennertamas.github.io/blondesite/tags/html/";
		String actualUrlTagHtml = tagsOnSite.checkLinkTagHtml();
		Assertions.assertEquals(expectedUrlTagHtml, actualUrlTagHtml);
		// markdown
		tagsOnSite.clickOnTagMarkdown();
		String expectedUrlTagMarkdown = "https://lennertamas.github.io/blondesite/tags/markdown/";
		String actualUrlTagMarkdown = tagsOnSite.checkLinkTagMarkdown();
		Assertions.assertEquals(expectedUrlTagMarkdown, actualUrlTagMarkdown);
		// privacy
		tagsOnSite.clickOnTagPrivacy();
		String expectedUrlTagPrivacy = "https://lennertamas.github.io/blondesite/tags/privacy/";
		String actualUrlTagPrivacy = tagsOnSite.checkLinkTagPrivacy();
		Assertions.assertEquals(expectedUrlTagPrivacy, actualUrlTagPrivacy);
		// shortcodes
		tagsOnSite.clickOnTagShortcodes();
		String expectedUrlTagShortcodes = "https://lennertamas.github.io/blondesite/tags/shortcodes/";
		String actualUrlTagShortcodes = tagsOnSite.checkLinkTagShortcodes();
		Assertions.assertEquals(expectedUrlTagShortcodes, actualUrlTagShortcodes);
		// text
		tagsOnSite.clickOnTagText();
		String expectedUrlTagText = "https://lennertamas.github.io/blondesite/tags/text/";
		String actualUrlTagText = tagsOnSite.checkLinkTagText();
		Assertions.assertEquals(expectedUrlTagText, actualUrlTagText);
		// themes
		tagsOnSite.clickOnTagThemes();
		String expectedUrlTagThemes = "https://lennertamas.github.io/blondesite/tags/themes/";
		String actualUrlTagThemes = tagsOnSite.checkLinkTagThemes();
		Assertions.assertEquals(expectedUrlTagThemes, actualUrlTagThemes);
	}
	
	@Test
	@Epic("Math Typesetting")
	@Story("Test all external links")
	@Description("Test all external links")
	@Severity(SeverityLevel.NORMAL)
	public void linksOnBlondeSite() throws InterruptedException {
		LinksOnSite linksOnSite = (LinksOnSite) SiteFactory.Create("LinksOnSite", driver);
		linksOnSite.navigate();
		Thread.sleep(5000);
		// Assertions
		// Apache Licence 2.0
		linksOnSite.clickOnLinkFirst();
		String expectedUrlLinkFirst = "https://github.com/gohugoio/hugo/blob/master/LICENSE";
		String actualUrlLinkFirst = linksOnSite.checkLinkResultFirst();
		Assertions.assertEquals(expectedUrlLinkFirst, actualUrlLinkFirst);
		// Goldmark
		linksOnSite.navigateback();
		linksOnSite.clickOnLinkSecond();
		String expectedUrlLinkSecond = "https://github.com/yuin/goldmark";
		String actualUrlLinkSecond = linksOnSite.checkLinkResultSecond();
		Assertions.assertEquals(expectedUrlLinkSecond, actualUrlLinkSecond);
		// Chroma
		linksOnSite.navigateback();
		linksOnSite.clickOnLinkThird();
		String expectedUrlLinkThird = "https://github.com/alecthomas/chroma";
		String actualUrlLinkThird = linksOnSite.checkLinkResultThird();
		Assertions.assertEquals(expectedUrlLinkThird, actualUrlLinkThird);
		// Smartcrop
		linksOnSite.navigateback();
		linksOnSite.clickOnLinkFourth();
		String expectedUrlLinkFourth = "https://github.com/muesli/smartcrop";
		String actualUrlLinkFourth = linksOnSite.checkLinkResultFourth();
		Assertions.assertEquals(expectedUrlLinkFourth, actualUrlLinkFourth);
		// Cobra
		linksOnSite.navigateback();
		linksOnSite.clickOnLinkFifth();
		String expectedUrlLinkFifth = "https://github.com/spf13/cobra";
		String actualUrlLinkFifth = linksOnSite.checkLinkResultFifth();
		Assertions.assertEquals(expectedUrlLinkFifth, actualUrlLinkFifth);
		// Viper
		linksOnSite.navigateback();
		linksOnSite.clickOnLinkSixth();
		String expectedUrlLinkSixth = "https://github.com/spf13/viper";
		String actualUrlLinkSixth = linksOnSite.checkLinkResultSixth();
		Assertions.assertEquals(expectedUrlLinkSixth, actualUrlLinkSixth);
		// Gohugoio
		linksOnSite.navigateback();
		linksOnSite.clickOnLinkSeventh();
		String expectedUrlLinkSeventh = "https://github.com/gohugoio";
		String actualUrlLinkSeventh = linksOnSite.checkLinkResultSeventh();
		Assertions.assertEquals(expectedUrlLinkSeventh, actualUrlLinkSeventh);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void pagesOnBlondeSite() throws InterruptedException {
		PagesOnSite pagesOnSite = (PagesOnSite) SiteFactory.Create("PagesOnSite", driver);
		pagesOnSite.navigate();
		Thread.sleep(5000);
		pagesOnSite.clickOnPageButton();
		// Assertions
		// Math Typesetting
		String expectedUrlPageMath = "https://lennertamas.github.io/blondesite/post/math-typesetting/";
		String actualUrlPageMath = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlPageMath, actualUrlPageMath);
		pagesOnSite.clickOnPageButton();
		// Placeholder Text
		String expectedUrlPlaceholder = "https://lennertamas.github.io/blondesite/post/placeholder-text/";
		String actualUrlPlaceholder = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlPlaceholder, actualUrlPlaceholder);
		pagesOnSite.clickOnPageButton();
		// Rich Content
		String expectedUrlRichContent = "https://lennertamas.github.io/blondesite/post/rich-content/";
		String actualUrlRichContent = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlRichContent, actualUrlRichContent);
		pagesOnSite.clickOnPageButton();
		// Markdown Syntax
		String expectedUrlMarkdown = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
		String actualUrlMarkdown = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlMarkdown, actualUrlMarkdown);
		pagesOnSite.clickOnPageButton();
		// Image Test
		String expectedUrlImage = "https://lennertamas.github.io/blondesite/post/image-test/";
		String actualUrlImage = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlImage, actualUrlImage);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void cssStyleOnBlondeSite() throws InterruptedException {
		CssStyle cssStyle = (CssStyle) SiteFactory.Create("CssStyleTest", driver);
		cssStyle.navigate();
		Thread.sleep(5000);
		cssStyle.clickOnSetButton();
		cssStyle.currentCssStyle();
		//Assertion: azt ellenőrizzük, hogy a gomb megváltozott-e
		String expectedCssStyleClass = "inline-flex align-middle leading-normal text-lg text-white icon-sun";
		String actualCssStyleClass = cssStyle.currentCssStyle();
		Assertions.assertEquals(expectedCssStyleClass, actualCssStyleClass);
		// Print
		System.out.println("Test results are:");
		System.out.println("Expected result was: " + expectedCssStyleClass);
		System.out.println("Actual result is: " + actualCssStyleClass);
		if (expectedCssStyleClass.equals(actualCssStyleClass)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Embedded Youtube Videos on Blonde Site")
	@Description("Testing embedded Youtube videos and video control functions on the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void youtubeTestOnBlondeSite() throws InterruptedException {
		Youtube youtubeTest = (Youtube) SiteFactory.Create("YoutubeTest", driver);
		youtubeTest.navigate();
		Thread.sleep(10000);
		youtubeTest.pressFirstVideoPlayButton();
	}
	
	@AfterEach
	@Epic("Blonde Site")
	@Story("Make Screenshot")
	@Description("Make Screenshot After Each Test")
	@Severity(SeverityLevel.CRITICAL)
	public void makeScreenshot() {
		Allure.addAttachment("Screenshot of Tested Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
}