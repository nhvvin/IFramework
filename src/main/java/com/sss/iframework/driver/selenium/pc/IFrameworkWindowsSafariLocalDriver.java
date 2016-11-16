package com.sss.iframework.driver.selenium.pc;

import org.openqa.selenium.safari.SafariDriver;

import com.sss.iframework.IFrameworkConstants;
import com.sss.iframework.driver.IFrameworkLocalDriver;

public class IFrameworkWindowsSafariLocalDriver extends IFrameworkLocalDriver {

	@Override
	public String getDeviceName() {
		return IFrameworkConstants.DEVICE_PC;
	}

	public IFrameworkWindowsSafariLocalDriver() {

	} // end method

	@Override
	public String getProvider() {
		return "selenium";
	}

	@Override
	public void createWebDriver() {
		try {
			this._webDriver = new SafariDriver();
		} catch (Exception ex) {
			System.err.println("Safari - createWebDriver - exception: "
					+ ex.getMessage());
		}
		System.out.println("[info] Safari driver is created.");
	}

	@Override
	public String getApplicationType() {
		return IFrameworkConstants.APP_TYPE_CHROME;
	}
} // end class
