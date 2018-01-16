package tests.google.testing;

import actions.Common.Common;
import actions.google.PageFactory;
import interfaces.google.GoogleHomeEntity;
import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UITesting {

  @BeforeClass
  public void set_up() throws Exception {
    Common.config();
    PageFactory.GoogleHome().Open();
  }

  @Test(description = "Navigate Google Home")
  public void TC001_Navigate_Google_Home() throws Exception {
    PageFactory.GoogleHome().Search("This is testing");
    // IFrameworkAutomation.waitForControl(GoogleHomeEntity.Search);
    Thread.sleep(5000);
    String txtSearch = IFrameworkAutomation.getAttribute(GoogleHomeEntity.Search, "value");
    IFrameworkAssert.verifyEquals(txtSearch, "This is testing");
  }

  @Test(description = "Check button Search")
  public void TC002_Check_button_Search() throws Exception {
    //IFrameworkAssert.verifyFalse(true, true);
  }

  @AfterTest
  public void after_test() throws Exception {
    IFrameworkAutomation.close();
  }
}
