package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsFeedPage extends BasePage {

  By publishButton = By.cssSelector("#feedx_sprouts_container [data-attachment-type='STATUS']");
  By messageInput = By
      .cssSelector("#feedx_sprouts_container [data-testid='status-attachment-mentions-input']");
  By lastMessage = By.cssSelector("div .userContent > div > p");
  By postButton = By
      .cssSelector("#feedx_sprouts_container [data-testid='react-composer-post-button']");

  public NewsFeedPage(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(publishButton));
  }

  public void publishNewMessage(String message) {
    driver.findElement(publishButton).click();
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(messageInput));
    driver.findElement(messageInput).click();
    driver.findElement(messageInput).sendKeys(message);
    driver.findElement(postButton).click();
  }

  public boolean assertLastMessage(String message) {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(lastMessage));
    return driver.findElement(lastMessage).getText().contains(message);
  }
}
