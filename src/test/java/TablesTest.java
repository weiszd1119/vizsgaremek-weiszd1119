import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablesTest extends StartDriver {
    private final String urlTables = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";

    private final By NameTable = By.xpath("//*[@id=\"tables\"]/tbody/tr/td[1]");

    private final String[] actualtablecolumnnames = getNameTable();

    private final String[] expectedtablecolumnnames = {"Bob", "Alice"};

    public TablesTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlTables);
    }

    public String[] getNameTable() {
        String[] namelist = null;
        List<WebElement> tds = driver.findElements(NameTable);
        namelist = new String[tds.size()];
        for (int i = 0; i < tds.size(); i++) {
            namelist[i] = tds.get(i).getText();
        }
        return namelist;
    }

    public void checktableresult() {
        Assertions.assertArrayEquals(expectedtablecolumnnames, actualtablecolumnnames);
    }
}



/*PageBase first = new PageBase(driver);
        first.navigate();
                first.search("new york");
                String[] actual = first.readTable();
                String[] expected = {"B. Williamson","C. Vance","G. Little","J. Caldwell","P. Byrd","Y. Berry"};
                Assertions.assertArrayEquals(expected, actual);
 */