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
        tagsOnSite.clickontagcss();
        String expectedUrlTagCss = "https://lennertamas.github.io/blondesite/tags/css/";
        String actualUrlTagCss = tagsOnSite.checklinktagcss();
        Assertions.assertEquals(expectedUrlTagCss, actualUrlTagCss);
        //
        tagsOnSite.clickontagemoji();
        String expectedUrlTagEmoji = "https://lennertamas.github.io/blondesite/tags/emoji/";
        String actualUrlTagEmoji = tagsOnSite.checklinktagemoji();
        Assertions.assertEquals(expectedUrlTagEmoji, actualUrlTagEmoji);
        //
        tagsOnSite.clickontaghtml();
        String expectedUrlTagHtml = "https://lennertamas.github.io/blondesite/tags/html/";
        String actualUrlTagHtml = tagsOnSite.checklinktaghtml();
        Assertions.assertEquals(expectedUrlTagHtml, actualUrlTagHtml);
        //
        tagsOnSite.clickontagmarkdown();
        String expectedUrlTagMarkdown = "https://lennertamas.github.io/blondesite/tags/markdown/";
        String actualUrlTagMarkdown = tagsOnSite.checklinktagmarkdown();
        Assertions.assertEquals(expectedUrlTagMarkdown, actualUrlTagMarkdown);
        //
        tagsOnSite.clickontagprivacy();
        String expectedUrlTagPrivacy = "https://lennertamas.github.io/blondesite/tags/privacy/";
        String actualUrlTagPrivacy = tagsOnSite.checklinktagprivacy();
        Assertions.assertEquals(expectedUrlTagPrivacy, actualUrlTagPrivacy);
        //
        tagsOnSite.clickontagshortcodes();
        String expectedUrlTagShortcodes = "https://lennertamas.github.io/blondesite/tags/shortcodes/";
        String actualUrlTagShortcodes = tagsOnSite.checklinktagshortcodes();
        Assertions.assertEquals(expectedUrlTagShortcodes, actualUrlTagShortcodes);
        //
        tagsOnSite.clickontagtext();
        String expectedUrlTagText = "https://lennertamas.github.io/blondesite/tags/text/";
        String actualUrlTagText = tagsOnSite.checklinktagtext();
        Assertions.assertEquals(expectedUrlTagText, actualUrlTagText);
        //
        tagsOnSite.clickontagthemes();
        String expectedUrlTagThemes = "https://lennertamas.github.io/blondesite/tags/themes/";
        String actualUrlTagThemes = tagsOnSite.checklinktagthemes();
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
        linksOnSite.clickonlinkfirst();
        String expectedUrlLinkFirst = "https://github.com/gohugoio/hugo/blob/master/LICENSE";
        String actualUrlLinkFirst = linksOnSite.checklinkresultfirst();
        Assertions.assertEquals(expectedUrlLinkFirst, actualUrlLinkFirst);
        // Goldmark
        linksOnSite.navigateback();
        linksOnSite.clickonlinksecond();
        String expectedUrlLinkSecond = "https://github.com/yuin/goldmark";
        String actualUrlLinkSecond = linksOnSite.checklinkresultsecond();
        Assertions.assertEquals(expectedUrlLinkSecond, actualUrlLinkSecond);
        // Chroma
        linksOnSite.navigateback();
        linksOnSite.clickonlinkthird();
        String expectedUrlLinkThird = "https://github.com/alecthomas/chroma";
        String actualUrlLinkThird = linksOnSite.checklinkresultthird();
        Assertions.assertEquals(expectedUrlLinkThird, actualUrlLinkThird);
        // Smartcrop
        linksOnSite.navigateback();
        linksOnSite.clickonlinkfourth();
        String expectedUrlLinkFourth = "https://github.com/muesli/smartcrop";
        String actualUrlLinkFourth = linksOnSite.checklinkresultfourth();
        Assertions.assertEquals(expectedUrlLinkFourth, actualUrlLinkFourth);
        // Cobra
        linksOnSite.navigateback();
        linksOnSite.clickonlinkfifth();
        String expectedUrlLinkFifth = "https://github.com/spf13/cobra";
        String actualUrlLinkFifth = linksOnSite.checklinkresultfifth();
        Assertions.assertEquals(expectedUrlLinkFifth, actualUrlLinkFifth);
        // Viper
        linksOnSite.navigateback();
        linksOnSite.clickonlinksixth();
        String expectedUrlLinkSixth = "https://github.com/spf13/viper";
        String actualUrlLinkSixth = linksOnSite.checklinkresultsixth();
        Assertions.assertEquals(expectedUrlLinkSixth, actualUrlLinkSixth);
        // Gohugoio
        linksOnSite.navigateback();
        linksOnSite.clickonlinkseventh();
        String expectedUrlLinkSeventh = "https://github.com/gohugoio";
        String actualUrlLinkSeventh = linksOnSite.checklinkresultseventh();
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
        pagesOnSite.clickonpagebutton();
        // Assertions
        String expectedUrlPageMath = "https://lennertamas.github.io/blondesite/post/math-typesetting/";
        String actualUrlPageMath = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrlPageMath, actualUrlPageMath);
        pagesOnSite.clickonpagebutton();
        //
        String expectedUrlPlaceholder = "https://lennertamas.github.io/blondesite/post/placeholder-text/";
        String actualUrlPlaceholder = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrlPlaceholder, actualUrlPlaceholder);
        pagesOnSite.clickonpagebutton();
        //
        String expectedUrlRichContent = "https://lennertamas.github.io/blondesite/post/rich-content/";
        String actualUrlRichContent = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrlRichContent, actualUrlRichContent);
        pagesOnSite.clickonpagebutton();
        //
        String expectedUrlMarkdown = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";
        String actualUrlMarkdown = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrlMarkdown, actualUrlMarkdown);
        pagesOnSite.clickonpagebutton();
        //
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
        CssStyle cssStyleTest = (CssStyle) SiteFactory.Create("CssStyleTest", driver);
        cssStyleTest.navigate();
        Thread.sleep(5000);
        cssStyleTest.clickonsetbutton();
        cssStyleTest.currentcssstyle();
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
        youtubeTest.pressfirstvideoplaybutton();
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
