//Class: oldal létrehozása aszerint, hogy melyik oldalt akarjuk tesztelni

import org.openqa.selenium.WebDriver;

public class SiteFactory {
	public static StartDriver Create(String name, WebDriver driver) {
		switch (name) {
			case "AcceptContract":
				return new AcceptContract(driver);
			case "LoginLogout":
				return new LoginLogout(driver);
			case "Register":
				return new Register(driver);
			case "Contact":
				return new Contact(driver);
			case "Search":
				return new Search(driver);
			case "Tags":
				return new Tags(driver);
			case "Links":
				return new Links(driver);
			case "Pages":
				return new Pages(driver);
			case "CssStyle":
				return new CssStyle(driver);
			case "Tables":
				return new Tables(driver);
			case "WebService":
				return new WebService(driver);
			case "OrderedList":
				return new OrderedList(driver);
			case "SaveImageTest":
				return new SaveImage(driver);
			case "SaveText":
				return new SaveText(driver);
			case "ModifyData":
				return new ModifyData(driver);
			default:
				return null;
		}
	}
}