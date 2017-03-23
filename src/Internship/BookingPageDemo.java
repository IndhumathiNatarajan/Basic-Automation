package Internship;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPageDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		//Launch the URL
		driver.get("http://testing.setmore.com/bookingpage/361d5f31-da63-4baf-b11f-2dcb46893432");
		Thread.sleep(5000);
        
	for(int l=0;l<10;l++)
	{
		
		//Handling the Booking policy
	  //  boolean status = driver.findElement(By.xpath(".//*[@id='policy_link']")).isDisplayed();
	    if(driver.findElement(By.xpath(".//*[@id='policy_link']")).isDisplayed())
	    {
	    	driver.findElement(By.id("close-policy")).click();
	    }
	    else
	    {
	    	System.out.println("Booking policy is not available");
	    }
	   
	    //Handling the accordion icon
	   
	    try{
	    boolean acc_icon=driver.findElement(By.xpath(".//*[@id='chs_service_act']/h3[1]/i")).isDisplayed();
		//WebElement test1 =driver.findElement(By.xpath(".//*[@id='chs_service_act']/h3[1]/i "));
	   
	    if(acc_icon)
	    {
	    	List<WebElement> categories=driver.findElements(By.xpath(".//*[@id='chs_service_act']/h3"));
	        categories.get(0).click();
	        List<WebElement> services=driver.findElements(By.xpath(".//*[@id='chs_service_act']/ul/li"));
	        services.get(0).click();
	    }
	   
	    else
	    {
	      List<WebElement> services=driver.findElements(By.xpath("//div[@id='chs_service_act']//ul/li "));
	  	  services.get(0).click();
	    }
	    }catch(Exception e){
	    	System.out.println(e.getMessage());
	    }
	    //Handling Skip the staff
	    try{
	    boolean stafflist=driver.findElement(By.xpath(".//*[@id='provide']")).isDisplayed();
	    if(stafflist)
	    {
	      List<WebElement> staffs=driver.findElements(By.xpath("//div[@id='sp_act']/ul//li "));
	      staffs.get(0).click();	
	    }
	    }catch(Exception e){
	    	System.out.println(e.getMessage());
	    }
	    boolean mul_service=driver.findElement(By.xpath(".//*[@class='multiple-service-popup']")).isDisplayed();
	    if(mul_service)
	    {
	    	driver.findElement(By.xpath("//a[text()='Skip']")).click();	
	    }
	    Thread.sleep(5000);
	    
	    //Selecting dates and time
	    List<WebElement> availdates=driver.findElements(By.xpath("//*[@class='datepickerDays']/tr/td[not(contains(@class,'datepickerDisabled'))]"));

	    int total_availdates=availdates.size();
	    System.out.println(total_availdates);
	    
	    for(int i=1;i<total_availdates;i++)
	    {
	    	System.out.println( "availdates.size()--->>>" + total_availdates + " index:"+i );
	    	
	    	List<WebElement> availdate=driver.findElements(By.xpath("//*[@class='datepickerDays']/tr/td[not(contains(@class,'datepickerDisabled'))]"));
	    	
            Boolean noslots = false;
            //Boolean noslots = true;
	    	try
	    	{
	    		//noslots = !driver.findElement(By.xpath(".//*[@id='timesheet']/ul[1]/li[1]")).isDisplayed();
	    	      noslots = driver.findElement(By.xpath(".//*[text()='No Slots Available' or text()='Non Working Day']")).isDisplayed();
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("ERROR HERE!");
	    		System.out.println(e.getMessage());
	    	}
	    	System.out.println(noslots);
	    	if(noslots)
	    	{
	    		System.out.println("NO SLOTS!!!!");
	    		availdate.get(i).click();
	    		Thread.sleep(5000);
	    	}
	    	else
	    	{
	    		System.out.println( "CLICKING TIME!" );
	    		List<WebElement> availtimes=driver.findElements(By.xpath("//div[@id='timesheet']/ul//li[not(contains(@class,'list_heading'))]"));
	    		availtimes.get(0).click();
	    		break;
	    	}
	    	
 	    }
	    
	    //Handling Customer login
	    boolean cuslogin= false;
	    cuslogin=driver.findElement(By.xpath(".//*[@id='newProfile']")).isDisplayed();
	     if(cuslogin)
	    {
	    	driver.findElement(By.id("skip_step")).click();
	    	System.out.println("always present");
	    }
	     
	    //Handling customer personal info
	    List<WebElement> CustDetails=driver.findElements(By.xpath(".//*[@class='service-container']/div/form/div/ul/li/div/input"));
	    int total_availinfo=CustDetails.size();
	    System.out.println("Total size :"+total_availinfo );
	    for(int k=0;k<total_availinfo;k++)
	    {
	    	String test=CustDetails.get(k).getAttribute("placeholder");
	    	if(test.contains("*"))
	    	{
	    		System.out.println("Mandatory fields are:"+test);
	    		if(test.equalsIgnoreCase("Name *"))
	    		{ 
	    			CustDetails.get(k).sendKeys("pandiyan-sta-sm");
	    		}
	    		else if(test.equalsIgnoreCase("Email *"))
	    		{
	    			CustDetails.get(k).sendKeys("p7s@full.io");
	    		}
	    		else if(test.equalsIgnoreCase("Phone *"))
	    		{
	    			CustDetails.get(k).sendKeys("8122589549");
	    		}
	    		else if(test.equalsIgnoreCase("Address *"))
	    		{
	    			CustDetails.get(k).sendKeys("Plot 29, B2, A.G.S.Colony, 3rd cross street");
	    		}
	    		else if(test.contains("*"))
	    		{
	    			CustDetails.get(k).sendKeys("123456");
	    		}
	    	}
	    	
	    }
	
	    
	    //Handling Cancellaltion Policy
	    boolean cancelpolicy = false;
	    try
	    {
	    	cancelpolicy = driver.findElement(By.xpath(".//*[@id='acceptCancellationPolicyTerms']")).isDisplayed();
	    }
	    catch(Exception e)
	    {
	    	System.out.println("No cancellation policy!!");
	    }
	    
	    if(cancelpolicy)
	    {
	    	driver.findElement(By.xpath(".//*[@id='acceptCancellationPolicyTerms']")).click();
	    }
	    
	    //Continuing and Booking appointment
	    driver.findElement(By.id("cust-continue")).click();
	   // Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[text()='Book My Appointment']")).click();
	    Thread.sleep(2000);
	   	WebDriverWait wait=new WebDriverWait(driver,25);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("company_name")));
	    
	}
	
	    driver.close();
	    driver.quit();

	}

}

