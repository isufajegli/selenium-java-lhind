package selenium.tests;

import generics.GenericSeleniumTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.EmailGenerator;
import utils.WebElemntMapper;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic("Selenium + Java - Miniproject")
@Feature("nopCommerce Test Scenarios")
class RegisterTest extends GenericSeleniumTest {

    LoginPage loginPage;
    MainPage mainPage;
    RegisterPage registerPage;
    RegisterSuccess registerSuccess;
    NotebooksPage notebooksPage;
    ShoppingCartPage shoppingCartPage;

    private static String email;
    private String password = "Egli1234!@#";

    @BeforeAll
    public static void setupTestData() {
        email = EmailGenerator.generateRandomEmail();
    }

        @Test
        @Order(1)
        @Step
        @Description("Register Test")
        public void registerTest (){
            //1.	Navigate to : https://demo.nopcommerce.com/
            driver.get("https://demo.nopcommerce.com/");
            //2.	Click LogIn - Menu
            mainPage = new MainPage(driver);
            mainPage.clickOnLoginLink();
            //3.	Click  Register - button
            loginPage = new LoginPage(driver);
            loginPage.clickOnRegisterButton();
            //4.	Check the title of the page after clicking Register button
            registerPage = new RegisterPage(driver);
            assertEquals(driver.getTitle(), "nopCommerce demo store. Register");
            //5.	Fill the register form as below:
            registerPage.fillInGenderAsMale();
            registerPage.fillInMandatoryFields("Egli", "Isufaj", email,  password);
            //Date of birth dropdown???
            registerPage.fillInDateOfBirth(7,4,95);
            registerPage.fillInCompany("Lufthansa Industry Solutions");
            registerPage.clickRegisterButton();
            //6.	Verify that register is successful
            String expectedResult = "Your registration completed";
            registerSuccess = new RegisterSuccess(driver);
            assertEquals(expectedResult, registerSuccess.returnResultMessage());
            //7.	Click Log out - Menu
            mainPage.logout();
    }

    @Test
    @Step
    @Order(2)
    @Description("Login Test")
    public void loginTest (){
        //1.	Navigate to : https://demo.nopcommerce.com/
        driver.get("https://demo.nopcommerce.com/");
        //2.	Click LogIn - Menu
        mainPage = new MainPage(driver);
        mainPage.clickOnLoginLink();
        //3.	Login with the credentials created from Test 1
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        //4.	Verify that login is successful:   -“Welcome to our store text” - is displayed    -Log out - Menu is displayed
        assertEquals(mainPage.getWelcomeMessage(), "Welcome to our store");
        assertTrue(mainPage.logoutIsVisible());
        //5.	Log out (was set to execute before the driver gets closed in the last test)
    }

    @Test
    @Order(3)
    @Description("Dashboard Test")
    public void dashboardTest() throws InterruptedException {
        // Precondition: Log in nopCommerce Application
        //1.	Hover over Computers Menu
        // 2.	Click Notebooks
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        mainPage.hoverOverComputersMenu();
        //3.	Verify that we have navigate to Notebooks Page
        notebooksPage = new NotebooksPage(driver);
        System.out.println(notebooksPage.getSizeOfProductsDisplayed());
        assertEquals(driver.getTitle(), "nopCommerce demo store. Notebooks");
        //4.	Choose 9 on Display dropdown
        notebooksPage.clickOnProductsPageSize();
        notebooksPage.clickOnNineItems();
        //5.	Verify that only 6 items are displayed
        assertEquals(6, notebooksPage.getSizeOfProductsDisplayed());
        //6.	On Filter by attributes check 16GB
        notebooksPage.clickOnMemory16GB();
        //7.	Verify that only 1 item is displayed
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]")));
        assertEquals(1, notebooksPage.getSizeOfProductsDisplayed());
        //8.	Uncheck the 16GB checkbox
        notebooksPage.clickOnMemory16GB();
        //9.	Verify that 6 items are displayed now
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]")));
        assertEquals(6, notebooksPage.getSizeOfProductsDisplayed());
        //10.	Add the second and the third item on wishlist
        //11.	Verify that after every item added a notification with text : The product has been added to your wishlist – is displayed
        notebooksPage.clickSecondItemAddToWishlistButton();
        assertEquals(notebooksPage.checkWishlistSuccessNotification(), "The product has been added to your wishlist");
        Thread.sleep(2000);
        notebooksPage.clickSuccessNotificationCloseButton();

        notebooksPage.clickThirdItemAddToWishlistButton();
        assertEquals(notebooksPage.checkWishlistSuccessNotification(), "The product has been added to your wishlist");
        notebooksPage.clickSuccessNotificationCloseButton();
        Thread.sleep(2000);
        //12.	Add the fourth, fifth and sixth item on Shopping Cart
        //13.	Verify that after every item added a notification with text : The product has been added to your shopping cart
        //14.	Verify that Wishlist on Menu bar displays 2
        //15.	Verify that Shopping Cart on Menu bar displays 3
        wait.until(ExpectedConditions.textToBe(By.className("wishlist-qty"), "(2)"));
        notebooksPage.clickFourthItemAddToCartButton();
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));
        notebooksPage.clickSuccessNotificationCloseButton();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.textToBe(By.className("cart-qty"), "(1)"));
        notebooksPage.clickFifthItemAddToCartButton();
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));
        notebooksPage.clickSuccessNotificationCloseButton();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.textToBe(By.className("cart-qty"), "(2)"));
        notebooksPage.clickSixthItemAddToCartButton();
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));
        notebooksPage.clickSuccessNotificationCloseButton();

        wait.until(ExpectedConditions.textToBe(By.className("cart-qty"), "(3)"));
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));

        assertEquals(notebooksPage.checkWishlistItemQuantityOnMenuBar(), "(2)");
        assertEquals(notebooksPage.checkShoppingCartItemQuantityOnMenuBar(), "(3)");
        //16.	Close the browser
    }

    @Test
    @Order(4)
    @Description("Shopping Cart Test")
    public void shoppingCartTest() throws InterruptedException {
        //Precondition: Test 3
        //1.	Hover over Shopping Cart –Menu
        //2.	Verify that ‘Go To Cart’ – button is displayed
        //3.	Click ‘Go To Cart’ – button
        notebooksPage = new NotebooksPage(driver);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        notebooksPage.hoverOverShoppingCartMenu();
        //4.	Verify that we have navigate to Shopping Cart Page
        shoppingCartPage = new ShoppingCartPage(driver);
        assertEquals(driver.getTitle(), "nopCommerce demo store. Shopping Cart");
        //5.	Verify that following buttons are displayed
        assertTrue(shoppingCartPage.updateShoppingCartButtonIsVisible());
        assertTrue(shoppingCartPage.continueShoppingButtonIsVisible());
        assertTrue(shoppingCartPage.estimateShippingButtonIsVisible());
        //6.	Verify that the prices sum for all items is equal to Total Price in the end of the page
        Integer summary  = WebElemntMapper.webElementWithCurrencyValueToNumber(driver.findElement(By.className("value-summary")));
        WebElement displayedValue1 = driver.findElement(By.xpath("//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[1]/td[6]/span"));
        WebElement displayedValue2 = driver.findElement(By.xpath("//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[2]/td[6]/span"));
        WebElement displayedValue3 = driver.findElement(By.xpath("//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[3]/td[6]/span"));

        Integer sumOfAllSales = WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue1) +
                WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue2) +
                WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue3);

        assertEquals(summary, sumOfAllSales);
        //7.	Close the browser
    }

    @Test
    @Order(5)
    @Description("Empty Shopping Cart Test")
    public void emptyShoppingCartTest() {
        // Precondition: Test 3 & Test 4
        //1.	Delete the first item on shopping cart
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickFirstItemFromShoppingCartDeleteButton();
        //2.	Verify that the number of elements in Shopping Cart table is decreased by 1
        notebooksPage = new NotebooksPage(driver);
        assertEquals(notebooksPage.checkShoppingCartItemQuantityOnMenuBar(), "(2)");
        //3.	Repeat steps 1&2 until the last item is deleted
        shoppingCartPage.clickFirstItemFromShoppingCartDeleteButton();
        assertEquals(notebooksPage.checkShoppingCartItemQuantityOnMenuBar(), "(1)");
        shoppingCartPage.clickFirstItemFromShoppingCartDeleteButton();
        assertEquals(notebooksPage.checkShoppingCartItemQuantityOnMenuBar(), "(0)");
        //4.	Verify that Shopping Cart is empty
        assertTrue(shoppingCartPage.noProductsInShoppingCartIsVisible());
        assertEquals(shoppingCartPage.checkNoProductsInShoppingCart(), "Your Shopping Cart is empty!");
        //5.	Close the browser
        mainPage = new MainPage(driver);
        mainPage.logout();
    }
}