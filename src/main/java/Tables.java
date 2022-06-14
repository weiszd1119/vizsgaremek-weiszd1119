//TODO Not work yet

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tables extends StartDriver {
    private final String urlTables = "https://lennertamas.github.io/blondesite/post/markdown-syntax/";

    private final By NameTable = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/table[1]/tbody/tr[1]/td[1]");

    public Tables(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlTables);
    }

    public void getNameTable() {
        final String[] expectedtablecolumnnames = {"Bob", "Alice"};
        List<WebElement> tds = driver.findElements(NameTable);
        String[] namelist;
        namelist = new String[tds.size()];
        for (int i = 0; i < tds.size(); i++) {
          namelist[i] += tds.get(i).getText();
        } // Assertions.assertArrayEquals(expectedtablecolumnnames, namelist);
    }
  }
