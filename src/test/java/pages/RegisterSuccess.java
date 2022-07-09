package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccess {

    WebDriver driver;

    @FindBy(className = "result")
    WebElement resultLabel;

    public RegisterSuccess(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String returnResultMessage(){
        return resultLabel.getText();
    }
}
