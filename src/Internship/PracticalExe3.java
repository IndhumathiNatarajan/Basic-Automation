package Internship;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PracticalExe3 {

	@Test
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://my.setmore.com/");
        driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("indhu.nataraj@a-cti.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("setmore123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='account_menu']/a/i[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
		Thread.sleep(5000); 
		driver.close();
	}

}
