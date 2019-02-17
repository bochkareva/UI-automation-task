package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
  By signInLocator = By.className("login");

  public MainPage(WebDriver webDriver) {
    super(webDriver);
    waitForElementIsVisible(signInLocator);
  }

  public void clickLogin() {
    this.click(signInLocator);
  }
}
