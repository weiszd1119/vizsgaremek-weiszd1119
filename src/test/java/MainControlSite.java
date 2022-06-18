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
		Tags tags = (Tags) SiteFactory.Create("Tags", driver);
		tags.navigate();
		Thread.sleep(5000);
		// Assertions
		// css
		tags.clickOnTagCss();
		String expectedUrlTagCss = "https://lennertamas.github.io/blondesite/tags/css/";
		String actualUrlTagCss = tags.checkLinkTagCss();
		Assertions.assertEquals(expectedUrlTagCss, actualUrlTagCss);
		// emoji
		tags.clickOnTagEmoji();
		String expectedUrlTagEmoji = "https://lennertamas.github.io/blondesite/tags/emoji/";
		String actualUrlTagEmoji = tags.checkLinkTagEmoji();
		Assertions.assertEquals(expectedUrlTagEmoji, actualUrlTagEmoji);
		// html
		tags.clickOnTagHtml();
		String expectedUrlTagHtml = "https://lennertamas.github.io/blondesite/tags/html/";
		String actualUrlTagHtml = tags.checkLinkTagHtml();
		Assertions.assertEquals(expectedUrlTagHtml, actualUrlTagHtml);
		// markdown
		tags.clickOnTagMarkdown();
		String expectedUrlTagMarkdown = "https://lennertamas.github.io/blondesite/tags/markdown/";
		String actualUrlTagMarkdown = tags.checkLinkTagMarkdown();
		Assertions.assertEquals(expectedUrlTagMarkdown, actualUrlTagMarkdown);
		// privacy
		tags.clickOnTagPrivacy();
		String expectedUrlTagPrivacy = "https://lennertamas.github.io/blondesite/tags/privacy/";
		String actualUrlTagPrivacy = tags.checkLinkTagPrivacy();
		Assertions.assertEquals(expectedUrlTagPrivacy, actualUrlTagPrivacy);
		// shortcodes
		tags.clickOnTagShortcodes();
		String expectedUrlTagShortcodes = "https://lennertamas.github.io/blondesite/tags/shortcodes/";
		String actualUrlTagShortcodes = tags.checkLinkTagShortcodes();
		Assertions.assertEquals(expectedUrlTagShortcodes, actualUrlTagShortcodes);
		// text
		tags.clickOnTagText();
		String expectedUrlTagText = "https://lennertamas.github.io/blondesite/tags/text/";
		String actualUrlTagText = tags.checkLinkTagText();
		Assertions.assertEquals(expectedUrlTagText, actualUrlTagText);
		// themes
		tags.clickOnTagThemes();
		String expectedUrlTagThemes = "https://lennertamas.github.io/blondesite/tags/themes/";
		String actualUrlTagThemes = tags.checkLinkTagThemes();
		Assertions.assertEquals(expectedUrlTagThemes, actualUrlTagThemes);
	}
	
	@Test
	@Epic("Math Typesetting")
	@Story("Test all external links")
	@Description("Test all external links")
	@Severity(SeverityLevel.NORMAL)
	public void linksOnBlondeSite() throws InterruptedException {
		Links links = (Links) SiteFactory.Create("Links", driver);
		links.navigate();
		Thread.sleep(5000);
		// Assertions
		// Apache Licence 2.0
		links.clickOnLinkFirst();
		String expectedUrlLinkFirst = "https://github.com/gohugoio/hugo/blob/master/LICENSE";
		String actualUrlLinkFirst = links.checkLinkResultFirst();
		Assertions.assertEquals(expectedUrlLinkFirst, actualUrlLinkFirst);
		// Goldmark
		links.navigateback();
		links.clickOnLinkSecond();
		String expectedUrlLinkSecond = "https://github.com/yuin/goldmark";
		String actualUrlLinkSecond = links.checkLinkResultSecond();
		Assertions.assertEquals(expectedUrlLinkSecond, actualUrlLinkSecond);
		// Chroma
		links.navigateback();
		links.clickOnLinkThird();
		String expectedUrlLinkThird = "https://github.com/alecthomas/chroma";
		String actualUrlLinkThird = links.checkLinkResultThird();
		Assertions.assertEquals(expectedUrlLinkThird, actualUrlLinkThird);
		// Smartcrop
		links.navigateback();
		links.clickOnLinkFourth();
		String expectedUrlLinkFourth = "https://github.com/muesli/smartcrop";
		String actualUrlLinkFourth = links.checkLinkResultFourth();
		Assertions.assertEquals(expectedUrlLinkFourth, actualUrlLinkFourth);
		// Cobra
		links.navigateback();
		links.clickOnLinkFifth();
		String expectedUrlLinkFifth = "https://github.com/spf13/cobra";
		String actualUrlLinkFifth = links.checkLinkResultFifth();
		Assertions.assertEquals(expectedUrlLinkFifth, actualUrlLinkFifth);
		// Viper
		links.navigateback();
		links.clickOnLinkSixth();
		String expectedUrlLinkSixth = "https://github.com/spf13/viper";
		String actualUrlLinkSixth = links.checkLinkResultSixth();
		Assertions.assertEquals(expectedUrlLinkSixth, actualUrlLinkSixth);
		// Gohugoio
		links.navigateback();
		links.clickOnLinkSeventh();
		String expectedUrlLinkSeventh = "https://github.com/gohugoio";
		String actualUrlLinkSeventh = links.checkLinkResultSeventh();
		Assertions.assertEquals(expectedUrlLinkSeventh, actualUrlLinkSeventh);
	}
	
	@Test
	@Epic("Blonde Site")
	@Story("Search on Blonde Site")
	@Description("Search some expressions the Blonde Site")
	@Severity(SeverityLevel.NORMAL)
	public void pagesOnBlondeSite() throws InterruptedException {
		Pages pages = (Pages) SiteFactory.Create("Pages", driver);
		pages.navigate();
		Thread.sleep(5000);
		pages.clickOnPageButton();
		// Assertions
		// Math Typesetting
		String expectedUrlPageMath = "https://lennertamas.github.io/blondesite/post/math-typesetting/";
		String actualUrlPageMath = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlPageMath, actualUrlPageMath);
		pages.clickOnPageButton();
		// Placeholder Text
		String expectedUrlPlaceholder = "https://lennertamas.github.io/blondesite/post/placeholder-text/";
		String actualUrlPlaceholder = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlPlaceholder, actualUrlPlaceholder);
		pages.clickOnPageButton();
		// Rich Content
		String expectedUrlRichContent = "https://lennertamas.github.io/blondesite/post/rich-content/";
		String actualUrlRichContent = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlRichContent, actualUrlRichContent);
		pages.clickOnPageButton();
		// Markdown Syntax
		String expectedUrlMarkdown = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
		String actualUrlMarkdown = driver.getCurrentUrl();
		Assertions.assertEquals(expectedUrlMarkdown, actualUrlMarkdown);
		pages.clickOnPageButton();
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