package Internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PracticeExe2 {

	public static void main(String[] args) throws InterruptedException {
		/*WebDriver driver=new FirefoxDriver();
		driver.get("https://www.setmore.com");
		driver.findElement(By.xpath("//a[text()='Login'].click();
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().to("https://www.setmore.com");
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.close();*/
		System.setProperty("webdriver.chrome.driver", "/Users/indhu/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		

	}

}
