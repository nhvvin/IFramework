package tests.zinio;

import actions.Common.Common;

import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import interfaces.zinio.ZinioHomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginZinioTest {
  @BeforeTest
  public void init() throws Exception {
    Common.config();
    IFrameworkAutomation.open();
  }

  @Test
  public void TCOO1_Verify_login_func() throws Exception {
    IFrameworkAutomation.openURL("http://zinio.com");
    ZinioHomePage.signIn("vincent909@gmail.com", "viethuyen2602");
    IFrameworkAssert.verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbMyAccount), true);
  }

  // @Test
  // public void TC002_Verify_create_new_account() throws Exception {
  //   IFrameworkAutomation.openURL("http://zinio.com");
  //   ZinioHomePage.signUp("vincent909@gmail.com", "123456");
  //   IFrameworkAssert.verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbMyAccount), true);
  // }
}
