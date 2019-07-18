package interfaces.zinio;

import com.sss.iframework.driver.IFrameworkWebDriver;
import com.sss.selenium.IFrameworkAssert;
import com.sss.selenium.IFrameworkAutomation;
import com.sss.selenium.IFrameworkElementDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZinioHomePage {

    //Main page
    public static By inputSearchMagazines = IFrameworkElementDefinition
            .CssSelector("input[placeholder='Search for Magazines'][name='query']");
    public static By iconSearch = IFrameworkElementDefinition.CssSelector(".desktop .icon-search");
    public static By ddbShop = IFrameworkElementDefinition
            .CssSelector(".dropdown-button[data-target='.shop-menu']");
    public static By ddbMyMagazines = IFrameworkElementDefinition
            .CssSelector(".dropdown-button[data-target='.magazine-menu']");
    public static By ddbSignIn = IFrameworkElementDefinition
            .CssSelector(
                    ".magazine-menu .signInMenu[name='user-signin'] .ng-scope[translate='Btn.SignIn']");
    public static By inputEmailLogin = IFrameworkElementDefinition
            .CssSelector("#login-modal input[name='username']");
    public static By inputPassLogin = IFrameworkElementDefinition
            .CssSelector("#login-modal input[name='password']");
    public static By btnLogin = IFrameworkElementDefinition.CssSelector("#btn-login");
    public static By btnCreateAcc = IFrameworkElementDefinition
            .CssSelector("[ng-click='login.createModal()']");
    public static By inputEmailSignUp = IFrameworkElementDefinition
            .CssSelector("#create-modal input[type='email'][placeholder='Email address']");
    public static By inputPassSignUp = IFrameworkElementDefinition
            .CssSelector("#create-modal input[name='password'][placeholder='Password']");
    public static By inputVerifyPassSignUp = IFrameworkElementDefinition
            .CssSelector("#create-modal input[type='password'][placeholder='Confirm Password']");
    public static By btnCreateNewAcc = IFrameworkElementDefinition.CssSelector("#btn-create");
    public static By ddbMyAccount = IFrameworkElementDefinition
            .CssSelector(".magazine-menu [translate='Newsstand.Header.MyAccount']");
    public static By ddbRead = IFrameworkElementDefinition
            .CssSelector(".magazine-menu [translate='Read']");
    public static By searchContent = IFrameworkElementDefinition
            .CssSelector(".searchContainer .block a");
    public static By ddbSignOut = IFrameworkElementDefinition
            .CssSelector(".magazine-menu #user-signout");


    public static void signIn(String user, String pass) {
        IFrameworkAutomation.click(ddbMyMagazines);
        IFrameworkAutomation.click(ddbSignIn);
        IFrameworkAutomation.enter(inputEmailLogin, user);
        IFrameworkAutomation.enter(inputPassLogin, pass);
        IFrameworkAutomation.click(btnLogin);
    }

    public static void signUp(String user, String pass) {
        IFrameworkAutomation.click(ddbMyMagazines);
        IFrameworkAutomation.click(ddbSignIn);
        IFrameworkAutomation.click(btnCreateAcc);
        IFrameworkAutomation.enter(inputEmailSignUp, user);
        IFrameworkAutomation.enter(inputPassSignUp, pass);
        IFrameworkAutomation.enter(inputVerifyPassSignUp, pass);
        IFrameworkAutomation.click(btnCreateNewAcc);
    }

    public static void signOut() {
        IFrameworkAutomation.click(ddbMyMagazines);
        IFrameworkAutomation.click(ddbSignOut);
    }

    public static void searchMagazines(String nameMagazine) {
        IFrameworkAutomation.enter(inputSearchMagazines, nameMagazine);
        WebElement search = IFrameworkAutomation.findElement(inputSearchMagazines);
        search.sendKeys(Keys.RETURN);
    }

    public static void CheckSearchResult(String expectedName) {
        String result = IFrameworkAutomation.getText(searchContent);
        IFrameworkAssert.verifyEquals(result, expectedName);
    }
}
