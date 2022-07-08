package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(name = "DateOfBirthDay")
    WebElement  dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement  dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement  dateOfBirthYear;

    @FindBy(id = "Company")
    WebElement company;

    @FindBy(id = "register-button")
    WebElement registerButton;

    Select dateOfBirthYearSelect;
    Select dateOfBirthMonthSelect;
    Select dateOfBirthDaySelect;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dateOfBirthYearSelect = new Select(dateOfBirthYear);
        dateOfBirthMonthSelect= new Select(dateOfBirthMonth);
        dateOfBirthDaySelect = new Select(dateOfBirthDay);
    }

    public void fillInMandatoryFields(String firstName, String lastName, String email, String password){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.comfirmPassword.sendKeys(password);
    }

    public void fillInDateOfBirth(Integer day, Integer month, Integer year){
        dateOfBirthDaySelect.selectByIndex(day+1);
        dateOfBirthMonthSelect.selectByIndex(month+1);
        dateOfBirthYearSelect.selectByIndex(year+10);
    }

    public void fillInGenderAsMale(){
        genderMale.click();
    }

    public void fillInCompany(String company){
        this.company.sendKeys(company);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }
}
