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
        // tagsOnSite.clickonfindcsstagandcheckresult();
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
        String actualUrlRegisterFirst = linksOnSite.checklinkresultfirst();
        Assertions.assertEquals(expectedUrlLinkFirst, actualUrlRegisterFirst);

        linksOnSite.navigateback();
        linksOnSite.clickonlinksecond();
        String expectedUrlLinkSecond = "https://github.com/yuin/goldmark";
        String actualUrlRegisterSecond = linksOnSite.checklinkresultsecond();
        Assertions.assertEquals(expectedUrlLinkSecond, actualUrlRegisterSecond);

        linksOnSite.navigateback();
        linksOnSite.clickonlinkthird();
        String expectedUrlLinkThird = "https://github.com/alecthomas/chroma";
        String actualUrlRegisterThird = linksOnSite.checklinkresultthird();
        Assertions.assertEquals(expectedUrlLinkThird, actualUrlRegisterThird);

        linksOnSite.navigateback();
        linksOnSite.clickonlinkfourth();
        String expectedUrlLinkFourth = "https://github.com/muesli/smartcrop";
        String actualUrlRegisterFourth = linksOnSite.checklinkresultfourth();
        Assertions.assertEquals(expectedUrlLinkFourth, actualUrlRegisterFourth);

        linksOnSite.navigateback();
        linksOnSite.clickonlinkfifth();
        String expectedUrlLinkFifth = "https://github.com/spf13/cobra";
        String actualUrlRegisterFifth = linksOnSite.checklinkresultfifth();
        Assertions.assertEquals(expectedUrlLinkFifth, actualUrlRegisterFifth);

        linksOnSite.navigateback();
        linksOnSite.clickonlinksixth();
        String expectedUrlLinkSixth = "https://github.com/spf13/viper";
        String actualUrlRegisterSixth = linksOnSite.checklinkresultsixth();
        Assertions.assertEquals(expectedUrlLinkSixth, actualUrlRegisterSixth);

        linksOnSite.navigateback();
        linksOnSite.clickonlinkseventh();
        String expectedUrlLinkSeventh = "https://github.com/gohugoio";
        String actualUrlRegisterSeventh = linksOnSite.checklinkresultseventh();
        Assertions.assertEquals(expectedUrlLinkSeventh, actualUrlRegisterSeventh);
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
        // pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        // pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        // pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        // pagesOnSite.checkresult();
        pagesOnSite.clickonpagebutton();
        // pagesOnSite.checkresult();
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
        // cssStyleTest.checkiconchange();
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
