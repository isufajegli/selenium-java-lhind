package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement comfirmPassword;

    @FindBy(id = "gender-male")
    WebElement genderMale;

    @FindBy(id = "gender-male")
    WebElement dateOfBirthDay;

    @FindBy(id = "gender-male")
    WebElement dateOfBirthMonth;

    @FindBy(id = "gender-male")
    WebElement dateOfBirthYear;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInMandatoryFields(String firstName, String lastName, String email, String password){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.comfirmPassword.sendKeys(password);
    }

    public void fillInDateOfBirth(Integer day, Integer month, Integer year){
        dateOfBirthDay.click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]/option[" + (day+1) + "]")).click();
        dateOfBirthMonth.click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]/option[" + (month+1) +"]")).click();
        dateOfBirthYear.click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]/option["+ (year-10) +"]")).click();
    }

    public void fillInGenderAsMale(){
        genderMale.click();

    }

    public void fillInCompany(){

    }

    public void clickRegisterButton(){

    }
}
