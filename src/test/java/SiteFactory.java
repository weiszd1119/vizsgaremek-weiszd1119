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
            case "NavigateOnSite":
                return new NavigateOnSite(driver);
            case "FillContactOnSite":
                return new FillContactOnSite(driver);
            case "SearchOnSite":
                return new SearchOnSite(driver);
            case "TagsOnSite":
                return new TagsOnSite(driver);
            case "LinksOnSite":
                return new LinksOnSite(driver);
            case "ImageTest":
                return new ImageTest(driver);
            case "PagesOnSite":
                return new PagesOnSite(driver);
            case "CssStyleTest":
                return new CssStyleTest(driver);
            case "TablesTest":
                return new TablesTest(driver);
            default:
                return null;
        }
    }
}
