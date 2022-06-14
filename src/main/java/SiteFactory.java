//Class: oldal létrehozása aszerint, hogy melyik oldalt akarjuk tesztelni

import org.openqa.selenium.WebDriver;

public class SiteFactory {
    public static StartDriver Create(String name, WebDriver driver)
    {
        switch (name)
        {
            case "LoginToSite":
                return new LoginToSite(driver);
            case "RegisterToSite":
                return new RegisterToSite(driver);
            case "FillContactOnSite":
                return new FillContactOnSite(driver);
            case "SearchOnSite":
                return new SearchOnSite(driver);
            case "TagsOnSite":
                return new TagsOnSite(driver);
            case "LinksOnSite":
                return new LinksOnSite(driver);
            case "PagesOnSite":
                return new PagesOnSite(driver);
            case "CssStyleTest":
                return new CssStyle(driver);
            case "TablesTest":
                return new Tables(driver);
            case "WebServiceTest":
                return new WebService(driver);
            case "YoutubeTest":
                return new Youtube(driver);
            case "ListTest":
                return new List(driver);
            case "SaveImageTest":
                return new SaveImage(driver);
            default:
                return null;
        }
    }
}
