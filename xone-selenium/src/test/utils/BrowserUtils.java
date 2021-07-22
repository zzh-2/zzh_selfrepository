package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtils {
    public WebDriver driver;

    public WebDriver openBrowser(String browserType){
       if(browserType.equals("Chrome")){
           System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver.exe");
           driver = new ChromeDriver();
       }
        return driver;
    }
}
