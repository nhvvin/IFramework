package interfaces.ebay;

import com.sss.selenium.IFrameworkAutomation;
import com.sss.selenium.IFrameworkElementDefinition;
import org.openqa.selenium.By;

public class EbayHomePage {
    public static By searchInput = IFrameworkElementDefinition.CssSelector("[placeholder='Search for anything']");
    public static By searchButton = IFrameworkElementDefinition.CssSelector("[type='submit']");

    public static void searchProduct(String productName) {
        IFrameworkAutomation.enter(searchInput, productName);
        IFrameworkAutomation.click(searchButton);
    }
}
