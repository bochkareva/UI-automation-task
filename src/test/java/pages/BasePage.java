package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  WebDriver driver;

  public BasePage(WebDriver webDriver) {
    this.driver = webDriver;
  }

  protected void click(By by) {
    driver.findElement(by).click();
  }

  protected void clickElementByIndex(By by, int index) {
    driver.findElements(by).get(index).click();
  }

  protected void type(By by, String text) {
    driver.findElement(by).clear();
    driver.findElement(by).sendKeys(text);
  }

  protected String getText(By by) {
    return driver.findElement(by).getText();
  }

  protected String getTextByIndex(By by, int index) {
    return driver.findElements(by).get(index).getText();
  }

  protected int getSize(By by) {
    return driver.findElements(by).size();
  }

  public void waitForElementIsVisible(By by) {
    WebDriverWait wait = new WebDriverWait(driver, CommonProperties.BASE_TIMEOUT);
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public Boolean isDisplayed(By by){
    return driver.findElement(by).isDisplayed();
  }
}
