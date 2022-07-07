import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveText extends StartDriver {
	
	private final String urlTextTest = "https://lennertamas.github.io/blondesite/post/math-typesetting/";
	
	private final By textToFile = By.xpath("//*[@class=\"prose md:prose-lg lg:prose-xl max-w-none dark:prose-invert mt-5\"]//p[1]");
	
	public SaveText(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlTextTest);
	}
	
	public void saveTextToTXTFile() throws IOException {
		
		String stringOfTextToFile = driver.findElement(textToFile).getText();
		
		File file = new File("saveTextFile" + ".txt");
		{
			FileWriter fw;
			try {
				fw = new FileWriter(file, true);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			fw.write(stringOfTextToFile);
			fw.flush(); // Enélkül nem írja be az adatot a fájlba. Teljesítményprobléma esetén az első adatokat a pufferbe kell írni. Amikor a puffer megtelik, az adatok a kimenetre íródnak (fájl, konzol stb.). Ha a puffer részben megtelt, és el akarja küldeni a kimenetre (fájl, konzol), akkor kézzel kell meghívnia a flush() metódust, hogy a részben feltöltött puffert a kimenetre (fájl, konzol) írhassa.
		}
	}
}