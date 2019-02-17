package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage {
  private By emailFieldLocator   = By.id("email_create");
  private By createErrorLocator  = By.id("create_account_error");
  private By createButtonLocator = By.id("SubmitCreate");

  private By emailLocator = By.id("email");
  private By passwordLocator = By.id("passwd");
  private By loginLocator = By.id("SubmitLogin");

  public AuthenticationPage(WebDriver webDriver) {
    super(webDriver);
    this.waitForElementIsVisible(emailFieldLocator);
  }

  public void fillEmail(String email) {
    this.type(emailFieldLocator, email);
  }

  public void clickCreateButton() {
    this.click(createButtonLocator);
  }

  public String getCreateError() {
    return this.getText(createErrorLocator);
  }

  public void fillEmailForLogin(String email){
    this.type(emailLocator, email);
  }

  public void fillPassword(String password){
    this.type(passwordLocator, password);
  }

  public void clickLogin(){
    this.click(loginLocator);
  }
}
