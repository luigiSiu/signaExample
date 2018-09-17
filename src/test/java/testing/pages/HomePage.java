package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  By homeLink = By.cssSelector("#pagelet_bluebar [data-click*='home']");

  public HomePage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(homeLink));
  }

  public NewsFeedPage accessNewsFeedPage() {
    driver.findElement(homeLink).click();
    return new NewsFeedPage(driver, wait);
  }
}
