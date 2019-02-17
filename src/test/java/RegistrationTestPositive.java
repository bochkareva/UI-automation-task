import objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AuthenticationPage;
import pages.InformationPage;
import pages.MainPage;

public class RegistrationTestPositive {
  WebDriver driver;
  String    verifications;

  @BeforeTest
  public void beforeTest() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com");
    verifications = "";
    MainPage mainPage = new MainPage(driver);
    mainPage.clickLogin();
  }

  @AfterTest
  public void afterTest() {
    driver.quit();
    Assert.assertTrue(verifications.equals(""), verifications);
  }

  @DataProvider(name = "user")
  public Object[][] createUser() {
    User user = new User();
    return new Object[][]{{user}};
  }

  @Test(dataProvider = "user")
  public void testCreateAccountAllFields(User user) {
    System.out.println("Test 'Created account - positive' \n Fill all fields");

    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    authenticationPage.fillEmail(user.getEmail());
    authenticationPage.clickCreateButton();

    InformationPage informationPage = new InformationPage(driver);
    informationPage.fillAllFields(user);
    informationPage.clickRegisterButton();

    AccountPage accountPage = new AccountPage(driver);
    verifications += accountPage.verifyAccountPage(user);
    accountPage.clickLogout();

    authenticationPage = new AuthenticationPage(driver);
    authenticationPage.fillEmailForLogin(user.getEmail());
    authenticationPage.fillPassword(user.getPassword());
    authenticationPage.clickLogin();

    accountPage = new AccountPage(driver);
    verifications += accountPage.verifyAccountPage(user);
    System.out.println("Test 'Created account - positive with all fields' completed");
  }

  @Test(dataProvider = "user")
  public void testCreateAccountRequiredFields(User user) {
    System.out.println("Test 'Created account - positive' \n Fill required fields");

    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    authenticationPage.fillEmail(user.getEmail());
    authenticationPage.clickCreateButton();

    InformationPage informationPage = new InformationPage(driver);
    informationPage.fillRequiredFields(user);
    informationPage.clickRegisterButton();

    AccountPage accountPage = new AccountPage(driver);
    verifications += accountPage.verifyAccountPage(user);
    accountPage.clickLogout();

    authenticationPage = new AuthenticationPage(driver);
    authenticationPage.fillEmailForLogin(user.getEmail());
    authenticationPage.fillPassword(user.getPassword());
    authenticationPage.clickLogin();

    accountPage = new AccountPage(driver);
    verifications += accountPage.verifyAccountPage(user);
    System.out.println("Test 'Created account - positive with required fields' completed");
  }
}
