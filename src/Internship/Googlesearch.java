package Internship;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Googlesearch {
	static WebDriver driver;
	public static void main(String args[]) throws InterruptedException {
		
		driver =	new FirefoxDriver();
		driver.get("https://www.google.co.in");
	    driver.findElement(By.xpath(".//*[@id='sb_ifc0']"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]")).sendKeys("Full Creative");
		driver.quit();
		}
 
  }

