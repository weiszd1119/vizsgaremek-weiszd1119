import org.openqa.selenium.WebDriver;

public class WebService extends StartDriver {

    private final String urlOkString = "http://lennertamas.github.io/blondesite/";
    private final String urlNotFoundString = "http://lennertamas.github.io/blonde/";
    public WebService(WebDriver startdriver) {
        super(startdriver);
    }

    public String getUrlOkString() {
        return urlOkString;
    }

    public String getUrlNotFoundString() {
        return urlNotFoundString;
    }


}

