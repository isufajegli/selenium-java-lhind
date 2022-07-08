package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(css = "button.button-1.register-button")
    WebElement loginRegisterButton;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(css = "button.button-1.login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterButton(){
        loginRegisterButton.click();
    }

    public void login(String username, String password){
        this.email.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

}
