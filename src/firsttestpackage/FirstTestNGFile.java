// theo https://www.guru99.com/all-about-testng-and-selenium.html
// chú ý: cần thêm 2 thứ :
// 1. Lib TestNG
// 2. Tất cả file .jar của selenium-java-4.0.0
// link tải chromedriver https://chromedriver.chromium.org/downloads
// link tải geckodriver https://github.com/mozilla/geckodriver/releases
// tất cả phải phù hợp phiên bản, nếu sai phiên bản thì driver sẽ ko mở được browser lên.
// mới firefox nên tải bản mới nhất, còn chrome thì vào help -> giới thiệu chrome để xem phiên bản tải
package firsttestpackage;

import org.openqa.selenium.*;
//nếu muốn sử dụng firefox
import org.openqa.selenium.firefox.FirefoxDriver;
//nếu sử dụng chrome
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGFile {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	// nếu muốn sử dụng firefox
	// String driverPath =
	// "C:\\\\Users\\\\Admin\\\\Documents\\\\geckodriver-v0.30.0-win32\\\\geckodriver.exe";
	// nếu sử dụng chrome
	String driverPath = "C:\\\\Users\\\\Admin\\\\Documents\\\\chromedriver_win32\\\\chromedriver.exe";
	public WebDriver driver;

	@Test
	public void verifyHomepageTitle() {

		System.out.println("launching firefox browser");
		// nếu muốn sử dụng firefox
//      System.setProperty("webdriver.gecko.driver", driverPath);
		// driver = new FirefoxDriver();
		// nếu sử dụng chrome
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
}
