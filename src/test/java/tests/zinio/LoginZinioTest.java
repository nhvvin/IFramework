package tests.zinio;

import actions.Common.Common;

import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import com.sss.selenium.IFrameworkElementDefinition;
import interfaces.zinio.ZinioHomePage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginZinioTest {

  private static final String USER = "vincent909@gmail.com";
  private static final String PASS = "viethuyen2602";
  private static final String URL = "https://gb.zinio.com/www/#/";
  private static final String SEARCHNAME = "National Geographic History";

  @BeforeTest
  public void init() throws Exception {
    Common.config();
    IFrameworkAutomation.open();
  }

  @Test(enabled = false)
  public void TC001_Verify_that_user_can_create_new_account_successfully() throws Exception {
    IFrameworkAutomation.openURL(URL);
    ZinioHomePage.signUp(USER, PASS);
    IFrameworkAssert
        .verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbMyAccount), true);
  }

  @Test
  public void TCOO2_Verify_that_user_can_login_successfully() throws Exception {
    IFrameworkAutomation.openURL(URL);
    ZinioHomePage.signIn(USER, PASS);
    IFrameworkAssert
        .verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbMyAccount), true);
    IFrameworkAssert
        .verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbRead), true);
  }

  @Test
  public void TC003_Verify_that_user_can_search_for_magazines_successfully() throws Exception {
    IFrameworkAutomation.openURL(URL);
    ZinioHomePage.searchMagazines(SEARCHNAME);
    ZinioHomePage.CheckSearchResult(SEARCHNAME);
  }

  @Test
  public void TC005_Verify_that_user_can_read_an_issue_of_magazines_successfully()
      throws Exception {
    IFrameworkAutomation.openURL(URL);
    ZinioHomePage.signIn(USER, PASS);
    ZinioHomePage.searchMagazines("Bali Guide");
    By result = IFrameworkElementDefinition.Xpath("//p[contains(text(), 'Bali Guide')]");
    IFrameworkAutomation.click(result);
    IFrameworkAutomation.click(IFrameworkElementDefinition.CssSelector("img[alt='Bali Guide']"));
    ZinioReaderPage.CheckReadTab();
  }

  @Test
  public void T006_Verify_that_user_can_navigate_to_next_or_previous_page_to_read_issue_content()
      throws Exception {
    IFrameworkAutomation.openURL(URL);
    ZinioHomePage.signIn(USER, PASS);
    ZinioHomePage.searchMagazines("Bali Guide");
    By result = IFrameworkElementDefinition.Xpath("//p[contains(text(), 'Bali Guide')]");
    IFrameworkAutomation.click(result);
    IFrameworkAutomation.click(IFrameworkElementDefinition.CssSelector("img[alt='Bali Guide']"));
    IFrameworkAutomation.switchWindow("Zinio Reader");
    IFrameworkAutomation.click(ZinioReaderPage.btnNext);
    IFrameworkAutomation.waitForControl(ZinioReaderPage.sldView, 5000);

    //Get id of slider view
    String idNext = IFrameworkAutomation.getAttribute(ZinioReaderPage.sldView, "id");
    IFrameworkAssert.verifyEquals(idNext, "svgc2");

    IFrameworkAutomation.click(ZinioReaderPage.btnPrevious);
    IFrameworkAutomation.waitForControl(ZinioReaderPage.sldView, 5000);
    String idPrevious = IFrameworkAutomation.getAttribute(ZinioReaderPage.sldView, "id");
    IFrameworkAssert.verifyEquals(idPrevious, "svg0");
  }

  @AfterTest
  public void cleanUp() throws Exception {
    IFrameworkAutomation.close();
  }
}
