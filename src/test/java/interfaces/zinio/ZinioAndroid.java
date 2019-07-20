package interfaces.zinio;

import com.sss.selenium.IFrameworkAutomation;
import interfaces.android.AndroidScreenEntity;
import org.openqa.selenium.By;

public class ZinioAndroid extends AndroidScreenEntity {

  public static By btnMore = ByUIA("content-desc", "More options");
  public static By btnLibrary = ByUIA("content-desc", "Library");
  public static By txtEmail = ByUIA("text", "Email");
  public static By txtPass = ByUIA("text", "Password");
  public static By btnLogIn = ByUIA("text", "LOG IN");


  public static void LogIn(String user, String pass) {
    IFrameworkAutomation.enter(txtEmail, user);
    IFrameworkAutomation.enter(txtPass, pass);
    IFrameworkAutomation.click(btnLogIn);
  }
}
