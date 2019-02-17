package pages;

import objects.Address;
import objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class InformationPage extends BasePage {
  By firstNameLocator        = By.id("customer_firstname");
  By lastNameLocator         = By.id("customer_lastname");
  By emailLocator            = By.id("email");
  By passwordLocator         = By.id("passwd");
  By firstNameAddressLocator = By.id("firstname");
  By lastNameAddressLocator  = By.id("lastname");
  By companyLocator          = By.id("company");
  By addressLocator          = By.id("address1");
  By addressLine2Locator     = By.id("address2");
  By cityLocator             = By.id("city");
  By stateOptionLocator      = By.xpath("//*[@id=\"id_state\"]/option");
  By postalCodeLocator       = By.id("postcode");
  By countryOptionLocator    = By.xpath("//*[@id=\"id_country\"]/option");
  By addInfoLocator          = By.id("other");
  By homePhoneLocator        = By.id("phone");
  By mobilePhoneLocator      = By.id("phone_mobile");
  By registerButtonLocator   = By.id("submitAccount");
  By mrLocator               = By.id("uniform-id_gender1");
  By mrsLocator              = By.id("uniform-id_gender2");

  public InformationPage(WebDriver webDriver) {
    super(webDriver);
    this.waitForElementIsVisible(mrsLocator);
  }

  public void checkGender(Boolean isMr) {
    if (isMr) {
      click(mrLocator);
    } else {
      click(mrsLocator);
    }
  }

  public void fillFirstName(String firstName) {
    this.type(firstNameLocator, firstName);
  }

  public void fillLastName(String lastName) {
    this.type(lastNameLocator, lastName);
  }

  public void fillEmail(String email) {
    this.type(emailLocator, email);
  }

  public void fillPassword(String password) {
    this.type(passwordLocator, password);
  }

  public void fillFirstNameAdress(String firstName) {
    this.type(firstNameAddressLocator, firstName);
  }

  public void fillLastNameAdress(String lastName) {
    this.type(lastNameAddressLocator, lastName);
  }

  public void fillCompany(String company) {
    this.type(companyLocator, company);
  }

  public void fillAddress(String address) {
    this.type(addressLocator, address);
  }

  public void fillAddressLine2(String address) {
    this.type(addressLine2Locator, address);
  }

  public void fillCity(String city) {
    this.type(cityLocator, city);
  }

  public String chooseState() {
    int optionsSize     = this.getSize(stateOptionLocator);
    int skippedElements = 1;
    int randomElement   = new Random().nextInt(optionsSize - 1) + skippedElements;

    this.clickElementByIndex(stateOptionLocator, randomElement);
    return this.getTextByIndex(stateOptionLocator, randomElement);
  }

  public String chooseCountry() {
    int optionsSize     = this.getSize(countryOptionLocator);
    int skippedElements = 1;
    int randomElement   = new Random().nextInt(optionsSize - 1) + skippedElements;

    this.clickElementByIndex(countryOptionLocator, randomElement);
    return this.getTextByIndex(countryOptionLocator, randomElement);
  }

  public void fillPostalCode(String postalCode) {
    this.type(postalCodeLocator, postalCode);
  }

  public void fillAdditionalInfo(String additionalInfo) {
    this.type(addInfoLocator, additionalInfo);
  }

  public void fillHomePhone(String homePhone) {
    this.type(homePhoneLocator, homePhone);
  }

  public void fillMobilePhone(String mobilePhone) {
    this.type(mobilePhoneLocator, mobilePhone);
  }

  public void clickRegisterButton() {
    this.click(registerButtonLocator);
  }

  public void fillAllFields(User user) {
    this.fillRequiredFields(user);
    this.checkGender(user.getGender());

    this.fillFirstNameAdress(user.getFirstName());
    this.fillLastNameAdress(user.getLastName());
    this.fillAddressLine2(user.getAddress().getAddressLine2());

    this.fillAdditionalInfo(user.getAddress().getAdditionalInfo());
    this.fillHomePhone(user.getHomePhone());
  }

  public void fillRequiredFields(User user) {
    this.fillFirstName(user.getFirstName());
    this.fillLastName(user.getLastName());
    this.fillPassword(user.getPassword());

    this.fillCompany(user.getCompany());
    Address address = user.getAddress();
    this.fillAddress(address.getAddress());
    this.fillCity(address.getCity());
    this.chooseState();
    this.chooseCountry();
    this.fillPostalCode(address.getPostalCode());
    this.fillMobilePhone(user.getMobilePhone());
  }
}
