package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[7]/button")
    WebElement firstItemFromShoppingCartDeleteButton;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
}
    public void clickFirstItemFromShoppingCartDeleteButton(){
        firstItemFromShoppingCartDeleteButton.click();
    }
}