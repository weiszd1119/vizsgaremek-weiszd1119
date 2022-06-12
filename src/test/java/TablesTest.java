import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablesTest extends StartDriver {
    private final String urlTables = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";

    private final By NameTable = By.xpath("//*[@id=\"tables\"]/tbody/tr/td[1]");

    private final String[] expectedtablecolumnnames = {"Bob", "Alice"};

    public TablesTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlTables);
    }

    public String[] getNameTable() {
        List<WebElement> tds = driver.findElements(NameTable);
        String[] namelist;
        namelist = new String[tds.size()];
        for (int i = 0; i < tds.size(); i++) {
            namelist[i] = tds.get(i).getText();
        }
        Assertions.assertArrayEquals(expectedtablecolumnnames, namelist);
        return namelist;
    }

    public void checktableresult() {

    }
}