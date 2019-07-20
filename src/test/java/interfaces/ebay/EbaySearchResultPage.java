package interfaces.ebay;

import com.google.common.collect.FluentIterable;
import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import com.sss.selenium.IFrameworkElementDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EbaySearchResultPage {
    public static By priceElement = IFrameworkElementDefinition.CssSelector(".s-item__price");
    public static List priceElements = IFrameworkAutomation.findElements(priceElement);
    public static List expectedPrice = Arrays.asList("$104.99 to $214.99", "$200.00", "$104.99 to $214.99", "$239.85 to $329.85", "$182.00 to $334.00", "$619.99", "$79.85", "$105.00", "$100.00", "$185.00");

    public static void verifyTopResults(int top) {
        List topElements = FluentIterable.from(priceElements).limit(top).toList();
        List topElementsPrice = new ArrayList();
        for (Object e : topElements) {
            String temp = ((WebElement) e).getText();
            topElementsPrice.add(temp);
        }
        Reporter.log(String.valueOf(topElementsPrice));
<<<<<<< HEAD
<<<<<<< Updated upstream
        IFrameworkAssert.verifyTrue(expectedPrice.containsAll(topElementsPrice), true);
=======
        IFrameworkAssert.verifyTrue(expectedPrice.containsAll(topElementsPrice));
>>>>>>> Stashed changes
=======
        IFrameworkAssert.verifyTrue(expectedPrice.containsAll(topElementsPrice));
>>>>>>> parent of ee83bf9... Delete old test examples
    }
}
