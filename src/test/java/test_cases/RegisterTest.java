package test_cases;

import generics.GenericSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.EmailGenerator;
import utils.WebElemntMapper;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest extends GenericSeleniumTest {

    LoginPage loginPage;
    MainPage mainPage;
    RegisterPage registerPage;

    @Test
    public void registerTest() {
        //1.	Navigate to : https://demo.nopcommerce.com/
        driver.get("https://demo.nopcommerce.com/");
        //2.	Click LogIn - Menu
        mainPage = new MainPage(driver);
        mainPage.clickOnLoginLink();
        //3.	Click  Register - button
        loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterButton();
        //4.	Check the title of the page after clicking Register button
        Assertions.assertEquals("nopCommerce demo store. Register", driver.getTitle());
        //5.	Fill the register form as below:
        registerPage = new RegisterPage(driver);
        registerPage.fillGender('M');
        registerPage.fillInMandatoryFields("Egli", "Isufaj", EmailGenerator.generateRandomEmail(), "Egli1234!@#");
        //Date of birth dropdown???
        registerPage.fillInDateOfBirth(7, 4, 95);
        driver.findElement(By.id("Company")).sendKeys("Lufthansa Industry Solutions");
        //driver.findElement(By.id("Newsletter"));
        driver.findElement(By.id("register-button")).click();
        //6.	Verify that register is successful
        //Should complete registration and asser registration through success message.
        //<div class="result">Your registration completed</div>
            /*String actualString = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText();
            String expectedString = "Your registration completed";
            assertTrue(actualString.contains(expectedString));*/
        assertEquals(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText(), "Your registration completed");
        //7.	Click Log out - Menu
        driver.findElement(By.className("ico-logout")).click();
    }

    @Test
    public void loginTest() {
        //1.	Navigate to : https://demo.nopcommerce.com/
        driver.get("https://demo.nopcommerce.com/");
        //2.	Click LogIn - Menu
        driver.findElement(By.className("ico-login")).click();
        //3.	Login with the credentials created from Test 1
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("egliisufaj3@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Egli1234!@#");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
        //4.	Verify that login is successful:
        //-	“Welcome to our store text” - is displayed
        //-	Log out - Menu is displayed
        /*String actualString = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2")).getText();
        assertTrue(actualString.contains("Welcome to our store"));*/
        assertEquals(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2")).getText(), "Welcome to our store");
        assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
        //5.	Log out
        driver.findElement(By.className("ico-logout")).click();
    }

    @Test
    public void dashboardTest() {
        //Precondition: Log in nopCommerce Application
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("egliisufaj@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test1234!");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
        //1.	Hover over Computers Menu
        Actions action = new Actions(driver);
        WebElement Computers = driver.findElement(By.partialLinkText("Computers"));
        action.moveToElement(Computers).build().perform();
        //2.	Click Notebooks
        driver.findElement(By.partialLinkText("Notebooks")).click();
        //3.	Verify that we have navigate to Notebooks Page
        assertEquals(driver.getTitle(), "Notebooks");
        //4.	Choose 9 on Display dropdown
        driver.findElement(By.id("products-pagesize")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div[3]/select/option[3]")).click();
        //5.	Verify that only 6 items are displayed
        assertFalse(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[7]")).isDisplayed());
        //6.	On Filter by attributes check 16GB
        driver.findElement(By.id("attribute-option-10")).click();
        //7.	Verify that only 1 item is displayed
        assertFalse(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]")).isDisplayed());
        //8.	Uncheck the 16GB checkbox
        driver.findElement(By.id("attribute-option-10")).click();
        //9.	Verify that 6 items are displayed now
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[5]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[6]")).isDisplayed());
        assertFalse(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[7]")).isDisplayed());
        //10.	Add the second and the third item on wishlist
        //11.	Verify that after every item added a notification with text : The product has been added to your wishlist – is displayed
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[3]")).click();
        assertEquals(driver.findElement(By.className("content")).getText(), "The product has been added to your wishlist");
        driver.findElement(By.className("close")).click();

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[3]")).click();
        assertEquals(driver.findElement(By.className("content")).getText(), "The product has been added to your wishlist");
        driver.findElement(By.className("close")).click();
        //12.	Add the fourth, fifth and sixth item on Shopping Cart
        //13.	Verify that after every item added a notification with text : The product has been added to your shopping cart
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[4]/div/div[2]/div[3]/div[2]/button[1]")).click();
        assertEquals(driver.findElement(By.className("content")).getText(), "The product has been added to your shopping cart");
        driver.findElement(By.className("close")).click();

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[5]/div/div[2]/div[3]/div[2]/button[1]")).click();
        assertEquals(driver.findElement(By.className("content")).getText(), "The product has been added to your shopping cart");
        driver.findElement(By.className("close")).click();

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[6]/div/div[2]/div[3]/div[2]/button[1])")).click();
        assertEquals(driver.findElement(By.className("content")).getText(), "The product has been added to your shopping cart");
        driver.findElement(By.className("close")).click();

        //14.	Verify that Wishlist on Menu bar displays 2
        /*String actualStringWishlist = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]")).getText();
        String expectedStringWishlist = "(2)";
        assertTrue(actualStringWishlist.contains(expectedStringWishlist));*/
        assertEquals(driver.findElement(By.className("wishlist-qty")).getText(), "(2)");
        //15.	Verify that Shopping Cart on Menu bar displays 3
        /*String actualStringShoppingCart = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]")).getText();
        String expectedStringShoppingCart = "(3)";
        assertTrue(actualStringShoppingCart.contains(expectedStringShoppingCart));*/
        assertEquals(driver.findElement(By.className("cart-qty")).getText(), "(3)");
        //16.	Close the browser
    }

    //@Test
    public void shoppingCartTest() {
        //Precondition: Test 3
        //1.	Hover over Shopping Cart –Menu
        Actions action = new Actions(driver);
        WebElement ShoppingCart = driver.findElement(By.id("topcartlink"));
        action.moveToElement(ShoppingCart).build().perform();
        //2.	Verify that ‘Go To Cart’ – button is displayed
        assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div/div[4]/button")).isDisplayed());
        //3.	Click ‘Go To Cart’ – button
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[2]/div/div[4]/button")).click();
        //4.	Verify that we have navigate to Shopping Cart Page
        //String actualString = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1")).getText();
        //assertTrue(actualString.contains("Shopping cart"));
        assertEquals(driver.getTitle(), "Shopping cart");
        //5.	Verify that following buttons are displayed
        assertTrue(driver.findElement(By.id("updatecart")).isDisplayed());
        assertTrue(driver.findElement(By.name("continueshopping")).isDisplayed());
        assertTrue(driver.findElement(By.id("open-estimate-shipping-popup")).isDisplayed());
        //6.	Verify that the prices sum for all items is equal to Total Price in the end of the page
        WebElement valueSummary = driver.findElement(By.className("value-summary"));
        WebElement displayedValue1 = driver.findElement(By.xpath("//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[1]/td[6]/span"));
        WebElement displayedValue2 = driver.findElement(By.xpath("//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[2]/td[6]/span"));
        WebElement displayedValue3 = driver.findElement(By.xpath("//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[3]/td[6]/span"));

        Integer sumOfAllSales = WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue1) +
                WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue2) +
                WebElemntMapper.webElementWithCurrencyValueToNumber(displayedValue3);

        assertEquals(WebElemntMapper.webElementWithCurrencyValueToNumber(valueSummary), sumOfAllSales);

        //7.	Close the browser
    }

    //@Test
    public void emptyShoppingCartTest() {
        // Precondition: Test 3 & Test 4
        //1.	Delete the first item on shopping cart
        //2.	Verify that the number of elements in Shopping Cart table is decreased by 1
        //driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td[7]/button")).click();
        //String actualStringShoppingCartTwoProducts = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]")).getText();
        //String expectedStringShoppingCartTwoProducts = "(2)";
        //assertTrue(actualStringShoppingCartTwoProducts.contains(expectedStringShoppingCartTwoProducts));

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[7]/button")).click();
        assertEquals(driver.findElement(By.className("cart-qty")).getText(), "(2)");
        //3.	Repeat steps 1&2 until the last item is deleted
        //driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td[7]/button")).click();
        //String actualStringShoppingCartOneProduct = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]")).getText();
        //String expectedStringShoppingCartOneProduct = "(1)";
        //assertTrue(actualStringShoppingCartOneProduct.contains(expectedStringShoppingCartOneProduct));
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[7]/button")).click();
        assertEquals(driver.findElement(By.className("cart-qty")).getText(), "(1)");
        //driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td[7]/button")).click();
        //String actualStringShoppingCartZeroProducts = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]")).getText();
        //String expectedStringShoppingCartZeroProducts = "(0)";
        //assertTrue(actualStringShoppingCartZeroProducts.contains(expectedStringShoppingCartZeroProducts));
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[7]/button")).click();
        assertEquals(driver.findElement(By.className("cart-qty")).getText(), "(0)");
        //4.	Verify that Shopping Cart is empty
        /*Actions action = new Actions(driver);
        WebElement ShoppingCart = driver.findElement(By.className("ico-cart"));
        action.moveToElement(ShoppingCart).build().perform();*/
        //"You have no items in your shopping cart." "//*[@id=\"flyout-cart\"]/div/div"
        assertTrue(driver.findElement(By.className("no-data")).isDisplayed());
        assertEquals(driver.findElement(By.className("no-data")).getText(), "Your Shopping Cart is empty!");

        //5.	Close the browser
    }
}