package tests.ebay;

import actions.Common.Common;
import com.sss.selenium.IFrameworkAutomation;
import interfaces.ebay.EbayHomePage;
import interfaces.ebay.EbaySearchResultPage;
import org.testng.annotations.*;

public class EbayWebTest {
    private static final String URL = "https://www.ebay.com/";

    @BeforeClass
    public void init() {
        Common.config();
        IFrameworkAutomation.openURL(URL);
    }

    @Parameters({"product-name", "top"})
    @Test
    public void TC_Verify_Search_Feature(String productName, int top) {
        EbayHomePage.searchProduct(productName);
        EbaySearchResultPage.verifyTopResults(top);
    }

    @AfterClass
    public void cleanUp() {
        IFrameworkAutomation.close();
    }
}
