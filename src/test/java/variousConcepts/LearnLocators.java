 package variousConcepts;



import org.junit.Test;
import org.junit.Before;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators {
	
	WebDriver driver;
	
	@Before
	public void init() {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\agam1\\selenium\\crm\\driver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.get("https://codefios.com/ebilling/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
						
		}
	
		
		@Test		
		public void Testing() {
				//web element and actions for opening website and deposits 
				driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("demo@codefios.com");
				driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");  
				driver.findElement(By.xpath("//*[@id=\"login_submit\"]")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[4]/a/span")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id=\"transactions\"]/li[2]/a/span")).click();
				
				//Filling out the deposit form
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/div/input")).sendKeys("Jack Smith");
				driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/div/input")).sendKeys("2400");
				
				//Submit the form
				driver.findElement(By.xpath("//*[@id=\"form\"]/div[6]/div/button")).click();
				
				//Assertion 
				
					
				//close the browser
				driver.close();
				
				}
				
		
	}
	
			
