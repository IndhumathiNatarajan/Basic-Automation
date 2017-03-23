package Internship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PracticalExe1 {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		String ActualURL = "https://google.co.in";
		driver.get(ActualURL);
		String PageTitle=driver.getTitle();
		int PageLength=driver.getTitle().length();
		System.out.println("The title of the web page opened is "+PageTitle);
		System.out.println("The length of the web page opened is "+PageLength);
		String CurrentURL=driver.getCurrentUrl();
		if(ActualURL.equalsIgnoreCase("CurrentURL"))
		{
			System.out.println("Correct page Verified and Opened:The URL is:"+ActualURL);
		}
		else
		{
			System.out.println("Wrong URL page Opened and Verification failed:The wrong URL is:"+CurrentURL);
			System.out.println("The correct URL is "+ActualURL);
		}
		String PageSource=driver.getPageSource();
		int PageSourceLength=driver.getPageSource().length();
		System.out.println("The length of the pagesource is "+PageSourceLength);
		driver.close();
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		

	}

}
