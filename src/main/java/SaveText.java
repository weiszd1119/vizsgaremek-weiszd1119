import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveText extends StartDriver{
	
	private final String urlTextTest = "https://lennertamas.github.io/blondesite/post/math-typesetting/";
	
	private final String textToFile = "Write to file";
	
	
	
	private final String metaTxtFile = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
	
	public SaveText(WebDriver startdriver) {
		super(startdriver);
	}
	
	public void navigate() {
		driver.navigate().to(urlTextTest);
	}
	
	public void saveTextToTXTFile() throws IOException {
		
		File file = new File("Filename" + metaTxtFile + ".txt");
		
		{
			FileWriter fw;
			try {
				fw = new FileWriter(file, true);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			fw.write(textToFile);
			fw.flush(); // Enélkül nem írja be az adatot a fájlba. Teljesítményprobléma esetén az első adatokat a pufferbe kell írni. Amikor a puffer megtelik, az adatok a kimenetre íródnak (fájl, konzol stb.). Ha a puffer részben megtelt, és el akarja küldeni a kimenetre (fájl, konzol), akkor kézzel kell meghívnia a flush() metódust, hogy a részben feltöltött puffert a kimenetre (fájl, konzol) írhassa.
		}
	}
	/*
	public boolean checkSaveTextResult() {
	
		File savedImageFile = new File(saveFileName);
		return savedImageFile.exists();
	}
	*/
}