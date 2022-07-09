package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    @FindBy(className = "ico-login")
    WebElement login;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2")
    WebElement welcomeLabel;

    @FindBy(className = "ico-logout")
    WebElement logout;

    @FindBy(partialLinkText = "Computers")
    WebElement computersMenu;

    @FindBy(partialLinkText = "Notebooks")
    WebElement notebooksMenu;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginLink(){
        login.click();
    }

    public boolean logoutIsVisible(){
        return logout.isDisplayed();
    }

    public void logout(){
        logout.click();
    }

    public String getWelcomeMessage(){
        return  welcomeLabel.getText();
    }

    public void hoverOverComputersMenu(){
        //computersMenu.build().perform();
    }
    public void clickNotebooksMenu(){
        notebooksMenu.click();
    }
}
