//TODO Not work yet

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class List extends StartDriver {
    private final String urlList = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";

    private final By orderedList = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/ol");

    private final String[] actualorderedlistelements = getOrderedList();

    private final String[] expectedorderedlistelements = {"Bob", "Alice"};

    public List(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlList);
    }
    public String[] getOrderedList() {
        String[] orderedlistelements = null;
        java.util.List<WebElement> ols = driver.findElements(orderedList);
        orderedlistelements = new String[ols.size()];
        for (int i = 0; i < ols.size(); i++) {
            orderedlistelements[i] = ols.get(i).getText();
        }
        return orderedlistelements;
    }

    /*
    public void checklistresult() {
        Assertions.assertArrayEquals(expectedorderedlistelements, actualorderedlistelements);
    }
    */
}