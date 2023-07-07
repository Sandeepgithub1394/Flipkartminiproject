package tnp.FlipkartAssesment;


	import java.time.Duration;
	import java.util.Scanner;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class login {
		WebDriver driver;
		@Test(priority=1)
		public void openFlipKart() throws Exception
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
		
			driver = new ChromeDriver(option);
		
			 driver.get("https://www.flipkart.com");
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			 Thread.sleep(10000);
			/* driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("8971128097");
			 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();*/
			 driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();
			 driver.findElement(By.name("q")).sendKeys("oneplus mobile");
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 driver.findElement(By.xpath("(//div[@class='col col-7-12']//div[@class='_4rR01T'])[1]")).click();
			 String originalWindow = driver.getWindowHandle();
			 for (String windowHandle : driver.getWindowHandles()) {
				    if(!originalWindow.contentEquals(windowHandle)) {
				        driver.switchTo().window(windowHandle);
				        break;
				    }
				}
			 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
			 
			 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("8971128097");
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 Thread.sleep(10000);
			
			 Scanner sc=new Scanner(System.in);
			 System.out.println("enter the otp");
			 String data = sc.nextLine();
			 driver.findElement(By.xpath("//div[@class='IiD88i GtCYSF']//input[@class='_2IX_2- _3mctLh _17N0em']")).sendKeys(data);
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 driver.findElement(By.xpath("//input[@id='CNTCT6020ED46C3134F76811A16CC5']")).click();
			
			 String actualProd=driver.findElement(By.linkText("OnePlus Nord CE 2 Lite 5G (Blue Tide, 128 GB)")).getText();
			 String expectedProd="OnePlus Nord CE 2 Lite 5G (Blue Tide, 128 GB)";
			 Assert.assertEquals(actualProd, expectedProd,"expected product is not added to cart");
			
			 
			 driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
			 driver.findElement(By.xpath("//span[text()='Payment Options']")).click();
			 driver.findElement(By.xpath("//div[@class='_3dsJAO']")).click();
			
			 String actualText=driver.findElement(By.xpath("//div[text()='Your checkout has no items.']")).getText();
			 String expectedText="Your checkout has no items";
			Assert.assertEquals(actualText, expectedText,"producted is not removed from the cart");
			driver.quit();
			 
		}


	}

