package variousConcepts;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {
	static WebDriver driver;

	@Before
	public void init() {
		// Chrome Setup
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void TestingLogin() {
		// web element and actions for opening website and deposits
		// Element list - WebElement type
		WebElement USER_NAME = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement PASSWORD = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON = driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));

		USER_NAME.sendKeys("demo@codefios.com");
		PASSWORD.sendKeys("abc123");
		SIGNIN_BUTTON.click();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		

	}

	@Test
	public void TestingDeposit() {

		TestingLogin();
		driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Deposit')]")).click();
		// Filling out the deposit form
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Jack Smith");
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("2400");

		// Assertion Add Deposit Page Found
		WebElement DEPOSIT_PAGE = driver.findElement(By.xpath("//strong[contains(text(),'Add Deposit')]"));
		Assert.assertTrue("Deposit page not found", DEPOSIT_PAGE.isDisplayed());

		// Submit the form
		driver.findElement(By.xpath("//button[@class=\"btn btn-sm btn-primary\"]")).click();
//		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	// close the browser
	public void end() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();

	}
}
