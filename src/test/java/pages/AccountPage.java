package pages;

import objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPage extends BasePage {
  By logoutLocator = By.className("logout");
  By nameLocator   = By.xpath("//*[@class=\"account\"]/span");

  public AccountPage(WebDriver webDriver) {
    super(webDriver);
    this.waitForElementIsVisible(logoutLocator);
  }

  public void clickLogout() {
    this.click(logoutLocator);
  }

  public String verifyAccountPage(User user) {
    String verifications = "";
    if (!isDisplayed(logoutLocator)){
      Assert.fail("Logout button is absent!");
    }
    if ((!getText(nameLocator).contains(user.getFirstName()) ||
         (!getText(nameLocator).contains(user.getLastName())))){
      verifications = "Account was not created! ";
    }
    return verifications;
  }
}
