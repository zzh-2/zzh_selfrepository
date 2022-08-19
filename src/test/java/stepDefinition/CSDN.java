package stepDefinition;

import po.CSDNLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class CSDN {
    private WebDriver driver;
    private CommonUtils cm = new CommonUtils();
    CSDNLoginPage csdnLoginPage;

    @Given("^Open CSDN website$")
    public void navigateToCsdn() throws Exception {
        driver = cm.openBrowser("Chrome");
        csdnLoginPage = new CSDNLoginPage(driver);
        driver.get("https://csdn.net/");
        driver.manage().window().maximize();
    }

    @Then("Click login button")
    public void clickLogin() throws InterruptedException {
        csdnLoginPage.clickLogin();
        Thread.sleep(3000);
        driver.switchTo().frame(csdnLoginPage.getPassportFrame());
    }

    @Then("Change login type")
    public void selectType() {
        csdnLoginPage.selectType();
    }

    @Then("Input username {string}")
    public void inputUsername(String username) {
        csdnLoginPage.setTxtUsername(username);
    }

    @Then("Input password {string}")
    public void inputPassword(String password) {
        csdnLoginPage.setTxtPassword(password);
        driver.quit();
    }
}
