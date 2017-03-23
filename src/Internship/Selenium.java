package Internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
      public static void main (String[]args){
    	  WebDriver driver=new FirefoxDriver();
    	  driver.get("https://accounts.google.com/SignUp?hl=en-GB");
    	  driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("AAA");
    	  driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("BBB");
    	  driver.findElement(By.xpath(".//*[@id='GmailAddress']")).sendKeys("setmore107");
    	  driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("Twilight@85");
    	  driver.findElement(By.xpath(".//*[@id='PasswdAgain']")).sendKeys("Twilight@85");
    	  driver.findElement(By.xpath(".//*[@id='BirthDay']")).sendKeys("22");
    	  driver.findElement(By.xpath(".//*[@id='BirthYear']")).sendKeys("1994");
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
      }
 
}
