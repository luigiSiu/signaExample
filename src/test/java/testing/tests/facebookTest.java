package testing.tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import testing.pages.LoginPage;
import testing.pages.NewsFeedPage;

public class facebookTest extends BaseTest {

  @Test
  public void postStatusMessage() throws InterruptedException {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String message = "SignaTest " + timeStamp;

    LoginPage loginPage = new LoginPage(driver, wait);
    NewsFeedPage newsFeedPage = loginPage
        .login("signaExample@gmail.com", "Test@1234")
        .accessNewsFeedPage();
    newsFeedPage.publishNewMessage(message);
    Thread.sleep(5000);
    Assert.assertTrue(newsFeedPage.assertLastMessage(message), "Last message was not submitted.");
  }
}
