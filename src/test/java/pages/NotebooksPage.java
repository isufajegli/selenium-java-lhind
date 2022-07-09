package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    WebElement wishlistSuccessNotificationCloseButton;

    @FindBy(className = "content")
    WebElement shoppingCartSuccessNotification;

    @FindBy(className = "close")
    WebElement shoppingCartSuccessNotificationCloseButton;

    @FindBy(className = "wishlist-qty")
    WebElement wishlistItemQuantityOnMenuBar;

    @FindBy(className = "cart-qty")
    WebElement shoppingCartItemQuantityOnMenuBar;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]")
    WebElement itemOne;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]")
    WebElement itemTwo;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]")
    WebElement itemThree;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[4]")
    WebElement itemFour;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[5]")
    WebElement itemFive;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[6]")
    WebElement itemSix;

    @FindBy(className = "cart-label")
    WebElement shoppingCartMenuBar;
    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div/div[4]/button")
    WebElement goToCartButton;

    Actions action;

    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void clickWishlistSuccessNotificationCloseButton() {
        wishlistSuccessNotificationCloseButton.click();
    }

    public String checkShoppingCartSuccessNotification() {
        return shoppingCartSuccessNotification.getText();
    }

    public void clickShoppingCartSuccessNotificationCloseButton() {
        shoppingCartSuccessNotificationCloseButton.click();
    }

    public String checkWishlistItemQuantityOnMenuBar() {
        return wishlistItemQuantityOnMenuBar.getText();
    }

    public String checkShoppingCartItemQuantityOnMenuBar() {
        return shoppingCartItemQuantityOnMenuBar.getText();
    }

    public boolean itemOneIsVisible() {
        return itemOne.isDisplayed();
    }

    public boolean itemTwoIsVisible() {
        return itemTwo.isDisplayed();
    }

    public boolean itemThreeIsVisible() {
        return itemThree.isDisplayed();
    }

    public boolean itemFourIsVisible() {
        return itemFour.isDisplayed();
    }

    public boolean itemFiveIsVisible() {
        return itemFive.isDisplayed();
    }

    public boolean itemSixIsVisible() {
        return itemSix.isDisplayed();
    }

    public boolean checkIfItemIsVisible(int item) {
        return !driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[" + item + "]")).isEmpty();
    }

    public boolean goToCartButtonIsVisible() {
        return goToCartButton.isDisplayed();
    }

    public void clickGoToCartButton() {
        goToCartButton.click();
    }

    public void hoverOverShoppingCartMenu() {
        action.moveToElement(shoppingCartMenuBar);
        action.moveToElement(goToCartButton);
        action.click().build().perform();
    }
}