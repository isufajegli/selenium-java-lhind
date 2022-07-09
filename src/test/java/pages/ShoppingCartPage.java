package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[7]/button")
    WebElement firstItemFromShoppingCartDeleteButton;
    @FindBy(id = "updatecart")
    WebElement updateShoppingCartButton;

    @FindBy(name = "continueshopping")
    WebElement continueShoppingButton;

    @FindBy(id = "open-estimate-shipping-popup")
    WebElement estimateShippingButton;

    @FindBy(className = "no-data")
    WebElement noProductsInShoppingCart;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
}
    public void clickFirstItemFromShoppingCartDeleteButton(){
        firstItemFromShoppingCartDeleteButton.click();
    }
    public boolean updateShoppingCartButtonIsVisible(){
        return updateShoppingCartButton.isDisplayed();
    }
    public boolean continueShoppingButtonIsVisible(){
        return continueShoppingButton.isDisplayed();
    }
    public boolean estimateShippingButtonIsVisible(){
        return estimateShippingButton.isDisplayed();
    }
    public boolean noProductsInShoppingCartIsVisible(){
        return noProductsInShoppingCart.isDisplayed();
    }
    public String checkNoProductsInShoppingCart(){
         return noProductsInShoppingCart.getText();
    }
}