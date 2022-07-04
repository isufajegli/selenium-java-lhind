import com.google.common.base.Verify;
import generics.GenericSeleniumTest;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RegisterTest extends GenericSeleniumTest {

        @Test
        public void registerTest (){
            //1.	Navigate to : https://demo.nopcommerce.com/
            WebDriver driver = new ChromeDriver();
            driver.get("https://demo.nopcommerce.com/");
            //2.	Click LogIn - Menu
            driver.findElement(By.className("ico-login")).click();
            //3.	Click  Register - button
            driver.findElement(By.className("button-1 register-button")).click();
            //4.	Check the title of the page after clicking Register button
            driver.getTitle();
            //5.	Fill the register form as below:
            driver.findElement(By.id("gender-male")).click();
            driver.findElement(By.id("FirstName")).sendKeys("Egli");
            driver.findElement(By.id("LastName")).sendKeys("Isufaj");
            //Date of birth dropdown???
            driver.findElement(By.name("DateOfBirthDay")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[8]")).click();
            driver.findElement(By.name("DateOfBirthMonth")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[5]")).click();
            driver.findElement(By.name("DateOfBirthYear")).click();
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]/option[85]")).click();
            driver.findElement(By.id("Email")).sendKeys("egliisufaj@gmail.com");
            driver.findElement(By.id("Company")).sendKeys("Lufthansa Industry Solutions");
            //driver.findElement(By.id("Newsletter"));
            driver.findElement(By.id("Password")).sendKeys("Egli1234!@#");
            driver.findElement(By.id("ConfirmPassword")).sendKeys("Egli1234!@#");
            driver.findElement(By.id("register-button")).click();
            //6.	Verify that register is successful
            //Should complete registration and asser registration through success message.
            //<div class="result">Your registration completed</div>
            String actualString = driver.findElement(By.className("result")).getText();
            String expectedString = "Your registration completed";
            assertTrue(actualString.contains(expectedString));
            //7.	Click Log out - Menu
            driver.findElement(By.className("ico-logout")).click();
    }

    @Test
    public void loginTest (){
        //1.	Navigate to : https://demo.nopcommerce.com/
        //2.	Click LogIn - Menu
        //3.	Login with the credentials created from Test 1
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("egliisufaj@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Egli1234!@#");
        driver.findElement(By.className("button-1 login-button")).click();
        //4.	Verify that login is successful:
        //-	“Welcome to our store text” - is displayed
        //-	Log out - Menu is displayed
        String actualString = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2")).getText();
        assertTrue(actualString.contains("Welcome to our store"));
        driver.findElement(By.className("ico-logout")).isDisplayed();
        //5.	Log out
        driver.findElement(By.className("ico-logout")).click();

    }
    @Test
    public void dashboardTest (){
            //Precondition: Log in nopCommerce Application
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("egliisufaj@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Egli1234!@#");
        driver.findElement(By.className("button-1 login-button")).click();
        //1.	Hover over Computers Menu
        Actions action = new Actions(driver);
        WebElement Computers = driver.findElement(By.linkText("Computers"));
        action.moveToElement(Computers).build().perform();
        //2.	Click Notebooks
        driver.findElement(By.linkText("Notebooks")).click();
        //3.	Verify that we have navigate to Notebooks Page
        //4.	Choose 9 on Display dropdown
        //5.	Verify that only 6 items are displayed
        //6.	On Filter by attributes check 16GB
        //7.	Verify that only 1 item is displayed
        //8.	Uncheck the 16GB checkbox
        //9.	Verify that 6 items are displayed now
        //10.	Add the second and the third item on wishlist
        //11.	Verify that after every item added a notification with text : The product has been added to your wishlist – is displayed
        //12.	Add the fourth, fifth and sixth item on Shopping Cart
        //13.	Verify that after every item added a notification with text : The product has been added to your shopping cart
        //14.	Verify that Wishlist on Menu bar displays 2
        //15.	Verify that Shopping Cart on Menu bar displays 3
        //16.	Close the browser






    }

    @Test
    public void shoppingCartTest (){
            //Precondition: Test 3
        //1.	Hover over Shopping Cart –Menu
        Actions action = new Actions(driver);
        WebElement ShoppingCart = driver.findElement(By.linkText("Shopping cart"));
        action.moveToElement(ShoppingCart).build().perform();
        //2.	Verify that ‘Go To Cart’ – button is displayed
        //driver.findElement();
        //3.	Click ‘Go To Cart’ – button
        driver.findElement(By.linkText("Go to cart")).click();
        //4.	Verify that we have navigate to Shopping Cart Page
        String actualString = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1")).getText();
        assertTrue(actualString.contains("Shopping cart"));
        //5.	Verify that following buttons are displayed
        driver.findElement(By.linkText("Update shopping cart"));
        driver.findElement(By.linkText("Continue shopping"));
        driver.findElement(By.linkText("Estimate shipping "));
        //6.	Verify that the prices sum for all items is equal to Total Price in the end of the page
        //7.	Close the browser


    }
    @Test
    public void emptyShoppingCartTest (){
            // Precondition: Test 3 & Test 4
        //1.	Delete the first item on shopping cart
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]/button"));
        //2.	Verify that the number of elements in Shopping Cart table is decreased by 1
        //3.	Repeat steps 1&2 until the last item is deleted
        //4.	Verify that Shopping Cart is empty
        //5.	Close the browser

    }
}