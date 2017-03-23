package Internship;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class New {
WebDriver driver;

Date dNow = new Date();
SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy 'at' hh");

@Test()
public void doublebooking() throws Exception {
Thread.sleep(5000);
driver.findElement(By.id("startCalendar")).click();
for (int i = 0; i < 2; i++) {
System.out.println("Inside the loop");
driver.findElement(By.xpath(".//*[contains(@class, 'fc-slot44 ')]")).click();
Thread.sleep(2000);


driver.findElement(By.xpath(".//*[@class='appt-dropdown-btn']")).click();
List<WebElement> staff = driver.findElements(By.xpath(".//*[@class='appt-dropdown-menu']/li [starts-with(@id, 'staff-')]"));
System.out.println("Clicking on provider");
staff.get(0).click();
System.out.println("Staff Selected");

// clicking on the service dropdown and selecting 5mins service
driver.findElement(By.xpath(".//b[@class='appt-service-name']")).click();
List<WebElement> service = driver.findElements(By.xpath("//li[starts-with(@id,'service')]/descendant::span[position()=1]"));
System.out.println("Available service::" + service.size());
service.get(1).click();
System.out.println("clicked Service");
String serviceName = service.get(1).getText();
System.out.println("Service clicked:: " + serviceName);
Thread.sleep(1000);

// clicking on the time dropdown
driver.findElement(By.xpath(".//b[@class='appt-time-title']")).click();
System.out.println("Clicking on time dropdown");

// getting time
driver.findElement(By.xpath(".//*[@id='appt-slots-11-30']")).click();

// adding notes in comments
driver.findElement(By.xpath(".//*[@class='appt-notes-area']")).click();
driver.findElement(By.xpath(".//*[@class='appt-notes-area']")).sendKeys("Appointment from Automation code");
System.out.println("Comment entered successfully");
Thread.sleep(1000);

// Click and continue to select customer
driver.findElement(By.xpath(".//*[text()='Continue']")).click();
System.out.println("Clicked on continue button and moved to customer popup");

// searching customer
driver.findElement(By.xpath(".//input[@class='appt-customer-input']")).clear();
driver.findElement(By.xpath("//input[@class='appt-customer-input']")).sendKeys("Devi Sri Gurumurthy");
System.out.println("Searching the customer");
Thread.sleep(3000);
String s = driver.findElement(
By.xpath(".//*[@class='searching-cust']")).getText();
System.out.println(s);
if (s.equals("No Customer Found!")) {
System.out.println("Inside if loop");
driver.findElement(
By.xpath(".//*[@class='appt-customer-newcustomer-btn']")).click();
driver.findElement(By.id("apptCust-LoginId")).click();
driver.findElement(By.id("apptCust-LoginId")).sendKeys("setmore2007user@gmail.com");
driver.findElement(By.id("apptCust-MobileNo")).click();
driver.findElement(By.id("apptCust-MobileNo")).sendKeys("7845783582");
driver.findElement(By.xpath(".//*[@class='appt-save-btn']")).click();
} else {
// selecting the customer from suggestion
driver.findElement(
By.xpath(".//span[@class='appt-suggestion-dropdown-title'][text()='Devi Sri Gurumurthy']")).click();
System.out.println("Selecting the customer from the suggestion");
// save appt button
driver.findElement(By.xpath(".//a[text()='Save Appointment']")).click();
System.out.println("Appointment save successfully");
Thread.sleep(1000);
}

Thread.sleep(3000);
}
}
//}

@BeforeMethod
public void beforeMethod() throws Exception {
// FIREFOX BROWSER
driver = new FirefoxDriver();
driver.get("https://my.setmore.com");
driver.findElement(By.id("username")).clear();
driver.findElement(By.id("username")).sendKeys("noopra@gmail.com");
driver.findElement(By.id("password")).clear();
driver.findElement(By.id("password")).sendKeys("setmore123");
driver.findElement(By.xpath("//input[@value='Sign In']")).click();
Thread.sleep(2000);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}



@AfterMethod
public void afterMethod(ITestResult result) {

driver.quit();

}
}
