//TODO
//Annak ellenőrzése, hogy a Moon gombra kattintáskor a gomb megváltozik-e Sun gombra
//Annak ellenőrzése, hogy a háttér megváltozott-e
//Nem találom a gombot

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CssStyle extends StartDriver {
    private final String urlCss = "https://lennertamas.github.io/blondesite/about/";
    private final By findSetButton = By.className("focus:outline-none mr-1");
    public CssStyle(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlCss);
    }

    public void clickonsetbutton() {
        driver.findElement(findSetButton).click();
    }

    public String currentcssstyle() {
        String currentattributevaluecss = driver.findElement(By.id("icon")).getAttribute("class");
        System.out.println(currentattributevaluecss);
        return currentattributevaluecss;
        }

}




