package tests.zinio;

import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import com.sss.selenium.IFrameworkElementDefinition;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZinioReaderPage {

  //Zinio Reader
  public static By coverPage = IFrameworkElementDefinition.Xpath(
      "//image[xlink:href='http://imgs.zinio.com/repository/500806567/416276104/SVG/img_1_1.jpg']");
  public static By btnNext = IFrameworkElementDefinition.CssSelector("span#next-page");
  public static By btnBookmark = IFrameworkElementDefinition.CssSelector("li#bookmarks-toggle");
  public static By btnSkipPage = IFrameworkElementDefinition.CssSelector("li#thumbs-toggle");
  public static By btnFullScreen = IFrameworkElementDefinition
      .CssSelector("li#footer-button-change-window");
  public static By btnZoom = IFrameworkElementDefinition
      .CssSelector("li#footer-button-change-window");
  public static By btnPrint = IFrameworkElementDefinition
      .CssSelector("li#footer-button-change-window");
  public static By btnPrevious = IFrameworkElementDefinition.CssSelector("span#previous-page");
  public static By thmView = IFrameworkElementDefinition.CssSelector("ul.Thumbnails");
  public static By sldView = IFrameworkElementDefinition.CssSelector("svg");

  public static void CheckReadTab() {
    WebDriver driver = IFrameworkAutomation.getDriver();
    ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
    WebElement cover = driver.findElement(By.cssSelector("image"));
    IFrameworkAssert.verifyTrue(cover.isDisplayed(), true);
  }

  public void SelectPage(Integer index) {
    By ulThumbnailsOpend = IFrameworkElementDefinition.CssSelector("ul.is-open.Thumbnails");
    String liSelect = String.format("//*[@id=\"%d\"]", index);
    By liSelectElement = IFrameworkElementDefinition.Xpath(liSelect);
    if (IFrameworkAutomation.isElementDisplayed(ulThumbnailsOpend)) {
      IFrameworkAutomation.click(liSelectElement);
    }
  }
}
