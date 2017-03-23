package Internship;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calendar {
	 WebDriver driver;
	
	@BeforeMethod
	public void before() throws InterruptedException
	{
		driver = new FirefoxDriver ();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://testing.setmore.com/index.jsp");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("indhu.nataraj@a-cti.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("setmore123");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(3000);
	}

	@Test
	public void main() throws InterruptedException 
	{
		// Changing the calendar to Daily view
		WebElement CalMenu=driver.findElement(By.xpath(".//*[@id='calendarHeader']/div[1]"));
	    String CalMenuview= CalMenu.getText();
		System.out.println(CalMenuview);
		if(!CalMenuview.contains("Daily"))
		{
			if(CalMenuview.equalsIgnoreCase("Weekly")||CalMenuview.equalsIgnoreCase("Monthly"))
			{
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath(".//*[@id='calendarHeader']/div[1]/div"))).perform();
			    driver.findElement(By.xpath(".//*[@id='cal-daily']/a")).click();
			    Thread.sleep(2000);
			}
			else
			{
				Actions act = new Actions(driver);
			    act.moveToElement(driver.findElement(By.xpath(".//*[@id='calendarHeader']/div[1]/div[3]"))).perform();
			    driver.findElement(By.xpath(".//*[@id='cal-daily']/a")).click();
			}
		}
		
		Thread.sleep(2000);
		//Starting the loop for Double booking
		for(int j=0;j<10;j++)
		{
		    System.out.println("Came inside loop!!");
			try
			{
		     driver.findElement(By.xpath(".//*[contains(@class,'fc-slot44 ')]")).click();
		     Thread.sleep(2000);
		    }
			catch(Exception E)
			{
				E.getMessage();
				
			}
			 
		    driver.findElement(By.xpath(".//*[@class='appt-details-holder']//ul/li[2]/div/a/i[2]")).click();
			    
		    //Selecting service
		    List<WebElement> servicelist=driver.findElements(By.xpath(".//*[@class='appt-details-holder']//ul/li[2]/div/ul/li"));
		    servicelist.get(1).click();
		    Thread.sleep(3000);
		    
		    /*String timetext=driver.findElement(By.xpath(".//*[@class='appt-time-dropdown']/a/b")).getText();
		    System.out.println("Inner text is : "+timetext);*/
		    
		    driver.findElement(By.xpath(".//*[@class='appt-time-dropdown']/a/i")).click();
		    driver.findElement(By.xpath(".//*[@id='appt-slots-16-10']")).click();
		    Thread.sleep(1000);
		    
		     /* List<WebElement> timelist=driver.findElements(By.xpath(".//*[@class='appt-time-dropdown open']//ul/li"));
		    for(int k=0;k<timelist.size();k++)
		    {
		    	String timetext1=timelist.get(k).getText();
		    	if(timetext1.equalsIgnoreCase("04:15 pm"))
		    	{
		    		System.out.println("Content Matched");
		    		timelist.get(k).click();
		    		break;
		    	}
		    }*/
		    
		    
		    try
		    {
		     driver.findElement(By.xpath(".//*[text()='Continue']")).click();
		    
		    }
		    catch(Exception E)
		    {
		    	E.getMessage();
		    }
		    
		    // Selecting customer
		     driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/div/input")).sendKeys("Remind");
		    Thread.sleep(1000);
			List<WebElement> customerlist= driver.findElements(By.xpath(".//*[@class='appt-customer-search-holder']/div/ul/li"));
			int totalcuslist=customerlist.size();
			for(int i=0;i<totalcuslist;i++)
		    {
			 String name = customerlist.get(i).getText();
			 if(name.equalsIgnoreCase("Remind"))
			  {
				customerlist.get(i).click();
				break;
			 }
		    }
		     driver.findElement(By.xpath(".//*[text() ='Save Appointment']")).click();
		     Thread.sleep(5000);
		}
	}
	
	@AfterMethod
	public void after()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='account_menu']/a/i[2]")));
		driver.findElement(By.xpath(".//*[@id='account_menu']/a/i[2]")).click();
		driver.findElement(By.xpath(".//*[text()='Sign Out']")).click();
	    driver.close();
	    driver.quit();
	}
 }


