package RBTechTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TechTestClass
{
	@Test
	public void SpeedyLogin()
	{
			System.setProperty("webdriver.chrome.driver","D:\\softwares required for testing\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://uat3.speedyservices.com/");
			driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("test@test.com");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test007");
			driver.findElement(By.xpath("//input[@id='loginBtn']")).click();
			String errorMessage=driver.findElement(By.xpath("//div[@class='custom-validation-alert']")).getText();
			Assert.assertNotEquals(errorMessage, "User name or password is invalid.");
			driver.close();
	}
}
