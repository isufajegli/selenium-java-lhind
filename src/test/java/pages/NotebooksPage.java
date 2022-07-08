package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnProductsPageSize(){
        productsPageSize.click();
    }

    public void clickOnNineItems(){
        nineItemsOption.click();
    }

    public void clickOnMemory16GB(){
        memory16GB.click();
    }

    public void clickSecondItemAddToWishlistButton(){
        secondItemAddToWishlistButton.click();
    }

    public void clickThirdItemAddToWishlistButton(){
        thirdItemAddToWishlistButton.click();
    }

    public void clickFourthItemAddToCartButton(){
        fourthItemAddToCartButton.click();
    }

    public void clickFifthItemAddToCartButton(){
        fifthItemAddToCartButton.click();
    }

    public void clickSixthItemAddToCartButton(){
        sixthItemAddToCartButton.click();
    }

}