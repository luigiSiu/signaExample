package testing.tests;

import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Test;
import testing.pages.LoginPage;
import testing.pages.NewsFeedPage;

public class facebookTest extends BaseTest {

  @Test
  public void postStatusMessage() {
    java.sql.Date currentTimestamp = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    String message = "SignaTest " + currentTimestamp;

    LoginPage loginPage = new LoginPage(driver, wait);
    NewsFeedPage newsFeedPage = loginPage
        .login("signaExample@gmail.com", "Test@1234")
        .accessNewsFeedPage();
    newsFeedPage.publishNewMessage(message);
    Assert.assertTrue(newsFeedPage.assertLastMessage(message), "Last message was not submitted.");
  }
}
