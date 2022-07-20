package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotebooksPage {
    WebDriver driver;
    @FindBy(id = "products-pagesize")
    WebElement productsPageSize;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div[3]/select/option[3]")
    WebElement nineItemsOption;

    @FindBy(id = "attribute-option-10")
    WebElement memory16GB;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[3]")
    WebElement secondItemAddToWishlistButton;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[3]")
    WebElement thirdItemAddToWishlistButton;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[4]/div/div[2]/div[3]/div[2]/button[1]")
    WebElement fourthItemAddToCartButton;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[5]/div/div[2]/div[3]/div[2]/button[1]")
    WebElement fifthItemAddToCartButton;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[6]/div/div[2]/div[3]/div[2]/button[1]")
    WebElement sixthItemAddToCartButton;

    @FindBy(className = "content")
    WebElement wishlistSuccessNotification;

    @FindBy(className = "close")
    WebElement successNotificationCloseButton;

    @FindBy(className = "content")
    WebElement shoppingCartSuccessNotification;

    @FindBy(className = "wishlist-qty")
    WebElement wishlistItemQuantityOnMenuBar;

    @FindBy(className = "cart-qty")
    WebElement shoppingCartItemQuantityOnMenuBar;

    @FindBys({
            @FindBy(className = "item-grid"),
            @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div")
    })
    public List<WebElement> sellingProducts;

    @FindBy(id = "topcartlink")
    WebElement shoppingCartMenuBar;
    @FindBy(css = "#flyout-cart > div > div.buttons > button")
    WebElement goToCartButton;

    Actions action;

    public NotebooksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
    }

    public void clickOnProductsPageSize() {
        productsPageSize.click();
    }

    public void clickOnNineItems() {
        nineItemsOption.click();
    }

    public void clickOnMemory16GB() {
        memory16GB.click();
    }

    public void clickSecondItemAddToWishlistButton() {
        secondItemAddToWishlistButton.click();
    }

    public void clickThirdItemAddToWishlistButton() {
        thirdItemAddToWishlistButton.click();
    }

    public void clickFourthItemAddToCartButton() {
        fourthItemAddToCartButton.click();
    }

    public void clickFifthItemAddToCartButton() {
        fifthItemAddToCartButton.click();
    }

    public void clickSixthItemAddToCartButton() {
        sixthItemAddToCartButton.click();
    }

    public String checkWishlistSuccessNotification() {
        return wishlistSuccessNotification.getText();
    }

    public void clickSuccessNotificationCloseButton() {
        successNotificationCloseButton.click();
    }

    public WebElement getShoppingCartSuccessNotification() {
        return shoppingCartSuccessNotification;
    }

    public String checkWishlistItemQuantityOnMenuBar() {
        return wishlistItemQuantityOnMenuBar.getText();
    }

    public String checkShoppingCartItemQuantityOnMenuBar() {
        return shoppingCartItemQuantityOnMenuBar.getText();
    }

    public void hoverOverShoppingCartMenu() throws InterruptedException {
        action.moveToElement(shoppingCartMenuBar);
        Thread.sleep(1000);
        action.moveToElement(goToCartButton);
        action.click().build().perform();
    }

    public int getSizeOfProductsDisplayed(){
        return sellingProducts.size();
    }
}