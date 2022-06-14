//TODO
//Annak ellenőrzése, hogy a Moon gombra kattintáskor a gomb megváltozik-e Sun gombra
//Annak ellenőrzése, hogy a háttér megváltozott-e
//Nem találom a gombot

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CssStyle extends StartDriver {
    private final String urlCss = "https://lennertamas.github.io/blondesite/about/";

    //Attribútum kiolvasásához (az icon2 class-ét kéri, amit tartalmazza az icon-moon szöveget, ez változik icon-sun-ra)
    private final String expectedValueCss = "hover:opacity-50 duration-200 inline-flex align-middle leading-normal text-lg ml-2 icon-sun";

    // private final String attributeValueCss = driver.findElement(By.id("icon")).getAttribute("class");
    private final By findSetButton = By.className("icon-moon inline-flex align-middle leading-normal text-lg text-white");
    public CssStyle(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlCss);
    }

    public void clickonsetbutton() {
        driver.findElement(findSetButton).click();
    }

    /*
    public void checkiconchange() {
        assertEquals(expectedValueCss, attributeValueCss);
    }
    */
}




