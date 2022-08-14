package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ZhihuController {
    private WebDriver driver;
    private CommonUtils cm = new CommonUtils();

    @Given("^Open ZhiHu website$")
    public void navigateToCsdn() throws Exception {
        driver = cm.openBrowser("Chrome");
        driver.get("https://www.zhihu.com/signin?next=%2F");
        driver.manage().window().maximize();
        driver.close();
    }

    @Then("^Login Zhihu$")
    public void loginCsdn() throws IOException, InterruptedException {
        Thread.sleep(2000);
        InputStream ip = new BufferedInputStream(new FileInputStream("src/test/resources/run.properties"));
        Properties p = new Properties();
        p.load(ip);

        String mainHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("(//button[@class='Button Login-socialButton Button--plain'])[2]")).click();
        Thread.sleep(2000);

        Set<String> handles = driver.getWindowHandles();
        for(String handle: handles){
            if(handle.equals(mainHandle) == false){
                driver.switchTo().window(handle);
            }
        }

        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ptlogin_iframe']")));
        driver.findElement(By.xpath("//a[@id='switcher_plogin']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='u']")).sendKeys(p.getProperty("username.zhihu"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='p']")).sendKeys(p.getProperty("password.zhihu"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login_button']")).click();
        Thread.sleep(2000);

        for (String handle: handles){
            if(handle.equals(mainHandle) == true){
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//input[@class='Input'])[1]")).sendKeys("UZI");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='Button SearchBar-searchButton Button--primary Button--blue']")).click();
        Thread.sleep(2000);

        //driver.quit();
    }
}
