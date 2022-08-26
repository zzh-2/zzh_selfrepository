package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CSDNLoginPage {
    public WebDriver csdnDriver;

    public CSDNLoginPage(WebDriver driver){
        csdnDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='toolbar-btn toolbar-btn-login csdn-toolbar-fl ']")
    @CacheLookup
    WebElement clickLogin;

    @FindBy(xpath = "//iframe[@name='passport_iframe']")
    @CacheLookup
    WebElement passportFrame;

    @FindBy(xpath = "//div[@class='login-box-tabs-items']/span[4]")
    @CacheLookup
    WebElement selectType;

    @FindBy(xpath = "//input[@autocomplete='username']")
    @CacheLookup
    WebElement txtUsername;

    @FindBy(xpath = "//input[@autocomplete='current-password']")
    @CacheLookup
    WebElement txtPassword;

    public void clickLogin(){
        clickLogin.click();
    }

    public WebElement getPassportFrame() {
        return passportFrame;
    }

    public void selectType(){
        selectType.click();
    }

    public void setTxtUsername(String username) {
        txtUsername.clear();
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
}
