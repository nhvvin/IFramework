package tests.zinio;

import actions.Common.Common;

import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import com.sss.selenium.IFrameworkElementDefinition;
import interfaces.zinio.ZinioHomePage;
import interfaces.zinio.ZinioReaderPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZinioWebTest {

  private static final String USER = "minhhoang@msv-tech.vn";
  private static final String PASS = "12345678";
  private static final String URL = "https://gb.zinio.com/www/#/";
  private static final String SEARCHNAME = "National Geographic History";

  @BeforeClass
  public void init() throws Exception {
    Common.config();
    IFrameworkAutomation.openURL(URL);
  }

  @Test(enabled = false)
  public void TC001_Verify_that_user_can_create_new_account_successfully() throws Exception {
    ZinioHomePage.signUp(USER, PASS);
    IFrameworkAssert
        .verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbMyAccount), true);
  }

  @Test
  public void TC002_Verify_that_user_can_login_successfully() throws Exception {
    ZinioHomePage.signIn(USER, PASS);
    IFrameworkAssert
        .verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbMyAccount), true);
    IFrameworkAssert
        .verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbRead), true);
  }

  @Test
  public void TC003_Verify_that_user_can_search_for_magazines_successfully() throws Exception {
    ZinioHomePage.searchMagazines(SEARCHNAME);
    ZinioHomePage.CheckSearchResult(SEARCHNAME);
  }

  @Test
  public void TC005_Verify_that_user_can_read_an_issue_of_magazines_successfully()
      throws Exception {
    ZinioHomePage.searchMagazines("Bali Guide");
    By result = IFrameworkElementDefinition.Xpath("//p[contains(text(), 'Bali Guide')]");
    IFrameworkAutomation.click(result);
    IFrameworkAutomation.click(IFrameworkElementDefinition.CssSelector("img[alt='Bali Guide']"));
    ZinioReaderPage.CheckReadTab();
  }

  @Test
  public void TC006_Verify_that_user_can_navigate_to_next_or_previous_page_to_read_issue_content()
      throws Exception {
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

  @Test
  public void TC007_Verify_that_user_can_select_specific_page_of_the_issue_to_read()
      throws Exception {
    ZinioReaderPage.SelectPage(10);
    String idCurrent = IFrameworkAutomation.getAttribute(ZinioReaderPage.sldView, "id");
    IFrameworkAssert.verifyEquals(idCurrent, "svg10");
  }

  @Test
  public void TC008_Verify_that_user_can_bookmark_a_page()
      throws Exception {
    ZinioReaderPage.SelectPage(8);
    ZinioReaderPage.BookMark("Test Bookmarks");
    String bookmarkTitle = IFrameworkAutomation.getText(ZinioReaderPage.spnFirstBookmarkTitle);
    String bookmarkDescription = IFrameworkAutomation
        .getText(ZinioReaderPage.spnFirstBookmarkDescription);
    IFrameworkAssert.verifyEquals(bookmarkTitle, "PAGE 8");
    IFrameworkAssert.verifyEquals(bookmarkDescription, "Test Bookmarks");
  }

  @Test
  public void TC009_Verify_that_user_can_navigate_to_a_specific_page_of_an_issue_via_bookmark_section()
      throws Exception {
    ZinioReaderPage.SelectPage(3);
    IFrameworkAutomation.click(ZinioReaderPage.btnBookmark);
    IFrameworkAutomation.waitForControlDisplay(ZinioReaderPage.spnFirstBookmarkTitle, 2000);
    IFrameworkAutomation.click(ZinioReaderPage.spnFirstBookmarkTitle);
    IFrameworkAutomation.waitForControlDisplay(ZinioReaderPage.sldView, 2000);
    String idCurrent = IFrameworkAutomation.getAttribute(ZinioReaderPage.sldView, "id");
    IFrameworkAssert.verifyEquals(idCurrent, "svg8");
  }

  @Test
  public void TC010_Verify_that_user_can_read_the_issue_in_full_screen_mode()
      throws Exception {
    IFrameworkAutomation.click(ZinioReaderPage.btnFullScreen);
    String fullscreen = IFrameworkAutomation
        .getAttribute(IFrameworkElementDefinition.CssSelector("body"), "class");
    IFrameworkAssert.verifyEquals(fullscreen, "fullScreen");
    IFrameworkAutomation.click(ZinioReaderPage.btnFullScreen);
  }

  @Test
  public void TC011_Verify_that_user_can_zoom_in_and_zoom_out_when_reading_the_issue()
      throws Exception {
    String tranformCurrent = IFrameworkAutomation
        .getAttribute(ZinioReaderPage.viewPage, "transform");
    ZinioReaderPage.Zoom();
    String tranformAfter = IFrameworkAutomation.getAttribute(ZinioReaderPage.viewPage, "transform");
    IFrameworkAssert.verifyNotEquals(tranformCurrent, tranformAfter);
  }

  @Test
  public void TC012_Verify_that_user_can_sign_out_successfully()
      throws Exception {
    IFrameworkAutomation.switchWindow("| Zinio");
    ZinioHomePage.signOut();
    IFrameworkAssert
        .verifyTrue(IFrameworkAutomation.isElementExists(ZinioHomePage.ddbSignIn), true);
  }

  @AfterTest
  public void cleanUp() throws Exception {
    IFrameworkAutomation.close();
  }
}
