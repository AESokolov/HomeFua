package org.itstep;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RegistrationTest {
	private static WebDriver driver;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Tester\\Softwear\\Selenium\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
		
	  //System.setProperty("webdriver.gecko.driver", "D:\\Tester\\Softwear\\Selenium\\geckodriver.exe"); 
	  //DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
	  //capabilities.setCapability("marionette", true); 
	  //FirefoxOptions option = new FirefoxOptions(); 
	  //option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	  //driver = new FirefoxDriver(option);

      //System.setProperty("webdriver.opera.driver", "D:\\Tester\\Softwear\\Selenium\\operadriver_win32\\operadriver.exe");
	  //OperaOptions options = new OperaOptions(); 
	  //options.setBinary("C:\\Program Files\\Opera\\54.0.2952.64\\opera.exe"); 
	  //driver = new OperaDriver(options); 
		
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.manage().window().maximize();
         driver.get("https://f.ua/");
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//a[@class='title not_auth']")).click();	
		String parentWindow = driver.getWindowHandle();
		Set<String> allPopupWindows = driver.getWindowHandles();
		for (String popupWindow : allPopupWindows) {
			driver.switchTo().window(popupWindow);
						
			 driver.findElement(By.linkText("Создать новый профиль")).click();
		}
			
			driver.switchTo().window(parentWindow);
			String parentwindow1 = driver.getWindowHandle();
			Set<String> allPopupWindows1 = driver.getWindowHandles();
			for (String popupWindow : allPopupWindows1) {
			driver.switchTo().window(popupWindow); 
									
			driver.findElement(By.xpath("//form[@id='register_form']/div[1]/div[2]/input")).sendKeys("Sigizmund");
			driver.findElement(By.xpath("//form[@id='register_form']/div[2]/div[2]/input")).sendKeys("sigizmundok@i.ua");
				
			driver.findElement(By.name("password")).sendKeys("123456fqw");
			driver.findElement(By.name("password2")).sendKeys("123456fqw");
			driver.findElement(By.id("register_form")).findElement(By.name("save")).click();
				
		}			
}		
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			driver.findElement(By.id("ga-master-id")).click();
			driver.quit();
		}
}
