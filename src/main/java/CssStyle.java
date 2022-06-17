//TODO
//Annak ellenőrzése, hogy a Moon gombra kattintáskor a gomb megváltozik-e Sun gombra
//Annak ellenőrzése, hogy a háttér megváltozott-e
//Nem találom a gombot

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssStyle extends StartDriver {
    private final String urlCss = "https://lennertamas.github.io/blondesite/about/";
    private final By findSetButton = By.xpath("//*[@class=\"py-2\"]/button");
    public CssStyle(WebDriver startdriver) {
        super(startdriver);
    }
    
    
    public void navigate() {
        driver.navigate().to(urlCss);
    }

    public void clickOnSetButton() {
        WebElement waitForVisible = driver.findElement(findSetButton);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", waitForVisible);
        }

    public String currentCssStyle() {
        String currentAttributeValueCss = driver.findElement(By.id("icon")).getAttribute("class");
        System.out.println(currentAttributeValueCss);
        return currentAttributeValueCss;
        }

}