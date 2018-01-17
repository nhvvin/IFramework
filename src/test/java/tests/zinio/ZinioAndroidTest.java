package tests.zinio;

import actions.Common.Common;
import com.sss.selenium.IFrameworkAutomation;
import interfaces.zinio.ZinioAndroid;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZinioAndroidTest {

  private static final String USER = "minhhoang@msv-tech.vn";
  private static final String PASS = "12345678";
  private static final String SEARCHNAME = "National Geographic History";

  @BeforeClass
  public void init() throws Exception {
    Common.config();
    IFrameworkAutomation.open();
  }

  @Test
  public void TC001_Verify_that_user_can_sign_in_successfully() {
    ZinioAndroid.LogIn(USER, PASS);
  }

  @AfterTest
  public void cleanUp() throws Exception {
    IFrameworkAutomation.close();
  }
}
