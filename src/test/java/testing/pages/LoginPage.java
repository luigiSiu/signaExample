package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

  String homePageUrl = "https://es-es.facebook.com/";

  By emailInput = By.id("email");
  By pwdInput = By.id("pass");
  By loginButton = By.id("loginbutton");

  public LoginPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    driver.get(homePageUrl);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(emailInput));
  }

  public HomePage login(String email, String pwd) {
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(pwdInput).sendKeys(pwd);
    driver.findElement(loginButton).click();
    return new HomePage(driver, wait);
  }
}
