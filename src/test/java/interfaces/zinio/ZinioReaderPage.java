package interfaces.zinio;

import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import com.sss.selenium.IFrameworkElementDefinition;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ZinioReaderPage {

    //Zinio Reader
    public static By coverPage = IFrameworkElementDefinition.Xpath(
            "//image[xlink:href='http://imgs.zinio.com/repository/500806567/416276104/SVG/img_1_1.jpg']");
    public static By viewPage = IFrameworkElementDefinition.CssSelector(".svg-pan-zoom_viewport");
    public static By btnNext = IFrameworkElementDefinition.CssSelector("span#next-page");
    public static By btnBookmark = IFrameworkElementDefinition.CssSelector("li#bookmarks-toggle");
    public static By btnSkipPage = IFrameworkElementDefinition.CssSelector("li#thumbs-toggle");
    public static By btnFullScreen = IFrameworkElementDefinition
            .CssSelector("li#footer-button-change-window");
    public static By btnZoom = IFrameworkElementDefinition
            .CssSelector(".icon-zoom");
    public static By btnPrint = IFrameworkElementDefinition
            .CssSelector("li#footer-button-change-window");
    public static By btnPrevious = IFrameworkElementDefinition.CssSelector("span#previous-page");
    public static By thmView = IFrameworkElementDefinition.CssSelector("ul.Thumbnails");
    public static By sldView = IFrameworkElementDefinition.CssSelector("svg");
    public static By divBookMark = IFrameworkElementDefinition.CssSelector("div.Bookmark-add");
    public static By rdoLeftPage = IFrameworkElementDefinition
            .CssSelector("input#leftPageRadio[type='radio']");
    public static By rdoRight = IFrameworkElementDefinition
            .CssSelector("input#rightPageRadio[type='radio']");
    public static By txtDescription = IFrameworkElementDefinition
            .CssSelector("textarea#bookmark-user-description");
    public static By btnSubmit = IFrameworkElementDefinition.CssSelector("input[type='submit']");
    public static By spnFirstBookmarkTitle = IFrameworkElementDefinition
            .CssSelector(".BookmarkItem-title[data-auto='book_title_0']");
    public static By spnFirstBookmarkDescription = IFrameworkElementDefinition
            .CssSelector(".BookmarkItem-blurb[data-auto='book_blurb_0']");
    public static By sldZoomBar = IFrameworkElementDefinition.CssSelector(".ZoomSlider");
    public static By svgContainer = IFrameworkElementDefinition.CssSelector("#svgContainer");

    public static void CheckReadTab() {
        WebDriver driver = IFrameworkAutomation.getDriver();
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        WebElement cover = driver.findElement(By.cssSelector("image"));
        IFrameworkAssert.verifyTrue(cover.isDisplayed(), true);
    }

    public static void SelectPage(Integer index) throws InterruptedException {
        By ulThumbnails = IFrameworkElementDefinition.CssSelector(".Thumbnails");
        String classThubnail = IFrameworkAutomation.getAttribute(ulThumbnails, "class");
        String liSelect = String.format("#thumb_%d", index);
        By liSelectElement = IFrameworkElementDefinition.CssSelector(liSelect);
        if (classThubnail.equals("Thumbnails is-open")) {
            IFrameworkAutomation.click(liSelectElement);
            Thread.sleep(1000);
            IFrameworkAutomation.click(btnSkipPage);
        } else {
            IFrameworkAutomation.click(btnSkipPage);
            Thread.sleep(1000);
            IFrameworkAutomation.click(liSelectElement);
            Thread.sleep(1000);
            IFrameworkAutomation.click(btnSkipPage);
        }
    }

    public static void BookMark(String description) throws InterruptedException {
        IFrameworkAutomation.click(ZinioReaderPage.btnBookmark);
        Thread.sleep(1000);
        IFrameworkAutomation.click(ZinioReaderPage.divBookMark);
        Thread.sleep(1000);
        IFrameworkAutomation.click(ZinioReaderPage.rdoLeftPage);
        Thread.sleep(1000);
        IFrameworkAutomation.enter(ZinioReaderPage.txtDescription, description);
        Thread.sleep(1000);
        IFrameworkAutomation.click(ZinioReaderPage.btnSubmit);
    }

    public static void Zoom() throws InterruptedException {
        Thread.sleep(1000);
        Actions action = new Actions(IFrameworkAutomation.getDriver());
        action.doubleClick(IFrameworkAutomation.findElement(viewPage)).perform();
    }
}
