package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this); //// PageFactory, @FindBy notasyonlarını kullanmamızı sağlar.
    }

    //Locators
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    public WebElement signupLoginButonu;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signupNameKutusu;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signupEmailKutusu;

    @FindBy(xpath = "//*[text()='Email Address already exist!']")
    public WebElement EmailALreadyExist;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signupButonu;

    @FindBy(id = "id_gender1") // Mr. radyosu
    public WebElement genderRadio;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(css = "[data-qa='days']")
    public WebElement dayDropdown;

    @FindBy(css = "[data-qa='months']")
    public WebElement monthDropdown;

    @FindBy(css = "[data-qa='years']")
    public WebElement yearDropdown;

    // 🔥 SELECT METODLARI
    public void selectDay() {
        Select select = new Select(dayDropdown);
        select.selectByIndex(6);
    }

    public void selectMonth() {
        Select select = new Select(monthDropdown);
        select.selectByIndex(6);
    }

    public void selectYear() {
        Select select = new Select(yearDropdown);
        select.selectByIndex(6);
    }

    //Address Information

    @FindBy(css = "[data-qa=first_name]")
    public WebElement firstNameKutusu;

    @FindBy(css = "[data-qa=last_name]")
    public WebElement lastNameKutusu;

    @FindBy(css = "[data-qa=company]")
    public WebElement companyKutusu;

    @FindBy(css = "[data-qa=address]")
    public WebElement adressKutusu;

    @FindBy(css = "[data-qa=country]")
    public WebElement countryDropdown;

    public void  selectCountry() {
        Select select = new Select(countryDropdown);
        select.selectByIndex(2);
    }

    @FindBy(css = "[data-qa=state]")
    public WebElement stateKutusu;

    @FindBy(css = "[data-qa=city]")
    public WebElement cityKutusu;

    @FindBy(css = "[data-qa=zipcode]")
    public WebElement zipcodeKutusu;

    @FindBy(css = "[data-qa=mobile_number]")
    public WebElement mobileNumberKutusu;


    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButonu;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedYazisi;
}






















