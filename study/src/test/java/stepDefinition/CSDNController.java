package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.CommonUtils;

import java.io.*;
import java.util.Properties;

public class CSDNController {
    private WebDriver driver;
    private CommonUtils cm = new CommonUtils();

    @Given("^Open CSDN website$")
    public void navigateToCsdn() throws Exception {
        driver = cm.openBrowser("Chrome");
        driver.get("https://csdn.net/");
        driver.manage().window().maximize();
    }

    @Then("^Login CSDN$")
    public void loginCsdn() throws IOException, InterruptedException {
        InputStream ip = new BufferedInputStream(new FileInputStream("src/test/resources/run.properties"));
        Properties p = new Properties();
        p.load(ip);

        driver.findElement(By.xpath("//div[@class='toolbar-btn toolbar-btn-login csdn-toolbar-fl ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='login-box-tabs-items']/span)[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys(p.getProperty("username.csdn"));
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys(p.getProperty("password.csdn"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='login-form-item']/button")).click();
        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.xpath("//span[@id='nc_1_n1z']")));
        action.moveByOffset(260,0);
        action.perform();
        Thread.sleep(2000);
        driver.close();
    }
}
