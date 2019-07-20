package actions.Common;

import com.sss.selenium.IFrameworkSetting;

public class Common {

	public static void config() {
		// Configure browser to launch
		IFrameworkSetting.setObjecWait(15);
		/*IFrameworkSetting.setChromeDriverExecutable(new File("resources","chromedriver.exe").getAbsolutePath());
		IFrameworkSetting.setIeDriverExecutable(new File("resources","IEDriverServer.exe").getAbsolutePath());*/

	}

}
