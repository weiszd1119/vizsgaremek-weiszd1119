import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TagsOnSite extends StartDriver {
    private final String urlTags = "https://lennertamas.github.io/blondesite/about/";

    private final By findCssTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[1]/span");
    private final By findEmojiTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[2]/span");
    private final By findHtmlTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[3]/span");
    private final By findMarkdownTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[4]/span");
    private final By findPrivacyTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[5]/span");
    private final By findShortcodesTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[6]/span");
    private final By findTextTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[7]/span");
    private final By findThemesTag = By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/a[8]/span");

    public TagsOnSite(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlTags);
    }

    public void clickontagcss() {
        driver.findElement(findCssTag).click();
    }

    public void clickontagemoji() {
        driver.findElement(findEmojiTag).click();
    }

    public void clickontaghtml() {
        driver.findElement(findHtmlTag).click();
    }

    public void clickontagmarkdown() {
        driver.findElement(findMarkdownTag).click();
    }

    public void clickontagprivacy() {
        driver.findElement(findPrivacyTag).click();
    }

    public void clickontagshortcodes() {
        driver.findElement(findShortcodesTag).click();
    }

    public void clickontagtext() {
        driver.findElement(findTextTag).click();
    }

    public void clickontagthemes() {
        driver.findElement(findThemesTag).click();
    }

    public String checklinktagcss() {
        String currentUrlTagCss = driver.getCurrentUrl();
        return currentUrlTagCss;
    }

    public String checklinktagemoji() {
        String currentUrlTagEmoji = driver.getCurrentUrl();
        return currentUrlTagEmoji;
    }

    public String checklinktaghtml() {
        String currentUrlTagHtml = driver.getCurrentUrl();
        return currentUrlTagHtml;
    }

    public String checklinktagmarkdown() {
        String currentUrlTagMarkdown = driver.getCurrentUrl();
        return currentUrlTagMarkdown;
    }

    public String checklinktagprivacy() {
        String currentUrlTagPrivacy = driver.getCurrentUrl();
        return currentUrlTagPrivacy;
    }

    public String checklinktagshortcodes() {
        String currentUrlTagShortcodes = driver.getCurrentUrl();
        return currentUrlTagShortcodes;
    }

    public String checklinktagtext() {
        String currentUrlTagText = driver.getCurrentUrl();
        return currentUrlTagText;
    }

    public String checklinktagthemes() {
        String currentUrlTagThemes = driver.getCurrentUrl();
        return currentUrlTagThemes;
    }

}