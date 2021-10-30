// https://www.guru99.com/all-about-testng-and-selenium.html phần Multiple Parameters
// chú ý là testNG thực hiện theo chú thích ( là annotation) chứ không phải theo tuần tự của code
//click “Chronological view.” để xem thứ tự thực thi
package firsttestpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class secondtestngfile {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "C:\\\\Users\\\\Admin\\\\Documents\\\\chromedriver_win32\\\\chromedriver.exe";
	public WebDriver driver;
// thực thi trước khi thực hiện method @test
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
// thực thi ở giữa
	@Test
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
// thực thi sau khi hoàn thành method @test
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}