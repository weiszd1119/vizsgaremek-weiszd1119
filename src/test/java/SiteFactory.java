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
            default:
                return null;
        }
    }
}
